package controller;

import java.util.ArrayList;

import ControllerInterfaces.IUndoable;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import viewInterfaces.IStartAndEndPointCommand;

public class MoveCommand implements IStartAndEndPointCommand, IUndoable {
	private final IShapeList _shapeList;
	private final IShapeList _selectedShapelist;
	private int _horizontalDistance;
	private int _verticalDistance;
	private final ArrayList<IDisplayableShape> _undoableSelectedShapelist = new ArrayList<IDisplayableShape>();
	
	
	public MoveCommand(IShapeList shapeList, IShapeList selectedShapelist) {
		_shapeList = shapeList;
		_selectedShapelist = selectedShapelist;
	}

	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		if(_selectedShapelist.getArrayList().size() == 0) {
			return;
		}
		_horizontalDistance = endingPoint.getX() - startingPoint.getX();
		_verticalDistance = endingPoint.getY() - startingPoint.getY();
		for(IDisplayableShape shape : _selectedShapelist.getArrayList()) {
			_undoableSelectedShapelist.add(shape);
		}
		move(_selectedShapelist.getArrayList());
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		restore(_undoableSelectedShapelist);
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		move(_undoableSelectedShapelist);
	}
	
	private void move(ArrayList<IDisplayableShape> moveList) {
		Shape shape;
		for(IDisplayableShape displayableShape : moveList) {
			shape = displayableShape.getViewShape().getShape();
			shape.setStartX(_horizontalDistance + shape.getStartX());
			shape.setStartY(_verticalDistance + shape.getStartY());
			shape.setEndX(_horizontalDistance + shape.getEndX());
			shape.setEndY(_verticalDistance + shape.getEndY());
		}
		_shapeList.notifyObesrver();
	}
	
	private void restore(ArrayList<IDisplayableShape> restoreList) {
		Shape shape;
		for(IDisplayableShape displayableShape : restoreList) {
			shape = displayableShape.getViewShape().getShape();
			shape.setStartX(shape.getStartX() - _horizontalDistance);
			shape.setStartY(shape.getStartY() - _verticalDistance);
			shape.setEndX(shape.getEndX() - _horizontalDistance);
			shape.setEndY(shape.getEndY() - _verticalDistance);
		}
		_shapeList.notifyObesrver();
	}

}
