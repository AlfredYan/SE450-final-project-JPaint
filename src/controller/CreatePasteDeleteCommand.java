package controller;

import ControllerInterfaces.ICommand;
import modelInterfaces.IShapeList;
import viewInterfaces.EventName;

public class CreatePasteDeleteCommand implements ICommand {

	private EventName _eventName;
	private final IShapeList _shapeList;
	
	public CreatePasteDeleteCommand(EventName eventName, IShapeList shapeList) {
		_eventName = eventName;
		_shapeList = shapeList;
	}
	
	@Override
	public void run() {
		ICommand command;
		
		switch (_eventName) {
		case PASTE:
			command = new PasteCommand(_shapeList);
			break;
		case DELETE:
			command = new DeleteCommand(_shapeList);
			break;
		default:
			return;
		}
		
		command.run();
	}

}
