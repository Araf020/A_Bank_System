public class FixedDeposit extends Accounts {

    private Double initialDeposit;

    private Double balance;

    public  static Double maxLoan;
    private Double minWithdrawal;
    private Double mindeposit;
    public static Double minDepo = 100000.0;

    public Double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(Double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    FixedDeposit(String name, Double initialDeposit){

        super(name,"FIXED",initialDeposit);
        maxLoan = 100000.0;
        this.maturityAge = 1;
        this.minWithdrawal = 0.0;
        this.initialDeposit = 100000.0;
        this.mindeposit = 50000.0;
        super.setMaxLoan(maxLoan);
        super.setBalance(initialDeposit);
        System.out.println("Fixed Account for " + name +" created" + ". Initial Balance "+ initialDeposit+ super.Currency);

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

//    public Double getBalance() {
//        return balance;
//    }
//
    public void setBalance(Double balance) {

        this.balance = this.balance + balance;
        super.setBalance(this.balance);
    }





    @Override
    public void deposit(Double amount) {
        if (amount< this.mindeposit ){
            System.out.println("Amount is too small to deposit");
            return;
        }

        setBalance(amount);
        //super.deposit(amount);
    }



    @Override
    public void withdraw(Double amount) {
        if(super.getAccAge()>this.maturityAge){

            if((this.balance - amount) >0.0 ){
                this.balance = this.balance - amount;
            }

        }
        else {
            System.out.println("Sorry! immature Acc. " );
        }

    }









    /**
     * to set minimum Withdrawal amount

     */



    public boolean isMinWithdrawalage() {

        return this.getAccAge() >=1;

    }



}
