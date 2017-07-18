package view.GuiUiModule;

import javax.swing.*;
import viewInterfaces.EventName;
import ControllerInterfaces.ICommand;
import viewInterfaces.IDialogChoice;
import viewInterfaces.UIModule;
import view.IGuiWindow;

public class Gui implements UIModule {

    private final IGuiWindow gui;

    public Gui(IGuiWindow gui) {
        this.gui = gui;
    }
    
	@Override
	public void addEvent(EventName eventName, ICommand command) {
		JButton button = gui.getButton(eventName);
		button.addActionListener((ActionEvent) -> command.run());
	}

    @Override
    public <T> T getDialogResponse(IDialogChoice dialogSettings) {
        Object selectedValue = JOptionPane.showInputDialog(null,
                dialogSettings.getDialogText(), dialogSettings.getDialogTitle(),
                JOptionPane.PLAIN_MESSAGE,
                null,
                dialogSettings.getDialogOptions(),
                dialogSettings.getDefaultChoice());
        return (T)selectedValue;
    }
}
