package controller;

import modelInterfaces.IShapeList;
import viewInterfaces.IStartAndEndPointCommand;

public class SelectCommand implements IStartAndEndPointCommand {
	
	private final SelectOperation _selectOperation;

	public SelectCommand(IShapeList shapeList) {
		_selectOperation = new SelectOperation(shapeList);
	}
	
	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		_selectOperation.selectShapes(startingPoint, endingPoint);
	}

}
