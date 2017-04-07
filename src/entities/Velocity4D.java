package entities;

/**
 *
 * @author Dennis
 */
public class Velocity4D {
    private double vX;
    private double vY;
    private double vU;
    private double vW;

    public Velocity4D(double vX, double vY, double vU, double vW) {
        this.vX = vX;
        this.vY = vY;
        this.vU = vU;
        this.vW = vW;
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

    public void setvY(double vY) {
        this.vY = vY;
    }

    public double getvU() {
        return vU;
    }

    public void setvU(double vU) {
        this.vU = vU;
    }

    public double getvW() {
        return vW;
    }

    public void setvW(double vW) {
        this.vW = vW;
    }

}
