package controller;

import java.util.Stack;

import ControllerInterfaces.IUndoable;

public class CommandHistory {

	private static final Stack<IUndoable> undoStack = new Stack<IUndoable>();
	private static final Stack<IUndoable> redoStack = new Stack<IUndoable>();
	
	public static void add(IUndoable cmd) {
		undoStack.add(cmd);
		redoStack.clear();
	}
	
	public static boolean undo() {
		boolean result = !undoStack.empty();
		if(result) {
			IUndoable cmd = undoStack.pop();
			redoStack.push(cmd);
			cmd.undo();
		}
		return result;
	}
	
	public static boolean redo() {
		boolean result = !redoStack.empty();
		if(result) {
			IUndoable cmd = redoStack.pop();
			undoStack.push(cmd);
			cmd.redo();
		}
		return result;
	}
}
