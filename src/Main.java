import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("It's time");

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int numberMenu = testNumber(scanner);

            if (numberMenu == 1) {
                int monthNumber = selectMonthNumber(scanner);
                int dayNumber = selectDay(scanner);
                int steps = selectSteps(scanner);

                stepTracker.monthToData[monthNumber].daysToMonth[dayNumber - 1] = steps;
                System.out.println("Готово! Данные сохранены.");

            } else if (numberMenu == 2) {
                int monthNumber = selectMonthNumber(scanner);

                /*
                Вернул массив значений, чтобы выполнить вывод в классе Main. Задание просит делать ввод и вывод в Main.
                Тип float выбрал для того, чтобы вывести более точную цифру по пройденной дистанции. Остальные значения
                округлил до int.
                 */
                float[] values = stepTracker.printStepsOfMonth(monthNumber);

                System.out.println("Общее количество шагов в месяце: " + (int) values[0]);
                System.out.println("Среднее количество шагов: " + (int) values[1]);
                System.out.println("Лучшая серия: " + (int) values[2]);
                System.out.println("Пройденная дистанция: " + values[3] + " км");
                System.out.println("Колличество сожённых каллорий: " + (int) values[4]);

            } else if (numberMenu == 3) {
                System.out.println("Сейчас твоя цель = " + stepTracker.stepsGoal + " шагов в день!");
                System.out.println("Введи новую цель:");
                int steps = selectSteps(scanner);
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

    private static int selectMonthNumber(Scanner scanner) {
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

            int monthNumber = testNumber(scanner);

            if (monthNumber > 11) {
                System.out.println("Такого месяца не существует.");
            } else {
                return monthNumber;
            }
        }
    }

    private static int selectDay(Scanner scanner) {
        System.out.println("Обратите внимание, что ход времени изменился. Теперь в каждом месяце ровно по 30 дней.");

        while (true) {
            System.out.println("Выберите номер дня.");
            System.out.println("Введите число от 1 до 30:");

            int numberDay = testNumber(scanner);

            if (numberDay < 1 || numberDay > 30) {
                System.out.println("Такого дня не существует.");
            } else {
                return numberDay;
            }
        }
    }

    private static int selectSteps(Scanner scanner) {
        while (true) {
            System.out.println("Введите количество шагов:");

            return testNumber(scanner);
        }
    }

    private static int testNumber(Scanner scanner) {
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
}
