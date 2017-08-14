package view.GuiUiModule;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import controller.PaintColor;
import controller.Shape;
import viewInterfaces.IViewShape;

public class GuiRectangle implements IViewShape {
	private PaintCanvas _canvas;
	private Shape _shape;
	
	public GuiRectangle(Shape shape, PaintCanvas canvas) {
		_shape = shape;
		_canvas = canvas;
	}

	@Override
	public void displayOutline(PaintColor color) {
		Graphics2D graphics = _canvas.getGraphics2D();
		graphics.setStroke(new BasicStroke(5));
		graphics.setColor(color.getColor());
		graphics.drawRect(_shape.getStartX(), _shape.getStartY(), _shape.getWidth(), _shape.getHeight());
	}

	@Override
	public void displayFilled(PaintColor color) {
		Graphics2D graphics = _canvas.getGraphics2D();
		graphics.setColor(color.getColor());
		graphics.fillRect(_shape.getStartX(), _shape.getStartY(), _shape.getWidth(), _shape.getHeight());
	}

	@Override
	public PaintColor getPrimaryColor() {
		return _shape.getPrimaryColor();
	}

	@Override
	public PaintColor getSecondaryColor() {
		return _shape.getSecondaryColor();
	}

	@Override
	public Shape getShape() {
		return _shape;
	}
	
	@Override
	public IViewShape clone() throws CloneNotSupportedException {
		return new GuiRectangle(_shape.clone(), _canvas);
	}

}
