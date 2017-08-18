package view;

import ControllerInterfaces.ICommand;
import controller.CopyCommand;
import controller.DeleteCommand;
import controller.PasteCommand;
import controller.RedoCommand;
import controller.UndoCommand;
import model.CopyOperation;
import model.DeleteOperation;
import model.PasteOperation;
import modelInterfaces.IShapeList;
import viewInterfaces.ICreateKeyboardCommandFactory;

public class GuiCreateKeyboardCommandFactory implements ICreateKeyboardCommandFactory {

	@Override
	public ICommand createCopyCommand(IShapeList shapeList) {
		return new CopyCommand(new CopyOperation(shapeList));
	}

	@Override
	public ICommand createPasteCommand(IShapeList shapeList) {
		return new PasteCommand(new PasteOperation(shapeList));
	}

	@Override
	public ICommand createDeleteCommand(IShapeList shapeList) {
		return new DeleteCommand(new DeleteOperation(shapeList));
	}

	@Override
	public ICommand createRedoCommand() {
		return new RedoCommand();
	}

	@Override
	public ICommand createUndoCommand() {
		return new UndoCommand();
	}

}
