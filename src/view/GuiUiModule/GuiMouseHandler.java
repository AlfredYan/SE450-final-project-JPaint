package view.GuiUiModule;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ControllerInterfaces.IMouseModeObserver;
import controller.MouseMode;
import controller.Point;
import controller.SingletonStartAndEndPointCommandFactory;
import viewInterfaces.IStartAndEndPointCommand;

public class GuiMouseHandler extends MouseAdapter implements IMouseModeObserver{
	private Point _startingPoint;
	private Point _endingPoint;
	private Point _adjustedStartingPoint;
	private Point _adjustedEndingPoint;
	private MouseMode _currentMode;
	private IStartAndEndPointCommand _currentCommand;

	@Override
	public void mousePressed(MouseEvent e) {
		_startingPoint = new Point(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e){
		_endingPoint = new Point(e.getX(), e.getY());
		try {
			_adjustedStartingPoint = getAdjustedStartingPoint(_startingPoint, _endingPoint);
			_adjustedEndingPoint = getAdjustedEndingPoint(_startingPoint, _endingPoint);
			_currentCommand = SingletonStartAndEndPointCommandFactory.getInstance().createStartAndEndPointCommand(_currentMode);
			if(_currentMode.toString().toUpperCase() == "MOVE") {
				_currentCommand.run(_startingPoint, _endingPoint);
			} else {
				_currentCommand.run(_adjustedStartingPoint, _adjustedEndingPoint);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void update(MouseMode currentmouseMode) {
		_currentMode = currentmouseMode;
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

}
