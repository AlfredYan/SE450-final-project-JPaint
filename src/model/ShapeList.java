package model;

import java.util.ArrayList;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import view.GuiUiModule.PaintCanvas;

public class ShapeList implements IShapeList {

	private final ArrayList<IDisplayableShape> _shapelist;
	private final ArrayList<IDisplayableShape> _selectedShapelist;
	private final ArrayList<IDisplayableShape> _copiedShapelist;
	private PaintCanvas _canvas;
	
	public ShapeList() {
		_shapelist = new ArrayList<IDisplayableShape>();
		_selectedShapelist = new ArrayList<IDisplayableShape>();
		_copiedShapelist = new ArrayList<IDisplayableShape>();
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
	public void removeShape(IDisplayableShape displayableShape) {
		_shapelist.remove(displayableShape);
	}

	@Override
	public ArrayList<IDisplayableShape> getArrayList() {
		return _shapelist;
	}

	@Override
	public void addToSelectedShapeList(IDisplayableShape displayableShape) {
		_selectedShapelist.add(displayableShape);
	}

	@Override
	public ArrayList<IDisplayableShape> getSelectedArrayList() {
		return _selectedShapelist;
	}

	@Override
	public void addToCopiedShapeList(IDisplayableShape displayableShape) {
		_copiedShapelist.add(displayableShape);
	}

	@Override
	public ArrayList<IDisplayableShape> getCopiedArrayList() {
		return _copiedShapelist;
	}
	
}
