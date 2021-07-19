package Model;

public class UserPhone {

    private Long id;
    private String telephoneNumber;
    private String telephoneType;
    private Long userId;

    public UserPhone(){

    }

    public UserPhone(String telephoneNumber, String telephoneType){
        this.telephoneNumber = telephoneNumber;
        this.telephoneType = telephoneType;
    }

    public UserPhone(String telephoneNumber, String telephoneType, Long userId){
        this.telephoneNumber = telephoneNumber;
        this.telephoneType = telephoneType;
        this.userId = userId;
    }

    public UserPhone(Long id, String telephoneNumber, String telephoneType, Long userId){
        this.id = id;
        this.telephoneNumber = telephoneNumber;
        this.telephoneType = telephoneType;
        this.userId = userId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserPhone{" +
                "id=" + id +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", telephoneType='" + telephoneType + '\'' +
                ", userId='" + userId + '\'' +
                "}\n";
    }
}
