package gui;

import systems.GameEventManager;
import util.Data;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Events implements java.awt.event.ActionListener
{
    private GuiMain guiMain;
    private GameEventManager gameEventManager;
    public Events(GuiMain guiMain)
    {
        this.guiMain = guiMain;
        gameEventManager = new GameEventManager(guiMain);
    }

    private final String[] topics = {"Education", "Research", "CO2", "Poverty", "Accessibility", "Tax",
                                        "Crime", "PO", "Population","GDP"};
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(guiMain.currentData.dataMap);
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

                updateData(topic.toLowerCase(), change);
                break;
            }
        }

        System.out.println(guiMain.currentData.dataMap);

        Map<String, Integer> newChangeMap = new HashMap<>();
        Map<Data.Type, Integer> nextDayMap = gameEventManager.nextDay();
        for (Data.Type type : nextDayMap.keySet())
        {
            String name = "";

            switch (type)
            {
                case EDUCATION:
                    name = "education";
                    break;
                case RESEARCH:
                    name = "research";
                    break;
                case CO2:
                    name = "co2";
                    break;
                case POVERTY:
                    name = "poverty";
                    break;
                case ACCESSIBILITY:
                    name = "accessibility";
                    break;
                case TAX_RATE:
                    name = "tax";
                    break;
                case CRIME_RATE:
                    name = "crime";
                    break;
                case PUBLIC_OPINION:
                    name = "po";
                    break;
                case GDP:
                    name = "gdp";
                    break;
                case HDI:
                    name = "hdi";
                    break;
                case HAPPINESS:
                    name = "happiness";
                    break;
                case POPULATION:
                    name = "population";
                    break;
            }

            newChangeMap.put(name, nextDayMap.get(type));
            System.out.println(newChangeMap);
        }
        updateDataMap(newChangeMap, nextDayMap);

        System.out.println(guiMain.currentData.dataMap);
    }

    private void checkConditions()
    {
        Map<Data.Type, Integer> dataMap = gameEventManager.nextDay();

        for (Data.Type type : dataMap.keySet())
        {
           String s = type.name();
        }
    }

    private void updateData(String topic, int change)
    {
        Map<String, Integer> changeMap = new HashMap<>();
        changeMap.put(topic, change);

        //System.out.println(topic + " | " + change);

        guiMain.updateBarChart(changeMap);
        guiMain.updateGUI();

    }

    private void updateDataMap(Map<String, Integer> changeMap, Map<Data.Type, Integer> changeMapEnum)
    {
        guiMain.refreshGlobal(changeMap, changeMapEnum);
        guiMain.updateGUI();
    }
}
