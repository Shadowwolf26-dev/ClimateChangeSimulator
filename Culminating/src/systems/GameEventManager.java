package systems;

import gui.GuiMain;
import util.Data;

import java.util.Map;
import java.util.Random;

public class GameEventManager
{
    private GuiMain guiMain;

    public GameEventManager(GuiMain guiMain)
    {
        this.guiMain = guiMain;
    }

    public Map<Data.Type, Integer> nextDay()
    {
        Random random = new Random();
        int roll = random.nextInt(0, 10);
        Map<Data.Type, Integer> dataMap = guiMain.currentData.dataMap;

        if (dataMap.get(Data.Type.POPULATION) >= 95)
        {
            dataMap.put(Data.Type.ACCESSIBILITY, dataMap.get(Data.Type.ACCESSIBILITY) - 10);
            dataMap.put(Data.Type.POVERTY, dataMap.get(Data.Type.POVERTY) + 5);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 10);
            dataMap.put(Data.Type.POPULATION, dataMap.get(Data.Type.POPULATION) - 5);
        }
        if (dataMap.get(Data.Type.POPULATION) <= 20)
        {
            //DEATH EVENT
        }
        if (dataMap.get(Data.Type.CO2) >= 70)
        {
            dataMap.put(Data.Type.POVERTY, dataMap.get(Data.Type.POVERTY) + 5);
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 10);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 5);
            dataMap.put(Data.Type.POPULATION, dataMap.get(Data.Type.POPULATION) - 10);

        }
        if (dataMap.get(Data.Type.POVERTY) >= 50)
        {
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) - 20);
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 50);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 50);
            dataMap.put(Data.Type.HDI, dataMap.get(Data.Type.HDI) - 10);
        }
        if (dataMap.get(Data.Type.TAX_RATE) >= 75)
        {
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 10);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 20);
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) - 10);

        }
        if (dataMap.get(Data.Type.CRIME_RATE) >= 90)
        {
            dataMap.put(Data.Type.EDUCATION, dataMap.get(Data.Type.EDUCATION) - 10);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 50);
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 50);
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) - 30);
            dataMap.put(Data.Type.HDI, dataMap.get(Data.Type.HDI) - 30);

        }
        if (dataMap.get(Data.Type.HDI) > 50)
        {
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) + 10);
        }
        if (dataMap.get(Data.Type.HAPPINESS) > 90)
        {
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) + 10);

        }

        System.out.print(dataMap);

        return dataMap;
    }
}
