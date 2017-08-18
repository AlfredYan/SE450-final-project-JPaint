package model;

import java.util.ArrayList;

import controller.Shape;
import modelInterfaces.ICopiedShapeList;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IPasteOperation;
import modelInterfaces.IShapeList;

public class PasteOperation implements IPasteOperation{

	private final IShapeList _shapeList;
	private final ICopiedShapeList _copiedShapeList;
	private final ArrayList<IDisplayableShape> _undoableCopiedShapelist = new ArrayList<IDisplayableShape>();
	
	public PasteOperation(IShapeList shapeList) {
		_shapeList = shapeList;
		_copiedShapeList = shapeList;
	}
	
	@Override
	public void pasteShapes() {
		cloneToUndoableList(_copiedShapeList.getCopiedArrayList());
		addShapes(_undoableCopiedShapelist);
	}
	
	@Override
	public void undoPaste() {
		removeShapes(_undoableCopiedShapelist);
	}
	
	@Override
	public void redoPaste() {
		addShapes(_undoableCopiedShapelist);
	}
	
	private void cloneToUndoableList(ArrayList<IDisplayableShape> copiedShapeList) {
		if(copiedShapeList.size() == 0)
			return;
		Shape shape;
		for(IDisplayableShape displayableShape : copiedShapeList) {
			try {
				IDisplayableShape pastedDisplayableShape = displayableShape.clone();
				_undoableCopiedShapelist.add(pastedDisplayableShape);
				shape = pastedDisplayableShape.getViewShape().getShape();
				resetPoint(shape);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void resetPoint(Shape shape) {
		int height = shape.getHeight();
		int width = shape.getWidth();
		shape.setStartX(0);
		shape.setStartY(0);
		shape.setEndX(width);
		shape.setEndY(height);
	}
	
	private void addShapes(ArrayList<IDisplayableShape> addList) {
		for(IDisplayableShape displayableShape : addList) {
			_shapeList.addToList(displayableShape);
		}
		_shapeList.notifyObesrver();
	}
	
	private void removeShapes(ArrayList<IDisplayableShape> removeList) {
		for(IDisplayableShape displayableShape : removeList) {
			_shapeList.removeShape(displayableShape);
		}
		_shapeList.notifyObesrver();
	}
}
