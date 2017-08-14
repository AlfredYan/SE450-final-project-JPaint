package controller;

import ControllerInterfaces.ICommand;
import modelInterfaces.IShapeList;

public class CopyCommand implements ICommand{

	private final CopyOperation _copyOperation;
	
	public CopyCommand(IShapeList shapeList) {
		_copyOperation = new CopyOperation(shapeList);
	}
	
	@Override
	public void run() {
		_copyOperation.copyShapes();
	}
}
