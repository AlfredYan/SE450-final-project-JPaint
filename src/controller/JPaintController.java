package controller;

import viewInterfaces.EventName;
import viewInterfaces.UIModule;

public class JPaintController implements IPaintController {
    private final UIModule _uiModule;
    private final ApplicationSettings _settings = new ApplicationSettings();

    public JPaintController(UIModule uiModule){
        _uiModule = uiModule;
        _settings.getDrawShapeSettings().setCurrentShape(Shape.ELLIPSE);
        _settings.getMouseModeSettings().setCurrentMouseMode(MouseMode.DRAW);
    }

    @Override
    public void run() {
        _uiModule.addEvent(EventName.CHOOSE_SHAPE, new SelectShapeCommand(_settings.getDrawShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, new SelectMouseModeCommand(_settings.getMouseModeSettings(), _uiModule));
    }
}
