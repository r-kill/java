/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class DrawSmiley extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //draw face
        g.setColor(Color.YELLOW);
        g.fillOval(10, 10, 200, 200);

        //draw eyes
        g.setColor(Color.BLACK);
        g.fillOval(55, 65, 30, 30);
        g.fillOval(135, 65, 30, 30);

        //draw mount
        g.fillOval(50, 110, 120, 60);

        //fix mouth to be in shape of smile
        g.setColor(Color.YELLOW);
        g.fillRect(50, 110, 120, 30);
        g.fillOval(50, 120, 120, 40);
    }//end paintComponent

    public static void main(String[] args) {
        DrawSmiley panel = new DrawSmiley();
        JFrame app = new JFrame();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.setSize(230, 250);
        app.setVisible(true);
    }//end Main
}//end Class
