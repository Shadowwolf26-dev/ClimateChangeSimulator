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

        JPanel rightPanel = new JPanel();
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(4, 1));
        rightPanel.setLayout(new GridLayout(5, 1));

        JButton rButton1 = new JButton("Build Schools! (Increase Education)");
        rightPanel.add(rButton1);
        JButton rButton2 = new JButton("Invest in Research (Increase Research)");
        rightPanel.add(rButton2);
        JButton rButton3 = new JButton("Increase Green Energy Spending. (Lowers CO2)");
        rightPanel.add(rButton3);
        JButton rButton4 = new JButton("Create Jobs and Build Shelters. (Lowers Poverty)");
        rightPanel.add(rButton4);
        JButton rButton5 = new JButton("Equity Spending (Increases Accessibility)");
        rightPanel.add(rButton5);

        JButton lButton1 = new JButton("Lower Tax Rate (Lowers Tax Rate)");
        leftPanel.add(lButton1);
        JButton lButton2 = new JButton("Increase Security. (Lowers Crime Rate)");
        leftPanel.add(lButton2);
        JButton lButton3 = new JButton("Post a Meme (Increases Public Opinion)");
        leftPanel.add(lButton3);
        JButton lButton4 = new JButton("Build Factory (Increase GDP)");
        leftPanel.add(lButton4);

        frame.getContentPane().add(BorderLayout.WEST, leftPanel);
        frame.getContentPane().add(BorderLayout.EAST, rightPanel);

        JPanel panel = new JPanel();
        panel.setSize(450, 75);
        frame.getContentPane().add(BorderLayout.NORTH, panel);

        BarChart barChart = new BarChart();
        /*barChart.addBar("Population", Color.CYAN, 100);
        barChart.addBar(Color.RED, 75);
        barChart.addBar(Color.GREEN, 25);
        barChart.addBar(Color.ORANGE, 50);
        barChart.addBar(Color.MAGENTA, 10);
        barChart.addBar(Color.PINK, 20);
        barChart.addBar(Color.YELLOW, 15);
        barChart.addBar(Color., 10);
        barChart.addBar(Color.PINK, 20);
        barChart.addBar(Color.YELLOW, 15);
        barChart.addBar(Color.PINK, 20);
        barChart.addBar(Color.YELLOW, 15);
        barChart.setSize(400, 400);*/

        frame.getContentPane().add(BorderLayout.CENTER, barChart);

        JLabel text = new JLabel("Welcome to Climate Change Simulator!");
        text.setFont(new Font("Serif", Font.PLAIN, 24));
        panel.add(BorderLayout.NORTH, text);

        //GridLayout gridLayout = new GridLayout();
        frame.setVisible(true);
    }
}
