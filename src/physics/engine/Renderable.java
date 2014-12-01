package physics.engine;

public abstract class Renderable extends Positionable
{
    private String renderType;
    
    public Renderable(double x, double y, String renderType)
    {
        super(x, y);
        this.renderType = renderType;
    }
    
    public Renderable(Renderable clone)
    {
        super(clone.getX(), clone.getY());
        this.renderType = clone.getRenderType();
    }
    
    public String getRenderType()
    {
        return this.renderType;
    }
    
    public void setRenderType(String newRenderType)
    {
        this.renderType = newRenderType;
    }

    @Override
    public String toString()
    {
        return super.toString() +"\nRenderable{" + "renderType=" + renderType + '}';
    }
}
