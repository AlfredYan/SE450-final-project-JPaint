package controller;

import viewInterfaces.EventName;
import viewInterfaces.UIModule;

public class JPaintController implements IPaintController {
    private final UIModule _uiModule;
    private final ApplicationSettings _settings;

    public JPaintController(UIModule uiModule, ApplicationSettings settings){
        _uiModule = uiModule;
        _settings = settings;
        _settings.getDrawShapeSettings().setCurrentShape(ShapeType.ELLIPSE);
        _settings.getPrimaryColorSettings().setCurrentPrimaryColor(PaintColor.BLACK);
        _settings.getSecondaryColorSettings().setCurrentSecondaryColor(PaintColor.BLUE);
        _settings.getShadingTypeSettings().setCurrentShadingType(ShadingType.OUTLINE);
        _settings.getMouseModeSettings().setCurrentMouseMode(MouseMode.DRAW);
    }

    @Override
    public void run() {
        _uiModule.addEvent(EventName.CHOOSE_SHAPE, new SelectShapeCommand(_settings.getDrawShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, new SelectPrimaryColorCommand(_settings.getPrimaryColorSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, new SelectSecondaryColorCommand(_settings.getSecondaryColorSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, new SelectShadingTypeCommand(_settings.getShadingTypeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, new SelectMouseModeCommand(_settings.getMouseModeSettings(), _uiModule));
        _uiModule.addEvent(EventName.REDO, new RedoCommand());
        _uiModule.addEvent(EventName.UNDO, new UndoCommand());
        
    }
}
