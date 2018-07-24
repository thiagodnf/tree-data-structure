package thiagodnf.tds.gui;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class Visualize<S, T extends Node<S>> extends JPanel implements MouseWheelListener {

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
	
	private double zoomFactor = 1;
	
	private double prevZoomFactor = 1;
	
	private boolean zoomer;
	
	private double xOffset = 0;
    
	private double yOffset = 0;
	
	public Visualize(Tree<S, T> tree) {
		
		this.tree = tree;

		this.hints = new RenderingHints(null);
		this.hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		this.hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		this.hints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		
		addMouseWheelListener(this);
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
		zoomer = true;
	    
		//Zoom in
	    if (e.getWheelRotation() < 0) {
	        zoomFactor *= 1.1;
	        repaint();
	    }
	    //Zoom out
	    if (e.getWheelRotation() > 0) {
	        zoomFactor /= 1.1;
	        repaint();
	    }
	}	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		if (zoomer) {
			
			AffineTransform at = new AffineTransform();

            double xRel = MouseInfo.getPointerInfo().getLocation().getX() - getLocationOnScreen().getX();
            double yRel = MouseInfo.getPointerInfo().getLocation().getY() - getLocationOnScreen().getY();

            double zoomDiv = zoomFactor / prevZoomFactor;

            xOffset = (zoomDiv) * (xOffset) + (1 - zoomDiv) * xRel;
            yOffset = (zoomDiv) * (yOffset) + (1 - zoomDiv) * yRel;
            
            at.translate(xOffset, yOffset);
            at.scale(zoomFactor, zoomFactor);
           
            prevZoomFactor = zoomFactor;
            
            g2.transform(at);
            
            int w = ((int) (getSize().width*zoomFactor));
    	    int h = ((int) (getSize().height*zoomFactor));
    	    
    	    setPreferredSize(new Dimension(w, h)); 
            
            zoomer = false;
            
	    }
		
		g2.setFont(FONT);

		g2.setRenderingHints(hints);
		
		double width = scale * getSize().width;

		if (tree.isEmpty()) {
			return;
		}

		draw(g2, tree.getRoot(), "NONE", (int) width / 2, marginTop);
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
			g.drawLine(parentX + 20, parentY - 40, x + 20, y + 20);

			g.setColor(BLUE);
			g.fillOval(x, y, diameter, diameter);
			g.setColor(DARK_BLUE);
			g.drawOval(x, y, diameter, diameter);

			g.setColor(BLACK);
			g.drawString(String.valueOf(node.getValue()), x + diameter / 2 - 5, y + diameter / 2 + 5);
		}

		if (node.hasLeftNode()) {
			draw(g, node.getLeftNode(), "LEFT", x, y + 80);
		}

		if (node.hasRightNode()) {
			draw(g, node.getRightNode(), "RIGHT", x, y + 80);
		}
	}

	public static void show(Tree tree) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				Visualize vis = new Visualize(tree);
				
				JFrame frame = new JFrame("Visualize");

				frame.getContentPane().add(new JScrollPane(vis));
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				frame.setSize(WIDTH, HEIGHT);
				// Centralize the jframe
				frame.setLocationRelativeTo(null);
				// Show the jframe
				frame.setVisible(true);
			}
		});
	}
}
