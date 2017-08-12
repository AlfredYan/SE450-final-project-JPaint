package controller;

import model.DisplayableShapeFctory;
import model.ShapeFactory;
import modelInterfaces.IShapeList;
import view.GuiViewShapeFactory;
import view.GuiUiModule.PaintCanvas;
import viewInterfaces.IStartAndEndPointCommand;
import viewInterfaces.IStartAndEndPointCommandFactory;

public class SingletonStartAndEndPointCommandFactory implements IStartAndEndPointCommandFactory {
	private ApplicationSettings _settings;
	private IShapeList _shapeList;
	private PaintCanvas _canvas;
	private IShapeList _selectedShapeList;
	private static SingletonStartAndEndPointCommandFactory _instance;
	
	private SingletonStartAndEndPointCommandFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static SingletonStartAndEndPointCommandFactory getInstance() {
		if(_instance == null)
			_instance = new SingletonStartAndEndPointCommandFactory();
		return _instance;
	}
	
	public void setParameters(ApplicationSettings settings, IShapeList shapeList, 
							PaintCanvas canvas, IShapeList selectedShapeList) {
		if(_settings == null)
			_settings = settings;
		if(_shapeList == null)
			_shapeList = shapeList;
		if(_canvas == null)
			_canvas = canvas;
		if(_selectedShapeList == null)
			_selectedShapeList = selectedShapeList;
	}

	@Override
	public IStartAndEndPointCommand createStartAndEndPointCommand(MouseMode mouseMode) throws Exception {
		IStartAndEndPointCommand startAndEndPointCommand;
		
		switch (mouseMode) {
		case DRAW:
			startAndEndPointCommand = new CreateShapeCommand(new ShapeFactory(_settings, _shapeList, new GuiViewShapeFactory(_canvas), new DisplayableShapeFctory()), _shapeList);
			break;
		case SELECT:
			startAndEndPointCommand = new SelectCommand(_shapeList, _selectedShapeList);
			break;
		case MOVE:
			startAndEndPointCommand = new MoveCommand(_shapeList, _selectedShapeList);
			break;
		default:
			throw new Exception("Incorrect Mouse Mode");
		}
		
		return startAndEndPointCommand;
	}

}
