import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculate(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return calculate(amount + (amount * yearRate * depositPeriod), 2);
    }

    double calculate(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDepositAmount() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double depositAmount = 0;
        if (action == 1) {
            depositAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            depositAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositAmount();
    }
}
