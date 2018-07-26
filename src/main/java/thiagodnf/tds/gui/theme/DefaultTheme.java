package thiagodnf.tds.gui.theme;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;

public class DefaultTheme extends Theme {

	@Override
	public Color getEdgeColor() {
		return Theme.BLACK;
	}

	@Override
	public Color getTextColor() {
		return Theme.BLACK;
	}

	@Override
	public Color getNodeBorderColor() {
		return Theme.DARK_BLUE;
	}

	@Override
	public Color getNodeFillColor() {
		return Theme.BLUE;
	}

	@Override
	public Stroke getEdgeStroke() {
		return new BasicStroke(1.0f);
	}

	@Override
	public Stroke getNodeBorderStroke() {
		return new BasicStroke(2.0f);
	}

	@Override
	public Font getFont() {
		return new Font("Helvetica", Font.PLAIN, 15);
	}	
}
