/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YumExpress.dao;

import YumExpress.dbutil.DbConnection;
import YumExpress.pojo.StaffPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ashmi
 */
public class StaffDao {
    public static String getNewStaffId()throws SQLException{
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(staff_id) from staff");
        rs.next();
        String id=rs.getString(1);
        String staffId="";
        if(id!=null){
            id=id.substring(4);
            staffId="STF-"+(Integer.parseInt(id)+1);
        }
        else{
            staffId="STF-101";
        }
        return staffId;
    }
    
    public static String addStaff(StaffPojo staff) throws SQLException{
       Connection conn=DbConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("insert into staff values(?,?,?,?,?)");
       staff.setStaffId(getNewStaffId());
       ps.setString(1, staff.getStaffId());
       ps.setString(2, staff.getCompanyId());
       ps.setString(3, staff.getEmailId());
       ps.setString(4, staff.getPassword());
       ps.setString(5, staff.getStaffName());
       return (ps.executeUpdate()==1?staff.getStaffId():null);
    }
    
    public static List<String> getAllStaffIdByCompanyId(String companyId) throws SQLException{
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select staff_id from staff where company_id=?");
        ps.setString(1, companyId);
        List<String>StaffList=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {            
            StaffList.add(rs.getString(1));
        }
        return StaffList;
    }
    
    public static StaffPojo getStaffDetailsById(String staffId) throws SQLException{
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from staff where staff_id=?");
        ps.setString(1, staffId);
        StaffPojo staff=new StaffPojo();
        ResultSet rs=ps.executeQuery();
        rs.next();
        staff.setStaffName(rs.getString(5));
        staff.setEmailId(rs.getString(3));
        return staff;
    }
    public static String getRandomStaffIdFromCompany(String compId)throws SQLException{
        List<String>staffList=StaffDao.getAllStaffIdByCompanyId(compId);
        Random rand=new Random();
        int index=rand.nextInt(staffList.size());
        return staffList.get(index);
    }
    public static StaffPojo validateStaff(String EmailId,String Password)throws SQLException{
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from staff where email_id=? and password=?");
        ps.setString(1, EmailId);
        ps.setString(2, Password);
        ResultSet rs=ps.executeQuery();
        StaffPojo sp=null;
        if(rs.next()){
            sp=new StaffPojo();
            sp.setStaffId(rs.getString(1));
            sp.setCompanyId(rs.getString(2));
            sp.setStaffName(rs.getString(5));
        }
        return sp;
    }
     
}
