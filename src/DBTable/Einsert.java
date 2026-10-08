package DBTable;

public class Einsert {

    // date type to class
    private String Mobile, Fname, Lname, Email, Job;

    // constarctor to class
    public Einsert(String Mobile, String Fname, String Lname, String Job, String Email) {
        this.Mobile = Mobile;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Email = Email;
        this.Job = Job;
    }

    // all method to getter and setter of class
    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

}
