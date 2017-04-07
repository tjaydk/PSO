package entities;

import java.util.Random;
import static services.Calculator.*;

/**
 *
 * @author Dennis
 */
public class Particle2D {
    private double posX;
    private double posY;
    private double randomVariable;
    private Velocity2D v;
    private Best2D pBest;
    private Best2D gBest;
    private Random ran;

    public Particle2D(double posX, double posY, double randomVariable) {
        this.posX = posX;
        this.posY = posY;
        this.randomVariable = randomVariable;
        this.pBest = new Best2D(posX, posY, 0);
        this.v = new Velocity2D(0,0);
        this.ran = new Random();
    }
    
    public void travel() {
        posX = posX + v.getvX();
        posY = posY + v.getvY();
        double res = calc(posX, posY);
        //change the operand to max or min
        if(res > pBest.getValue()) {
            pBest.setValue(res);
            pBest.setPosX(posX);
            pBest.setPosY(posY);
        }
        changeVelocity();
    }
    
    public double getX() {
        return this.posX;
    }
    
    public double getY() {
        return this.posY;
    }
    
    private void changeVelocity() {
        double rho1 = ran.nextDouble() * randomVariable + 1;
        double rho2 = ran.nextDouble() * randomVariable + 1;
        double newvX = k(rho1, rho2)*((v.getvX()) + (rho1) * (pBest.getPosX() - posX) + (rho2) * (gBest.getPosX() - posX));
        double newvY = k(rho1, rho2)*((v.getvY()) + (rho1) * (pBest.getPosY() - posY) + (rho2) * (gBest.getPosY() - posY));
        if(newvX < -2) newvX = -2;
        if(newvY < -2) newvY = -2;
        v.setvX(newvX);
        v.setvY(newvY);
    }
    
    public Best2D getpBest() {
        return pBest;
    }
    
    public void setgBest(Best2D gBest) {
        this.gBest = gBest;
    }
    
    public double k(double rho1, double rho2) {
        double rho = rho1 + rho2;
        if(rho > 4) rho = 4;
        return 1 - 1/rho + (Math.sqrt(Math.abs((rho * rho) - 4 * rho))/ 2);
    }
    
}
