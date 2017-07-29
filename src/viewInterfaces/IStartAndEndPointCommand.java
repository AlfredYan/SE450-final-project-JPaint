package viewInterfaces;

import controller.Point;

public interface IStartAndEndPointCommand {

	void run(Point startingPoint, Point endingPoint) throws Exception;
}
