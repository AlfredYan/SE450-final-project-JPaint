package view;

import controller.ApplicationSettings;
import controller.CreateShapeCommand;
import controller.MouseMode;
import controller.MoveCommand;
import controller.SelectCommand;
import controller.SingletonStartAndEndPointCommandFactory;
import model.ShapeFactory;
import model.DisplayableShapeFctory;
import model.SelectedShapeList;
import model.ShapeList;
import modelInterfaces.IShapeList;
import view.CmdUiModule.Cmd;
import view.GuiUiModule.Gui;
import view.GuiUiModule.GuiMouseHandler;
import viewInterfaces.IStartAndEndPointCommandFactory;
import viewInterfaces.InvalidUIException;
import viewInterfaces.UIModule;
import view.GuiUiModule.GuiWindow;
import view.GuiUiModule.PaintCanvas;

public class UIFactory {
    public static UIModule createUI(UIType uiType, ApplicationSettings settings, IShapeList shapeList, IShapeList selectedShapeList) throws InvalidUIException {
        UIModule ui;

        switch(uiType){
            case CMD:
                ui = new Cmd();
                break;
            case GUI:
            		PaintCanvas canvas = new PaintCanvas();
                ui = new Gui(new GuiWindow(canvas));
                IStartAndEndPointCommandFactory startAndEndPointCommandFactory = SingletonStartAndEndPointCommandFactory.getInstance();
                startAndEndPointCommandFactory.setParameters(settings, shapeList, canvas, selectedShapeList);
                GuiMouseHandler mouseHandler = new GuiMouseHandler();
                settings.getMouseModeSettings().registerObserver(mouseHandler);
                canvas.addMouseListener(mouseHandler);
                shapeList.registerObserver(canvas);
                selectedShapeList.registerObserver(canvas);
                break;
            default:
                throw new InvalidUIException();
        }

        return ui;
    }
}
