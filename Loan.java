
public class Loan {

    private String username;
    private Double requestedloanAmount;
    private boolean loanStatus;
    private boolean isApproved;
    private Double loantaken;

    public Double getLoantaken() {
        return loantaken;
    }

    public void setLoantaken(Double loantaken) {
        this.loantaken = loantaken;
    }

    Loan(){}
    public Loan(String username, Double requestedloanAmount) {
        this.username = username;
        this.requestedloanAmount = requestedloanAmount;
        this.loanStatus = false;
        this.isApproved = false;
    }

    public void   setLoanStatusFalse(){
        this.loanStatus = false;
    }
    public boolean isApproved() {
        return isApproved;
    }


    public void setApproved(boolean approved) {
        this.isApproved = approved;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getRequestedloanAmount() {
        return requestedloanAmount;
    }

    public void setRequestedloanAmount(Double requestedloanAmount) {
        this.requestedloanAmount = requestedloanAmount;
    }

    public boolean isLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(boolean loanStatus) {
        this.loanStatus = loanStatus;
    }



    public  void  setLoanStatusTrue(){
        this.loanStatus = true;
    }
    protected boolean getLoanStatus() {return  this.loanStatus;}

//    public static void main(String[] args){
//        Bank bank = new Bank();
//        Employees md = new MD("A");
//
//        Accounts acc = new Student("A",10000.0);
//
//        System.out.println(bank.getInternalFund());
//        System.out.println(md.getName());
//    }

}
