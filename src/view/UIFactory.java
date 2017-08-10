package view;

import controller.ApplicationSettings;
import controller.CreateShapeCommand;
import controller.MouseMode;
import controller.MoveCommand;
import controller.SelectCommand;
import model.ShapeFactory;
import model.DisplayableShapeFctory;
import model.SelectedShapeList;
import model.ShapeList;
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
            		SelectedShapeList selectedShapeList = new SelectedShapeList();
                ui = new Gui(new GuiWindow(canvas));
                CreateShapeCommand drawCommand = new CreateShapeCommand(new ShapeFactory(settings, shapeList, new GuiViewShapeFactory(canvas), new DisplayableShapeFctory()));
                SelectCommand selectCommand = new SelectCommand(shapeList, selectedShapeList);
                MoveCommand moveCommand = new MoveCommand(shapeList, selectedShapeList);
                GuiMouseHandler mouseHandler = new GuiMouseHandler(drawCommand, selectCommand, moveCommand);
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
