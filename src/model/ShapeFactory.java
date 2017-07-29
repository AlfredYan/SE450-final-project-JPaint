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
	

	public ShapeFactory(ApplicationSettings settings, IShapeList shapeList, IViewShapeFactory viewShapeFactory, IDisplayableShapeFactory displayableShapeFactory) {
		_settings = settings;
		_shapeList = shapeList;
		_viewShapeFactory = viewShapeFactory;
		_displayableShapeFactory = displayableShapeFactory;
	}

	@Override
	public void create(Point startingPoint, Point endingPoint) throws Exception {
		Point adjuestedStartingPoint = getAdjustedStartingPoint(startingPoint, endingPoint);
		Point adjustedEndingPoint = getAdjustedEndingPoint(startingPoint, endingPoint);
		IViewShape viewShape = getIViewShape(adjuestedStartingPoint, adjustedEndingPoint);
		IDisplayableShape displayableShape = getIDiplayableShape(viewShape);
		_shapeList.addToList(displayableShape);
	}
	
	private Point getAdjustedStartingPoint(Point startingPoint, Point endingPoint) {
		int startingX = Math.min(startingPoint.getX(), endingPoint.getX());
		int startingY = Math.min(startingPoint.getY(), endingPoint.getY());
		
		return new Point(startingX, startingY);
	}
	
	private Point getAdjustedEndingPoint(Point startingPoint, Point endingPoint) {
		int endingX = Math.max(startingPoint.getX(), endingPoint.getX());
		int endingY = Math.max(startingPoint.getY(), endingPoint.getY());
		
		return new Point(endingX, endingY);
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
