package controller;

import java.util.ArrayList;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.ISelectedShapeList;
import modelInterfaces.IShapeList;

public class DeleteOperation {
	private final IShapeList _shapeList; 
	private final ISelectedShapeList _selectedShapeList; 
	private final ArrayList<IDisplayableShape> _undoableSelectedShapelist = new ArrayList<IDisplayableShape>();
	
	public DeleteOperation(IShapeList shapeList) {
		_shapeList = shapeList;
		_selectedShapeList = shapeList;
	}
	
	public void deleteShapes() {
		cacheToUndoableList(_selectedShapeList.getSelectedArrayList());
		removeShapes(_selectedShapeList.getSelectedArrayList());
	}
	
	public void undoDelete() {
		addShapes(_undoableSelectedShapelist);
	}
	
	public void redoDelete() {
		removeShapes(_undoableSelectedShapelist);
	}

	private void cacheToUndoableList(ArrayList<IDisplayableShape> selectedShapelist) {
		for(IDisplayableShape shape : selectedShapelist) {
			_undoableSelectedShapelist.add(shape);
		}
	}
	
	private void removeShapes(ArrayList<IDisplayableShape> removeList) {
		for(IDisplayableShape shape : removeList) {
			_shapeList.removeShape(shape);
		}
		_shapeList.notifyObesrver();
	}
	
	private void addShapes(ArrayList<IDisplayableShape> addList) {
		for(IDisplayableShape shape : addList) {
			_shapeList.addToList(shape);
		}
		_shapeList.notifyObesrver();
	}
}
