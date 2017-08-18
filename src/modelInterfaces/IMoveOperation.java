package modelInterfaces;

import controller.Point;

public interface IMoveOperation {

	void moveShapes(Point startingPoint, Point endingPoint);

	void undoMove();

	void redoMove();

}
