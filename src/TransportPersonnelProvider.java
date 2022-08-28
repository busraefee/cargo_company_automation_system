import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TransportPersonnelProvider {
    private Map<String, TransportationPersonnel> transportPersonnelMap = new ConcurrentHashMap<>();
    private final Scanner scannerString = new Scanner(System.in);
    private final Scanner scanner = new Scanner(System.in);
    public Map<String, TransportationPersonnel> getTransportPersonnelMap() {
        return transportPersonnelMap;
    }


    public void addTransportPersonnel(BranchProvider branchProvider){
        if (branchProvider.hasAnyBranch()){
            branchProvider.listBranches();

            System.out.print("Please select branch: ");
            String selectedBranchName = scannerString.nextLine();

            if (!branchProvider.getBranchMap().containsKey(selectedBranchName)) {
                System.out.println("Branch does not exist try another");
            }  else {
                System.out.println("Selected branch: " + branchProvider.getBranch(selectedBranchName));
                int selectedBranchNumber = branchProvider.getBranch(selectedBranchName).getBranchNum();
                System.out.println("Branch selected successfully");

                System.out.print("Transport personnel name: ");
                String transportPersonName = scannerString.nextLine();
                System.out.print("Transport personnel number: ");
                int transportPersonNumber = scanner.nextInt();
                TransportationPersonnel transportationPersonnel = new TransportationPersonnel(selectedBranchNumber,
                        transportPersonName, transportPersonNumber);
                transportPersonnelMap.put(transportPersonName, transportationPersonnel);
                System.out.println("Transport personnel added.");
                System.out.println(transportationPersonnel);
            }
        }else {
            System.out.println("Please firstly enter branch");
        }
    }


    public void removeTransportPersonnel() {
        if (hasAnyTransportPersonnel()){
            System.out.println("Please select transport employee: ");
            String selectedTransportPer = scannerString.nextLine();
            TransportationPersonnel removeTransportPer = transportPersonnelMap.remove(selectedTransportPer);
            if (removeTransportPer == null) {
                System.out.println("Transport Personnel does not exist try another");
            } else {
                System.out.println(removeTransportPer.getUserName() + " Transport Personnel removed successfully");
            }
        }else {
            System.out.println("Please add Transport Personnel!!");
        }
    }


    /**
     * personel listesini ekrana bastırır.
     */
    public void listTransportPersonnel(){
        if (hasAnyTransportPersonnel()){
            System.out.println("Transportation Personnel List");
            Set set = transportPersonnelMap.keySet();

            for (Object o : set) {
                TransportationPersonnel value = transportPersonnelMap.get(o);
                System.out.println(value.toString());
            }

        }else {
            System.out.println("Please add Transport Personnel!!");
        }

    }

    /**
     * transport personnel varsa true, yoksa false döner
     * @return
     */
    private boolean hasAnyTransportPersonnel() {
        return !transportPersonnelMap.isEmpty();
    }
}
