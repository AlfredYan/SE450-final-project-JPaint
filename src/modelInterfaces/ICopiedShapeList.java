package modelInterfaces;

import java.util.ArrayList;

public interface ICopiedShapeList {
	void addToCopiedShapeList(IDisplayableShape displayableShape);
	ArrayList<IDisplayableShape> getCopiedArrayList();
}
