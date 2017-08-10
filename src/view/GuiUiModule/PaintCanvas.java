package view.GuiUiModule;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import modelInterfaces.IShapeListObserver;

public class PaintCanvas extends JComponent implements IShapeListObserver{

	@Override
	public void update(List<IDisplayableShape> shapes) {
		for(IDisplayableShape shape : shapes) {
			shape.display();
		}
		
	}
	
	public Graphics2D getGraphics2D() {
		return (Graphics2D)getGraphics();
	}
	
}
