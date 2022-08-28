public class Branch {
    private int branchNum;
    private String name;

    public Branch(int branchNum, String name) {
        this.branchNum = branchNum;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(int branchNum) {
        this.branchNum = branchNum;
    }

    @Override
    public String toString() {
        return "--> " +
                "branchNum=" + branchNum +
                ", name=" + name;
    }
}
