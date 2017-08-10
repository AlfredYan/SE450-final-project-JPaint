package controller;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import viewInterfaces.IStartAndEndPointCommand;

public class MoveCommand implements IStartAndEndPointCommand {
	private final IShapeList _shapeList;
	private final IShapeList _selectedShapelist;
	private int _horizontalDistance;
	private int _verticalDistance;
	
	
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
			shape.getViewShape().getShape().setStartX(_horizontalDistance + shape.getViewShape().getShape().getStartX());
			shape.getViewShape().getShape().setStartY(_verticalDistance + shape.getViewShape().getShape().getStartY());
			shape.getViewShape().getShape().setEndX(_horizontalDistance + shape.getViewShape().getShape().getEndX());
			shape.getViewShape().getShape().setEndY(_verticalDistance + shape.getViewShape().getShape().getEndY());
		}
		System.out.println("Move");
		_shapeList.notifyObesrver();
	}

}
