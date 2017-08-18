package view.GuiUiModule;

import javax.swing.*;
import viewInterfaces.EventName;
import ControllerInterfaces.ICommand;
import viewInterfaces.IDialogChoice;
import viewInterfaces.UIModule;
import view.IGuiWindow;

public class Gui implements UIModule {

    private final IGuiWindow gui;
    private final GuiKeyboardHandler _keyboardHandler;

    public Gui(IGuiWindow gui, GuiKeyboardHandler keyboardHandler) {
        this.gui = gui;
        _keyboardHandler = keyboardHandler;
    }
    
	@Override
	public void addEvent(EventName eventName, ICommand command) {
		JButton button = gui.getButton(eventName);
		button.addActionListener((ActionEvent) -> command.run());
		button.addKeyListener(_keyboardHandler);
	}

    @Override
    public <T> T getDialogResponse(IDialogChoice dialogSettings) {
        Object selectedValue = JOptionPane.showInputDialog(null,
                dialogSettings.getDialogText(), dialogSettings.getDialogTitle(),
                JOptionPane.PLAIN_MESSAGE,
                null,
                dialogSettings.getDialogOptions(),
                dialogSettings.getDefaultChoice());
        if((T)selectedValue != null)
        		return (T)selectedValue;
        else
        		return (T) dialogSettings.getDefaultChoice();
    }
}
