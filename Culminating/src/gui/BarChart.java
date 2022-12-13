package gui;

import util.Bar;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BarChart extends JPanel
{
    private Map<String, Bar> bars = new HashMap<>();

    public void addBar(String name, Color color, int value)
    {
        Bar bar = new Bar(color, value);
        bars.put(name, bar);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
       int max = Integer.MIN_VALUE;
       for (Bar entry : bars.values())
       {
           max = Math.max(max, entry.getValue());
       }

       int width = (getWidth() / bars.size());
       int x = 1;
       for (Bar entry : bars.values())
       {
           int value = entry.getValue();
           int height = (int) ((getHeight() - 5) * ((double) value / max));
           g.setColor(entry.getColor());
           g.fillRect(x, getHeight() - height, width, height);
           g.setColor(Color.BLACK);
           g.drawRect(x, getHeight() - height, width, height);
           x += (width + 2);
       }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(bars.size() * 10 + 2, 50);
    }
}
