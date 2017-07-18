package controller;

import viewInterfaces.IDialogChoice;

public class MouseModeSettings implements IDialogChoice {
	private MouseMode currentMouseMode;
	
	void setCurrentMouseMode(MouseMode currentMouseMode) {
		this.currentMouseMode = currentMouseMode;
	}
	
	MouseMode getCurrentMouseMode() {
		return currentMouseMode;
	}
	
	@Override
	public String getDialogTitle() {
		return "Select a mouse mode";
	}

	@Override
	public String getDialogText() {
		return "Select a mouse mode";
	}

	@Override
	public Object[] getDialogOptions() {
		return MouseMode.values();
	}

	@Override
	public Object getDefaultChoice() {
		return getCurrentMouseMode();
	}
	
}
