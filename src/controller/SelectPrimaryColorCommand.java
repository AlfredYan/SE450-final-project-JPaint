package controller;

import ControllerInterfaces.ICommand;
import viewInterfaces.UIModule;

public class SelectPrimaryColorCommand implements ICommand {
	private final PrimaryColorSettings _primaryColorSettings;
	private final UIModule _uiModule;
	
	SelectPrimaryColorCommand(PrimaryColorSettings primaryColorSettings, UIModule uiModule) {
		_primaryColorSettings = primaryColorSettings;
		_uiModule = uiModule;
	}
	
	@Override
	public void run() {
		PaintColor primaryColorChoice = _uiModule.getDialogResponse(_primaryColorSettings);
		_primaryColorSettings.setCurrentPrimaryColor(primaryColorChoice);
	}

}
