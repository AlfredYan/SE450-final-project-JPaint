package controller;

import ControllerInterfaces.ICommand;

public class UndoCommand implements ICommand{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/**
		 * draw
		 * move
		 * paste
		 * delete
		 */
		CommandHistory.undo();
	}

}
