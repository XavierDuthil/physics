package physics.engine;

import java.util.ArrayList;
import physics.display.DrawingPanel;
import physics.display.MainWindow;

public class Control
{
    private DrawingPanel drawingPanel;
    private ArrayList<Rectangle> rectanglesList;
    private ArrayList<Circle> circlesList;
    
    public Control(MainWindow window)
    {
        drawingPanel = window.getDrawingPanel();
        init();
        run();
    }
    
    private void init()
    {
        this.rectanglesList = new ArrayList<>();
        this.circlesList = new ArrayList<>();
        
        this.rectanglesList.add(new Rectangle(50,50,3,3));
        this.circlesList.add(new Circle(150,150,50));
    }

    private void run()
    {
        for(int i = 50; i < 500; i++)
        {
            Circle circle = circlesList.get(0);
            int x = (int)circle.getX() + 1;
            int y = (int)circle.getY() + 1;
            circle.setX(x);
            circle.setY(y);
            
            redraw();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void redraw()
    {
        this.drawingPanel.setRectanglesList(rectanglesList);
        this.drawingPanel.setCirclesList(circlesList);
        this.drawingPanel.repaint();
    }
}
