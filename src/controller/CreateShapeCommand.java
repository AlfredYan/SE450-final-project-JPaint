package controller;

import ControllerInterfaces.IUndoable;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeFactory;
import modelInterfaces.IShapeList;
import viewInterfaces.IStartAndEndPointCommand;

public class CreateShapeCommand implements IStartAndEndPointCommand, IUndoable {
	
	private final IShapeFactory _shapeFactory;
	
	public CreateShapeCommand(IShapeFactory shapeFactory) {
		_shapeFactory = shapeFactory;
	}

	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		_shapeFactory.create(startingPoint, endingPoint);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		_shapeFactory.undoCreateShape();
	}

	@Override
	public void redo() {
		_shapeFactory.redoCreateShpae();
	}

}
