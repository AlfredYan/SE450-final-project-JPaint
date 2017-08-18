package controller;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import model.DeleteOperation;
import modelInterfaces.IDeleteOperation;
import modelInterfaces.IShapeList;

public class DeleteCommand implements ICommand, IUndoable {
	private final IDeleteOperation _deleteOperation;
	
	public DeleteCommand(IDeleteOperation deleteOperation) {
		_deleteOperation = deleteOperation;
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
