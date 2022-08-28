public class User {
    private int branchNum;

    private String userName;

    public User(int branchNum, String userName) {
        this.branchNum = branchNum;
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(int branchNum) {
        this.branchNum = branchNum;
    }

}
