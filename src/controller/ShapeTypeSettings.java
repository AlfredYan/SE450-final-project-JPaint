package controller;

import viewInterfaces.IDialogChoice;

public class ShapeTypeSettings implements IDialogChoice {
    private ShapeType currentShape;

    void setCurrentShape(ShapeType currentShape) {
        this.currentShape = currentShape;
    }

    public ShapeType getCurrentShape() {
        return currentShape;
    }

    @Override
    public String getDialogTitle() {
        return "Select a Shape";
    }

    @Override
    public String getDialogText() {
        return "Select a Shape:";
    }

    @Override
    public Object[] getDialogOptions() {
        return ShapeType.values();
    }

    @Override
    public Object getDefaultChoice() {
        return getCurrentShape();
    }
}
