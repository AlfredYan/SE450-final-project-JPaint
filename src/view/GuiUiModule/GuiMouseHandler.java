package view.GuiUiModule;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GuiMouseHandler implements MouseListener, MouseMotionListener {
	private PaintCanvas canvas;
	
	public GuiMouseHandler(PaintCanvas canvas) {
		this.canvas = canvas;
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
