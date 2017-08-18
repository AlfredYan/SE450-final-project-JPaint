package controller;

import java.util.ArrayList;
import java.util.List;

import ControllerInterfaces.IMouseModeObserver;
import ControllerInterfaces.IMouseModeSubject;
import viewInterfaces.IDialogChoice;

public class MouseModeSettings implements IDialogChoice, IMouseModeSubject {
	private MouseMode currentMouseMode;
	private List<IMouseModeObserver> mouseModeObservers = new ArrayList<IMouseModeObserver>();
	
	void setCurrentMouseMode(MouseMode currentMouseMode) {
		this.currentMouseMode = currentMouseMode;
		notifyObserver();
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

	@Override
	public void registerObserver(IMouseModeObserver mouseModeObserver) {
		mouseModeObservers.add(mouseModeObserver);
	}

	@Override
	public void notifyObserver() {
		for(IMouseModeObserver mouseModeObserver : mouseModeObservers) {
			mouseModeObserver.update(currentMouseMode);
		}
	}
	
}
