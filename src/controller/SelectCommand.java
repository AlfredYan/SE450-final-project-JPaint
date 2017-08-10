package controller;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import viewInterfaces.IStartAndEndPointCommand;

public class SelectCommand implements IStartAndEndPointCommand {
	
	private final IShapeList _shapeList;
	private final IShapeList _selectedShapeList;

	public SelectCommand(IShapeList shapeList, IShapeList selectedShapeList) {
		_shapeList = shapeList;
		_selectedShapeList = selectedShapeList;
	}
	
	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		// TODO Auto-generated method stub
		if(_selectedShapeList.getArrayList().size() != 0) {
			_selectedShapeList.getArrayList().clear();
			System.out.println("selectedShapeList is empty !");
		}
		for(IDisplayableShape shape : _shapeList.getArrayList()) {
			if(startingPoint.getX() == endingPoint.getX() && startingPoint.getY() == endingPoint.getY()) {
				// click to select
				if(shape.getViewShape().getShape().getStartX() <= startingPoint.getX()
						&& shape.getViewShape().getShape().getStartY() <= startingPoint.getY()
						&& shape.getViewShape().getShape().getEndX() >= endingPoint.getX()
						&& shape.getViewShape().getShape().getEndY() >= endingPoint.getY()) {
					System.out.println("click to select !");
					_selectedShapeList.addToList(shape);
				}
			}else {
				// drag to select
				if(shape.getViewShape().getShape().getStartX() >= startingPoint.getX()
						&& shape.getViewShape().getShape().getStartY() >= startingPoint.getY()
						&& shape.getViewShape().getShape().getEndX() <= endingPoint.getX()
						&& shape.getViewShape().getShape().getEndY() <= endingPoint.getY()) {
					System.out.println("drag to select !");
					_selectedShapeList.addToList(shape);
				}
			}
		}
	}

}
