package view.CmdUiModule;

import viewInterfaces.EventName;
import ControllerInterfaces.ICommand;
import controller.IPaintController;
import controller.JPaintController;
import viewInterfaces.IDialogChoice;
import viewInterfaces.UIModule;

public class Cmd implements UIModule {

	@Override
	public void addEvent(EventName eventName, ICommand command) {
		// throw new Exception("Not Implemented");
	}

    @Override
    public <T> T getDialogResponse(IDialogChoice dialogSettings) {
        return null;
    }

	@Override
	public void getJPainterController(JPaintController paintController) {
		// TODO Auto-generated method stub
		
	}
}
