import java.util.*;
import java.util.logging.Logger;

public class Control {
    public static final int REMOVE_BRANCH = 2;
    public static final int ADD_BRANCH = 1;
    public static final int ADD_BRANCH_EMPLOYEE = 3;
    public static final int REMOVE_BRANCH_EMPLOYEE = 4;
    public static final int ADD_TRANSPORTATION_PERSONNEL = 5;
    public static final int REMOVE_TRANSPORTATION_PERSONNEL = 6;
    public static final int LIST_BRANCH_EMPLOYEE = 7;
    public static final int BRANCH_EMPLOYEE_PANEL = 2;
    public static final int ADMIN_PANEL = 1;
    public static final int ADD_CUSTOMER = 1;
    public static final int REMOVE_CUSTOMER = 2;
    public static final int ADD_CARGO = 3;
    public static final int BRANCHEMPLOYEE_CHANGE_CARGO_STATUS = 4;
    public static final int EXIT_ADMIN = 9;
    public static final int LIST_TRANSPORTATION_PERSONNEL = 8;
    public static final int TRANSPORTATION_PERSONNEL_PANEL = 3;
    public static final int TRANSPORTPERSONNEL_CHANGE_CARGO_STATUS = 1;
    public static final int CUSTOMER_PANEL = 4;
    public static final int LIST_CARGOS = 5;
    public static final int EXIT_BRANCH_EMPLOYEE_PANEL = 6;
    public static final int EXIT_TRANSPORTPERSONNEL_PANEL = 2;
    public static final int LOGIN_CUSTOMER = 1;
    public static final int EXIT_CUSTOMER = 2;
    private BranchProvider branchProvider = new BranchProvider();
    private BranchEmployeeProvider branchEmployeeProvider = new BranchEmployeeProvider();
    private TransportPersonnelProvider transportPersonnelProvider = new TransportPersonnelProvider();
    private CargoProvider cargoProvider = new CargoProvider();
    private CustomerProvider customerProvider = new CustomerProvider();
    public static final int EXIT = 5;


    public void control_panel() {
        System.out.println("Welcome the Cargo company automation system");
        System.out.println("Please choose your input method");

        String choose = "1-) Admin\n"
                + "2-) Branch Employee\n"
                + "3-) Transportation Personnel\n"
                + "4-) Customer\n"
                + "5-) Exit";

        String adminChoose = "- Admin Panel -\n" + "1-) Add Branches\n" + "2-) Remove Branches\n"
                + "3-) Add Branches Employee\n" + "4-) Remove Branches Employee\n"
                + "5-) Add Transportation Personnel\n" + "6-) Remove Transportation Personnel\n"
                + "7-) List Branches Employee\n" + "8-) List Transportation Personnel\n" + "9-) Exit";

        String branchEmpChoose = "- Branch Employee Panel -\n" + "1-) Add Customer\n" + "2-) Remove Customer\n"
                + "3-) Add Cargo\n" + "4-) Change Cargo Status\n"
                + "5-) List Cargos\n" + "6-) Exit";


        String transportPersonChoose = "- Transportation Personnel Panel -\n" + "1-) Change Cargo Status\n" + "2-) Exit";
        String customerChoose = "- Customer Panel -\n" + "1-) Login\n" + "2-) Exit";

        boolean controlExitFlag = false;

        while (!controlExitFlag) {
            System.out.println(choose);
            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();
            while (true) {
                if (choice == EXIT) {
                    System.out.println("Exiting...");
                    controlExitFlag = true;
                    break;
                } else if (choice == ADMIN_PANEL) {
                    System.out.println("Please select operation that you want");
                    System.out.println(adminChoose);
                    int adminChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (adminChoice == EXIT_ADMIN) {
                        System.out.println("Admin Exiting...");
                        break;
                    } else if (adminChoice != 9) {
                        switch (adminChoice) {
                            case ADD_BRANCH:
                                branchProvider.addBranch();
                                continue;
                            case REMOVE_BRANCH:
                                branchProvider.removeBranch(branchEmployeeProvider, transportPersonnelProvider);
                                continue;
                            case ADD_BRANCH_EMPLOYEE:
                                branchEmployeeProvider.addBranchEmployee(branchProvider);
                                continue;
                            case REMOVE_BRANCH_EMPLOYEE:
                                branchEmployeeProvider.removeBranchEmployee();
                                continue;
                            case ADD_TRANSPORTATION_PERSONNEL:
                                transportPersonnelProvider.addTransportPersonnel(branchProvider);
                                continue;
                            case REMOVE_TRANSPORTATION_PERSONNEL:
                                transportPersonnelProvider.removeTransportPersonnel();
                                continue;
                            case LIST_BRANCH_EMPLOYEE:
                                branchEmployeeProvider.listBranchEmployee();
                                continue;
                            case LIST_TRANSPORTATION_PERSONNEL:
                                transportPersonnelProvider.listTransportPersonnel();
                                continue;
                        }
                        break;
                    }
                } else if (choice == BRANCH_EMPLOYEE_PANEL) {
                        System.out.println("Please select operation that you want");
                        System.out.println(branchEmpChoose);
                        int branchEmployeeChoose = scanner.nextInt();

                        if (choice == EXIT_BRANCH_EMPLOYEE_PANEL){
                            System.out.println("Branch Employee Exiting...");
                            break;
                        }else {
                            switch (branchEmployeeChoose) {
                                case ADD_CUSTOMER:
                                    customerProvider.addCustomer(cargoProvider);
                                    continue;
                                case REMOVE_CUSTOMER:
                                    customerProvider.removeCustomer();
                                    continue;
                                case ADD_CARGO:
                                    cargoProvider.addCargo(branchProvider);
                                    continue;
                                case BRANCHEMPLOYEE_CHANGE_CARGO_STATUS:
                                    cargoProvider.changeCargoStatus();
                                    continue;
                                case LIST_CARGOS:
                                    cargoProvider.listCargo();
                                    continue;
                            }
                            break;
                        }

                } else if (choice == TRANSPORTATION_PERSONNEL_PANEL) {
                    System.out.println("Please select operation that you want");
                    System.out.println(transportPersonChoose);
                    int personnelChoose = scanner.nextInt();
                    if (personnelChoose == EXIT_TRANSPORTPERSONNEL_PANEL){
                        System.out.println("Transportation Personnel Exiting...");
                        break;
                    }else if(personnelChoose == TRANSPORTPERSONNEL_CHANGE_CARGO_STATUS){
                        cargoProvider.changeCargoStatus();
                    }


                } else if (choice == CUSTOMER_PANEL) {
                    System.out.println("Please select operation that you want");
                    System.out.println(customerChoose);
                    int customerChoice = scanner.nextInt();
                    if (customerChoice == EXIT_CUSTOMER){
                        System.out.println("Customer Exiting...");
                        break;
                    } else if (customerChoice == LOGIN_CUSTOMER) {
                        customerProvider.loginCustomer();
                        break;
                    }
                }

            }
        }
    }

}


