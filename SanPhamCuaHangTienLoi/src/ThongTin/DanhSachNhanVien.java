/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongTin;

import Data.DBConnect;
import Data.TruyVan.TruyVanNhanVien;
import com.microsoft.sqlserver.jdbc.StringUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author ASUS
 */
public class DanhSachNhanVien {
    public static DanhSachNhanVien Instance = null;    
    TruyVanNhanVien truyVan = new TruyVanNhanVien();
    DBConnect dataBase = new DBConnect();
    
    public List<NhanVien> DanhSachNV = new ArrayList<>();

    public DanhSachNhanVien() {
        
    }
    
    //singleton
    public static DanhSachNhanVien getInstance()
    {
        if (Instance == null)
            Instance = new DanhSachNhanVien();
        
        return Instance;
    }
    
    public List<NhanVien> getDanhSachNV() {
        return DanhSachNV;
    }

    public void setDanhSachNV(List<NhanVien> DanhSachNV) {
        this.DanhSachNV = DanhSachNV;
    }
    
    public void AddList(String TenNV,String DiaChi,String SDT,String CMND)
    {
        NhanVien nv = new NhanVien(TenNV, DiaChi, DiaChi, CMND, SDT);
        DanhSachNV.add(nv);
    }
    
    public void AddList(String TenNV,String DiaChi,String SDT,String CMND, Date date)
    {
        NhanVien nv = new NhanVien(TenNV, DiaChi, DiaChi, CMND, SDT, date);
        DanhSachNV.add(nv);
    }
    
    public void getData() throws SQLException
    {
        getInstance().getDanhSachNV().removeAll(DanhSachNV);
        try {
            Connection connect = new DBConnect().getInstance().getBConnect();

            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM NhanVien");
            
            while (rs.next())
            {
                String TenNhanVien = rs.getString("TenNhanVien").trim().toUpperCase();
                String pass = rs.getString("DiaChi").trim();
                String SDT = rs.getString("SDT").trim();
                String CMND = rs.getString("CMND").trim();
                Date date = Date.valueOf(rs.getString("NgayVaoLam"));
                AddList(TenNhanVien, pass, SDT, CMND, date);
            }           
        }
        catch (SQLException ex)
        {
            Logger.getLogger("Có lỗi xảy ra.");
        }
        
    }
    
    public int GetID(String CMND)
    {
        for (int i= 0; i< getInstance().getDanhSachNV().size();i++)
        {
            if (getInstance().getDanhSachNV().get(i).getCMND().equals(CMND))
                return i;
        }
        return -1;
    }
   
    
    public void Update(String TenNV,String DiaChi,String SDT,String CMND,String NgayVaoLam)
    {
        int id = GetID(CMND);
        dataBase.TruyVan(truyVan.Update(TenNV, DiaChi, SDT, CMND, NgayVaoLam ));
        
        getInstance().DanhSachNV.get(id).setTenNhanVien(TenNV);
        getInstance().DanhSachNV.get(id).setDiaChi(DiaChi);
        getInstance().DanhSachNV.get(id).setCMND(CMND);
        getInstance().DanhSachNV.get(id).setSDT(SDT);
        getInstance().DanhSachNV.get(id).setDate(Date.valueOf(NgayVaoLam));
        
    }
    
    public void Delete(int id,String cmnd)
    {
        dataBase.TruyVan(truyVan.XoaNhanVien(cmnd));
        DanhSachNV.remove(id);
        RefreshList();
    }
    
    void RefreshList()
    {
        for (int i=0; i<DanhSachNV.size();i++)
        {
            dataBase.TruyVan(truyVan.Update(i, DanhSachNV.get(i).CMND));
        }
    }
    
    public void Insert(String name, String address, String PhoneNumber,String CMND)
    {
        dataBase.TruyVan(truyVan.Insert(name, address, PhoneNumber, CMND));
        getInstance().AddList(name, address, PhoneNumber, CMND);
        JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công.", "Thông báo",  JOptionPane.INFORMATION_MESSAGE);   

    }
    
    public void Insert(String name, String address, String PhoneNumber,String CMND, String NgayVaoLam)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
        dataBase.TruyVan(truyVan.Insert(name, address, PhoneNumber, CMND, NgayVaoLam));
        getInstance().AddList(name, address, PhoneNumber, CMND, Date.valueOf(NgayVaoLam));
        JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công.", "Thông báo",  JOptionPane.INFORMATION_MESSAGE);   

    }
    
    public boolean Check(String cmnd)
    {
        
        for (int i=0; i<DanhSachNV.size();i++)
        {
            if (DanhSachNV.get(i).CMND.equals(cmnd))
                return true;
        }
  
        return false;
    }
    
    public boolean CheckSyntax(String PhoneNumber, String cmnd)
    {
        if (!StringUtils.isNumeric(cmnd) || !StringUtils.isNumeric(PhoneNumber))
            return false;
        
        if (cmnd.length() != 9)
            return false;
        
        return true;
    }
    
}
