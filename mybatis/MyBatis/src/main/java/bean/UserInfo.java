package bean;

//第三步：创建相应的bean包和相应的mapper包
//第四步：创建相应的类与对应的属性
public class UserInfo {
    private Integer userId;
    private String userName;
    private String userSex;
    private Integer userAge;
    private String userAddress;
    private String userPass;
    private Integer userState;

    public UserInfo() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge=" + userAge +
                ", userAddress='" + userAddress + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userState=" + userState +
                '}';
    }

    public UserInfo(String userName, String userSex, Integer userAge, String userAddress, String userPass) {
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userAddress = userAddress;
        this.userPass = userPass;
    }

    public UserInfo(Integer userId, String userName, String userSex, Integer userAge, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userAddress = userAddress;
    }
}
