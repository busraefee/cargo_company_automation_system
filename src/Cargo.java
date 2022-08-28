public class Cargo extends CargoInfo{
    private String cargoName;
    private String branchName;

    public Cargo(int cargoTrackingNumber, String sender, String receiver, String cargoStatus,
                 String cargoName, String branchName) {
        super(cargoTrackingNumber, sender, receiver, cargoStatus);
        this.cargoName = cargoName;
        this.branchName = branchName;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }



    @Override
    public String toString() {
        return "Cargo -->" +
                "Cargo Name='" + cargoName + '\'' +
                ", Cargo Status='" + getCargoStatus() + '\'' +
                ", Branch Name='" + branchName + '\'' +
                ", Sender='" + getSender() + '\'' +
                ", Receiver='" + getReceiver() + '\'' +
                ", Cargo tracking number='" + getCargoTrackingNumber() + '\'';
    }

}
