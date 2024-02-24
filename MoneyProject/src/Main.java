public class Main {
    public static void main(String[] args) {


        System.out.printf("%.2f%n",futureInvestmentAmount(1000, 3.25, 1));


        int cents = 450;
        int dollars = 1;

        if(cents >= 100){
            dollars += cents / 100;
            double tempCents = cents % 100d;

            cents = (int)tempCents;
        }

        System.out.println("dollars: " + dollars);
        System.out.println("cents: " + cents);


    }

    public static double futureInvestmentAmount(double money, double annualInterestRate, int years){
        double result;
        annualInterestRate /= 1200;
        years *= 12;

        result = money * Math.pow((1 + annualInterestRate), years);
        return result;
    }
}