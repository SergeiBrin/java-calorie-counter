import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("It's time");

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int numberMenu = stepTracker.checkStepsNumber(scanner);

            if (numberMenu == 1) {
                int monthNumber = stepTracker.selectMonthNumber(scanner);
                int dayNumber = stepTracker.selectDay(scanner);
                int steps = stepTracker.selectSteps(scanner);

                stepTracker.monthToData[monthNumber].daysToMonth[dayNumber - 1] = steps;
                System.out.println("Готово! Данные сохранены.");

            } else if (numberMenu == 2) {
                int monthNumber = stepTracker.selectMonthNumber(scanner);
                double[] values = stepTracker.printStepsOfMonth(monthNumber);

                System.out.println("Общее количество шагов в месяце: " + (int) values[0]);
                System.out.println("Среднее количество шагов: " + (int) values[1]);
                System.out.println("Лучшая серия: " + (int) values[2]);
                System.out.println("Пройденная дистанция: " + values[3] + " км");
                System.out.println("Количество сожжённых калорий: " + (int) values[4]);

            } else if (numberMenu == 3) {
                System.out.println("Сейчас твоя цель = " + stepTracker.stepsGoal + " шагов в день!");
                System.out.println("Введи новую цель:");
                int steps = stepTracker.selectSteps(scanner);
                stepTracker.changeStepsGoal(steps);
                System.out.println("Изменено. Теперь твоя новая цель по количеству шагов в день = " + stepTracker.stepsGoal);

            } else if (numberMenu == 0) {
                System.out.println("Программа завершена. До встречи :)");
                return;
            } else {
                System.out.println("Такой команды нет. Выберите правильную команду.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}
