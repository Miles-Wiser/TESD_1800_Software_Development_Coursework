import java.util.Date;

class Account {
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated = new Date();

    /// Instances
    Account() {
    }

    Account(int id, double balance) {
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

    double getMonthlyInterstRate() {
        return annualInterestRate / 12;
    }

    double getMonthlyInterst() {
        return balance * getAnnualInterstRate();
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    void deposit(double amount) {
        balance += amount;
    }
}
