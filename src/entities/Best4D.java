package entities;

/**
 *
 * @author Dennis
 */
public class Best4D {
    private double x;
    private double y;
    private double u;
    private double w;
    private double value;
    
    public Best4D(double x, double y, double u, double w, double value) {
        this.x = x;
        this.y = y;
        this.u = u;
        this.w = w;
        this.value = value;
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getU() {
        return u;
    }

    public void setU(double u) {
        this.u = u;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
