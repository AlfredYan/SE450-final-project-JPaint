package controller;

import modelInterfaces.ISelectOperation;
import viewInterfaces.IStartAndEndPointCommand;

public class SelectCommand implements IStartAndEndPointCommand {
	
	private final ISelectOperation _selectOperation;

	public SelectCommand(ISelectOperation selectOperation) {
		_selectOperation = selectOperation;
	}
	
	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		_selectOperation.selectShapes(startingPoint, endingPoint);
	}

}
