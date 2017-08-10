package controller;

import ControllerInterfaces.ICommand;

public class UndoCommand implements ICommand{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/**
		 * draw
		 * delete
		 * move
		 * paste
		 */
		CommandHistory.undo();
	}

}
