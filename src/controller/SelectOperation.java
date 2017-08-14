package controller;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.ISelectedShapeList;
import modelInterfaces.IShapeList;

public class SelectOperation {

	private final IShapeList _shapeList;
	private final ISelectedShapeList _selectedShapeList;
	
	public SelectOperation(IShapeList shapeList) {
		_shapeList = shapeList;
		_selectedShapeList = shapeList;
	}
	
	public void selectShapes(Point startingPoint, Point endingPoint) {
		addSeletedShapes(startingPoint, endingPoint);
	}
	
	private void addSeletedShapes(Point startingPoint, Point endingPoint) {
		if(_selectedShapeList.getSelectedArrayList().size() != 0) {
			_selectedShapeList.getSelectedArrayList().clear();
		}
		Shape shape;
		for(IDisplayableShape displayableShapeshape : _shapeList.getArrayList()) {
			shape = displayableShapeshape.getViewShape().getShape();
			boolean isSelectedByClick = selectByClick(startingPoint, endingPoint, shape);
			boolean isSelectedByDrag = selectByDrag(startingPoint, endingPoint, shape);
			if(isSelectedByClick || isSelectedByDrag) {
				_selectedShapeList.addToSelectedShapeList(displayableShapeshape);
			}
		}
	}
	
	private boolean selectByClick(Point startingPoint, Point endingPoint, Shape shape) {
		boolean isSelected = false;
		if(startingPoint.getX() == endingPoint.getX() && startingPoint.getY() == endingPoint.getY()) {
			// click to select
			if(shape.getStartX() <= startingPoint.getX()
					&& shape.getStartY() <= startingPoint.getY()
					&& shape.getEndX() >= endingPoint.getX()
					&& shape.getEndY() >= endingPoint.getY()) {
				isSelected = true;
			}
		}
		return isSelected;
	}
	
	private boolean selectByDrag(Point startingPoint, Point endingPoint, Shape shape) {
		boolean isSelected = false;
		if(shape.getStartX() >= startingPoint.getX()
				&& shape.getStartY() >= startingPoint.getY()
				&& shape.getEndX() <= endingPoint.getX()
				&& shape.getEndY() <= endingPoint.getY()) {
			isSelected = true;
		}
		return isSelected;
	}
}
