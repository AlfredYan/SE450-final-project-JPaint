package controller;

import ControllerInterfaces.ICommand;
import viewInterfaces.UIModule;

public class SelectSecondaryColorCommand implements ICommand {
	private SecondaryColorSettings _secondaryColorSettings;
	private UIModule _uiModule;
	
	SelectSecondaryColorCommand(SecondaryColorSettings secondaryColorSettings, UIModule uiModule) {
		_secondaryColorSettings = secondaryColorSettings;
		_uiModule = uiModule;
	}

	@Override
	public void run() {
		PaintColor secondaryColor = _uiModule.getDialogResponse(_secondaryColorSettings);
		if(secondaryColor != null)
			_secondaryColorSettings.setCurrentSecondaryColor(secondaryColor);
	}

}
