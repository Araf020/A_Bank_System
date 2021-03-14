public class Officer extends MD{



    Officer(){
        name = "A";

    }
    Officer(String name){
        super(name);
//        this.isClosed = false;
//        System.out.println("officer created");

    }
    @Override
    protected void seeInternalFund() {
        if (!this.getVisibility()){
            System.out.println("You don’t have permission for this operation");
            return;

        }
        System.out.println("You don’t have permission for this operation");


    }

    @Override
    public void open() {
        super.open();
    }
//


    @Override
    protected void changeInterestRate(String accType, Double rate, Bank bank){
        System.out.println("You are not allowed");
    }



}
