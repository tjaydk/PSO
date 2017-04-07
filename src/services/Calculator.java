package services;

import entities.Best2D;
import entities.Best4D;
import entities.Particle2D;
import entities.Particle4D;

/**
 *
 * @author Dennis
 */
public class Calculator {

    public static double calc(double x, double y) {
        return x * Math.exp(-x * x - y * y);
    }
    
    public static double calc(double x, double y, double u, double w) {
        return 2 * x * Math.exp(-x * x - y * y - (u-1) * (u-1) - w * w);
    }
    
    public static Best2D getGlobalBest(Particle2D[] particles) {
        Best2D gBest = null;
        // change operand to max or min
        for (Particle2D particle : particles) {
            if (gBest == null) {
                gBest = particle.getpBest();
            }
            if (particle.getpBest().getValue() > gBest.getValue()) {
                gBest = particle.getpBest();
            }
        }
        return gBest;
    }
    
    public static Best4D getGlobalBest(Particle4D[] particles) {
        Best4D gBest = null;
        // change operand to max or min
        for (Particle4D particle : particles) {
            if (gBest == null) {
                gBest = particle.getpBest();
            }
            if (particle.getpBest().getValue() > gBest.getValue()) {
                gBest = particle.getpBest();
            }
        }
        return gBest;
    }

    public static double getGreatestDistance(Particle2D[] particles) {
        double greatestDistance = 0;
        for (Particle2D particle : particles) {
            double x1 = particle.getX();
            double y1 = particle.getY();
            for (Particle2D particle2 : particles) {
                double x2 = particle2.getX();
                double y2 = particle2.getY();
                double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
                if(distance > greatestDistance) greatestDistance = distance;
            }
        }
        return greatestDistance;
    }
}
