package controller;

public class ApplicationSettings {
    private ShapeTypeSettings drawShapeSettings = new ShapeTypeSettings();
    private PrimaryColorSettings primaryColorSettings = new PrimaryColorSettings();
    private SecondaryColorSettings secondaryColorSettings = new SecondaryColorSettings();
    private ShadingTypeSettings shadingTypeSettings = new ShadingTypeSettings();
    private MouseModeSettings mouseModeSettings = new MouseModeSettings();

    public ShapeTypeSettings getDrawShapeSettings() {
        return drawShapeSettings;
    }
    
    public PrimaryColorSettings getPrimaryColorSettings() {
    		return primaryColorSettings;
    }
    
    public SecondaryColorSettings getSecondaryColorSettings() {
    		return secondaryColorSettings;
    }
    
    public ShadingTypeSettings getShadingTypeSettings() {
    		return shadingTypeSettings;
    }
    
    public MouseModeSettings getMouseModeSettings() {
    		return mouseModeSettings;
    }
}
