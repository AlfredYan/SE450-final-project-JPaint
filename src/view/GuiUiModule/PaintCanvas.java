package view.GuiUiModule;


import java.awt.*;

import javax.swing.JComponent;

public class PaintCanvas extends JComponent {

	@Override
	public void paint(Graphics graphics){
        Graphics2D graphics2d = (Graphics2D)graphics;
        graphics2d.setColor(Color.black);
        graphics2d.fillRect(12, 13, 200, 400);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.blue);
        graphics2d.drawRect(12, 13, 200, 400);
	}
}
