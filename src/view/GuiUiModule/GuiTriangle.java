package view.GuiUiModule;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import controller.PaintColor;
import controller.Shape;
import viewInterfaces.IViewShape;

public class GuiTriangle implements IViewShape{
	private PaintCanvas _canvas;
	private Shape _shape;
	private int[] _xPoints;
	private int[] _yPoints;
	private int _nPoints;
	
	public GuiTriangle(Shape shape, PaintCanvas canvas) {
		_shape = shape;
		_canvas = canvas;
		setPoints();
	}

	private void setPoints() {
		int[] xPoints = {_shape.getStartX(), _shape.getEndX(), _shape.getStartX()};
		int[] yPoints = {_shape.getStartY(), _shape.getEndY(), _shape.getEndY()};
		_xPoints = xPoints;
		_yPoints = yPoints;
		_nPoints = 3;
	}

	@Override
	public void displayOutline(PaintColor color) {
		Graphics2D graphics = _canvas.getGraphics2D();
		graphics.setStroke(new BasicStroke(5));
		graphics.setColor(color.getColor());
		graphics.drawPolygon(_xPoints, _yPoints, _nPoints);
	}

	@Override
	public void displayFilled(PaintColor color) {
		Graphics2D graphics = _canvas.getGraphics2D();
		graphics.setColor(color.getColor());
		graphics.fillPolygon(_xPoints, _yPoints, _nPoints);
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