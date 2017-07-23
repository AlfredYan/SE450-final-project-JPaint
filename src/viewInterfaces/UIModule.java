package viewInterfaces;

import ControllerInterfaces.ICommand;
import controller.IPaintController;
import controller.JPaintController;

public interface UIModule {
    void addEvent(EventName eventName, ICommand command);
    <T> T getDialogResponse(IDialogChoice dialogSettings);
    void getJPainterController(IPaintController paintController);
}
