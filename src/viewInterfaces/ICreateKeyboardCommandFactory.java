package viewInterfaces;

import ControllerInterfaces.ICommand;
import modelInterfaces.IShapeList;

public interface ICreateKeyboardCommandFactory {
	ICommand createCopyCommand(IShapeList shapeList);
	ICommand createPasteCommand(IShapeList shapeList);
	ICommand createDeleteCommand(IShapeList shapeList);
	ICommand createRedoCommand();
	ICommand createUndoCommand();
}
