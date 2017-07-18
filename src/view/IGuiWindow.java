package view;

import viewInterfaces.EventName;

import javax.swing.*;

public interface IGuiWindow {
    JButton getButton(EventName eventName);
}
