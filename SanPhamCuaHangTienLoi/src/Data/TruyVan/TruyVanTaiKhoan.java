/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data.TruyVan;

import Data.DBConnect;

/**
 *
 * @author ASUS
 */
public class TruyVanTaiKhoan {

    public TruyVanTaiKhoan() {
    }
    
    
    String DBname = new DBConnect().getInstance().DBname;
    public String Insert(String user,String Pass,Boolean IsAdmin)
    {
        return "declare @id int;\n" +
                "select @id = MAX(id) from TaiKhoanDangNhap\n"
                + "\n" +
                "insert into TaiKhoanDangNhap(id,m_User,m_Password) values (@id+1,'"+ user +"','" +Pass+ "');"
                + "\n" +
                "SELECT * FROM TaiKhoanDangNhap";
    }
    
    public String Update(int id,String user,String pass,Boolean isadmin)
    {
        int is = isadmin ? 1:0;
        return "USE "+DBname+" UPDATE TaiKhoanDangNhap SET m_Password = '"+pass+"', m_User = '"+user+"', isAdmin = "+is+" WHERE id = "+id+";" 
                +"\n"+
                " SELECT * FROM TaiKhoanDangNhap";        
    }
    
    public String Repass(int id,String NewPass)
    {
        return "USE "+DBname+" UPDATE TaiKhoanDangNhap SET m_Password = '"+NewPass+"' WHERE id ='"+id+"';"
                +"\n"+
                " SELECT * FROM TaiKhoanDangNhap";     
    }
    
    public String DeleteUser(String user)
    {
        return "USE "+DBname+" DELETE FROM TaiKhoanDangNhap where m_User = '"+user+"';"
                +"\n"+
                " SELECT * FROM TaiKhoanDangNhap;"; 
    }
    
        
    public String setIdUser(int id, String user)
    {
        return "USE "+DBname+" UPDATE TaiKhoanDangNhap SET id = "+id+" WHERE m_User = '"+user+"';" 
                +"\n"+
                " SELECT * FROM TaiKhoanDangNhap";  
    }
    
}
