package controller;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.ISelectedShapeList;
import modelInterfaces.IShapeList;
import viewInterfaces.IStartAndEndPointCommand;

public class SelectCommand implements IStartAndEndPointCommand {
	
	private final IShapeList _shapeList;
	private final ISelectedShapeList _selectedShapeList;

	public SelectCommand(IShapeList shapeList) {
		_shapeList = shapeList;
		_selectedShapeList = shapeList;
	}
	
	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		// TODO Auto-generated method stub
		if(_selectedShapeList.getSelectedArrayList().size() != 0) {
			_selectedShapeList.getSelectedArrayList().clear();
		}
		Shape shape;
		for(IDisplayableShape displayableShapeshape : _shapeList.getArrayList()) {
			shape = displayableShapeshape.getViewShape().getShape();
			if(startingPoint.getX() == endingPoint.getX() && startingPoint.getY() == endingPoint.getY()) {
				// click to select
				if(shape.getStartX() <= startingPoint.getX()
						&& shape.getStartY() <= startingPoint.getY()
						&& shape.getEndX() >= endingPoint.getX()
						&& shape.getEndY() >= endingPoint.getY()) {
					System.out.println("click to select !");
					_selectedShapeList.addToSelectedShapeList(displayableShapeshape);
				}
			}else {
				// drag to select
				if(shape.getStartX() >= startingPoint.getX()
						&& shape.getStartY() >= startingPoint.getY()
						&& shape.getEndX() <= endingPoint.getX()
						&& shape.getEndY() <= endingPoint.getY()) {
					System.out.println("drag to select !");
					_selectedShapeList.addToSelectedShapeList(displayableShapeshape);
				}
			}
		}
	}

}
