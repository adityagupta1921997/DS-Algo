package LLD.BookMyShow;

public class User {

    private Long uid;
    private String uname;
    private String ulocation;

    public User(Long uid, String uname, String ulocation) {
        this.uid = uid;
        this.uname = uname;
        this.ulocation = ulocation;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUlocation() {
        return ulocation;
    }

    public void setUlocation(String ulocation) {
        this.ulocation = ulocation;
    }

}
