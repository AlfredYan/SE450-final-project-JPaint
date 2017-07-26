package controller;

import viewInterfaces.IDialogChoice;

class ApplicationSettings {
    private ShapeTypeSettings drawShapeSettings = new ShapeTypeSettings();
    private PrimaryColorSettings primaryColorSettings = new PrimaryColorSettings();
    private SecondaryColorSettings secondaryColorSettings = new SecondaryColorSettings();
    private ShadingTypeSettings shadingTypeSettings = new ShadingTypeSettings();
    private MouseModeSettings mouseModeSettings = new MouseModeSettings();

    ShapeTypeSettings getDrawShapeSettings() {
        return drawShapeSettings;
    }
    
    PrimaryColorSettings getPrimaryColorSettings() {
    		return primaryColorSettings;
    }
    
    SecondaryColorSettings getSecondaryColorSettings() {
    		return secondaryColorSettings;
    }
    
    ShadingTypeSettings getShadingTypeSettings() {
    		return shadingTypeSettings;
    }
    
    MouseModeSettings getMouseModeSettings() {
    		return mouseModeSettings;
    }
}
