package controller;

import viewInterfaces.IStartAndEndPointCommand;

public class MoveCommand implements IStartAndEndPointCommand {

	@Override
	public void run(Point startingPoint, Point endingPoint) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MOVE MODE");
	}

}
