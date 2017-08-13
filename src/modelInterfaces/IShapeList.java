package modelInterfaces;

import java.util.ArrayList;

import view.GuiUiModule.PaintCanvas;

public interface IShapeList extends ISelectedShapeList, ICopiedShapeList{
	void addToList(IDisplayableShape displayableShape);
	void registerObserver(PaintCanvas canvas);
	ArrayList<IDisplayableShape> getArrayList();
	void removeShape(IDisplayableShape displayableShape);
	void notifyObesrver();
}
