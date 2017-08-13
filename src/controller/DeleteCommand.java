package controller;

import java.util.ArrayList;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.ISelectedShapeList;
import modelInterfaces.IShapeList;

public class DeleteCommand implements ICommand, IUndoable {
	private final IShapeList _shapeList;
	private final ISelectedShapeList _selectedShapeList;
	private final ArrayList<IDisplayableShape> _undoableSelectedShapelist = new ArrayList<IDisplayableShape>();
	
	public DeleteCommand(IShapeList shapeList) {
		_shapeList = shapeList;
		_selectedShapeList = shapeList;
	}

	@Override
	public void run() {
		for(IDisplayableShape shape : _selectedShapeList.getSelectedArrayList()) {
			_undoableSelectedShapelist.add(shape);
		}
		removeShapes(_selectedShapeList.getSelectedArrayList());
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		addShapes(_undoableSelectedShapelist);
	}

	@Override
	public void redo() {
		removeShapes(_undoableSelectedShapelist);
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
