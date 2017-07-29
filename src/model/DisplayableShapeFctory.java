package model;

import controller.ShadingType;
import modelInterfaces.IDisplayableShape;
import modelInterfaces.IDisplayableShapeFactory;
import viewInterfaces.IViewShape;

public class DisplayableShapeFctory implements IDisplayableShapeFactory{

	@Override
	public IDisplayableShape createDisplayShape(ShadingType currentShadingType, IViewShape viewShape) throws Exception {
		switch (currentShadingType) {
		case OUTLINE:
			return new OutlineShape(viewShape);
		case FILLED_IN:
			return new FilledShape(viewShape);
		case OUTLINE_AND_FILLED_IN:
			return new FilledAndOutlineShape(viewShape);
		default:
			throw new Exception("Incorrect ShadingType");
		}
	}

}
