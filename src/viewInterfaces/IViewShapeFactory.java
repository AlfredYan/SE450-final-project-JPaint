package viewInterfaces;

import controller.Shape;
import controller.ShapeType;

public interface IViewShapeFactory {

	IViewShape createViewShape(ShapeType currentShape, Shape shape) throws Exception;
}
