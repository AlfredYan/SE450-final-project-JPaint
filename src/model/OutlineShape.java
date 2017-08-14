package model;

import modelInterfaces.IDisplayableShape;
import viewInterfaces.IViewShape;

public class OutlineShape implements IDisplayableShape{
	
	private final IViewShape _viewShape;
	
	public OutlineShape(IViewShape viewShape) {
		_viewShape = viewShape;
	}

	@Override
	public void display() {
		_viewShape.displayOutline(_viewShape.getPrimaryColor());
	}

	@Override
	public IViewShape getViewShape() {
		return _viewShape;
	}
	
	@Override
	public IDisplayableShape clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return new OutlineShape(_viewShape.clone());
	}

}
