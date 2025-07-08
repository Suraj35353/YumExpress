/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YumExpress.dao;

import YumExpress.dbutil.DbConnection;
import YumExpress.pojo.ProductPojo;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author ashmi
 */
public class ProductDao {
    public static String getNewProductId()throws SQLException{
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(product_id) from products");
        rs.next();
        String id=rs.getString(1);
        String productId="";
        if(id!=null){
            id=id.substring(4);
            productId="PRD-"+(Integer.parseInt(id)+1);
        }
        else{
            productId="PRD-101";
        }
        return productId;
    }
    
    public static boolean addProduct(ProductPojo product)throws SQLException,IOException{
        BufferedImage bi=new BufferedImage(product.getProductImage().getHeight(null),product.getProductImage().getWidth(null),BufferedImage.TYPE_INT_RGB);
        
        Graphics gr=bi.getGraphics();
        gr.drawImage(product.getProductImage(), 0, 0, null);
        
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ImageIO.write(bi,product.getProductImageType(),baos);
        byte[] image=baos.toByteArray();
        ByteArrayInputStream bais=new ByteArrayInputStream(image);
        
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into products values(?,?,?,?,?)");
        ps.setString(1, getNewProductId());
        ps.setString(2, product.getCompanyId());
        ps.setString(3, product.getProductName());
        ps.setDouble(4, product.getProductPrice());
        ps.setBinaryStream(5, bais, image.length);
        return ps.executeUpdate() > 0;
    }
    public static Map<String,ProductPojo> getProductDetailsByCompanyId(String companyId) throws SQLException,IOException{
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from products where company_id=?");
        ps.setString(1, companyId);
        ResultSet rs=ps.executeQuery();
        Map<String,ProductPojo> productDetails=new HashMap<>();
        while(rs.next()){
            ProductPojo product= new ProductPojo();
            product.setProductName(rs.getString(3));
            product.setProductPrice(rs.getDouble(4));
            InputStream is=rs.getBinaryStream("product_image");
            
            BufferedImage bi=ImageIO.read(is);
            
            Image image=bi;
            product.setProductImage(image);
            productDetails.put(product.getProductName(), product);
        }
        return productDetails;
    }
    public static List<ProductPojo> getAllProductsByCompanyId(String companyId)throws SQLException,IOException{
        Connection conn = DbConnection.getConnection();
        PreparedStatement ps;
        if(companyId.equalsIgnoreCase("ALL")){
             ps = conn.prepareStatement("select * from products where company_id in(select company_id from companies where status='ACTIVE')");
        }else{
        
        ps= conn.prepareStatement("select * from products where company_id=?");
        ps.setString(1, companyId);
        }
        ResultSet rs = ps.executeQuery();
        List<ProductPojo> productDetails = new ArrayList<>();
        while (rs.next()) {
            ProductPojo product = new ProductPojo();
            product.setProductId(rs.getString("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductPrice(rs.getDouble("product_price"));
            product.setCompanyId(rs.getString("company_id"));
            InputStream inputStream = rs.getBinaryStream("product_image");

            BufferedImage bufferedImage = ImageIO.read(inputStream);

            Image image = bufferedImage;
            product.setProductImage(image);
            productDetails.add(product);

        }
        return productDetails;
   }
}
