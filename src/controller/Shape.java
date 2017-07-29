package controller;


public class Shape {
	private Point _startPoint;
	private Point _endPoint;
	private PaintColor _primaryColor;
	private PaintColor _secondaryColor;
	
	public Shape(PaintColor primaryColor, PaintColor secondaryColor, Point startPoint, Point endPoint) {
		_primaryColor = primaryColor;
		_secondaryColor = secondaryColor;
		_startPoint = startPoint;
		_endPoint = endPoint;
	}
	
	public int getStartX() {
		return _startPoint.getX();
	}
	
	public int getStartY() {
		return _startPoint.getY();
	}
	
	public int getEndX() {
		return _endPoint.getX();
	}
	
	public int getEndY() {
		return _endPoint.getY();
	}
	
	public int getWidth() {
		return getEndX() - getStartX();
	}
	
	public int getHeight() {
		return getEndY() - getStartY();
	}
	
	public PaintColor getPrimaryColor() {
		return _primaryColor;
	}
	
	public PaintColor getSecondaryColor() {
		return _secondaryColor;
	}
}
