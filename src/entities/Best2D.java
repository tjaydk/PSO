package entities;

/**
 *
 * @author Dennis
 */
public class Best2D {
    private double posX;
    private double posY;
    private double value;

    public Best2D(double posX, double posY, double value) {
        this.posX = posX;
        this.posY = posY;
        this.value = value;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
