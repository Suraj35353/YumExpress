/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumexpress.pojo;

/**
 *
 * @author HP
 */
public class CompanyPojo {

    public CompanyPojo() {
    }

    public CompanyPojo(String CompanyId, String CompanyName, String OwnerName, String Password, String SecurityKey, String EmailId) {
        this.CompanyId = CompanyId;
        this.CompanyName = CompanyName;
        this.OwnerName = OwnerName;
        this.Password = Password;
        this.SecurityKey = SecurityKey;
        this.EmailId = EmailId;
    }
     private String CompanyId;
    private String CompanyName;
    private  String OwnerName;
    private String Password;
    private String SecurityKey;
    private  String EmailId;

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String CompanyId) {
        this.CompanyId = CompanyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getSecurityKey() {
        return SecurityKey;
    }

    public void setSecurityKey(String SecurityKey) {
        this.SecurityKey = SecurityKey;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }
    
}
