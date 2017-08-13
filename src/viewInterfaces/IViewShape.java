package viewInterfaces;

import controller.PaintColor;
import controller.Shape;
import view.GuiUiModule.PaintCanvas;

public interface IViewShape {
	void displayOutline(PaintColor color);
	void displayFilled(PaintColor color);
	PaintColor getPrimaryColor();
	PaintColor getSecondaryColor();
	PaintCanvas getCanvas();
	Shape getShape();
}
