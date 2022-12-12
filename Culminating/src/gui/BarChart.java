package gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BarChart extends JPanel
{
    private Map<Color, Integer> bars = new HashMap<>();

    public void addBar(Color color, int value)
    {
        bars.put(color, value);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        
    }
}
