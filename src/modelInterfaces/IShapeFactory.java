package modelInterfaces;

import controller.Point;

public interface IShapeFactory {

	void create(Point startingPoint, Point endingPoint) throws Exception;
}
