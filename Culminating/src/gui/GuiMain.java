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
    public JLabel text;
    private BarChart barChart = new BarChart();
    private final ValueUpdateSystem valueUpdateSystem = new ValueUpdateSystem(this);

    public GuiMain()
    {
        globalMap.put("population", 75);
        globalMap.put("education", 25);
        globalMap.put("research", 0);
        globalMap.put("hdi", 50);
        globalMap.put("co2", 50);
        globalMap.put("poverty", 5);
        globalMap.put("accessibility", 25);
        globalMap.put("tax", 15);
        globalMap.put("crime", 5);
        globalMap.put("po", 50);
        globalMap.put("happiness", 50);
        globalMap.put("gdp", 50);
        currentData = new Data(75, 25, 0, 50, 5, 25, 15, 5 ,50 ,50 ,50, 50);
        System.out.println(currentData.dataMap);
    }
    public void main()
    {
        frame = new JFrame("Climate Change Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.setSize(400, 400);

        populateBarChart();
        barChart.setSize(400, 1000);

        JPanel buttonPanel = new JPanel();
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

        text = new JLabel("Welcome to Climate Change Simulator!");
        text.setFont(new Font("Serif", Font.PLAIN, 24));
        tPanel.add(BorderLayout.NORTH, text);

        frame.add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }

    public void updateBarChart(Map<String, Integer> updateMap)
    {
        for (Map.Entry<String, Integer> entry : updateMap.entrySet())
        {
            valueUpdateSystem.updateAllValues(entry.getKey());
        }
        System.out.println(currentData.dataMap);
    }

    private void populateBarChart()
    {
        for (Map.Entry<String, Integer> entry : globalMap.entrySet())
        {
            int num = entry.getValue();

            if (num >= 100)
                num = 100;
            else if (num <= 0)
                num = 0;
            barChart.updateBar(entry.getKey(), Color.CYAN, num);
        }
    }

    public void updateGUI()
    {
        populateBarChart();
        frame.repaint();

        currentData = new Data(globalMap);

        System.out.println(currentData.dataMap);

    }

    public void refreshGlobal(Map<String, Integer> changeMap, Map<Data.Type, Integer> changeMapEnum)
    {
        globalMap.putAll(changeMap);
        currentData.dataMap.putAll(changeMapEnum);
    }
}
