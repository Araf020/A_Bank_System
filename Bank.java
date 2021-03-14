import java.util.ArrayList;
import java.util.Scanner;

public class Bank{

    protected static Integer loanCount;
    private static Double internalFund;
    protected    ArrayList<Accounts> accs;
    protected  ArrayList<Employees> employees;
    private Integer Age;
    public String currentCursorAt;

    protected  Employees md;
    public  Employees o1;
    public Employees o2;
    public  Employees c1;
    public Employees c2;
    public  Employees c3;
    public Employees c4;
    public Employees c5;

    Bank(){

        md = new MD("md");

        /**
         * two Officer
         *
         */
        o1 = new Officer("o1");
        o2 = new Officer("o2");

        c1 = new Cashier("C1");
        c2 = new Cashier("C2");
        c3 = new Cashier("C3");
        c4 = new Cashier("C4");
        c5 = new Cashier("C5");
        /**
         * five cashier
         */

        internalFund = 10000000.0;
        loanCount = 0;
        accs = new ArrayList<>();
        employees = new ArrayList<>();
        this.currentCursorAt = "BANK";
        this.Age =0;
        System.out.println("Bank Created; MD, O1, O2, C1, C2, C3, C4, C5 created");

    }



    private Employees openAcctoSee(String role){
        /**
         * implement it to open S1 type command
         */
        return null;
    }




    /**
     *
     * create Employee
     */



    /**
     *
     * create Employee
     */

    protected  Accounts getAccByname(String name){
        Accounts ac = null;
//        acc.setVisibility(true);
        for (int i=0;i< this.accs.size();i++){
            this.accs.get(i).setVisibility(true);
//            System.out.println("i m looking at: "+ this.accs.get(i).getName());
            if (this.accs.get(i).getName().toUpperCase().equals(name.toUpperCase())){

//                System.out.println(this.accs.get(i).getName());
                return this.accs.get(i);
//                System.out.println(this.accs.get(i).getName());

            }



        }
        return null;
    }

    protected Employees createEmployee(String role, String name) {

//        role = role.toUpperCase();

        Employees newEmployee = null;

        if (role.equals("MD"))
            newEmployee = new MD(name);

        else if (role.equals("OFFICER"))
            newEmployee = new Officer(name);

        else
            newEmployee = new Cashier(name);

        employees.add(newEmployee);

        return newEmployee;

    }


    public   ArrayList<Accounts> getAccs() {
        return accs;
    }


    protected Accounts createAcc(String name, String type, Double intialDeposit){
//        System.out.println("number of acc1: "+ accs.size());
        type = type.toUpperCase();
        Accounts acc = null;

        /**
         * check if an account with this name already exists
         *
         */
        if (this.accs.size()!=0){
            if (this.getAccByname(name)!=null){
                System.out.println("An account with this name already exist!");
                return null;
            }
        }

        if (type.equals("STUDENT"))
           acc = new Student(name,intialDeposit);

        else if (type.equals("SAVINGS"))
            acc = new Savings(name,intialDeposit);

        else {
            if (intialDeposit>=FixedDeposit.minDepo)
                acc = new FixedDeposit(name, intialDeposit);
            else
            {
                System.out.println("Insufficient amount for initial deposition");
                return null;
            }
        }

//        Bank.accounts.add(acc);
        this.accs.add(acc);
//        index++;
//        System.out.println("acc created!");
//        System.out.println("number of acc: "+ Bank.accounts.size());
//        System.out.println("number of acc: "+ this.accs.size());

        return acc;
    }

    protected static Double  getInternalFund(){
        return internalFund;
    }


    protected  void IncreaseLoanCount(){
        this.loanCount +=1;
    }


    protected static void applyInterestRate(String acctype,Double rate){

    }

    public void setInternalFund(Double internalFund) {
        this.internalFund = internalFund;
    }

    protected Double seeInternalFund(){

       return  null;
    }



    public ArrayList<Employees> getEmployees() {
        return employees;
    }

    public boolean setLoanStatus(String name){
        try {
            for (int i =0;i<this.accs.size();i++){
                if (this.accs.get(i).getName().toUpperCase().equals(name.toUpperCase())){
                    if (!this.accs.get(i).getLoan().isApproved()) { /** check if approved before*/
                        this.accs.get(i).getLoan().setApproved(true);

                        this.accs.get(i).getLoan().setLoanStatusFalse();
//                        this.removeLoan(name);
                        System.out.println("Loan approved for " + this.accs.get(i).getName() + ".");
//                        System.out.println("loan status for " + this.accs.get(i).getName() + " is " + accs.get(i).getLoan().isApproved());
                        return true;
                    }

                }
            }
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    protected void setInterestRatebyType(String accType,Double rate){

        for (int i=0;i<this.accs.size();i++){
            if (accs.get(i).getType().toUpperCase().equals(accType.toUpperCase()));
            {
                System.out.println("previous rate: "+accs.get(i).getInterestRate().getRate() );
                this.accs.get(i).setInterestRate(rate);
                System.out.println("after rate: "+accs.get(i).getInterestRate().getRate() );

            }
        }


    }
    protected  void incrementAge(){
        this.Age ++;
        /** update those account who toke loan*/

        for (int i =0;i<accs.size();i++){

            this.accs.get(i).setAccAge(this.Age); //increment by 1

            Double balance = this.accs.get(i).getBalance();
//            System.out.println(balance);
            Double loanamount = this.accs.get(i).getLoan().getLoantaken();
            Double irate = this.accs.get(i).getInterestRate().getRate();
//            System.out.println("loan: " +loanamount);

/**          set new balance*/
            balance = balance - loanamount* irate;
            System.out.println(
                    balance
            );
            this.accs.get(i).setBalance(balance);
        }
    }

    public Integer getAge() {
        return this.Age;
    }

    public void setAge(Integer age) {
        this.Age = age;
    }

}
