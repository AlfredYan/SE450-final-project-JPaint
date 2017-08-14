package viewInterfaces;

import controller.PaintColor;
import controller.Shape;

public interface IViewShape {
	void displayOutline(PaintColor color);
	void displayFilled(PaintColor color);
	PaintColor getPrimaryColor();
	PaintColor getSecondaryColor();
	Shape getShape();
	IViewShape clone() throws CloneNotSupportedException;
}
