package gui;

public class ValueUpdateSystem
{
    public static final String[] topics = {"Education", "Research", "CO2", "Poverty", "Accessibility", "Tax",
            "Crime", "PO", "GDP"};

    public int education, research, co2, poverty, accessibility, taxRate, crimeRate, publicOpinion, GDP, hdi, happiness, population;
    private GuiMain guiMain;

    public ValueUpdateSystem(GuiMain guiMain)
    {
        this.guiMain = guiMain;
    }

    public void updateAllValues(String s)
    {
        education = 0;
        research = 0;
        co2 = 0;
        poverty = 0;
        accessibility = 0;
        taxRate = 0;
        crimeRate = 0;
        publicOpinion = 0;
        GDP = 0;
        hdi = 0;
        happiness = 0;
        population = 0;
        if (s.equals(topics[0]))
        {
            //Education
            population -= 1;
            education += 5;
            research += 1;
            hdi += 1;
            poverty -= 1;
            accessibility += 3;
            taxRate += 5;
            publicOpinion -= 1;
            happiness += 1;
            GDP += 5;
        }
        else if (s.contains(topics[1]))
        {
            //Research
            research += 1;
            education += 5;
            hdi += 5;
            co2 += 5;
            poverty -= 1;
            accessibility += 2;
            taxRate += 10;
            GDP += 5;
        }
        else if (s.contains(topics[2]))
        {
            //Warming
            education += 5;
            co2 -= 1;
            poverty -= 1;
            accessibility += 1;
            taxRate += 5;

            GDP -= 5;
        }
        else if (s.contains(topics[3]))
        {
            //Poverty
            hdi += 1;
            poverty -= 1;
            accessibility += 1;
            crimeRate -= 1;
            publicOpinion -= 1;
            happiness += 1;

            GDP -= 5;
        }
        else if (s.contains(topics[4]))
        {
            //Accessibility
            accessibility += 10;

            population += 5;
            education += 1;
            hdi += 1;
            poverty -= 1;
            taxRate += 5;
            publicOpinion += 5;
            happiness += 1;

            GDP -= 10;
        }
        else if (s.contains(topics[5]))
        {
            //Tax
            taxRate -= 1;

            population += 1;
            poverty -= 1;
            accessibility += 1;
            crimeRate -= 1;
            publicOpinion += 5;
            happiness += 5;

            GDP += 1;
        }
        else if (s.contains(topics[6]))
        {
            //Crime Rate

            population += 1;
            hdi += 1;
            poverty -= 1;
            publicOpinion -= 1;
            happiness += 5;

        }
        else if (s.contains(topics[7]))
        {
            //Public Opinion

            publicOpinion += 1;
            hdi += 1;
            crimeRate -= 5;
            happiness += 1;

            GDP -= 5;
        }
        else if (s.contains(topics[8]))
        {
            //GDP

            GDP += 5;
            education -= 1;
            hdi -= 1;
            co2 += 10;
            poverty += 5;
            accessibility -= 1;

        }

        for (String string : topics)
        {
            int x = 0;
            string = string.toLowerCase();
            if (string.contains("education"))
            {
                x = education;
            }
            else if (string.contains("research"))
            {
                x = research;
            }
            else if (string.contains("co2"))
            {
                x = co2;
            }
            else if (string.contains("poverty"))
            {
                x = poverty;
            }
            else if (string.contains("accessibility"))
            {
                x = accessibility;
            }
            else if (string.contains("tax"))
            {
                x = taxRate;
            }
            else if (string.contains("crime"))
            {
                x = crimeRate;
            }
            else if (string.contains("po"))
            {
                x = publicOpinion;
            }
            else if (string.contains("gdp"))
            {
                x = GDP;
            }

            x += guiMain.globalMap.get(string);

            if (x >= 100)
                x = 100;
            else if (x <= 0)
                x = 0;

            guiMain.globalMap.put(string, x);
        }
    }
}
