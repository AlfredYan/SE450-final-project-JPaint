package view.GuiUiModule;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import controller.IPaintController;
import controller.JPaintController;

public class GuiMouseHandler implements MouseListener, MouseMotionListener {
	private PaintCanvas canvas;
	private IPaintController paintController;
	
	public GuiMouseHandler(PaintCanvas canvas, IPaintController painterControler) {
		this.canvas = canvas;
		this.paintController = painterControler;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(String.format("mouse dragged at (%d, %d)", e.getX(), e.getY()));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(String.format("mouse clicked at (%d, %d)", e.getX(), e.getY()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(String.format("mouse pressed at (%d, %d)", e.getX(), e.getY()));
		canvas.setStartPoint(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(String.format("mouse released at (%d, %d)", e.getX(), e.getY()));
		System.out.println(paintController.getSelectedShape().toString());
		canvas.setEndPoint(e.getX(), e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
