package modelInterfaces;

import viewInterfaces.IViewShape;

public interface IDisplayableShape {

	void display();
	IViewShape getViewShape();
	IDisplayableShape clone() throws CloneNotSupportedException;
}
