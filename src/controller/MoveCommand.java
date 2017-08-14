package controller;

import ControllerInterfaces.IUndoable;
import modelInterfaces.IShapeList;
import viewInterfaces.IStartAndEndPointCommand;

public class MoveCommand implements IStartAndEndPointCommand, IUndoable {

	private final MoveOperation _moveOperation;

	public MoveCommand(IShapeList shapeList) {
		_moveOperation = new MoveOperation(shapeList);
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
