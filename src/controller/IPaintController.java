package controller;

import viewInterfaces.IDialogChoice;

public interface IPaintController {
    void run();
    ShapeType getSelectedShape();
    PaintColor getPrimaryColor();
    PaintColor getSecondaryColor();
    ShadingType getShadingType();
}
