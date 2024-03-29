package model;

import modelInterfaces.IDisplayableShape;
import viewInterfaces.IViewShape;

public class FilledAndOutlineShape implements IDisplayableShape {
	
	private final IViewShape _viewShape;
	
	public FilledAndOutlineShape(IViewShape viewShape) {
		_viewShape = viewShape;
	}

	@Override
	public void display() {
		_viewShape.displayFilled(_viewShape.getSecondaryColor());
		_viewShape.displayOutline(_viewShape.getPrimaryColor());
	}

	@Override
	public IViewShape getViewShape() {
		return _viewShape;
	}
	
	@Override
	public IDisplayableShape clone() throws CloneNotSupportedException {
		return new FilledAndOutlineShape(_viewShape.clone());
	}

}
