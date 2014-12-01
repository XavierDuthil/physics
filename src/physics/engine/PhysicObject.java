package physics.engine;

public abstract class PhysicObject extends Movable
{
    private double mass;
    
    // Rebound factor, between 0 and 1
    private double coefficientOfRestitution;
    
    public PhysicObject(double x, double y, String renderType, double mass, double coefficientOfRestitution)
    {
        super(x, y, renderType);
        this.mass = mass;
        this.coefficientOfRestitution = coefficientOfRestitution;
    }

    public double getMass()
    {
        return mass;
    }

    public void setMass(double mass)
    {
        this.mass = mass;
    }

    public double getCoefficientOfRestitution()
    {
        return coefficientOfRestitution;
    }

    public void setCoefficientOfRestitution(double coefficientOfRestitution)
    {
        this.coefficientOfRestitution = coefficientOfRestitution;
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
