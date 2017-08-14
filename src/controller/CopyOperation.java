package controller;

import modelInterfaces.ICopiedShapeList;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.ISelectedShapeList;
import modelInterfaces.IShapeList;

public class CopyOperation {
	
	private final ISelectedShapeList _selectedShapeList;
	private final ICopiedShapeList _copiedShapeList;

	public CopyOperation(IShapeList shapeList) {
		_selectedShapeList = shapeList;
		_copiedShapeList = shapeList;
	}
	
	public void copyShapes() {
		for(IDisplayableShape shape : _selectedShapeList.getSelectedArrayList()) {
			try {
				_copiedShapeList.addToCopiedShapeList(shape.clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
