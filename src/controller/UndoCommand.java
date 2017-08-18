package controller;

import ControllerInterfaces.ICommand;

public class UndoCommand implements ICommand{

	@Override
	public void run() {
		CommandHistory.undo();
	}

}
