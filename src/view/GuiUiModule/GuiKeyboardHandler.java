package view.GuiUiModule;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import ControllerInterfaces.ICommand;
import modelInterfaces.IShapeList;
import view.GuiCreateKeyboardCommandFactory;
import viewInterfaces.ICreateKeyboardCommandFactory;

public class GuiKeyboardHandler extends KeyAdapter {
	private IShapeList _shapeList;
	private ICreateKeyboardCommandFactory _createKeyboardCommandFactory = new GuiCreateKeyboardCommandFactory();

	public GuiKeyboardHandler(IShapeList shapeList) {
		_shapeList = shapeList;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		ICommand command = null;
		
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
			command = _createKeyboardCommandFactory.createCopyCommand(_shapeList);
		} else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V) {
			command = _createKeyboardCommandFactory.createPasteCommand(_shapeList);
		} else if (e.getKeyCode() == KeyEvent.VK_DELETE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			command = _createKeyboardCommandFactory.createDeleteCommand(_shapeList);
		} else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
			command = _createKeyboardCommandFactory.createUndoCommand();
		} else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y) {
			command = _createKeyboardCommandFactory.createRedoCommand();
		}
		
		if(command != null)
			command.run();
	}
}

