package main;

import controller.ApplicationSettings;
import controller.IPaintController;
import controller.JPaintController;
import model.ShapeList;
import modelInterfaces.IShapeList;
import view.UIFactory;
import view.UIType;
import viewInterfaces.UIModule;

public class Main {

	public static void main(String[] args) {

        try {
            /*if(args.length == 0)
                throw new Exception("Must specify ui switch.\nex: \"-ui=[GUI][CMD]\"");

            UISelector selector = new UISelector();
            UIModule ui = selector.getUi(args[0]);*/
        	
        		ApplicationSettings settings = new ApplicationSettings();
        		IShapeList shapeList = new ShapeList();
            UIModule ui = UIFactory.createUI(UIType.GUI, settings, shapeList);
            IPaintController controller = new JPaintController(ui, settings, shapeList);
            JPaint jpaintProgram = new JPaint(controller);
            jpaintProgram.run();
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
	}
}
