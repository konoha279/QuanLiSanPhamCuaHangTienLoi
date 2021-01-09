/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongTin;

import Data.DBConnect;
import Data.TruyVan.TruyVanTaiKhoan;
import FormInput.DoiMatKhau;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DanhSachTK {
    public static DanhSachTK Instance = null;
    public TruyVanTaiKhoan tv = new TruyVanTaiKhoan();

    public List<TaiKhoanDangNhap> DanhSachTK= new ArrayList<>();

    public DanhSachTK() {
    }
    
    //singleton
    public static DanhSachTK getInstance()
    {
        if (Instance == null)
            Instance = new DanhSachTK();
        
        return Instance;
    }

    public List<TaiKhoanDangNhap> getDanhSachTK() {
        return DanhSachTK;
    }

    public void setDanhSachTK(List<TaiKhoanDangNhap> DanhSachTK) {
        this.DanhSachTK = DanhSachTK;
    }
    
    //lấy quyền admin
    public Boolean getIsAdmin(int id)
    {        
        return getInstance().DanhSachTK.get(id).isAdmin;
    }
    
    //kiểm tra đăng nhập
    public Boolean Login(String user,String pass)
    {
        for (int i=0; i<DanhSachTK.size();i++)
        {
            if (DanhSachTK.get(i).Login(user, pass))
                return true;
        }
        return false;
    }
    
    //thêm vào danh sách
    public void addList(String user,String pass,Boolean isAdmin)
    {
        TaiKhoanDangNhap taikhoan = new TaiKhoanDangNhap(user, pass, isAdmin);
        DanhSachTK.add(taikhoan);
    }
    
    public void getData() throws SQLException
    {
        getInstance().getDanhSachTK().removeAll(DanhSachTK);
        try {
            Connection connect = new DBConnect().getInstance().getBConnect();

            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TaiKhoanDangNhap");
            
            while (rs.next())
            {
                String user = rs.getString("m_User").trim();
                String pass = rs.getString("m_Password").trim();
                Boolean isAdmin = rs.getBoolean("isAdmin");
                addList(user, pass, isAdmin);
            }
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger("Có lỗi xảy ra.");
        }
        
    }
    
    public Boolean isExists(String user)
    {
        for (int i =0; i < getInstance().getDanhSachTK().size();i++)
        {
            if (getInstance().getDanhSachTK().get(i).getUser().equals(user))
            {
                return true;
            }
        } 
        return false;
    }
    
    public Boolean CheckOldPassword(String pass)
    {
        int ID = new Logined().getInstance().getIdLogin() ;
        return getInstance().DanhSachTK.get(ID).getPassword().equals(pass);
    }
    
    public void RePassMyself(String MatKhauCu, String MatKhauMoi, String NhapLaiMatKhau)
    {

            if (CheckOldPassword(MatKhauCu))
            {
                if (MatKhauMoi.equals(NhapLaiMatKhau))
                {                
                    getInstance().DanhSachTK.get(new Logined().getInstance().getIdLogin()).setPassword(MatKhauMoi);
                                                            
                    new DBConnect().TruyVan(tv.Repass(new Logined().getInstance().getIdLogin(), MatKhauMoi));
                    
                    JOptionPane.showMessageDialog(null, "Mật khẩu mới của bạn là: " + MatKhauMoi, "Thông báo",  JOptionPane.INFORMATION_MESSAGE);
                    new DoiMatKhau().getInstance().dispose();
                 }
                else JOptionPane.showMessageDialog(null, "Mật khẩu mới không khớp.", "Thông báo",  JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng.", "Thông báo",  JOptionPane.ERROR_MESSAGE);
            }           
    }
    
    public void ThayDoiInfo(int ID, String User, String MatKhau, Boolean isAdmin)
    {            
            new DBConnect().TruyVan(tv.Update(ID, User, MatKhau, isAdmin));  
            
            getInstance().DanhSachTK.get(ID).setUser(User);
            getInstance().DanhSachTK.get(ID).setPassword(MatKhau);
            getInstance().DanhSachTK.get(ID).setIsAdmin(Boolean.valueOf(isAdmin));    
    }

    public int getID(String user,String pass)
    {
        for (int i=0; i<DanhSachTK.size();i++)
        {
            if (DanhSachTK.get(i).Login(user, pass))
                return i;
        }
        return -1;
    }
    
    public void AddUser(String user, String pass, Boolean IsAdmin)
    {       
            new DBConnect().TruyVan(tv.Insert(user, pass, IsAdmin));
            getInstance().getDanhSachTK().add(new TaiKhoanDangNhap(user, pass, IsAdmin));
            
            JOptionPane.showMessageDialog(null, "Bạn đã thêm tài khoản thành công.", "Thông báo",  JOptionPane.INFORMATION_MESSAGE);   
    }
    
    public void DeleteUser(int id)
    {
        if (id != new Logined().getInstance().getIdLogin())
        {
            new DBConnect().TruyVan(tv.DeleteUser(getInstance().getDanhSachTK().get(id).getUser()));
            
            getInstance().getDanhSachTK().remove(id);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Không thể xóa tài khoản đang đăng nhập.", "Thông báo",  JOptionPane.ERROR_MESSAGE);   
        }
    }
    
    public void RefreshListSQL()
    {  
        for (int i=0; i< getInstance().getDanhSachTK().size();i++)
        {
            String user = getInstance().getDanhSachTK().get(i).getUser();
            
            new DBConnect().TruyVan(tv.setIdUser(i, user));
        }
    }   
}
