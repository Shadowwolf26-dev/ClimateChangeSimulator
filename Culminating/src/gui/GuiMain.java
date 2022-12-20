package gui;

import util.Bar;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GuiMain
{
    private Events events = new Events(this);
    public Map<String, Integer> globalMap = new HashMap<>();
    private JFrame frame;
    private JPanel panel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private BarChart barChart = new BarChart();

    public GuiMain()
    {
        globalMap.put("Population", 100);
        globalMap.put("Education", 75);
        globalMap.put("HDI", 25);
        globalMap.put("CO2", 50);
        globalMap.put("Poverty", 10);
        globalMap.put("Accessibility", 20);
        globalMap.put("Tax", 15);
        globalMap.put("Crime", 10);
        globalMap.put("PO", 20);
        globalMap.put("Happiness", 15);
        globalMap.put("GDP", 20);
    }
    public void main()
    {
        frame = new JFrame("Climate Change Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);

        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.setSize(400, 400);

        populateBarChart();
        barChart.setSize(400, 400);

        rightPanel = new JPanel();
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(4, 1));
        rightPanel.setLayout(new GridLayout(5, 1));

        JButton rButton1 = new JButton("Build Schools! (+5 Education)");
        rightPanel.add(rButton1);
        rButton1.addActionListener(events);

        JButton rButton2 = new JButton("Invest in Research (+1 Research)");
        rightPanel.add(rButton2);
        rButton2.addActionListener(events);

        JButton rButton3 = new JButton("Increase Green Energy Spending. (-5 CO2)");
        rightPanel.add(rButton3);
        rButton3.addActionListener(events);

        JButton rButton4 = new JButton("Create Jobs and Build Shelters. (-5 Poverty)");
        rightPanel.add(rButton4);
        rButton4.addActionListener(events);

        JButton rButton5 = new JButton("Equity Spending (+10 Accessibility)");
        rightPanel.add(rButton5);
        rButton5.addActionListener(events);

        JButton lButton1 = new JButton("Lower Tax Rate (-1 Tax Rate)");
        leftPanel.add(lButton1);
        lButton1.addActionListener(events);

        JButton lButton2 = new JButton("Increase Security. (-5 Crime Rate)");
        leftPanel.add(lButton2);
        lButton2.addActionListener(events);

        JButton lButton3 = new JButton("Post a Meme (+1 Public Opinion)");
        leftPanel.add(lButton3);
        lButton3.addActionListener(events);

        JButton lButton4 = new JButton("Build Factory (+5 GDP)");
        leftPanel.add(lButton4);
        lButton4.addActionListener(events);

        /*frame.getContentPane().add(BorderLayout.WEST, leftPanel);
        frame.getContentPane().add(BorderLayout.EAST, rightPanel);*/

        panel.add(BorderLayout.WEST, leftPanel);
        panel.add(BorderLayout.CENTER, barChart);
        panel.add(BorderLayout.EAST, rightPanel);

        JPanel tPanel = new JPanel();
        tPanel.setSize(450, 75);
        frame.getContentPane().add(BorderLayout.NORTH, tPanel);

        JLabel text = new JLabel("Welcome to Climate Change Simulator!");
        text.setFont(new Font("Serif", Font.PLAIN, 24));
        tPanel.add(BorderLayout.NORTH, text);

        frame.add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }

    public void updateBarChart(Map<String, Integer> updateMap)
    {
        for (Map.Entry<String, Integer> entry : updateMap.entrySet())
        {
            Integer newNumber = globalMap.get(entry.getKey());
            newNumber += entry.getValue();

            globalMap.put(entry.getKey(), newNumber);
        }

    }

    private void populateBarChart()
    {
        for (Map.Entry<String, Integer> entry : globalMap.entrySet())
        {
            barChart.updateBar(entry.getKey(), Color.CYAN, entry.getValue());
        }
    }

    public void updateGUI()
    {
        populateBarChart();
        frame.repaint();
        
    }
}
