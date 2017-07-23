package view.GuiUiModule;


import java.awt.*;
import java.util.ArrayList;

import javax.swing.JComponent;

import modelInterfaces.IShape;

public class PaintCanvas extends JComponent {
	private int startX;
	private int startY;
	private int width;
	private int height;
	private ArrayList<IShape> shapeList;
	
	@Override
	public void paint(Graphics graphics){
        Graphics2D graphics2d = (Graphics2D)graphics;
//        graphics2d.setColor(Color.black);
//        graphics2d.fillRect(12, 13, 200, 400);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.blue);
        graphics2d.drawRect(startX, startY, width, height);
//        graphics2d.drawRect(12, 13, 200, 400);
	}
	
	public void setStartPoint(int x, int y) {
		startX = x;
		startY = y;
	}
	
	public void setEndPoint(int x, int y) {
		width = x - startX;
		height = y - startY;
		paint(getGraphics());
	}
}
