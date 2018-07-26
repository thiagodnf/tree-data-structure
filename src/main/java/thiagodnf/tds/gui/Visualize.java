package thiagodnf.tds.gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.RenderingHints;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import thiagodnf.tds.gui.listener.ZoomAndPanListener;
import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class Visualize<S, T extends Node<S>> extends Canvas {

	private static final long serialVersionUID = 7916390359313167134L;

	protected static final int marginTop = 20;

	protected static final int WIDTH = 800;

	protected static final int HEIGHT = 600;

	protected static final int diameter = 40;

	protected static final Color BLACK = new Color(67, 67, 72);

	protected static final Color BLUE = new Color(184, 217, 248);

	protected static final Color DARK_BLUE = new Color(113, 178, 242);

	protected static final Font FONT = new Font("Helvetica", Font.PLAIN, 15);

	protected Tree<S, T> tree;

	protected double scale = 1.0;

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
		
		g.setFont(FONT);
		
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

		if (node != null) {
			g.setColor(BLACK);
			g.drawLine(parentX + 20, parentY - diameter, x + (diameter / 2), y + (diameter / 2));

			g.setColor(BLUE);
			g.fillOval(x, y, diameter, diameter);
			g.setColor(DARK_BLUE);
			g.drawOval(x, y, diameter, diameter);

			g.setColor(BLACK);
			
			g.drawString(tree.toString(node), x + diameter / 2 - 5, y + diameter / 2 + 5);
		}

		if (node.hasLeftNode()) {
			draw(g, node.getLeftNode(), "LEFT", x, y + (diameter * 2));
		}

		if (node.hasRightNode()) {
			draw(g, node.getRightNode(), "RIGHT", x, y + (diameter * 2));
		}
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
