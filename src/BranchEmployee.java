
public class BranchEmployee extends User {
    private int personalNum;

    public BranchEmployee(int branchNum, String userName, int personalNum) {
        super(branchNum, userName);
        this.personalNum = personalNum;
    }

    public int getPersonalNum() {
        return personalNum;
    }

    public void setPersonalNum(int personalNum) {
        this.personalNum = personalNum;
    }

    @Override
    public String toString() {
        return "--> "+
                " Branch Num=" + super.getBranchNum() +
                ", Branch Employee Name='" + super.getUserName() + '\'' +
                ", Branch Employee Number='" + personalNum + '\'';
    }
}
