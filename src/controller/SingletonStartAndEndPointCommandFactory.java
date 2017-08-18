package controller;

import model.DisplayableShapeFactory;
import model.MoveOperation;
import model.SelectOperation;
import model.ShapeFactory;
import modelInterfaces.ISelectedShapeList;
import modelInterfaces.IShapeList;
import view.GuiViewShapeFactory;
import view.GuiUiModule.PaintCanvas;
import viewInterfaces.IStartAndEndPointCommand;
import viewInterfaces.IStartAndEndPointCommandFactory;

public class SingletonStartAndEndPointCommandFactory implements IStartAndEndPointCommandFactory {
	private ApplicationSettings _settings;
	private IShapeList _shapeList;
	private PaintCanvas _canvas;
	private ISelectedShapeList _selectedShapeList;
	private static SingletonStartAndEndPointCommandFactory _instance;
	
	private SingletonStartAndEndPointCommandFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static SingletonStartAndEndPointCommandFactory getInstance() {
		if(_instance == null)
			_instance = new SingletonStartAndEndPointCommandFactory();
		return _instance;
	}
	
	@Override
	public void setParameters(ApplicationSettings settings, IShapeList shapeList, 
							PaintCanvas canvas) {
		if(_settings == null)
			_settings = settings;
		if(_shapeList == null)
			_shapeList = shapeList;
		if(_canvas == null)
			_canvas = canvas;
		if(_selectedShapeList == null)
			_selectedShapeList = shapeList;
	}

	@Override
	public IStartAndEndPointCommand createStartAndEndPointCommand(MouseMode mouseMode) throws Exception {
		IStartAndEndPointCommand startAndEndPointCommand;
		
		switch (mouseMode) {
		case DRAW:
			startAndEndPointCommand = new CreateShapeCommand(new ShapeFactory(_settings, _shapeList, new GuiViewShapeFactory(_canvas), new DisplayableShapeFactory()));
			break;
		case SELECT:
			startAndEndPointCommand = new SelectCommand(new SelectOperation(_shapeList));
			break;
		case MOVE:
			startAndEndPointCommand = new MoveCommand(new MoveOperation(_shapeList));
			break;
		default:
			throw new Exception("Incorrect Mouse Mode");
		}
		
		return startAndEndPointCommand;
	}

}
