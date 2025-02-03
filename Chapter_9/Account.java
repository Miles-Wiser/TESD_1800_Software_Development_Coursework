import java.util.Date;

class Account {
    private int id = 0;
    protected double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated = new Date();

    /// Instances
    public Account() {
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    /// ID methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /// balance methods
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /// annualInterestRate methods
    public static double getAnnualInterstRate() {
        return annualInterestRate;
    }
    
    public static void setAnnualInterstRate(double newRate) {
        annualInterestRate = newRate / 100;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterstRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterst() {
        return balance * getAnnualInterstRate();
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public String toString() {
        return "Account ID " + getId() + " Creation " + getDateCreated() + " Balance: " + getBalance();
    }
}
