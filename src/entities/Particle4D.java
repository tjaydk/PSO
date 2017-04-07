package entities;

import java.util.Random;
import static services.Calculator.calc;

/**
 *
 * @author Dennis
 */
public class Particle4D {
    private double posX;
    private double posY;
    private double posU;
    private double posW;
    private double randomVariable;
    private Velocity4D v;
    private Best4D pBest;
    private Best4D gBest;
    private Random ran;
    
    public Particle4D(double posX, double posY, double posU, double posW, double randomVariable) {
        this.posX = posX;
        this.posY = posY;
        this.posU = posU;
        this.posW = posW;
        this.randomVariable = randomVariable;
        this.pBest = new Best4D(posX, posY, posU, posW, 0);
        this.v = new Velocity4D(0,0,0,0);
        this.ran = new Random();
    }
    
    public void travel() {
        posX = posX + v.getvX();
        posY = posY + v.getvY();
        posU = posU + v.getvU();
        posW = posW + v.getvW();
        double res = calc(posX, posY, posU, posW);
        //change the operand to max or min
        if(res > pBest.getValue()) {
            pBest.setValue(res);
            pBest.setX(posX);
            pBest.setY(posY);
            pBest.setU(posU);
            pBest.setW(posW);
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
        double newvX = k(rho1, rho2)*((v.getvX()) + (rho1) * (pBest.getX() - posX) + (rho2) * (gBest.getX() - posX));
        double newvY = k(rho1, rho2)*((v.getvY()) + (rho1) * (pBest.getY() - posY) + (rho2) * (gBest.getY() - posY));
        double newvU = k(rho1, rho2)*((v.getvU()) + (rho1) * (pBest.getU() - posU) + (rho2) * (gBest.getU() - posU));
        double newvW = k(rho1, rho2)*((v.getvW()) + (rho1) * (pBest.getW() - posW) + (rho2) * (gBest.getW() - posW));
        if(newvX < -2) newvX = -2;
        if(newvY < -2) newvY = -2;
        if(newvU < -2) newvU = -2;
        if(newvW < -2) newvW = -2;
        v.setvX(newvX);
        v.setvY(newvY);
        v.setvU(newvU);
        v.setvW(newvW);
    }
    
    public Best4D getpBest() {
        return pBest;
    }
    
    public void setgBest(Best4D gBest) {
        this.gBest = gBest;
    }
    
    public double k(double rho1, double rho2) {
        double rho = rho1 + rho2;
        if(rho > 4) rho = 4;
        return 1 - 1/rho + (Math.sqrt(Math.abs((rho * rho) - 4 * rho))/ 2);
    }
}
