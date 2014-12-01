package physics.engine;

import physics.display.DrawingPanel;

public class MainLoop
{
    DrawingPanel drawingPanel;
    private boolean running;
    private double delta_time;
    private double time_passed;
    
    public MainLoop(DrawingPanel drawingPanel)
    {
        this.running = true;
        this.drawingPanel = drawingPanel;
    }
    
    public void run()
    {
        
    }
    
    public void stop()
    {
        this.running = false;
    }
}
