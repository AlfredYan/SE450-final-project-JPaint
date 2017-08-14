package viewInterfaces;

import ControllerInterfaces.ICommand;

public interface UIModule {
    void addEvent(EventName eventName, ICommand command);
    <T> T getDialogResponse(IDialogChoice dialogSettings);
}
