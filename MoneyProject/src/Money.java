public class Money {
    private int dollars, cents;

    public Money() {
        this(0, 0);
    }

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        setCents(cents);
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    public void setDollars(int dollars) {
        if(isValid(dollars, cents)){
            this.dollars = dollars;
        } else {
            throw new IllegalArgumentException("Invalid input: Dollars value cannot be negative.");
        }

    }

    public void setCents(int cents) {
        if (isValid(dollars, cents)) {
            this.dollars += cents / 100;
            this.cents = cents % 100;
        } else {
            throw new IllegalArgumentException("Invalid input: Cents value cannot be negative.");
        }
    }

    public double getValue() {
        return dollars + cents / 100.0;
    }

    public void add(Money anotherMoney) {
        add(anotherMoney.getDollars(), anotherMoney.getCents());
    }

    public void add(int dollars, int cents) {
        if(isValid(dollars, cents)){
            this.dollars += dollars;
            setCents(this.cents + cents);
        } else {
            throw new IllegalArgumentException("Invalid input: Dollars or Cents values cannot be negative.");
        }
    }

    public void subtract(Money anotherMoney) {
        subtract(anotherMoney.getDollars(), anotherMoney.getCents());
    }

    public void subtract(int dollars, int cents) {
        if(isValid(dollars, cents)){
            int totalCents = (this.dollars * 100 + this.cents) - (dollars * 100 + cents);
            if (totalCents < 0) {
                throw new IllegalArgumentException("Invalid input: Insufficient funds for subtraction.");
            }else {
                this.dollars = totalCents / 100;
                this.cents = totalCents % 100;
            }
        } else {
            throw new IllegalArgumentException("Invalid input: Dollars or Cents values cannot be negative.");
        }
    }

    public void multiply(double factor) {
        if (factor < 0) {
            throw new IllegalArgumentException("Invalid input: Factor cannot be negative.");
        } else {
            int totalCents = (int) ((this.dollars * 100d + this.cents) * factor);
            this.dollars = totalCents / 100;
            this.cents = totalCents % 100;
        }
    }

    public void divide(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Invalid input: Factor cannot be negative.");
        } else {
            int totalCents = (int) ((this.dollars * 100d + this.cents) / factor);
            this.dollars = totalCents / 100;
            this.cents = totalCents % 100;
        }
    }

    public double loanCalculator(double money, double rate, int month) {
        // Monthly Payment = P * ((r * Math.pow(1+r, n)) / (Math.pow(1+r, n) - 1))
        rate /= 100;
        rate /= 12;
        return money * ((rate * Math.pow(1 + rate, month)) / (Math.pow(1 + rate, month) - 1));
    }

    protected boolean isValid(int dollars, int cents){
        return dollars >= 0 && cents >= 0;
    }

    @Override
    public String toString() {
        return "Money{" +
                "$" + dollars +
                "." + cents +
                '}';
    }
}
