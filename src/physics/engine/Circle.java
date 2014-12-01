package physics.engine;

public class Circle extends PhysicObject
{
    double diameter;
    
    public Circle(double x, double y, double diameter, double mass, double elasticity)
    {
        super(x, y, "circle", mass, elasticity);
        this.diameter = diameter;
    }
    
    public Circle(Circle clone)
    {
        super(clone.getX(), clone.getY(), clone.getRenderType(), clone.getMass(), clone.getCoefficientOfRestitution());
        this.diameter = clone.getDiameter();
    }
    
    public double getDiameter()
    {
        return diameter;
    }

    public void setDiametre(int diameter)
    {
        this.diameter = diameter;
    }
    
    @Override
    public String toString()
    {
        return super.toString();
    }
}
