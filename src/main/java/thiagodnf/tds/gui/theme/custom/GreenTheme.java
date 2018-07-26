package thiagodnf.tds.gui.theme.custom;

import java.awt.Color;

import thiagodnf.tds.gui.theme.DefaultTheme;
import thiagodnf.tds.gui.theme.Theme;

public class GreenTheme extends DefaultTheme {

	@Override
	public Color getNodeBorderColor() {
		return Theme.DARK_GREEN;
	}

	@Override
	public Color getNodeFillColor() {
		return Theme.GREEN;
	}
}
