import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BranchEmployeeProvider {
    private Map<String, BranchEmployee> branchEmployeeMap = new ConcurrentHashMap<>();

    private Scanner scannerString = new Scanner(System.in);
    private Scanner scanner = new Scanner(System.in);

    public Map<String, BranchEmployee> getBranchEmployeeMap() {
        return branchEmployeeMap;
    }

    public void setBranchEmployeeMap(Map<String, BranchEmployee> branchEmployeeMap) {
        this.branchEmployeeMap = branchEmployeeMap;
    }

    public void addBranchEmployee(BranchProvider branchProvider){
        if (branchProvider.hasAnyBranch()){
            branchProvider.listBranches();

            System.out.print("Please select branch: ");
            String selectedBranchName = scannerString.nextLine();

            if (!branchProvider.getBranchMap().containsKey(selectedBranchName)) {
                System.out.println("Branch does not exist try another");
            } else {
                System.out.println("Selected branch: " + branchProvider.getBranch(selectedBranchName));
                System.out.println("Branch selected successfully");
                int selectedBranchNumber = branchProvider.getBranch(selectedBranchName).getBranchNum();
                System.out.print("Branch employee name: ");
                String name = scannerString.nextLine();
                System.out.print("Branch employee number: ");
                int branchEmployeeNum = scanner.nextInt();
                BranchEmployee branchEmployee = new BranchEmployee(selectedBranchNumber,name,branchEmployeeNum);
                branchEmployeeMap.put(name, branchEmployee);
                System.out.println("Branch Employee added.");
                System.out.println(branchEmployee);

            }
        }else {
            System.out.println("Please firstly enter branch");
        }

    }

    /**
     * branch employeeler ekrana basılır.
     */
    public void listBranchEmployee(){
        if(hasAnyBranchEmployee()){
            System.out.println("Branch Employee List");
            Set set = branchEmployeeMap.keySet();
            Iterator it = set.iterator();

            while(it.hasNext()){
                BranchEmployee value = branchEmployeeMap.get(it.next());
                System.out.println(value.toString());
            }
        }else {
            System.out.println("Please firstly add branch employee!!");
        }
    }


    public void removeBranchEmployee(){
        if (hasAnyBranchEmployee()){
            listBranchEmployee();
            System.out.print("Please select branch employee name: ");
            String selectedBranchEmpName = scannerString.nextLine();
            BranchEmployee removeBranchEmp = branchEmployeeMap.remove(selectedBranchEmpName);
            if (removeBranchEmp == null) {
                System.out.println("Branch Employee does not exist try another");
            } else {
                System.out.println(removeBranchEmp.getUserName() + " Branch Employee removed successfully");
            }

        }else {
            System.out.println("Please add branch employee");
        }

    }

    private boolean hasAnyBranchEmployee() {
        return !branchEmployeeMap.isEmpty();
    }
}






