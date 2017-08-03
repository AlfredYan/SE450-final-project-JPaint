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
	private IStartAndEndPointCommand _currentState;
	private final SelectCommand _selectState = new SelectCommand();
	private final MoveCommand _moveState = new MoveCommand();
	private final CreateShapeCommand _drawState;
	
	public GuiMouseHandler(IStartAndEndPointCommand command) {
		_drawState = (CreateShapeCommand) command;
		_currentState = _drawState;
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
			_currentState.run(_startingPoint, _endingPoint);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		canvas.setEndPoint(e.getX(), e.getY());
//		canvas.createShape();
	}

	@Override
	public void update(MouseMode currentmouseMode) {
		// TODO Auto-generated method stub
		switch (currentmouseMode) {
		case DRAW:
			_currentState = _drawState;
			break;
		case SELECT:
			_currentState = _selectState;
			break;
		case MOVE:
			_currentState = _moveState;
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

}
