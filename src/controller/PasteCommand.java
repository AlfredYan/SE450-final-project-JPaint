package controller;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import model.PasteOperation;
import modelInterfaces.IPasteOperation;
import modelInterfaces.IShapeList;

public class PasteCommand implements ICommand, IUndoable {
	
	private final IPasteOperation _pasteOperation;
	
	public PasteCommand(IPasteOperation pasteOperation) {
		_pasteOperation = pasteOperation;
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
