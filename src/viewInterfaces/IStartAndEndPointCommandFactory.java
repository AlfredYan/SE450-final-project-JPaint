package viewInterfaces;

import controller.ApplicationSettings;
import controller.MouseMode;
import modelInterfaces.IShapeList;
import view.GuiUiModule.PaintCanvas;

public interface IStartAndEndPointCommandFactory {

	IStartAndEndPointCommand createStartAndEndPointCommand(MouseMode mouseMode) throws Exception;
	void setParameters(ApplicationSettings settings, IShapeList shapeList, PaintCanvas canvas);
}
