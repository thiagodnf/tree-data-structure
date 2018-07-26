package thiagodnf.tds.gui.theme.custom;

import java.awt.Color;

import thiagodnf.tds.gui.theme.DefaultTheme;
import thiagodnf.tds.gui.theme.Theme;

public class OrangeTheme extends DefaultTheme {

	@Override
	public Color getNodeBorderColor() {
		return Theme.DARK_ORANGE;
	}

	@Override
	public Color getNodeFillColor() {
		return Theme.ORANGE;
	}
}
