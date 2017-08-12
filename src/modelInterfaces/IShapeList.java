package modelInterfaces;

import java.util.ArrayList;

import view.GuiUiModule.PaintCanvas;

public interface IShapeList {
	void addToList(IDisplayableShape displayableShape);
	void registerObserver(PaintCanvas canvas);
	ArrayList<IDisplayableShape> getArrayList();
	void notifyObesrver();
	IDisplayableShape pop();
}
