/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Particle2D;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

/**
 *
 * @author Dennis
 */
public class DrawCanvas extends JFrame {

    private Particle2D[] particles;
    
    public DrawCanvas() {
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void drawCanvas(Particle2D[] particles) {
        this.particles = particles;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // draw a line (there is no drawPoint..)
        for (Particle2D particle : particles) {
            g.drawOval((int)((particle.getX()+2) * 100), (int)((particle.getY()+2) * 100), 2, 2);
        }
        
    }
}
