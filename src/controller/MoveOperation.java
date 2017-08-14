package controller;

import java.util.ArrayList;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.ISelectedShapeList;
import modelInterfaces.IShapeList;

public class MoveOperation {
	
	private final IShapeList _shapeList;
	private final ISelectedShapeList _selectedShapelist;
	private int _horizontalDistance;
	private int _verticalDistance;
	private final ArrayList<IDisplayableShape> _undoableSelectedShapelist = new ArrayList<IDisplayableShape>();

	public MoveOperation(IShapeList shapeList) {
		_shapeList = shapeList;
		_selectedShapelist = shapeList;
	}
	
	public void moveShapes(Point startingPoint, Point endingPoint) {
		if(_selectedShapelist.getSelectedArrayList().size() == 0) {
			return;
		}
		_horizontalDistance = endingPoint.getX() - startingPoint.getX();
		_verticalDistance = endingPoint.getY() - startingPoint.getY();
		for(IDisplayableShape shape : _selectedShapelist.getSelectedArrayList()) {
			_undoableSelectedShapelist.add(shape);
		}
		move(_selectedShapelist.getSelectedArrayList());
	}
	
	public void undoMove() {
		restore(_undoableSelectedShapelist);
	}
	
	public void redoMove() {
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
