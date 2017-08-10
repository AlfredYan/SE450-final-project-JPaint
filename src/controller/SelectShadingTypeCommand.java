package controller;

import ControllerInterfaces.ICommand;
import viewInterfaces.UIModule;

public class SelectShadingTypeCommand implements ICommand {
	private ShadingTypeSettings _shadingTypeSettings;
	private UIModule _uiModule;
	
	SelectShadingTypeCommand(ShadingTypeSettings shadingTypeSettings, UIModule uiModule) {
		_shadingTypeSettings = shadingTypeSettings;
		_uiModule = uiModule;
	}
	
	@Override
	public void run() {
		ShadingType shadingType = _uiModule.getDialogResponse(_shadingTypeSettings);
		if(shadingType != null)
			_shadingTypeSettings.setCurrentShadingType(shadingType);
	}

}
