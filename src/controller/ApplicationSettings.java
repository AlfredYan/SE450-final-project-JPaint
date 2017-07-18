package controller;

import viewInterfaces.IDialogChoice;

class ApplicationSettings {
    private ShapeSettings drawShapeSettings = new ShapeSettings();
    private MouseModeSettings mouseModeSettings = new MouseModeSettings();

    ShapeSettings getDrawShapeSettings() {
        return drawShapeSettings;
    }
    
    MouseModeSettings getMouseModeSettings() {
    		return mouseModeSettings;
    }
}
