package thiagodnf.tds.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class Visualize<S, T extends Node<S>> extends JPanel implements ChangeListener {

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

	public Visualize(Tree<S, T> tree) {
		this.tree = tree;

		hints = new RenderingHints(null);
		hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		hints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		
		setBackground(Color.WHITE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		
		
//		AffineTransform at = g2.getTransform();
//        at.scale(scale, scale);
        
        

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
			g.drawString(node.toString(), x + diameter / 2 - 5, y + diameter / 2 + 5);
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

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(new JScrollPane (vis));
				frame.getContentPane().add(vis.getControl(), "Last");
				frame.setSize(WIDTH, HEIGHT);
				// Centralize the jframe
				frame.setLocationRelativeTo(null);
				// Show the jframe
				frame.setVisible(true);
			}
		});
	}
	
	private JSlider getControl() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 50, 200, 100);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        return slider; 
    }

	@Override
	public void stateChanged(ChangeEvent e) {
		int value = ((JSlider) e.getSource()).getValue();
		scale = value / 100.0;
		
		repaint();
		revalidate();

	}
}
