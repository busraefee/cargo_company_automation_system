public class CargoInfo {
    private int cargoTrackingNumber;
    private String sender;
    private String receiver;

    private String cargoStatus;

    public CargoInfo(int cargoTrackingNumber, String sender, String receiver, String cargoStatus) {
        this.cargoTrackingNumber = cargoTrackingNumber;
        this.sender = sender;
        this.receiver = receiver;
        this.cargoStatus = cargoStatus;
    }

    public int getCargoTrackingNumber() {
        return cargoTrackingNumber;
    }

    public void setCargoTrackingNumber(int cargoTrackingNumber) {
        this.cargoTrackingNumber = cargoTrackingNumber;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(String cargoStatus) {
        this.cargoStatus = cargoStatus;
    }
}
