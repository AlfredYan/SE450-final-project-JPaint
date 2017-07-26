package controller;


public class Shape {
	private int _startX;
	private int _startY;
	private int _width;
	private int _height;
	private PaintColor _primaryColor;
	private PaintColor _secondaryColor;
	
	public Shape(int startX, int startY, int width, int height, PaintColor primaryColor, PaintColor secondaryColor) {
		_startX = startX;
		_startY = startY;
		_width = width;
		_height = height;
		_primaryColor = primaryColor;
		_secondaryColor = secondaryColor;
		
	}
}
