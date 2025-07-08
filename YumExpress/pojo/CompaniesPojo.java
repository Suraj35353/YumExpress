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
public class CompaniesPojo {

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public CompaniesPojo() {
    }

    public CompaniesPojo(String companyId, String companyName, String ownerName, String password, String securityKey, String emailId) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.password = password;
        this.emailId = emailId;
        this.securityKey=securityKey;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    private String companyId;
    private String companyName;
    private String ownerName;
    private String password;
    private String securityKey;
    private String emailId;
    
}
