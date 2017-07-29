package modelInterfaces;

import view.GuiUiModule.PaintCanvas;

public interface IShapeList {
	void addToList(IDisplayableShape displayableShape);
	void registerObserver(PaintCanvas canvas);
	void notifyObesrver();
}
