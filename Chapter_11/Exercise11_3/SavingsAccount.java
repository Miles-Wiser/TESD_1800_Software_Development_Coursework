public class SavingsAccount extends Account {
    SavingsAccount() {
        super();
    }

    SavingsAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        // I don't know how but this works.
        if (this.getBalance() - amount < 0)
            System.out.println("Exceeds savings limit.");
        else
            this.setBalance(this.getBalance() - amount);
    }

    @Override
    public String toString() {
        return "Savings " + super.toString();
    }

}
