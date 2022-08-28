public class TransportationPersonnel extends User{

    private int trasportPersonelNum;


    public TransportationPersonnel(int branchNum, String userName, int trasportPersonelNum) {
        super(branchNum, userName);
        this.trasportPersonelNum = trasportPersonelNum;
    }

    public int getTrasportPersonelNum() {
        return trasportPersonelNum;
    }

    @Override
    public String toString() {
        return "--> "+
                " BranchNum=" + super.getBranchNum() +
                ", Transport Personnel Name='" + super.getUserName() + '\'' +
                ", Transport Personnel Number ='" + trasportPersonelNum + '\'';
    }
}
