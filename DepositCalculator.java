import java.util.Scanner;

public class DepositCalculator {
    public static void main (String[] args){
        new DepositCalculator().processUserInput();

    double calculateComplexPercent(double amount, double yearRate, int yearsCount) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * yearsCount);
        return getRounding(pay, 2);
    }
    double calculateSimplePercent(amount, yearRate, yearsCount) {
        return getRounding(amount + amount * yearRate * yearsCount, 2);
    }
    double getRounding(double value, int places) {
        double scaLe = Math.pow(10 , places);
        return Math.round(value * scaLe) / scaLe;
    }

    void processUserInput() {
        int period;
        int depositType;
        double percentRate = 0.06;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        double totalProfit = 0.0;

        if (depositType == 1) {
            totalProfit = calculateSimplePercent(amount, percentRate, period);

        } else if (depositType == 2) {
            totalProfit = calculateComplexPercent(amount, percentRate, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalProfit);
    }

    }
}