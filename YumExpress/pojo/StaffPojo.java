/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YumExpress.pojo;

/**
 *
 * @author ashmi
 */
public class StaffPojo {

    @Override
    public String toString() {
        return "StaffPojo{" + "StaffId=" + StaffId + ", companyId=" + companyId + ", emailId=" + emailId + ", password=" + password + ", StaffName=" + StaffName + '}';
    }

    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String StaffId) {
        this.StaffId = StaffId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffName() {
        return StaffName;
    }

    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;
    }

    public StaffPojo(String StaffId, String companyId, String emailId, String password, String StaffName) {
        this.StaffId = StaffId;
        this.companyId = companyId;
        this.emailId = emailId;
        this.password = password;
        this.StaffName = StaffName;
    }

    public StaffPojo() {
    }
    private String StaffId;
    private String companyId;
    private String emailId;
    private String password;
    private String StaffName;
}
