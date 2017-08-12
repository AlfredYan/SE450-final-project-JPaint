package controller;

import java.util.ArrayList;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import viewInterfaces.UIModule;

public class SelectShapeCommand implements ICommand {
    private final ShapeTypeSettings _shapeSettings;
    private final UIModule _uiModule;
    SelectShapeCommand(ShapeTypeSettings shapeSettings, UIModule uiModule){
        _shapeSettings = shapeSettings;
        _uiModule = uiModule;
    }

    @Override
    public void run() {
        ShapeType shapeChoice = _uiModule.getDialogResponse(_shapeSettings);

        if(shapeChoice != null)
        		_shapeSettings.setCurrentShape(shapeChoice);
    }

}
