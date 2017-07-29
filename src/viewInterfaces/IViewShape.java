package viewInterfaces;

import controller.PaintColor;

public interface IViewShape {
	void displayOutline(PaintColor color);
	void displayFilled(PaintColor color);
	PaintColor getPrimaryColor();
	PaintColor getSecondaryColor();
}
