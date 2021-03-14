import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Accounts acc = null;
        Bank bank = null;

        try {
            bank = new Bank();
//            System.out.println(Bank.getInternalFund());
        }

        catch (Exception e){
            e.printStackTrace();
        }

        while (true) {

            Scanner input = new Scanner(System.in);
            String inSt = input.nextLine();
            String[] commands = inSt.split(" ");
//            System.out.println(inSt);
//        System.out.println(commands[0]);
            if (commands[0].toUpperCase().equals("CREATE")) {
                acc = bank.createAcc(commands[1], commands[2], Double.parseDouble(commands[3]));

                bank.currentCursorAt = "ACC";
//                for (Accounts accounts: bank.getAccs()){
//                    System.out.println(accounts.getName()+ " -> " + accounts.getType());
//                }
//            System.out.println(commands[1]);
            }

//            try {
//                System.out.println(acc.getName());
//                System.out.println(acc.getAccAge());
//                System.out.println(acc.getBalance());
//            } catch (Exception we) {
//                we.printStackTrace();
//            }
            if (commands[0].toUpperCase().equals("DEPOSIT")) {
//                acc = bank.createAcc(commands[1], commands[2], Double.parseDouble(commands[3]));
                acc.deposit(Double.parseDouble(commands[1]));
//            System.out.println(commands[1]);
            }
            if (commands[0].toUpperCase().equals("WITHDRAW")) {
                acc.withdraw(Double.parseDouble(commands[1]));
//            System.out.println(commands[1]);
            }
            if (commands[0].toUpperCase().equals("QUERY")){
                acc.query();
            }

            if(commands[0].toUpperCase().equals("REQUEST")){

                acc.requestLoan(Double.parseDouble(commands[1]),bank);

//                bank.md.seeLoans();

            }

            if(commands[0].toUpperCase().equals("CLOSE")){
                if (bank.currentCursorAt.equals("ACC")) {
                    if (acc != null)
                        acc.close();
                }

                else if (bank.currentCursorAt.equals("O1")) {
//                    bank.o1.setVisibility(false);
                    bank.o1.close();
                }
                else if (bank.currentCursorAt.equals("O2")) {
//                    bank.o2.setVisibility(false);
                    bank.o2.close();
                }
                else if (bank.currentCursorAt.equals("C1")) {
//                    bank.o2.setVisibility(false);
                    bank.c1.close();
                }
                else if (bank.currentCursorAt.equals("C2")) {
//                    bank.o2.setVisibility(false);
                    bank.c2.close();
                }else if (bank.currentCursorAt.equals("C3")) {
//                    bank.o2.setVisibility(false);
                    bank.c3.close();
                }else if (bank.currentCursorAt.equals("C4")) {
//                    bank.o2.setVisibility(false);
                    bank.c4.close();
                }else if (bank.currentCursorAt.equals("C5")) {
//                    bank.o2.setVisibility(false);
                    bank.c5.close();
                }

                else if (bank.currentCursorAt.toUpperCase().equals("MD")) {
//                    System.out.println("md is closed");
//                    bank.md.setVisibility(false);
                    bank.md.close();
                }
            }


            if (commands[0].toUpperCase().equals("OPEN")){
                String nextCommand = commands[1];
                if (nextCommand.toUpperCase().equals("O1")) {
                    bank.currentCursorAt = "O1";
//                    bank.o1.setVisibility(true);
                    bank.o1.open();
                    bank.o2.setVisibility(false);
                    bank.md.setVisibility(false);


                    if (acc!=null)
                        acc.setVisibility(false);
//                    System.out.println(bank.o1.getName());
                }

                else if(nextCommand.toUpperCase().equals("O2")){
                    bank.currentCursorAt = "O2";
                    bank.o2.open();
                    bank.md.setVisibility(false);
                    bank.o1.setVisibility(false);
                    acc.setVisibility(false);

                }
                else if (
                        nextCommand.toUpperCase().equals("MD")){
                    bank.md.open();
                    bank.currentCursorAt = "MD";



                }
                else if (nextCommand.toUpperCase().equals("C1")) {
                    bank.c1.open();
                    bank.currentCursorAt = "C1";
                }
                else if (nextCommand.toUpperCase().equals("C2")) {
                    bank.c2.open();
                    bank.currentCursorAt = "C2";
                }else if (nextCommand.toUpperCase().equals("C3")) {
                    bank.c3.open();
                    bank.currentCursorAt = "C3";
                }else if (nextCommand.toUpperCase().equals("C4")) {
                    bank.currentCursorAt = "C4";
                    bank.c4.open();
                }else if (nextCommand.toUpperCase().equals("C5")) {
                    bank.currentCursorAt = "C5";
                    bank.c5.open();
                }
                else
                {

                    acc = bank.getAccByname(nextCommand);
                    if (acc==null)
                    {
                        System.out.println("not found!");
                    }
                    else {
//                        acc.setVisibility(true);
                        acc.open();
                        bank.md.setVisibility(false);
                        bank.o1.setVisibility(false);
                        bank.o2.setVisibility(false);
                    }

                    bank.currentCursorAt = "ACC";
                }
            }
            if (commands[0].toUpperCase().equals("APPROVE")){

//                for(Accounts accounts: bank.getAccs()){
//                    accounts.setVisibility(true);
//
//                    System.out.println(acc.getName());
//
//                }
//                System.out.println(bank.getAccs().size());

                /**
                 * calling for approval of MD.
                 */
                if (bank.currentCursorAt.equals("MD"))
                    bank.md.approveLoan(bank);

                else if (bank.currentCursorAt.equals("O1") ){
                    System.out.println("o1 role");
                    bank.o1.approveLoan(bank);
                }
                else if ( bank.currentCursorAt.equals("O2")){
                    System.out.println("o2 role");

                    bank.o2.approveLoan(bank);
                }
            }
            if (commands[0].toUpperCase().equals("CHANGE")){
                String type = commands[1].toUpperCase();
                Double interasteRate = Double.parseDouble(commands[2].toUpperCase());
                bank.md.changeInterestRate(type,interasteRate,bank);

            }
            if (commands[0].toUpperCase().equals("LOOKUP")){
                String name = commands[1].toUpperCase();
                if (bank.currentCursorAt.equals("ACC"))
                    System.out.println("You are not permitted");
                else if (bank.currentCursorAt.equals("O1")) {
                    bank.o1.lookUp(name, bank);
                }
                else if (bank.currentCursorAt.equals("O2"))
                    bank.o2.lookUp(name,bank);
                else if (bank.currentCursorAt.equals("MD"))
                    bank.md.lookUp(name,bank);
                else {
                    bank.c1.setVisibility(true);
                    bank.c1.lookUp(name, bank);
                    bank.c1.setVisibility(false);
                }
            }
            if (commands[0].toUpperCase().equals("SEE")){
//                String name = commands[1].toUpperCase();
                bank.md.seeInternalFund();

            }
            if (commands[0].toUpperCase().equals("INC")){
//
                bank.incrementAge();
            }


        }



//        System.out.println(acc.getType());
//            bank.createAcc(commands[1],commands[2],Double.parseDouble(commands[3]));


    }

}
