package physics.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JPanel;
import physics.engine.*;

public class DrawingPanel extends JPanel
{
    private CopyOnWriteArrayList<Rectangle> rectanglesList;
    private CopyOnWriteArrayList<Circle> circlesList;
    private int frameCount;
    
    public DrawingPanel()
    {
        super();
        
        this.circlesList = new CopyOnWriteArrayList<>();
        this.rectanglesList = new CopyOnWriteArrayList<>();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);    // paints background
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);

        for (Rectangle rectangle: this.rectanglesList)
        {
            int x = (int)rectangle.getX();
            int y = (int)rectangle.getY();
            int height = (int)rectangle.getHeight();
            int width = (int)rectangle.getWidth();
            g2d.drawRect(x, y, height, width);
        }
        
        for (Circle circle: this.circlesList)
        {
            //System.out.println(circle);
            int diametre = (int)circle.getDiameter();
            int x = (int)circle.getX() - diametre/2;
            int y = (int)circle.getY() - diametre/2;
            g2d.drawOval(x, y, diametre, diametre);
        }
        this.frameCount ++;
    }

    public void render(ArrayList<Renderable> objects)
    {
        this.circlesList.clear();
        this.rectanglesList.clear();
        
        for (Renderable object : objects)
        {
            double renderingY = this.getHeight() - object.getY();
            object.setY(renderingY);
            
            switch(object.getRenderType())
            {
                case "circle":
                    this.circlesList.add((Circle)object);
                break;
                    
                case "rectangle":
                    this.rectanglesList.add((Rectangle)object);
                break;
                    
                default:
                    System.out.println("Error : unknown renderType '" +object.getRenderType() +"'");
                break;
            }
        }
        // System.out.println("real frames : " +this.frameCount);
        this.repaint();
    }
    
    
    
    private ArrayList<Renderable> cloneRenderableObjects(ArrayList<Renderable> toClone)
    {
        ArrayList<Renderable> clone = new ArrayList<>(toClone.size());
        
        for (Renderable object: toClone)
        {
            switch(object.getRenderType())
            {
                case "circle":
                    clone.add((Renderable)new Circle((Circle)object));
                break;
                    
                case "rectangle":
                    clone.add((Renderable)new Rectangle((Rectangle)object));
                break;
                    
                default:
                    System.out.println("Error - Unable to clone : unkown renderType '" +object.getRenderType() +"'");
                break;
            }
        }
        
        return clone;
    }
}