package model;

import java.util.ArrayList;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import view.GuiUiModule.PaintCanvas;

public class ShapeList implements IShapeList {

	private final ArrayList<IDisplayableShape> _shapelist;
	private PaintCanvas _canvas;
	
	public ShapeList() {
		_shapelist = new ArrayList<IDisplayableShape>();
	}

	@Override
	public void addToList(IDisplayableShape displayableShape) {
		_shapelist.add(displayableShape);
//		notifyObesrver();
	}

	@Override
	public void registerObserver(PaintCanvas canvas) {
		_canvas = canvas;
	}

	@Override
	public void notifyObesrver() {
		_canvas.getGraphics2D().clearRect(0, 0, _canvas.getWidth(), _canvas.getHeight());
		_canvas.update(_shapelist);
	}

	@Override
	public ArrayList<IDisplayableShape> getArrayList() {
		return _shapelist;
	}

	@Override
	public IDisplayableShape pop() {
		IDisplayableShape displayableShape = _shapelist.get(_shapelist.size()-1);
		_shapelist.remove(_shapelist.size()-1);
		return displayableShape;
	}
	
}
