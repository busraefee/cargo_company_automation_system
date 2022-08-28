import java.util.*;

public class CustomerProvider {

    private Map<Integer, Customer> customerMap = new HashMap<>();
    private Scanner scannerString = new Scanner(System.in);
    private Scanner scanner = new Scanner(System.in);

    /**
     * kargo takip numarasına göre müşteri ekler.
     * @param cargoProvider
     */
    public void addCustomer(CargoProvider cargoProvider) {
        if(cargoProvider.hasAnyCargo()){
            cargoProvider.listCargo();
            System.out.print("Customer Name: ");
            String customerName = scannerString.nextLine();
            System.out.print("Customer Number: ");
            int customerNum = scanner.nextInt();
            System.out.print("Cargo Tracking Number: ");
            int trackingNum = scanner.nextInt();

            Cargo cargo = cargoProvider.getCargoMap().get(trackingNum);

            Customer customer = new Customer(cargo.getCargoTrackingNumber(), cargo.getSender(), cargo.getReceiver(),
                    cargo.getCargoStatus(), customerName, customerNum);
            customerMap.put(customer.getCargoTrackingNumber(), customer);
            System.out.println("Customer added..");
        }else {
            System.out.println("Please firstly enter cargo!!");
        }

    }

    public void removeCustomer() {
        if (!customerMap.isEmpty()){
            System.out.print("Please select customer number you want to: ");
            int removeCustomer = scanner.nextInt();
            customerMap.remove(removeCustomer);
        }else {
            System.out.println("Please firstly add customer!!");
        }
    }

    public void loginCustomer() {
        System.out.print("please enter tracking number: ");
        Integer trackNum = scanner.nextInt();
        if (customerMap.containsKey(trackNum)){
            System.out.println("Login successfully");
        Customer customerTrackNum = customerMap.get(trackNum);
            System.out.println(customerTrackNum.toString());
        } else if (customerMap.isEmpty()) {
            System.out.println("customer not found");
        } else{
            System.out.println("Login failed");
        }
    }
}
