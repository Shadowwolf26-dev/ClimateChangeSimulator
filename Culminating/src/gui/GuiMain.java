package gui;

import util.Data;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GuiMain
{
    private Events events = new Events(this);
    public Map<String, Integer> globalMap = new HashMap<>();
    public Data currentData;
    private JFrame frame;
    private JPanel panel;
    private JPanel buttonPanel;
    private BarChart barChart = new BarChart();
    private ValueUpdateSystem valueUpdateSystem = new ValueUpdateSystem(this);

    public GuiMain()
    {
        globalMap.put("Population", 100);
        globalMap.put("Education", 75);
        globalMap.put("Research", 0);
        globalMap.put("HDI", 25);
        globalMap.put("CO2", 50);
        globalMap.put("Poverty", 10);
        globalMap.put("Accessibility", 20);
        globalMap.put("Tax", 15);
        globalMap.put("Crime", 10);
        globalMap.put("PO", 20);
        globalMap.put("Happiness", 15);
        globalMap.put("GDP", 20);
        currentData = new Data(100, 75, 0, 25, 50, 10, 20, 15 ,10 ,20 ,15, 20);
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
        barChart.setSize(400, 1000);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 2));

        JButton rButton1 = new JButton("Build Schools! (+5 Education)");
        buttonPanel.add(rButton1);
        rButton1.addActionListener(events);

        JButton rButton2 = new JButton("Invest in Research (+1 Research)");
        buttonPanel.add(rButton2);
        rButton2.addActionListener(events);

        JButton rButton3 = new JButton("Increase Green Energy Spending. (-5 CO2)");
        buttonPanel.add(rButton3);
        rButton3.addActionListener(events);

        JButton rButton4 = new JButton("Create Jobs and Build Shelters. (-5 Poverty)");
        buttonPanel.add(rButton4);
        rButton4.addActionListener(events);

        JButton rButton5 = new JButton("Equity Spending (+10 Accessibility)");
        buttonPanel.add(rButton5);
        rButton5.addActionListener(events);

        JButton lButton1 = new JButton("Lower Tax Rate (-1 Tax Rate)");
        buttonPanel.add(lButton1);
        lButton1.addActionListener(events);

        JButton lButton2 = new JButton("Increase Security. (-5 Crime Rate)");
        buttonPanel.add(lButton2);
        lButton2.addActionListener(events);

        JButton lButton3 = new JButton("Post a Meme (+1 PO)");
        buttonPanel.add(lButton3);
        lButton3.addActionListener(events);

        JButton lButton4 = new JButton("Build Factory (+5 GDP)");
        buttonPanel.add(lButton4);
        lButton4.addActionListener(events);

        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

        panel.add(BorderLayout.CENTER, barChart);
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
            if (newNumber >= 100)
                newNumber = 100;
            else if (newNumber <= 0)
                newNumber = 0;
            valueUpdateSystem.updateAllValues(entry.getKey());
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

        currentData = new Data(globalMap.values().stream().toList());

    }
}
