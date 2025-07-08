/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YumExpress.dao;

import YumExpress.dbutil.DbConnection;
import YumExpress.pojo.CompaniesPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author ashmi
 */
public class CompaniesDao {
    public static String getNewCompanyId()throws SQLException{
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(company_id) from companies");
        rs.next();
        String id=rs.getString(1);
        String compId="";
        if(id!=null){
            id=id.substring(4);
            compId="CMP-"+(Integer.parseInt(id)+1);
        }
        else{
            compId="CMP-101";
        }
        return compId;
    }
    public static boolean addSeller(CompaniesPojo cp)throws SQLException{
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into companies values(?,?,?,?,?,?,?)");
        ps.setString(1, getNewCompanyId());
        ps.setString(2, cp.getCompanyName());
        ps.setString(3, cp.getOwnerName());
        ps.setString(4, cp.getPassword());
        ps.setString(5, "ACTIVE");
        ps.setString(6, cp.getEmailId());
        ps.setString(7, cp.getSecurityKey());
        return ps.executeUpdate()==1;  
    }
    public static CompaniesPojo validateSeller(String userId, String password) throws SQLException{
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from companies where company_name=? and password=? and status='ACTIVE'");
        ps.setString(1, userId);
        ps.setString(2, password);
        ResultSet rs=ps.executeQuery();
        CompaniesPojo cp=null;
        if(rs.next()){
            cp=new CompaniesPojo();
            cp.setCompanyId(rs.getString(1));
            cp.setCompanyName(rs.getString(2));
            cp.setOwnerName(rs.getString(3));
        }
        return cp;
    }
    public static Map<String,String> getEmailCredentialsByCompanyId(String companyId) throws SQLException{
       Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select email_id,security_key from companies where company_id=? and status='ACTIVE'");
       ps.setString(1, companyId);
       Map<String,String> details=new HashMap<>();
       ResultSet rs=ps.executeQuery();
       if(rs.next()){
           String emailId=rs.getString(1);
           String seckey=rs.getString(2);
           details.put("emailId", emailId);
           details.put("seckey", seckey);
       }
       return details;
    }
    public static Map<String,String> getAllCompanyIdAndName()throws SQLException {
       Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("select company_id,company_name from companies where status='ACTIVE' and company_id in (select company_id from products)");
       ResultSet rs=ps.executeQuery();
       Map<String,String> compList=new HashMap<>();
       while(rs.next()){
           String c_id=rs.getString(1);
           String c_name=rs.getString(2);
           compList.put(c_name,c_id);
           
       }
       return compList;
   }
}
