package modelInterfaces;

import java.util.ArrayList;

public interface ISelectedShapeList {
	void addToSelectedShapeList(IDisplayableShape displayableShape);
	ArrayList<IDisplayableShape> getSelectedArrayList();
}
