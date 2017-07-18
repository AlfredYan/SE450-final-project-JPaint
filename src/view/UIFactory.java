package view;

import view.CmdUiModule.Cmd;
import view.GuiUiModule.Gui;
import viewInterfaces.InvalidUIException;
import viewInterfaces.UIModule;
import view.GuiUiModule.GuiWindow;

public class UIFactory {
    public static UIModule createUI(UIType uiType) throws InvalidUIException {
        UIModule ui;

        switch(uiType){
            case CMD:
                ui = new Cmd();
                break;
            case GUI:
                ui = new Gui(new GuiWindow());
                break;
            default:
                throw new InvalidUIException();
        }

        return ui;
    }
}
