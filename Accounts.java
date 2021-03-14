import java.util.ArrayList;
//import java.util.HashMap;

public class Accounts {

    private String name;
    private Double balance;
    private  InterestRate interestRate; /**typewise interestRate*/
    public String Currency;
    private  String type;
    private Integer accAge;
    public  Loan loan;
    private     boolean isopen;
    public Double maxLoan ;
    protected ArrayList<Loan> Loans;


    public void setAccAge(Integer accAge) {
        this.accAge = accAge;
    }

    Accounts(){
        this.name = "g";

        this.Currency = "$";
        //convert in uppercase
        this.accAge = 0;

        this.balance = 0.0;
        interestRate = new InterestRate(this.type,0.1); /** default 10% */
        Loans = new ArrayList<>();
        loan = null;
        isopen = true;
    }

    Accounts(String name,String type, Double initialDeposit,Double maxLoan){
        this.name = name;

        this.Currency = "$";
        this.type = type.toUpperCase(); //convert in uppercase
        this.accAge =0; //equals to bank age

        this.name = name;
        this.balance = initialDeposit;
        interestRate = new InterestRate(this.type,0.1); /** default rate is 10%*/
        loan = new Loan();
        isopen = true;
        this.maxLoan = maxLoan;
    }

    public Accounts(String name,String type,  Double initialDeposit) {
        this.name = name;

        this.Currency = "$";
        this.type = type.toUpperCase(); //convert in uppercase
        this.accAge =0; //equals to bank age

        this.name = name;
        this.balance = initialDeposit;
        interestRate = new InterestRate(this.type,0.1);
        loan = new Loan();
        isopen = true;


//        System.out.println("Account created...");



    }


    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Double getBalance() {
        if (this.getVisibility())
            return balance;
        else {

            System.out.println("Sorry account is not active now");
            return null;
        }


    }








    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InterestRate getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate.setRate(interestRate);
    }

    /**
     *

     * Constructor
     */



//    public Double getInterestRate(String type) {
//        return interestRate.get(type.toUpperCase());
//    }

//    public void setInterestRate(Double interestRate, String type) {
//
//        this.interestRate.put(type.toUpperCase(),interestRate);
//    }

    public String getName() {
        if (isopen)
            return this.name;
        else return "Account is not available now";
    }

    public void setName(String name) {
        this.name = name;
    }





    /**
     * to open a account
     */
    protected void createAccount(){

    }

    protected void deposit(Double amount){

        if (isopen) {
            this.balance = this.balance + amount;
            System.out.println(amount + this.Currency + " deposited. Current Balance is " + this.balance + Currency);
        }
        else {
            System.out.println("Sorry account is not active now");
        }
    }

     protected void withdraw(Double amount) {
        if (isopen)
            this.balance -= amount;
        else {
            System.out.println("Sorry account is not active now");
        }


    }


    public Double getMaxLoan() {
        return maxLoan;
    }

    protected   void requestLoan(Double loanAmount, Bank bank){
//        loan = new Loan(this.getName().toUpperCase(),loanAmount);
        if (this.getVisibility()) {
            if (loanAmount > this.getMaxLoan()) {
                System.out.println("Sorry! This Loan amount is not allowed for your acc. ");
            }

            else if (this.loan.getLoanStatus()){
                System.out.println("Already pending request!");
                return;
            }
            else {
                /**
                 * my code
                 */
                try {

                    Bank.loanCount++;

                    Loan loan1 = new Loan(name,loanAmount);
                    loan1.setLoanStatusTrue();
                    bank.md.addLoans(loan1);
                    this.setLoan(loan1);

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

//    protected void requestLoan(Double loanAmount,Bank bank){
//
//    }


    protected void   queryDeposit(String name){

    }

    private void   applyInterestRate(){

    }

    /**
     * To verify if a acc already exists.

     * @return bool
     */

    public    boolean verifier(String name){

        /**
         * my code here
         */
        return false;
    }



    public Integer getAccAge() {
        return accAge;
    }


    protected void   setVisibility(boolean c){
        if (!c) {
//            System.out.println(this.getName() + " is closed.");
            this.isopen = c;
        }
        else
        {
//            System.out.println("Hello" + this.getName() +"! welcome Back");
            this.isopen = c;
        }
    }
    protected  void  close(){

        System.out.println(this.getName() + " is closed");
        this.setVisibility(false);
    }
    protected  void  open(){
        this.setVisibility(true);
        System.out.println("Welcome Back! " + this.getName() );
    }

    protected boolean getVisibility(){
        return isopen;
    }

    protected void INCaccAge(){
        this.accAge =  this.accAge + 1;
    }

    protected    void query(){
        if (this.isopen){
            System.out.println("Your Current Balance is " + this.balance    + this.Currency);

        }
        else {
            System.out.println("Sorry account is not active now");
        }
    }

//    public  void  SeeLoans(){
//        for (Loan l : Loans){
//            System.out.print("Loan request from: ");
//            System.out.println(l.getUsername());
//        }
//    }

    protected  void setBalance(Double money){
        this.balance = money;
    }


    public void setMaxLoan(Double maxLoan) {
        this.maxLoan = maxLoan;
    }


    /** another one for test purpose*/
    protected   void requestLoan(Double loanAmount, Bank bank,Double maxLoan){

    }


}
