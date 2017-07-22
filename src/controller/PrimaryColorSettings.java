package controller;

import viewInterfaces.IDialogChoice;

public class PrimaryColorSettings implements IDialogChoice {
	private PaintColor currentPrimaryColor;
	
	
	void setCurrentPrimaryColor(PaintColor currentPrimaryColor) {
		this.currentPrimaryColor = currentPrimaryColor;
	}
	
	PaintColor getCurrentPrimaryColor() {
		return currentPrimaryColor;
	}
	
	@Override
	public String getDialogTitle() {
		return "Select a primary color";
	}

	@Override
	public String getDialogText() {
		return "Select a primary color";
	}

	@Override
	public Object[] getDialogOptions() {
		return PaintColor.values();
	}

	@Override
	public Object getDefaultChoice() {
		return getCurrentPrimaryColor();
	}

}
