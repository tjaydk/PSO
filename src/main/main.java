package main;

import entities.Best2D;
import entities.Best4D;
import entities.Particle2D;
import entities.Particle4D;
import java.awt.Canvas;
import java.awt.Frame;
import java.util.Random;
import static services.Calculator.getGlobalBest;
import static services.Calculator.getGreatestDistance;
import services.DrawCanvas;

/**
 *
 * @author Dennis
 */
public class main {

    
    private static int numberOfParticles = 625;
    private static int numberOfIterations = 500;
    
    private static Best2D globalBest;
    private static Best4D globalBest4D;
    
    private static double maxX = 2;
    private static double minX = -2;
    private static double maxY = 2;
    private static double minY = -2;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Particle2D[] particles = new Particle2D[numberOfParticles];
        Particle4D[] particles4D = new Particle4D[numberOfParticles];
        Random ran = new Random();
        
        DrawCanvas canvas = new DrawCanvas();
        
        for (int i = 0; i < numberOfParticles; i++) {
            particles[i] = new Particle2D((ran.nextDouble() * 4) - 2, (ran.nextDouble() * 4) - 2, ran.nextDouble() * 2);
            particles4D[i] = new Particle4D((ran.nextDouble() * 4) - 2,(ran.nextDouble() * 4) - 2,(ran.nextDouble() * 4) - 2,(ran.nextDouble() * 4) - 2, ran.nextDouble() * 2);
        }
        
        //calculate for 2D particles
        for (int i = 0; i < numberOfIterations; i++) {
            globalBest = getGlobalBest(particles);
            for (Particle2D particle : particles) {
                particle.setgBest(globalBest);
                particle.travel();
                canvas.drawCanvas(particles);
            }
        }
        
        //calculate for 4d particles
        for (int i = 0; i < numberOfIterations; i++) {
            globalBest4D = getGlobalBest(particles4D);
            for (Particle4D particle : particles4D) {
                particle.setgBest(globalBest4D);
                particle.travel();
                canvas.drawCanvas(particles);
            }
        }
        
        System.out.println("Best result is: " + globalBest.getValue());
        System.out.println("The greatest distance is: " + getGreatestDistance(particles));
        
        System.out.println("Best result for 4D is: " + globalBest4D.getValue());
    }
    
}
