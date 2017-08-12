package controller;

import ControllerInterfaces.IUndoable;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeFactory;
import modelInterfaces.IShapeList;
import viewInterfaces.IStartAndEndPointCommand;

public class CreateShapeCommand implements IStartAndEndPointCommand, IUndoable {
	
	private final IShapeFactory _shapeFactory;
	private final IShapeList _shapeList;
	private IDisplayableShape _displayableShape;
	
	public CreateShapeCommand(IShapeFactory shapeFactory, IShapeList shapeList) {
		_shapeFactory = shapeFactory;
		_shapeList = shapeList;
	}

	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		_shapeFactory.create(startingPoint, endingPoint);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		_displayableShape = _shapeList.pop();
		_shapeList.notifyObesrver();
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		_shapeList.addToList(_displayableShape);
		_shapeList.notifyObesrver();
	}

}
