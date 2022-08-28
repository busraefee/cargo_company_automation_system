import java.util.*;

public class CargoProvider {
    private Map<Integer,Cargo> cargoMap = new HashMap<>();
    private Scanner scannerString = new Scanner(System.in);
    private Scanner scanner = new Scanner(System.in);

    public Map<Integer, Cargo> getCargoMap() {
        return cargoMap;
    }


    public void addCargo(BranchProvider branchProvider) {
        if (branchProvider.hasAnyBranch()){
            branchProvider.listBranches();
            System.out.print("Please select branch: ");
            String branchName = scannerString.nextLine();
            String selectedBranchName = String.valueOf(branchProvider.getBranch(branchName));
            System.out.println("Selected branch: " + selectedBranchName);
            if (branchName == null) {
                System.out.println("Branch does not exist try another");
            } else {
                System.out.println("Branch selected successfully");

                System.out.print("Cargo Name: ");
                String cargoName = scannerString.nextLine();
                System.out.print("Cargo Tracking Number: ");
                int cargoTrackingNum = scanner.nextInt();
                System.out.print("Cargo Status: ");
                String cargoStatus = scannerString.nextLine();
                System.out.print("Cargo Sender: ");
                String cargoSender = scannerString.nextLine();
                System.out.print("Cargo Receiver: ");
                String cargoReceiver = scannerString.nextLine();
                Cargo cargo = new Cargo(cargoTrackingNum, cargoSender, cargoReceiver, cargoName, cargoStatus, branchName);
                cargoMap.put(cargoTrackingNum,cargo);
                System.out.println("Cargo added..");
                System.out.println(cargo.toString());
            }
        }else {
            System.out.println("Please firstly enter branch");
        }
    }

    /**
     * cargomap boş mu dolu mu kontrol edilir.
     * @return cargo yoksa false döner.
     */
    public boolean hasAnyCargo() {
       return !cargoMap.isEmpty();
    }

    /**
     * mevcut kargolar listelenir.
     */
    public void listCargo() {
        if (hasAnyCargo()){
            System.out.println("Cargo List: ");
            Set set = cargoMap.keySet();

            for (Object o : set) {
                Cargo value = cargoMap.get(o);
                System.out.println(value.toString());
            }
        }else {
            System.out.println("Please firstly add cargo");
        }
    }


    /**
     * kargo durumunu tutan cargoStatus değişkeni güncellenir.
     */
    public void changeCargoStatus(){
        if (hasAnyCargo()){
            System.out.print("Please enter the tracking number you want to change: ");
            int changeCargoId = scanner.nextInt();
            System.out.print("Please enter the new status of your cargo: ");
            String newCargoStatus = scannerString.nextLine();
            Cargo cargo = cargoMap.get(changeCargoId);
            cargo.setCargoStatus(newCargoStatus);
        } else {
            System.out.println("Please firstly enter cargo!!");
        }


    }


}
