package controller;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import modelInterfaces.ICopiedShapeList;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.ISelectedShapeList;
import modelInterfaces.IShapeList;

public class CopyCommand implements ICommand{

	private final ISelectedShapeList _selectedShapeList;
	private final ICopiedShapeList _copiedShapeList;
	
	public CopyCommand(IShapeList shapeList) {
		_selectedShapeList = shapeList;
		_copiedShapeList = shapeList;		
	}
	
	@Override
	public void run() {
		for(IDisplayableShape shape : _selectedShapeList.getSelectedArrayList()) {
			_copiedShapeList.addToCopiedShapeList(shape);
		}
	}

}
