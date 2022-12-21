package gui;

public class ValueUpdateSystem
{
    public static final String[] topics = {"Education", "Research", "CO2", "Poverty", "Accessibility", "Tax",
            "Crime", "PO", "GDP"};

    int education, research, co2, poverty, accessibility, taxRate, crimeRate, publicOpinion, GDP, hdi, happiness, population;
    private GuiMain guiMain;

    public ValueUpdateSystem(GuiMain guiMain)
    {
        this.guiMain = guiMain;
    }

    public void updateAllValues(String s)
    {
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
            if (string.contains("Education"))
            {
                x = education;
            }
            else if (string.contains("Research"))
            {
                x = research;
            }
            else if (string.contains("CO2"))
            {
                x = co2;
            }
            else if (string.contains("Poverty"))
            {
                x = poverty;
            }
            else if (string.contains("Accessibility"))
            {
                x = accessibility;
            }
            else if (string.contains("Tax"))
            {
                x = taxRate;
            }
            else if (string.contains("Crime"))
            {
                x = crimeRate;
            }
            else if (string.contains("PO"))
            {
                x = publicOpinion;
            }
            else if (string.contains("GDP"))
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
