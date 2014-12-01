package physics.engine;

public abstract class PhysicObject extends Movable
{
    double mass;
    double elasticity;
    
    public PhysicObject(double x, double y, String renderType, double mass, double elasticity)
    {
        super(x, y, renderType);
        this.mass = mass;
        this.elasticity = elasticity;
    }

    public double getMass()
    {
        return mass;
    }

    public void setMass(double mass)
    {
        this.mass = mass;
    }

    public double getElasticity()
    {
        return elasticity;
    }

    public void setElasticity(double elasticity)
    {
        this.elasticity = elasticity;
    }
    
    public void reactToGravity(double gravity, int timeInMs)
    {
        // 1 g = 9.80665 m/s² (standard gravity constant)
        double g = 9.80665;
        
        double ySpeed = this.getYSpeed();
        double newSpeed = ySpeed - ((gravity * g * timeInMs/1000) / 10);
        this.setYSpeed(newSpeed);
    }
    
    @Override
    public String toString()
    {
        return super.toString();
    }
}
