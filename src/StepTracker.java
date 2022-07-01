import java.util.Scanner;

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

    int selectMonthNumber(Scanner scanner) {
        while (true) {
            System.out.println("Выберите номер месяца:");
            System.out.println("0 - январь");
            System.out.println("1 - февраль");
            System.out.println("2 - март");
            System.out.println("3 - апрель");
            System.out.println("4 - май");
            System.out.println("5 - июнь");
            System.out.println("6 - июль");
            System.out.println("7 - август");
            System.out.println("8 - сентябрь");
            System.out.println("9 - октябрь");
            System.out.println("10 - ноябрь");
            System.out.println("11 - декабрь");

            int monthNumber = checkStepsNumber(scanner);

            if (monthNumber > 11) {
                System.out.println("Такого месяца не существует.");
            } else {
                return monthNumber;
            }
        }
    }

    int selectDay(Scanner scanner) {
        System.out.println("Обратите внимание, что ход времени изменился. Теперь в каждом месяце ровно по 30 дней.");

        while (true) {
            System.out.println("Выберите номер дня.");
            System.out.println("Введите число от 1 до 30:");

            int numberDay = checkStepsNumber(scanner);

            if (numberDay < 1 || numberDay > 30) {
                System.out.println("Такого дня не существует.");
            } else {
                return numberDay;
            }
        }
    }

    int selectSteps(Scanner scanner) {
        System.out.println("Введите количество шагов:");

        return checkStepsNumber(scanner);
    }

    int checkStepsNumber(Scanner scanner) { // Название метода исправил. Спасибо за наводку :)
        int number = 0;
        do {
            if (number < 0) {
                System.out.println("Вы ввели отрицательное число. В этой программе нельзя вводить отрицательное число.");
            }

            while (!scanner.hasNextInt()) {
                System.out.println("Это не число! Введите число!");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number < 0);
        return number;
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
