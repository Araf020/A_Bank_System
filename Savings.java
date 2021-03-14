public class Savings extends Accounts {

    private Double initialDeposit;

    private Double balance;

    public static     Double maxLoan;
    private  Double minBalance;
    private Double maxWithdrawal;

    private Double mindeposit;

    public Double getInitialDeposit() {
        return initialDeposit;
    }
    protected  boolean isWithdrawable(Double amount){
        return this.balance - amount > minBalance;
    }

    public void setInitialDeposit(Double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    Savings(String name, Double initialDeposit){


        super(name.toUpperCase(),"SAVINGS",initialDeposit);
        maxLoan = 100000.0;
        this.maturityAge = 1;
        this.minBalance = 1000.0;
        this.initialDeposit = 100000.0;
        this.mindeposit = 50000.0;
        super.setMaxLoan(maxLoan);
        super.setBalance(initialDeposit);
        System.out.println("Savings Account for " + name +" created" + ". Initial Balance "+ initialDeposit+ super.Currency);



    }

    public Double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(Double minBalance) {
        this.minBalance = minBalance;
    }

    public Integer getMaturityAge() {
        return maturityAge;
    }

    public void setMaturityAge(Integer maturityAge) {
        this.maturityAge = maturityAge;
    }

    private Integer maturityAge;



    public  Double getMaxLoan() {
        return maxLoan;
    }

    public void setMaxLoan(Double maxLoan) {
        this.maxLoan = maxLoan;
    }
//
//    public Double getBalance() {
//        return balance;
//    }




    @Override
    public void withdraw(Double amount) {
        if(isWithdrawable(amount)){
                this.balance = this.balance - amount;
        }
        else {
            System.out.println("Sorry! Account balance is low. Current Balance: " + this.getBalance() );
        }

    }


    /**
     * to set minimum Withdrawal amount

     */



    public boolean isMinWithdrawalage() {

        return this.getAccAge() >=1;

    }

    public void setBalance(Double balance) {

        this.balance = this.balance + balance;
        super.setBalance(this.balance);
    }

}
