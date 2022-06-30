public class StepTracker {
    MonthData[] monthToData;
    int stepsGoal;

    StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        stepsGoal = 10000;
    }

    void changeStepsGoal(int steps) {
        stepsGoal = steps;
    }

    float[] printStepsOfMonth(int monthNumber) {
        float[] values = new float[5];
        float allMonthSteps = 0;
        float averageMonthSteps = 0;
        float bestSeries = 0;
        int test = 0;

        int daysOfMonth = monthToData[monthNumber].daysToMonth.length;

        for (int i = 0; i < daysOfMonth; i++) {
            int daySteps = monthToData[monthNumber].daysToMonth[i];
            int dayNumber = i + 1;
            if (i < daysOfMonth - 1) {
                System.out.print(dayNumber + " День: " + daySteps + ", ");
            } else {
                System.out.println(dayNumber + " День: " + daySteps + ".");
            }

            allMonthSteps += daySteps;

            if (daySteps >= stepsGoal) {
                test++;
                if (bestSeries < test) {
                    bestSeries++;
                }
            } else {
                test = 0;
            }
        }

        averageMonthSteps = allMonthSteps / daysOfMonth;
        Converter converter = new Converter(allMonthSteps);

        values[0] = allMonthSteps;
        values[1] = averageMonthSteps;
        values[2] = bestSeries;
        values[3] = converter.distance;
        values[4] = converter.kiloCalories;

        return values;
    }

    class MonthData {
        int[] daysToMonth = new int[30];
    }
}
