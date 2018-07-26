package thiagodnf.tds.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import thiagodnf.tds.gui.listener.ZoomAndPanListener;
import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class Visualize<S, T extends Node<S>> extends Canvas {

	private static final long serialVersionUID = 7916390359313167134L;

	protected static final int marginTop = 20;

	protected static final int diameter = 40;

	protected Font font;

	protected Tree<S, T> tree;

	protected RenderingHints hints;
	
	private boolean init = true;
	
	private ZoomAndPanListener zoomAndPanListener;
	
	public Visualize(Tree<S, T> tree) {
		
		this.tree = tree;

		this.hints = new RenderingHints(null);
		this.hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		this.hints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		
		this.zoomAndPanListener = new ZoomAndPanListener(this);
		this.addMouseListener(zoomAndPanListener);
		this.addMouseMotionListener(zoomAndPanListener);
		this.addMouseWheelListener(zoomAndPanListener);
		
		this.font = tree.getColorTheme().getFont();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}
	
	@Override
	public void paint(Graphics graphics) {
		
		Graphics2D g = (Graphics2D) graphics;
		
		Dimension d = getSize();
		
		if (init) {
			// Initialize the viewport by moving the origin to the center of the window,
			// and inverting the y-axis to point upwards.
			init = false;
			
			int xc = d.width / 2;
			int yc = d.height / 2;

			g.translate(xc, yc);
			g.scale(1, 1);

			// Save the viewport to be updated by the ZoomAndPanListener
			zoomAndPanListener.setCoordTransform(g.getTransform());
		} else {
			// Restore the viewport after it was updated by the ZoomAndPanListener
			g.setTransform(zoomAndPanListener.getCoordTransform());
		}
		
		g.setFont(font);
		g.setRenderingHints(hints);
		
		if (tree.isEmpty()) {
			return;
		}

		draw(g, tree.getRoot(), "NONE", -(diameter / 2), -d.height / 2 + marginTop);
	}

	public void draw(Graphics2D g, Node<S> node, String direction, int parentX, int parentY) {

		int x = parentX;
		int y = parentY;

		if (direction.equalsIgnoreCase("LEFT")) {
			int numberOfNodes = tree.getNumberOfNodes(node.getRightNode()) + 1;
			x -= numberOfNodes * 80;
		}

		if (direction.equalsIgnoreCase("RIGHT")) {
			int numberOfNodes = tree.getNumberOfNodes(node.getLeftNode()) + 1;
			x += numberOfNodes * 80;
		}

		if (node.hasLeftNode()) {
			draw(g, node.getLeftNode(), "LEFT", x, y + (diameter * 2));
		}

		if (node.hasRightNode()) {
			draw(g, node.getRightNode(), "RIGHT", x, y + (diameter * 2));
		}
		
		if (node != null) {
			// Draw Edge
			g.setStroke(tree.getColorTheme().getEdgeStroke());
			g.setColor(tree.getColorTheme().getEdgeColor());
			g.drawLine(parentX + 20, parentY - (60), x + (diameter / 2), y + (diameter / 2));

			//Draw Node
			g.setColor(tree.getColorTheme().getNodeFillColor());
			g.fillOval(x, y, diameter, diameter);

			// Draw Border Node
			g.setStroke(tree.getColorTheme().getNodeBorderStroke());
			g.setColor(tree.getColorTheme().getNodeBorderColor());
			g.drawOval(x, y, diameter, diameter);

			// Draw Text
			g.setColor(tree.getColorTheme().getTextColor());
			printSimpleString(g, tree.toString((T) node), diameter, x, y + diameter / 2 + 5);
		}
	}
	
	private void printSimpleString(Graphics2D g, String s, int width, int XPos, int YPos) {

		int stringLen = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();

		int start = width / 2 - stringLen / 2;

		g.drawString(s, start + XPos, YPos);
	}

	public static void show(Tree tree) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				Visualize vis = new Visualize(tree);
				
				JFrame frame = new JFrame(tree.getName());

				frame.add(vis, BorderLayout.CENTER);
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				frame.pack();
				
				// Centralize the jframe
				frame.setLocationRelativeTo(null);
				// Show the jframe
				frame.setVisible(true);
				
				vis.createBufferStrategy(2);
			}
		});
	}
}
