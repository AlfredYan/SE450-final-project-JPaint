package controller;

import ControllerInterfaces.ICommand;

public class RedoCommand implements ICommand{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		CommandHistory.redo();
	}

}
