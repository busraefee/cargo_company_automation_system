import java.util.*;

public class BranchProvider {

    private Map<String, Branch> branchMap = new HashMap<>();

    private final Scanner scanner = new Scanner(System.in);

    public Map<String, Branch> getBranchMap() {
        return branchMap;
    }

    public boolean removeBranch(BranchEmployeeProvider branchEmployeeProvider,
                             TransportPersonnelProvider transportPersonnelProvider){
        if (hasAnyBranch()) {
            listBranches();
            System.out.print("Please select branch: ");
            String branchName = scanner.nextLine();

            System.out.println("Removing Branch... " + branchName);
            Branch removedBranch = branchMap.remove(branchName);
            if (removedBranch == null) {
                System.out.println("Branch does not exist try another");
                return false;
            }
            System.out.println("Branch removed successfully");


            Set set = branchEmployeeProvider.getBranchEmployeeMap().keySet();

            for (Object o : set) {
                BranchEmployee value = branchEmployeeProvider.getBranchEmployeeMap().get(o);
                if (removedBranch.getBranchNum() == value.getBranchNum()) {
                    branchEmployeeProvider.getBranchEmployeeMap().remove(value.getUserName());
                }
            }

            Set set2 = transportPersonnelProvider.getTransportPersonnelMap().keySet();

            for (Object o : set2) {
                TransportationPersonnel value = transportPersonnelProvider.getTransportPersonnelMap().get(o);
                if (removedBranch.getBranchNum() == value.getBranchNum()) {
                    transportPersonnelProvider.getTransportPersonnelMap().remove(value.getUserName());
                }
            }
        } else {
            System.out.println("Please firstly enter branch");
        }
        return true;
    }

    public void listBranches(){

        System.out.println("Branch List: ");
        Set set = branchMap.keySet();

        for (Object o : set) {
            Branch value = branchMap.get(o);
            System.out.println(value.getName());
        }
    }

    public void addBranch() {

        System.out.print("Branch name: ");
        String branchName = scanner.nextLine();
        System.out.print("Branch number: ");
        int branchNumber = (scanner.nextInt());
        scanner.nextLine();
        Branch branch = new Branch(branchNumber,branchName);
        branchMap.put(branch.getName(),branch);
        System.out.println("Branch name= "+branch.getName()+" and branch number= "+ branch.getBranchNum() + " added to system.");
    }

    public boolean hasAnyBranch(){
        return !branchMap.isEmpty();
    }

    /**
     * verilen branchname'e ait branchi döner.
     * @param branchName
     * @return
     */
    public Branch getBranch(String branchName){
        return branchMap.get(branchName);
    }

    /**
     * Branchi i günceller
     * @param branch
     * @return eklediyse false güncellediyse true
     */
    public boolean updateBranch(Branch branch) {
        Branch branch1 = branchMap.put(branch.getName(), branch);
        return branch1 != null;
    }

}
