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

public class DrawRainbow extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //define indigo and violet
        Color VIOLET = new Color(128, 0, 128);
        Color INDIGO = new Color(75, 0, 130);

        //colors to use in rainbow starting from innermost
        //the two white elements provide empty arc in center
        Color[] colors = {Color.WHITE, Color.WHITE, VIOLET, INDIGO, Color.BLUE,
            Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED};

        //radius of arc
        int radius = 20;

        //draw rainbow near botton-center of window
        int centerX = getWidth() / 2;
        int centerY = getHeight() - 10;

        //draw filled arcs starting with outermost in array
        for (int count = colors.length; count > 0; count--) {
            //set color for current arc
            g.setColor(colors[count - 1]);

            //fill arc from 0 to 180 degrees
            g.fillArc(centerX - count * radius, centerY - count * radius, count * radius * 2, count * radius * 2, 0, 180);
        }//end For
    }//end paintComponent

    public static void main(String[] args) {
        DrawRainbow panel = new DrawRainbow();
        JFrame app = new JFrame();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.setSize(400, 250);
        app.setVisible(true);
    }//end Main
}//end Class
