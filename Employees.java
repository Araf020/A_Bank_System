import java.util.ArrayList;

public class Employees {

    public  String name;
    public  String role;
    private boolean isOpen;
//    protected ArrayList<Loan> Loans;


    Employees(){
        name = "A";
        role = "X";
        isOpen = false;
    }

    Employees( String name, String role) {
        this.name = name;
        this.role = role;
        this.isOpen = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    protected void lookUp( String accName ,Bank bank){

        if (!getVisibility()){
            System.out.println("You are not allowed");
            return;
        }
        System.out.println(accName +"’s current balance 21,500$"+bank.getAccByname(accName.toUpperCase()).getBalance());

    }


    protected void approveLoan(Bank bank){

        System.out.println("You are not allowed");

    }

    protected  void  seeInternalFund(){
        System.out.println("You don’t have permission for this operation");
    }

    protected void changeInterestRate(String accType, Double rate, Bank bank){
            System.out.println("You are not allowed");
    }

    protected  String AccountTypebyName(String name, Bank bank){
        /**
         *
         * iterate through all accounts.
         */
        for (Accounts acc: bank.getAccs()
        ) {
            acc.setVisibility(true);
            System.out.println(acc.getName());
            System.out.println(acc.getType());
            if (acc.getName().toUpperCase().equals(name.toUpperCase())){

                return acc.getType();
            }
            acc.setVisibility(false);
        }
        return null;
    }

//    protected  boolean getLoanStatusbyName(String name){
//        /**
//         *
//         * iterate through all accounts.
//         */
//        for (Accounts acc: Bank.accounts
//             ) {
//            if (acc.getName().equals(name.toUpperCase())){
//                return acc.loan.getLoanStatus();
//            }
//
//        }
//        return false;
//    }
//
//    protected  void setLoanStatusbyName(String name){
//        /**
//         *
//         * iterate through all accounts.
//         */
//        for (Accounts acc: Bank.accounts
//        ) {
//            if (acc.getName().equals(name.toUpperCase())){
//                acc.loan.setLoanStatusTrue();
//                System.out.println("Loan for" + acc.getName() + "  approved");
//                return;
//            }
//
//        }
//        System.out.println("couldn't approve");
//
//    }

    protected void  setVisibility(boolean c){
        if (!c) {
//            System.out.println(this.getName()+ " is closed.");
            this.isOpen = c;
        }
        else
        {
//            System.out.println("Hello " + this.getName() +"! welcome Back");
            this.isOpen = c;
        }
    }
    protected  void close(){

        System.out.println("Operations for "+this.getName() + " closed");
        this.setVisibility(false);
    }
    protected  void open(){
        setVisibility(true);
        System.out.println(this.getName()+" is active now");
    }


    protected boolean getVisibility(){
        return isOpen;
    }

    public boolean addLoans(Loan loan){
        System.out.println("You aren't allowed!");
        return false;

    }
    public  void  seeLoans(){
        System.out.println("you are not allowed!");
    }

    public ArrayList<Loan> getLoans() {
        return null;
    }


}

