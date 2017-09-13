package physics.engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import physics.display.DrawingPanel;
import physics.display.MainWindow;

public class Control
{
    private MainWindow mainWindow;
    private DrawingPanel drawingPanel;
    private MainLoop mainLoop;
    private ArrayList<Renderable> objects;
    private boolean running;
    private double fps;
    
    // Temps fixé entre chaque update du moteur
    private static final int MS_PER_UPDATE = 10;
    private static final double GRAVITY = 10;
    
    public Control(MainWindow window)
    {
        this.mainWindow = window;
        this.drawingPanel = window.getDrawingPanel();
        this.mainLoop = new MainLoop(drawingPanel);
        init();
        run();
    }
    
    private void init()
    {
        // 100px = 1m
        
        this.objects = new ArrayList<>();
        //this.objects.add(new Rectangle(150,150,150,150));
        this.objects.add(new Circle(25, 450, 50, 50, 1));
        this.objects.add(new Circle(75, 450, 50, 50, 0.95));
        this.objects.add(new Circle(125, 450, 50, 50, 0.90));
        this.objects.add(new Circle(175, 450, 50, 50, 0.85));
        this.objects.add(new Circle(225, 450, 50, 50, 0.80));
        this.objects.add(new Circle(275, 450, 50, 50, 0.75));
        this.objects.add(new Circle(325, 450, 50, 50, 0.70));
        this.objects.add(new Circle(375, 450, 50, 50, 0.65));
        this.objects.add(new Circle(425, 450, 50, 50, 0.60));
        this.objects.add(new Circle(475, 450, 50, 50, 0.55));
    }
    
    private void run()
    {
        // Best game loop system : 
        // The engine continues rendering even if it's too soon to update, 
        // and it renders with a purcentage of progression toward the next frame
        // In the other hand, if the engine is one tick or more too late, 
        // it catches its lateness with the while bloc
        // See http://gameprogrammingpatterns.com/game-loop.html
        
        double previousTime = System.nanoTime() / 1000000;
        double lastRender = System.nanoTime() / 1000000;
        double lag = 0.0;
        this.running = true;
        double currentTime;
        double elapsedTime;
        int count = 0;
        
        while(this.running)
        {
            currentTime = System.nanoTime() / 1000000;
            elapsedTime = currentTime - previousTime;
            previousTime = currentTime;
            
            lag += elapsedTime;
            
            this.processInput();
            
            // The engine catches up its lateness
            while(lag >= MS_PER_UPDATE)
            {
                this.update();
                lag -= MS_PER_UPDATE;
            }

            // Stabilise at 60 fps : skips the rendering if time too short since last frame
            this.fps = (1 / ((System.nanoTime() - lastRender) / 1000000)) * 1000;
            if (fps <= 60)
            {
                this.render(lag / MS_PER_UPDATE);
                mainWindow.setFPS(this.fps);
                lastRender = System.nanoTime();
                count ++;
                // System.out.println(count);
            }
        }
    }
    
    private void processInput()
    {
        
    }
    
    private void update()
    {
        for (Renderable object : this.objects)
        {
            Circle physicObject = (Circle)object;
            physicObject.reactToGravity(GRAVITY, MS_PER_UPDATE);
            physicObject.move();
            
            double y = physicObject.getY();
            double diametre = physicObject.getDiameter();
            double ySpeed = physicObject.getYSpeed();
            
            // Collision avec le sol
            if (y - diametre/2 + ySpeed < 0)
            {
                physicObject.setYSpeed(Math.abs(ySpeed) * physicObject.getCoefficientOfRestitution());
                //physicObject.setY(diametre/2);
            }
            
            //System.out.println(physicObject.toString());
        }
        
        //double mass = object.getMass();
    }
    
    private void render(double frameProgression)
    {
        ArrayList<Renderable> objectsToRender = cloneRenderableObjects(this.objects);
        this.drawingPanel.render(objectsToRender);
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
                    System.out.println("Error - Unable to clone : unknown renderType '" +object.getRenderType() +"'");
                break;
            }
        }
        
        return clone;
    }
}
