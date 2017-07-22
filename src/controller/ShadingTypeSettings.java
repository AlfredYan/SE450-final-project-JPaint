package controller;

import viewInterfaces.IDialogChoice;

public class ShadingTypeSettings implements IDialogChoice {
	private ShadingType currentShadingType;
	
	void setCurrentShadingType(ShadingType currentShadingType) {
		this.currentShadingType = currentShadingType;
	}
	
	ShadingType getCurrentShadingType() {
		return currentShadingType;
	}
	
	@Override
	public String getDialogTitle() {
		return "Select a shading type";
	}

	@Override
	public String getDialogText() {
		return "Select a shading type";
	}

	@Override
	public Object[] getDialogOptions() {
		return ShadingType.values();
	}

	@Override
	public Object getDefaultChoice() {
		return getCurrentShadingType();
	}

}
