package view;

import viewInterfaces.EventName;

import javax.swing.*;

import controller.IPaintController;
import controller.JPaintController;

public interface IGuiWindow {
    JButton getButton(EventName eventName);
    void getJPainterController(IPaintController jPaintController);
}
