package controller;

import java.util.ArrayList;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import viewInterfaces.UIModule;

public class SelectShapeCommand implements ICommand, IUndoable {
    private final ShapeTypeSettings _shapeSettings;
    private final UIModule _uiModule;
    private ArrayList<ShapeType> _undoShapeTypeList = new ArrayList<ShapeType>();
    private ArrayList<ShapeType> _redoShapeTypeList = new ArrayList<ShapeType>();
    SelectShapeCommand(ShapeTypeSettings shapeSettings, UIModule uiModule){
        _shapeSettings = shapeSettings;
        _uiModule = uiModule;
    }

    @Override
    public void run() {
    		_undoShapeTypeList.add(_shapeSettings.getCurrentShape());
        ShapeType shapeChoice = _uiModule.getDialogResponse(_shapeSettings);

        if(shapeChoice != null)
        		_shapeSettings.setCurrentShape(shapeChoice);
        		CommandHistory.add(this);
    }

	@Override
	public void undo() {
		if(_undoShapeTypeList.size() == 0) {
			return;
		}
		System.out.println("undo " + _shapeSettings.getCurrentShape() + " to: " + _undoShapeTypeList.get(_undoShapeTypeList.size()-1));
		_redoShapeTypeList.add(_shapeSettings.getCurrentShape());
		_shapeSettings.setCurrentShape(_undoShapeTypeList.get(_undoShapeTypeList.size()-1));
		_undoShapeTypeList.remove(_undoShapeTypeList.size()-1);	
	}

	@Override
	public void redo() {
		if(_redoShapeTypeList.size() == 0) {
			return;
		}
		System.out.println("redo " + _shapeSettings.getCurrentShape() + " to: " + _redoShapeTypeList.get(_redoShapeTypeList.size()-1));
		_undoShapeTypeList.add(_shapeSettings.getCurrentShape());
		_shapeSettings.setCurrentShape(_redoShapeTypeList.get(_redoShapeTypeList.size()-1));
		_redoShapeTypeList.remove(_redoShapeTypeList.size()-1);
	}
}
