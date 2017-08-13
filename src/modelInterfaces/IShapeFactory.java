package modelInterfaces;

import controller.Point;

public interface IShapeFactory {

	IDisplayableShape create(Point startingPoint, Point endingPoint) throws Exception;
}
