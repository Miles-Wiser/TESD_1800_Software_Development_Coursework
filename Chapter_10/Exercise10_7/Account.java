import java.util.Date;
class Account {
    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    Date dateCreated = new Date();

    // Instances
    Account() {
    }

    Account(int newId, double newBalance) {
        id = newId;
        balance = newBalance;
    }

    // id accessor and mutator
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // balance accessor and mutator
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double changeBalance) {
        balance = changeBalance;
    }

    // annualInterestRate accessor and mutator
    public static double getAnnualInterstRate() {
        return annualInterestRate;
    }
    
    public static void setAnnualInterstRate(double newRate) {
        annualInterestRate = newRate / 100;
    }

    // dateCreated accessor
    public Date getDateCreated() {
        return dateCreated;
    }

    double getMonthlyInterstRate() {
        return annualInterestRate / 12;
    }

    double getMonthlyInterst() {
        return balance * getAnnualInterstRate();
    }

    double withdraw(double amount) {
        balance -= amount;

        return balance;
    }

    double deposit(double amount) {
        balance += amount;

        return balance;
    }
}