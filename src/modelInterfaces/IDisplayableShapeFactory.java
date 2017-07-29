package modelInterfaces;

import controller.ShadingType;
import viewInterfaces.IViewShape;

public interface IDisplayableShapeFactory {

	IDisplayableShape createDisplayShape(ShadingType currentShadingType, IViewShape viewShape) throws Exception;
}
