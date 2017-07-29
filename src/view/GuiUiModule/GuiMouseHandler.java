package view.GuiUiModule;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.IPaintController;
import controller.Point;
import model.ShapeFactory;
import viewInterfaces.IStartAndEndPointCommand;
import controller.Shape;

public class GuiMouseHandler extends MouseAdapter {
	private Point _startingPoint;
	private Point _endingPoint;
	private final IStartAndEndPointCommand _command;
	
	public GuiMouseHandler(IStartAndEndPointCommand command) {
		_command = command;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(String.format("mouse pressed at (%d, %d)", e.getX(), e.getY()));
		_startingPoint = new Point(e.getX(), e.getY());
//		canvas.setStartPoint(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e){
		// TODO Auto-generated method stub
		System.out.println(String.format("mouse released at (%d, %d)", e.getX(), e.getY()));
		_endingPoint = new Point(e.getX(), e.getY());
		try {
			_command.run(_startingPoint, _endingPoint);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		canvas.setEndPoint(e.getX(), e.getY());
//		canvas.createShape();
	}

}
