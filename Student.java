public class Student extends Accounts {
    private String name;
    private static Double maxWithdrawal;
    protected static   Double maxLoan;



    Student(String name, Double initialDeposit ){

        super(name.toUpperCase(),"STUDENT",initialDeposit);

        maxLoan = 1000.0;
        maxWithdrawal = 1000.0;
        this.name = name.toUpperCase();
        super.setMaxLoan(Student.maxLoan);
        super.setBalance(initialDeposit);
//        isclosed = false;
        System.out.println("Student Account for " + this.name +" created" + ". Initial Balance "+ initialDeposit+ super.Currency);


    }

    @Override
    public void setAccAge(Integer accAge) {
        super.setAccAge(accAge);
    }


    public  Double getMaxLoan() {
        return maxLoan;
    }

    public void setMaxLoan(Double maxL) {
        maxLoan = maxL;
    }








    @Override
    public void withdraw(Double amount) {
        if (this.getVisibility()) {
            if (amount < getMaxWithdrawal()) {

                if ((this.getBalance() - amount) > 0.0) {
                    super.withdraw(amount);
                    System.out.println(" Transaction successful! current balance " + this.getBalance() + super.Currency);

                }

            } else {
                System.out.println("Invalid transaction; current balance " + this.getBalance() + super.Currency);

            }
        }
        else {
            System.out.println("Sorry account is not active now");
        }

    }

    @Override
    public  void requestLoan(Double loan,Bank bank){
        if (this.getVisibility()) {
            if (loan > getMaxLoan()) {
                System.out.println("Sorry! This Loan amount is not allowed for your acc. ");
            }
            else if (super.loan.getLoanStatus()){
                System.out.println("Already pending request!");
                return;
            }
            else {
                /**
                 * my code
                 */
                try {

                    Bank.loanCount++;

                    Loan loan1 = new Loan(this.name, loan);
                    loan1.setLoanStatusTrue();
                    loan1.setLoantaken(loan);

                    bank.md.addLoans(loan1);
                    super.setLoan(loan1);

                    System.out.println("Loan request successful, sent for approval");

                } catch (Exception e) {
                    System.out.println("Failed to request now! Try again later");
                    e.printStackTrace();
                }
            }
        }
        else {
            System.out.println("Sorry account is not active now");
        }

    }







    /**
     * to set minimum Withdrawal amount

     */

    private static void setMaxWithdrawal(Double minWithdraWal){
        maxWithdrawal = minWithdraWal;
    }
    public static Double getMaxWithdrawal() {
        return maxWithdrawal;
    }

    public Integer getMaturity(){

        return super.getAccAge();
    }

}
