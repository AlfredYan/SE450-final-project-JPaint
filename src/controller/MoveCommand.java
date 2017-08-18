package controller;

import ControllerInterfaces.IUndoable;
import modelInterfaces.IMoveOperation;
import viewInterfaces.IStartAndEndPointCommand;

public class MoveCommand implements IStartAndEndPointCommand, IUndoable {

	private final IMoveOperation _moveOperation;

	public MoveCommand(IMoveOperation moveOperation) {
		_moveOperation = moveOperation;
	}

	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		_moveOperation.moveShapes(startingPoint, endingPoint);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		_moveOperation.undoMove();
	}

	@Override
	public void redo() {
		_moveOperation.redoMove();
	}
	
	

}
