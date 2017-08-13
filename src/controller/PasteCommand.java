package controller;

import java.util.ArrayList;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import modelInterfaces.ICopiedShapeList;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import view.GuiViewShapeFactory;
import view.GuiUiModule.PaintCanvas;
import viewInterfaces.IViewShape;
import viewInterfaces.IViewShapeFactory;

public class PasteCommand implements ICommand, IUndoable {
	private final IShapeList _shapeList;
	private final ICopiedShapeList _copiedShapeList;
//	private final ApplicationSettings _settings;
	private final ArrayList<IDisplayableShape> _undoableCopiedShapelist = new ArrayList<IDisplayableShape>();
	
	public PasteCommand(IShapeList shapeList) {
		_shapeList = shapeList;
		_copiedShapeList = shapeList;
//		_settings = settings;
	}

	@Override
	public void run() {
		if(_copiedShapeList.getCopiedArrayList().size() == 0)
			return;
		
		Shape shape;
		IViewShape viewShape;
		for(IDisplayableShape displayableShape : _copiedShapeList.getCopiedArrayList()) {
			shape = displayableShape.getViewShape().getShape();
			viewShape = displayableShape.getViewShape();
			Point newStartingPoint = new Point(0, 0);
			PaintCanvas canvas = viewShape.getCanvas();
			IViewShapeFactory viewShapeFactory = new GuiViewShapeFactory(canvas);
		}
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
