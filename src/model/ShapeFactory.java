package model;

import controller.ApplicationSettings;
import controller.PaintColor;
import controller.Point;
import controller.ShadingType;
import controller.Shape;
import controller.ShapeType;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IDisplayableShapeFactory;
import modelInterfaces.IShapeFactory;
import modelInterfaces.IShapeList;
import viewInterfaces.IViewShape;
import viewInterfaces.IViewShapeFactory;

public class ShapeFactory implements IShapeFactory{
	private final ApplicationSettings   _settings;
	private final IShapeList _shapeList;
	private final IViewShapeFactory _viewShapeFactory;
	private final IDisplayableShapeFactory _displayableShapeFactory;
	

	public ShapeFactory(ApplicationSettings settings, IShapeList shapeList, 
						IViewShapeFactory viewShapeFactory, IDisplayableShapeFactory displayableShapeFactory) {
		_settings = settings;
		_shapeList = shapeList;
		_viewShapeFactory = viewShapeFactory;
		_displayableShapeFactory = displayableShapeFactory;
	}

	@Override
	public IDisplayableShape create(Point startingPoint, Point endingPoint) throws Exception {
		IViewShape viewShape = getIViewShape(startingPoint, endingPoint);
		IDisplayableShape displayableShape = getIDiplayableShape(viewShape);
		_shapeList.addToList(displayableShape);
		_shapeList.notifyObesrver();
		return displayableShape;
	}
	
	private IViewShape getIViewShape(Point startingPoint, Point endingPoint) throws Exception {
		ShapeType currentShape = _settings.getDrawShapeSettings().getCurrentShape();
		Shape shape = createShape(startingPoint, endingPoint);
		return _viewShapeFactory.createViewShape(currentShape, shape);
	}
	
	private IDisplayableShape getIDiplayableShape(IViewShape viewShape) throws Exception {
		ShadingType currentShadingType = _settings.getShadingTypeSettings().getCurrentShadingType();
		return _displayableShapeFactory.createDisplayShape(currentShadingType, viewShape);
	}

	private Shape createShape(Point startingPoint, Point endingPoint) {
		PaintColor primaryColor = _settings.getPrimaryColorSettings().getCurrentPrimaryColor();
		PaintColor secondaryColor = _settings.getSecondaryColorSettings().getCurrentSecondaryColor();
		return new Shape(primaryColor, secondaryColor, startingPoint, endingPoint);
	}
}
