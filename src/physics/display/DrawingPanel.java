package physics.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;
import physics.engine.*;

public class DrawingPanel extends JPanel
{
    private ArrayList<Rectangle> rectanglesList;
    private ArrayList<Circle> circlesList;
    
    public DrawingPanel()
    {
        super();
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // paints background
      Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);

        for (Rectangle rectangle : this.rectanglesList)
        {
            int x = (int)rectangle.getX();
            int y = (int)rectangle.getY();
            int height = (int)rectangle.getHeight();
            int width = rectangle.getWidth();
            g2d.drawRect(x, y, height, width);
        }
         
        for (Circle circle : circlesList)
        {
            int x = (int)circle.getX();
            int y = (int)circle.getY();
            int diametre = (int)circle.getDiameter();
            g2d.drawOval(x, y, diametre, diametre);
        }
    }
    
    public void setRectanglesList(ArrayList<Rectangle> newRectanglesList)
    {
        this.rectanglesList = newRectanglesList;
    }
    
    public void setCirclesList(ArrayList<Circle> newCirclesList)
    {
        this.circlesList = newCirclesList;
    }
}