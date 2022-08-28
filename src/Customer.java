import java.util.ArrayList;

public class Customer extends CargoInfo{

    private String customerName;
    private int customerId;


    public Customer(int cargoTrackingNumber, String sender, String receiver, String cargoStatus,
                    String customerName, int customerId) {
        super(cargoTrackingNumber, sender, receiver, cargoStatus);
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Cargo Status='" + getCargoStatus() + '\'' +
                ", Sender='" + getSender() + '\'' +
                ", Receiver='" + getReceiver() + '\'' +
                ", Cargo tracking number='" + getCargoTrackingNumber() + '\'' +
                '}';
    }
}

