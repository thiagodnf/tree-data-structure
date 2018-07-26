package thiagodnf.tds.gui.theme;

import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;

public abstract class Theme {
	
	protected static final Color BLACK = new Color(67, 67, 72);

	protected static final Color BLUE = new Color(184, 217, 248);
	
	protected static final Color GREEN = new Color(181, 251, 185);
	
	protected static final Color ORANGE = new Color(255, 208, 163);

	protected static final Color DARK_BLUE = new Color(124, 181, 236);
	
	protected static final Color DARK_GREEN = new Color(144, 237, 125);
	
	protected static final Color DARK_ORANGE = new Color(247, 163, 92);

	public abstract Color getEdgeColor();

	public abstract Color getTextColor();

	public abstract Color getNodeBorderColor();

	public abstract Color getNodeFillColor();

	public abstract Stroke getEdgeStroke();

	public abstract Stroke getNodeBorderStroke();
	
	public abstract Font getFont();
}
