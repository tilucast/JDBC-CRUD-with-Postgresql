package Model;

public class UserAndPhoneInfo {

    private Long userId;
    private String name;
    private String email;
    private String telephoneNumber;
    private String telephoneType;

    public UserAndPhoneInfo(
            Long userId,
            String name,
            String email,
            String telephoneNumber,
            String telephoneType
    ){
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.telephoneType = telephoneType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneType() {
        return telephoneType;
    }

    public void setTelephoneType(String telephoneType) {
        this.telephoneType = telephoneType;
    }

    @Override
    public String toString() {
        return "UserAndPhoneInfo{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", telephoneType='" + telephoneType + '\'' +
                "}\n";
    }
}
