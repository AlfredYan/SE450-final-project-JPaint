package view.GuiUiModule;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import controller.PaintColor;
import controller.Shape;
import viewInterfaces.IViewShape;

public class GuiEllipse implements IViewShape{
	private Shape _shape;
	private PaintCanvas _canvas;

	public GuiEllipse(Shape shape, PaintCanvas canvas) {
		_shape = shape;
		_canvas = canvas;
	}

	@Override
	public void displayOutline(PaintColor color) {
		Graphics2D graphics = _canvas.getGraphics2D();
		graphics.setStroke(new BasicStroke(5));
		graphics.setColor(Color.BLACK);
		graphics.drawOval(_shape.getStartX(), _shape.getStartY(), _shape.getWidth(), _shape.getHeight());
	}

	@Override
	public void displayFilled(PaintColor color) {
		// TODO Auto-generated method stub
		Graphics2D graphics = _canvas.getGraphics2D();
		graphics.setColor(Color.BLUE);
		graphics.fillOval(_shape.getStartX(), _shape.getStartY(), _shape.getWidth(), _shape.getHeight());
	}

	@Override
	public PaintColor getPrimaryColor() {
		return _shape.getPrimaryColor();
	}

	@Override
	public PaintColor getSecondaryColor() {
		return _shape.getSecondaryColor();
	}
}
