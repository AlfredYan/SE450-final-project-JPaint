package ControllerInterfaces;

public interface IMouseModeSubject {
	void registerObserver(IMouseModeObserver mouseModeObserver);
	void notifyObserver();
}
