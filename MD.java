import java.util.ArrayList;

public class MD extends  Employees {

    private   Integer loanCount;
    public boolean loanRequests;
    public boolean isClosed;
    private  boolean isopen;
    protected static ArrayList<Loan> Loans;

        MD(){
                name = "A";
                role = "x";
                isClosed = true;
                loanCount = 0;
                isopen = false;
        }
    MD(String name){
        super(name,"MD");
        this.loanCount = 0;
        this.isClosed = true;
        Loans = new ArrayList<>();
        isopen = false;
    }


    public void setLoanCount(Integer loanCount) {
        this.loanCount = loanCount;
    }


    /**
     *
     * incomplete
     */
//    private Double seeInternalFund() {
//        return Bank.getInternalFund();
//    }



    protected void approveLoan(Bank bank) {

        /**
         * deny any other employee than MD and Officer
         */


//        System.out.println("approve called from here");
//        System.out.println(this.Loans.size());
        if (!getVisibility()){
            System.out.println("You are not allowed");
            return;
        }

        for (int i =0;i< this.Loans.size();i++ ) {
//            System.out.println(this.getLoans().get(i).getUsername()+" :"+" loan details..");
            String type = super.AccountTypebyName(this.Loans.get(i).getUsername().toUpperCase(),bank);

            /**
             * checking if there are any loan
             */
            if (Bank.loanCount == 0) {
                System.out.println("NO Loan Request");
                return ;
            }
//            else {
////                System.out.println("There's " + this.getLoans().size() + " loan requests for you approval.");
//            }

            if (!this.getVisibility()) {
                System.out.println("Not allowed");
                return;
            }


            if (type.equals("STUDENT")) {
                if (this.getLoans().get(i).getRequestedloanAmount() < Student.maxLoan) {
//                    this.setLoanStatusbyName(loans.getUsername(),bank);
                    String accName = this.getLoans().get(i).getUsername();
                    bank.setLoanStatus(accName.toUpperCase());
//                    this.removeLoan(accName.toUpperCase());
//                    return true;
                }

            }

            else if (type.equals("FIXED")) {
                if (this.getLoans().get(i).getRequestedloanAmount() < FixedDeposit.maxLoan) {
//                    this.setLoanStatusbyName(loans.getUsername(),bank);

                     bank.setLoanStatus(this.getLoans().get(i).getUsername());
                }
            }else if (type.equals("SAVINGS")) {
                if (this.getLoans().get(i).getRequestedloanAmount() < Savings.maxLoan) {
//                    this.setLoanStatusbyName(loans.getUsername(),bank);
                     bank.setLoanStatus(this.getLoans().get(i).getUsername());
                }

            }
            else {
                System.out.println("Invalid type account or request!");
            }
        }

        this.resetLoans();


    }


    @Override
    protected void changeInterestRate(String  accTYpe,Double rate,Bank bank){
        if (!this.getVisibility()){
            System.out.println("You are not allowed");
            return;
        }

        bank.setInterestRatebyType(accTYpe,rate);
    }




    @Override
    protected void setVisibility(boolean c) {

        this.isopen = c;
        super.setVisibility(c);
    }




    @Override
    public boolean addLoans(Loan loan){
        try {
            Loans.add(loan);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public   void  seeLoans(){
        for (Loan l : Loans){
            System.out.print("Loan request from: ");
            System.out.println(l.getUsername());
        }
    }

    private void resetLoans() {

        this.Loans = new ArrayList<Loan>();
    }

    @Override
    public ArrayList<Loan> getLoans() {
        return this.Loans;
    }

//    private void removeLoan(String accName){
//        for (int i =0;i<this.Loans.size();i++){
//            if (this.Loans.get(i).getUsername().toUpperCase().equals(accName.toUpperCase())){
//                this.Loans.remove(i);
//                System.out.println("Loan Removed");
//            }
//        }
//    }


    protected  boolean getLoanStatusbyName(String name,Bank bank){
        /**
         *
         * iterate through all accounts.
         */
        for (Accounts acc: bank.getAccs()
        ) {
            if (acc.getName().equals(name.toUpperCase())){
                return acc.loan.getLoanStatus();
            }

        }
        return false;
    }

    protected  void setLoanStatusbyName(String name,Bank bank){
        /**
         *
         * iterate through all accounts.
         */
        for (Accounts acc:bank.getAccs()
        ) {
            if (acc.getName().equals(name.toUpperCase())){
                acc.loan.setApproved(true);
                System.out.println("Loan for" + acc.getName() + "  approved");
                return;
            }

        }
        System.out.println("couldn't approve");

    }

    @Override
    protected void seeInternalFund() {
        if (!this.getVisibility()){
            System.out.println("You don’t have permission for this operation");;
            return;

        }
       System.out.println("Current Internal Fund is "+Bank.getInternalFund());
    }
    @Override
    public  void  close(){
        System.out.println(getName()+" is closed");
        super.setVisibility(false);
    }

    @Override
    public   void  open(){
        this.setVisibility(true);
        super.setVisibility(true);
        if (this.getVisibility()){
            System.out.println(this.getName()+" active, there are "  + this.Loans.size() +" loan approvals pending");
        }
    }
}
