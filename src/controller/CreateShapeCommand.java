package controller;

import modelInterfaces.IShapeFactory;
import viewInterfaces.IStartAndEndPointCommand;

public class CreateShapeCommand implements IStartAndEndPointCommand{
	
	private final IShapeFactory _shapeFactory;
	
	public CreateShapeCommand(IShapeFactory shapeFactory) {
		_shapeFactory = shapeFactory;
	}

	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		_shapeFactory.create(startingPoint, endingPoint);
	}

}
