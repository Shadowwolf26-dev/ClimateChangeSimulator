package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GuiMain
{
    public void main()
    {
        JFrame frame = new JFrame("Climate Change Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);


        JButton button = new JButton("Click Me!");
        frame.getContentPane().add(BorderLayout.WEST, button);

        JButton button2 = new JButton("Click Me Too!");
        frame.getContentPane().add(BorderLayout.EAST, button2);

        JPanel panel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, panel);

        JLabel text = new JLabel("Welcome to Climate Change Simulator!");
        panel.add(BorderLayout.NORTH, text);

        //GridLayout gridLayout = new GridLayout();
        frame.setVisible(true);
    }
}
