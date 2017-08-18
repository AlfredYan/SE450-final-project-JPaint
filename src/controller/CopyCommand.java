package controller;

import ControllerInterfaces.ICommand;
import model.CopyOperation;
import modelInterfaces.ICopyOperation;
import modelInterfaces.IShapeList;

public class CopyCommand implements ICommand{

	private final ICopyOperation _copyOperation;
	
	public CopyCommand(ICopyOperation copyOperation) {
		_copyOperation = copyOperation;
	}
	
	@Override
	public void run() {
		_copyOperation.copyShapes();
	}
}
