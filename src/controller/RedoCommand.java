package controller;

import ControllerInterfaces.ICommand;

public class RedoCommand implements ICommand{

	@Override
	public void run() {
		CommandHistory.redo();
	}

}
