package model;

import modelInterfaces.IDisplayableShape;
import viewInterfaces.IViewShape;

public class FilledShape implements IDisplayableShape {
	
	private final IViewShape _viewShape;
	
	public FilledShape(IViewShape viewShape) {
		_viewShape = viewShape;
	}

	@Override
	public void display() {
		_viewShape.displayFilled(_viewShape.getPrimaryColor());
	}

	@Override
	public IViewShape getViewShape() {
		return _viewShape;
	}

}
