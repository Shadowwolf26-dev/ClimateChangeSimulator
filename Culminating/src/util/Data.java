package util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data
{
    public Map<Type, Integer> dataMap = new HashMap<>();

    public Data(int population, int education, int research, int co2, int poverty, int accessibility, int taxRate,
                int crimeRate, int publicOpinion, int GDP, int hdi, int happiness)
    {
        dataMap.put(Type.Education, education);
        dataMap.put(Type.RESEARCH, research);
        dataMap.put(Type.CO2, co2);
        dataMap.put(Type.POVERTY, poverty);
        dataMap.put(Type.ACCESSIBILITY, accessibility);
        dataMap.put(Type.TAX_RATE, taxRate);
        dataMap.put(Type.CRIME_RATE, crimeRate);
        dataMap.put(Type.PUBLIC_OPINION, publicOpinion);
        dataMap.put(Type.GDP, GDP);
        dataMap.put(Type.HDI, hdi);
        dataMap.put(Type.HAPPINESS, happiness);
        dataMap.put(Type.POPULATION, population);
    }


    public Data(List<Integer> dataList)
    {
        if (dataList.size() < 11)
            return;
        dataMap.put(Type.Education, dataList.get(0));
        dataMap.put(Type.RESEARCH, dataList.get(1));
        dataMap.put(Type.CO2, dataList.get(2));
        dataMap.put(Type.POVERTY, dataList.get(3));
        dataMap.put(Type.ACCESSIBILITY, dataList.get(4));
        dataMap.put(Type.TAX_RATE, dataList.get(5));
        dataMap.put(Type.CRIME_RATE, dataList.get(6));
        dataMap.put(Type.PUBLIC_OPINION, dataList.get(7));
        dataMap.put(Type.GDP, dataList.get(8));
        dataMap.put(Type.HDI, dataList.get(9));
        dataMap.put(Type.HAPPINESS, dataList.get(10));
        dataMap.put(Type.POPULATION, dataList.get(11));
    }


    public enum Type
    {
        Education,
        RESEARCH,
        CO2,
        POVERTY,
        ACCESSIBILITY,
        TAX_RATE,
        CRIME_RATE,
        PUBLIC_OPINION,
        GDP,
        HDI,
        HAPPINESS,
        POPULATION
    }

}
