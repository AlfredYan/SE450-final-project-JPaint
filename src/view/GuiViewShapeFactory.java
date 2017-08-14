package view;

import controller.Shape;
import controller.ShapeType;
import view.GuiUiModule.GuiEllipse;
import view.GuiUiModule.GuiRectangle;
import view.GuiUiModule.GuiTriangle;
import view.GuiUiModule.PaintCanvas;
import viewInterfaces.IViewShape;
import viewInterfaces.IViewShapeFactory;

public class GuiViewShapeFactory implements IViewShapeFactory{

	private final PaintCanvas _canvas;
	
	public GuiViewShapeFactory(PaintCanvas canvas) {
		_canvas = canvas;
	}

	@Override
	public IViewShape createViewShape(ShapeType currentShape, Shape shape) throws Exception {
		switch (currentShape) {
		case ELLIPSE:
			return new GuiEllipse(shape, _canvas);
		case RECTANGLE:
			return new GuiRectangle(shape, _canvas);
		case TRIANGLE:
			return new GuiTriangle(shape, _canvas);
		default:
			throw new Exception("incorrect viewShape specified");
		}
	}
}
