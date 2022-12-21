package gui;

import com.sun.tools.javac.Main;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Events implements java.awt.event.ActionListener
{
    private GuiMain guiMain;
    public Events(GuiMain guiMain)
    {
        this.guiMain = guiMain;
    }

    private final String[] topics = {"Education", "Research", "CO2", "Poverty", "Accessibility", "Tax",
                                        "Crime", "PO", "GDP"};
    @Override
    public void actionPerformed(ActionEvent e)
    {

        String s = e.getActionCommand();
        String topic = "";
        int change = 0;
        boolean negative = false;

        for (String t : topics)
        {
            if (s.contains(t))
            {
                topic = t;

                List<String> strings = List.of(s.split("\\+"));

                if (strings.size() <= 1)
                {
                    strings = List.of(s.split("-"));
                    negative = true;
                }

                strings = List.of(strings.get(1).split(" "));

                change = Integer.parseInt(strings.get(0));
                if (negative)
                    change *= -1;

                updateData(topic, change);
                break;
            }
        }


    }

    private void updateData(String topic, int change)
    {
        Map<String, Integer> changeMap = new HashMap<>();
        changeMap.put(topic, change);

        System.out.println(topic + " | " + change);

        guiMain.updateBarChart(changeMap);
        guiMain.updateGUI();

    }
}
