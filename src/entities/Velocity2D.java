package entities;

/**
 *
 * @author Dennis
 */
class Velocity2D {
    private double vX;
    private double vY;

    public Velocity2D(double vX, double xy) {
        this.vX = vX;
        this.vY = xy;
    }

    public double getvX() {
        return vX;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public double getvY() {
        return vY;
    }

    public void setvY(double vy) {
        this.vY = vy;
    }
    
    
}
