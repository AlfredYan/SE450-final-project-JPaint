package model;

import java.util.ArrayList;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import view.GuiUiModule.PaintCanvas;

public class SelectedShapeList implements IShapeList {

	private final ArrayList<IDisplayableShape> _SelectedShapeList;
	private PaintCanvas _canvas;
	
	public SelectedShapeList() {
		_SelectedShapeList = new ArrayList<IDisplayableShape>();				
	}
	
	@Override
	public void addToList(IDisplayableShape displayableShape) {
		_SelectedShapeList.add(displayableShape);
	}

	@Override
	public void registerObserver(PaintCanvas canvas) {
		_canvas = canvas;
	}

	@Override
	public ArrayList<IDisplayableShape> getArrayList() {
		return _SelectedShapeList;
	}

	@Override
	public void notifyObesrver() {
		_canvas.repaint();
	}

}
