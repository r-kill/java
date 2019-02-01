/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rowan
 */
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class GUIdemo extends JPanel {

    public void paintComponent(Graphics g) {
        //render the object so we can draw on it
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        //line from up-left to low-right
        g.drawLine(0, 0, width, height);

        //line from low-left to up-right
        g.drawLine(0, height, width, 0);
    }//end paintComponent

    public static void main(String[] args) {
        //create panel to hold drawing
        GUIdemo panel = new GUIdemo();

        //create frame to hold panel
        JFrame application = new JFrame();

        //set frame to exit when closed
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        application.add(panel);
        application.setSize(250, 250);
        application.setVisible(true);
    }//end Main
}//end GUIdemo
