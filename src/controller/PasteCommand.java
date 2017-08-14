package controller;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import modelInterfaces.IShapeList;

public class PasteCommand implements ICommand, IUndoable {
	
	private final PasteOperation _pasteOperation;
	
	public PasteCommand(IShapeList shapeList) {
		_pasteOperation = new PasteOperation(shapeList);
	}

	@Override
	public void run() {
		_pasteOperation.pasteShapes();
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		_pasteOperation.undoPaste();
	}

	@Override
	public void redo() {
		_pasteOperation.redoPaste();
	}

}
