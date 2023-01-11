package systems;

import gui.GuiMain;
import util.Data;

import java.util.Map;
import java.util.Random;

public class GameEventManager
{
    private GuiMain guiMain;
    private boolean dead;

    public GameEventManager(GuiMain guiMain)
    {
        this.guiMain = guiMain;
        dead = false;
    }

    public Map<Data.Type, Integer> nextDay()
    {
        //Random random = new Random();
        //int roll = random.nextInt(0, 10);
        Map<Data.Type, Integer> dataMap = guiMain.currentData.dataMap;
        System.out.println(dataMap);

        if (dead)
            System.exit(0);
        if (dataMap.get(Data.Type.POPULATION) >= 95)
        {
            System.out.println("[EVENT] Population too high");
            guiMain.text.setText("Overpopulation!");
            dataMap.put(Data.Type.ACCESSIBILITY, dataMap.get(Data.Type.ACCESSIBILITY) - 10);
            dataMap.put(Data.Type.POVERTY, dataMap.get(Data.Type.POVERTY) + 5);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 10);
            dataMap.put(Data.Type.POPULATION, dataMap.get(Data.Type.POPULATION) - 5);
        }
        if (dataMap.get(Data.Type.POPULATION) <= 20)
        {
            System.out.println("Death Event");
            guiMain.text.setText("You have Died!");
            //DEATH EVENT
        }
        if (dataMap.get(Data.Type.CO2) >= 70)
        {
            guiMain.text.setText("The air tastes funny!");
            dataMap.put(Data.Type.POVERTY, dataMap.get(Data.Type.POVERTY) + 5);
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 10);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 5);
            dataMap.put(Data.Type.POPULATION, dataMap.get(Data.Type.POPULATION) - 10);

        }
        if (dataMap.get(Data.Type.POVERTY) >= 50)
        {
            guiMain.text.setText("Why are there so many people on the streets?!");
            System.out.println("[EVENT] Poverty Too High");
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) - 20);
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 50);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 50);
            dataMap.put(Data.Type.HDI, dataMap.get(Data.Type.HDI) - 10);
            dataMap.put(Data.Type.EDUCATION, dataMap.get(Data.Type.EDUCATION) - 10);
        }
        if (dataMap.get(Data.Type.TAX_RATE) >= 75)
        {
            guiMain.text.setText("Angry conservative noises!");
            System.out.println("[EVENT] Tax Rate Too High");
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 10);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 20);
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) - 10);

        }
        if (dataMap.get(Data.Type.CRIME_RATE) >= 50)
        {
            guiMain.text.setText("Everyone's been robbed!");
            System.out.println("[EVENT] Crime Rate Too High");
            dataMap.put(Data.Type.EDUCATION, dataMap.get(Data.Type.EDUCATION) - 10);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 50);
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 50);
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) - 30);
            dataMap.put(Data.Type.HDI, dataMap.get(Data.Type.HDI) - 30);

        }
        if (dataMap.get(Data.Type.HDI) > 50)
        {
            guiMain.text.setText("The UN recognizes your awesomeness!");
            System.out.println("[EVENT] Hdi High");
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) + 10);
        }
        if (dataMap.get(Data.Type.PUBLIC_OPINION) > 75)
        {
            guiMain.text.setText("Your citizens have built a statue of you!");
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) + 10);

        }
        if (dataMap.get(Data.Type.HAPPINESS) > 90)
        {
            guiMain.text.setText("Your subjects recognize your awesomeness!");
            System.out.println("[EVENT] Happiness High");
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) + 10);
        }
        if (dataMap.get(Data.Type.GDP) < 10)
        {
            guiMain.text.setText("You are poor!");
            System.out.println("[EVENT] Happiness High");
            dataMap.put(Data.Type.TAX_RATE, dataMap.get(Data.Type.TAX_RATE) + 5);
            dataMap.put(Data.Type.POVERTY, dataMap.get(Data.Type.POVERTY) + 5);
            dataMap.put(Data.Type.ACCESSIBILITY, dataMap.get(Data.Type.ACCESSIBILITY) - 10);
        }

        if (dataMap.get(Data.Type.POPULATION) <= 20)
        {
            System.out.println("Death Event");
            guiMain.text.setText("You have Died!");
            dead = true;

            //DEATH EVENT
        }
        if (dataMap.get(Data.Type.PUBLIC_OPINION) <= 10)
        {
            System.out.println("Death Event");
            guiMain.text.setText("Regicide!");
            dead = true;

            //DEATH EVENT
        }
        System.out.print(dataMap);

        return dataMap;
    }
}
