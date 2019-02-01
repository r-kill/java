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

public class OvalAndRect extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 10; i++) {
            g.drawRect(10 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
            g.drawOval(240 + i * 10, 10 + i * 10, 50 + i * 10, 50 + i * 10);
        }//end For
    }//end paintComponent

    public static void main(String[] args) {
        OvalAndRect panel = new OvalAndRect();
        JFrame app = new JFrame();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(panel);
        app.setSize(500, 290);
        app.setVisible(true);
    }//end Main
}//end Class
