package controller;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import modelInterfaces.IShapeList;

public class DeleteCommand implements ICommand, IUndoable {
	private final DeleteOperation _deleteOperation;
	
	public DeleteCommand(IShapeList shapeList) {
		_deleteOperation = new DeleteOperation(shapeList);
	}

	@Override
	public void run() {
		_deleteOperation.deleteShapes();
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		_deleteOperation.undoDelete();
	}

	@Override
	public void redo() {
		_deleteOperation.redoDelete();
	}

}
