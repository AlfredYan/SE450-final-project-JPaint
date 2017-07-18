package main;

import view.UIFactory;
import view.UIType;
import viewInterfaces.InvalidUIException;
import viewInterfaces.UIModule;

public class UISelector {
    public UIModule getUi(String arg) throws InvalidUIException {
        UIType uiType;
        uiType = getUiType(arg);
        UIModule ui = UIFactory.createUI(uiType);
        return ui;
    }

    private UIType getUiType(String uiArgument) throws IllegalArgumentException {
        String[] argParts = uiArgument.split("=");
        if(!argParts[0].equalsIgnoreCase("-ui"))
            throw new IllegalArgumentException("Did not pass in the correct switch");

        try {
            UIType uiType = UIType.valueOf(argParts[1].toUpperCase());
            return uiType;
        } catch (NullPointerException ex) {
            throw new IllegalArgumentException("Must specify GUI or CMD for -ui switch");
        }
    }
}
