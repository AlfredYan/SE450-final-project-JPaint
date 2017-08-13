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
	
	public void setStartX(int startX) {
		_startPoint.setX(startX);
	}
	
	public int getStartY() {
		return _startPoint.getY();
	}
	
	public void setStartY(int startY) {
		_startPoint.setY(startY);
	}
	
	public int getEndX() {
		return _endPoint.getX();
	}
	
	public void setEndX(int endX) {
		_endPoint.setX(endX);
	}
	
	public int getEndY() {
		return _endPoint.getY();
	}
	
	public void setEndY(int endY) {
		_endPoint.setY(endY);
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
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
