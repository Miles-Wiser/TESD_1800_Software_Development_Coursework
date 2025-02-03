public class CheckingAccount extends Account {
    private static double overdraftLimit = -500.00;
    private double balance = 0;

    CheckingAccount() {
        super();
    }
    CheckingAccount(int id, double balance) {
        super(id, balance);
    }

    public static void setOverdraftLimit(double newOverdraftLimit) {
        overdraftLimit = newOverdraftLimit;
    }
    public static double getOverdraftLimit() {
        return overdraftLimit;
    }

    /// Withdraw
    @Override
    public void withdraw(double amount) {
        // Keeps the user from pulling more money than is allowed.
        if (this.balance - amount < overdraftLimit)
            System.out.println("Exceeds overdraft limit.");
        else
            this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Checking " + super.toString() + ", Overdraft Limit: " + Math.abs(overdraftLimit);
    }
}
