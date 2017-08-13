package controller;

import ControllerInterfaces.ICommand;
import viewInterfaces.UIModule;

public class SelectMouseModeCommand implements ICommand {

	private final MouseModeSettings _mouseModeSettings;
	private final UIModule _uiModule;
	SelectMouseModeCommand(MouseModeSettings mouseModeSettings, UIModule uiModule) {
		_mouseModeSettings = mouseModeSettings;
		_uiModule = uiModule;
	}
	
	@Override
	public void run() {
		MouseMode mouseModeChoice = _uiModule.getDialogResponse(_mouseModeSettings);
		_mouseModeSettings.setCurrentMouseMode(mouseModeChoice);
	}

}
