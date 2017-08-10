package view.GuiUiModule;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ControllerInterfaces.IMouseModeObserver;
import controller.CreateShapeCommand;
import controller.MouseMode;
import controller.MoveCommand;
import controller.Point;
import controller.SelectCommand;
import viewInterfaces.IStartAndEndPointCommand;

public class GuiMouseHandler extends MouseAdapter implements IMouseModeObserver{
	private Point _startingPoint;
	private Point _endingPoint;
	private Point _adjustedStartingPoint;
	private Point _adjustedEndingPoint;
	private IStartAndEndPointCommand _currentMode;
	private final SelectCommand _selectMode;
	private final MoveCommand _moveMode;
	private final CreateShapeCommand _drawMode;
	
	public GuiMouseHandler(IStartAndEndPointCommand drawCommand, 
							IStartAndEndPointCommand selectCommand, 
							IStartAndEndPointCommand moveCommand) {
		_drawMode = (CreateShapeCommand) drawCommand;
		_selectMode = (SelectCommand) selectCommand;
		_moveMode = (MoveCommand) moveCommand;
		_currentMode = _drawMode;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(String.format("mouse pressed at (%d, %d)", e.getX(), e.getY()));
		_startingPoint = new Point(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e){
		// TODO Auto-generated method stub
//		System.out.println(String.format("mouse released at (%d, %d)", e.getX(), e.getY()));
		_endingPoint = new Point(e.getX(), e.getY());
		try {
			_adjustedStartingPoint = getAdjustedStartingPoint(_startingPoint, _endingPoint);
			_adjustedEndingPoint = getAdjustedEndingPoint(_startingPoint, _endingPoint);
//			System.out.println(String.format(" _adjustedStartingPoint at (%d, %d)", _adjustedStartingPoint.getX(), _adjustedStartingPoint.getY()));
//			System.out.println(String.format("_adjustedEndingPoint at (%d, %d)", _adjustedEndingPoint.getX(), _adjustedEndingPoint.getY()));
			if(_currentMode == _moveMode) {
				_currentMode.run(_startingPoint, _endingPoint);
			} else {
				_currentMode.run(_adjustedStartingPoint, _adjustedEndingPoint);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void update(MouseMode currentmouseMode) {
		// TODO Auto-generated method stub
		switch (currentmouseMode) {
		case DRAW:
			_currentMode = _drawMode;
			break;
		case SELECT:
			_currentMode = _selectMode;
			break;
		case MOVE:
			_currentMode = _moveMode;
			break;
		default:
			try {
				throw new Exception("Incorrect Mouse mode");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
