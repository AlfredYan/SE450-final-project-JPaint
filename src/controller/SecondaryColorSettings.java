package controller;

import viewInterfaces.IDialogChoice;

public class SecondaryColorSettings implements IDialogChoice {
	private PaintColor currentSecondaryColor;
	
	void setCurrentSecondaryColor(PaintColor currentSecondaryColor) {
		this.currentSecondaryColor = currentSecondaryColor;
	}
	
	PaintColor getCurrentSecondaryColor() {
		return currentSecondaryColor;
	}
	
	@Override
	public String getDialogTitle() {
		return "Select a secondary Color";
	}

	@Override
	public String getDialogText() {
		return "Select a secondary Color";
	}

	@Override
	public Object[] getDialogOptions() {
		return PaintColor.values();
	}

	@Override
	public Object getDefaultChoice() {
		return getCurrentSecondaryColor();
	}

}
