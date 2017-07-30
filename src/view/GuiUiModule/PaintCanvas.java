package view.GuiUiModule;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import modelInterfaces.IShapeListObserver;

public class PaintCanvas extends JComponent implements IShapeListObserver{
//	private IShapeList _shapes;
//	
//	public PaintCanvas(IShapeList shapes) {
//		_shapes = shapes;
//	}

	@Override
	public void update(List<IDisplayableShape> shapes) {
		for(IDisplayableShape shape : shapes) {
			shape.display();
		}
		
	}
	
	public Graphics2D getGraphics2D() {
		return (Graphics2D)getGraphics();
	}
	
//	@Override
//	public void paint(Graphics graphics){
//        _shapes.notifyObesrver();
//	}
	
	
	
//	private int startX;
//	private int startY;
//	private int width;
//	private int height;
//	private ArrayList<Shape> shapeList = new ArrayList<Shape>();
//	private IPaintController paintController;
	
//	@Override
//	public void paint(Graphics graphics){
//        Graphics2D graphics2d = (Graphics2D)graphics;
////        graphics2d.setColor(Color.black);
////        graphics2d.fillRect(12, 13, 200, 400);
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.blue);
//        graphics2d.drawRect(startX, startY, width, height);
////        graphics2d.drawRect(12, 13, 200, 400);
//	}
//	
//	public void setStartPoint(int x, int y) {
//		startX = x;
//		startY = y;
//	}
//	
//	public void setEndPoint(int x, int y) {
//		width = x - startX;
//		height = y - startY;
//		paint(getGraphics());
//	}
//	
//	public void setPainterController(IPaintController paintController) {
//		this.paintController = paintController;
//	}
//	
//	public void createShape() {
//		PaintColor primaryColor = paintController.getPrimaryColor();
//		PaintColor secondaryColor = paintController.getSecondaryColor();
//		
//		Shape shape = ShapeFactory.createShape(startX, startY, width, height, primaryColor, secondaryColor);
//		shapeList.add(shape);
//		for(Shape shapeItem : shapeList) {
//			System.out.println(String.format("start Point at: (%d, %d)", shapeItem.getStartX(), shapeItem.getStartY()));
//		}
//	}
	
}
