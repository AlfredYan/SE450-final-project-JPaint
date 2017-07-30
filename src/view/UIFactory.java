package view;

import controller.ApplicationSettings;
import controller.CreateShapeCommand;
import model.ShapeFactory;
import model.DisplayableShapeFctory;
import model.ShapeList;
import modelInterfaces.IShapeList;
import view.CmdUiModule.Cmd;
import view.GuiUiModule.Gui;
import view.GuiUiModule.GuiMouseHandler;
import viewInterfaces.InvalidUIException;
import viewInterfaces.UIModule;
import view.GuiUiModule.GuiWindow;
import view.GuiUiModule.PaintCanvas;

public class UIFactory {
    public static UIModule createUI(UIType uiType, ApplicationSettings settings, ShapeList shapeList) throws InvalidUIException {
        UIModule ui;

        switch(uiType){
            case CMD:
                ui = new Cmd();
                break;
            case GUI:
            		PaintCanvas canvas = new PaintCanvas();
                ui = new Gui(new GuiWindow(canvas));
                GuiMouseHandler mouseHandler = new GuiMouseHandler(new CreateShapeCommand(new ShapeFactory(settings, shapeList, 
                												new GuiViewShapeFactory(canvas), new DisplayableShapeFctory())));
                canvas.addMouseListener(mouseHandler);
                shapeList.registerObserver(canvas);
                break;
            default:
                throw new InvalidUIException();
        }

        return ui;
    }
}
