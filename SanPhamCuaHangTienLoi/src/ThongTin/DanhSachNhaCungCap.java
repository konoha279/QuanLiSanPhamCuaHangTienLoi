/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongTin;

import Data.DBConnect;
import Data.TruyVan.TruyVanNhaCungCap;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author ASUS
 */
public class DanhSachNhaCungCap {
    public static DanhSachNhaCungCap Instance = null;
    TruyVanNhaCungCap TruyVan = new TruyVanNhaCungCap();
    DBConnect DataBase = new DBConnect();
    
    public List<NhaCungCap> DanhSachNCC = new ArrayList<>();

    public DanhSachNhaCungCap() {
    }
    
    public static DanhSachNhaCungCap getInstance()
    {
        if (Instance == null)
            Instance = new DanhSachNhaCungCap();
        
        return Instance;
    }
    
    public void setDanhSachNCC(List<NhaCungCap> DanhSachNCC) {
        this.DanhSachNCC = DanhSachNCC;
    }

    public List<NhaCungCap> getDanhSachNCC() {
        return DanhSachNCC;
    }
   
    public void getData() throws SQLException
    {
        Connection con= null;
        Statement sta=null;
        try {
            con = new DBConnect().getInstance().getBConnect();

            sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM NhaCungCap");
            
            while (rs.next())
            {
                String MaNhaCungCap = rs.getString("MaNCC").trim();
                String TenNhaCungCap = rs.getString("TenNCC").trim();
                String DiaChi=rs.getString("DiaChi").trim();
                String SoDienThoai=rs.getString("SDT").trim();
                NhaCungCap ncc = new NhaCungCap( MaNhaCungCap, TenNhaCungCap, DiaChi, SoDienThoai);
                DanhSachNCC.add(ncc);
                
            }  
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DanhSachNhaCungCap.class.getName()).log(Level.SEVERE, null,ex);
        }  
    }
    
    public int getID(String MaNCC)
    {
        for (int i=0;i<DanhSachNCC.size();i++)
        {
            if (DanhSachNCC.get(i).getMaNhaCungCap().equals(MaNCC))
            {
                return i;
            }
        }
        return -1;
    }

    public void Update(String MaNCC, String TenNCC, String DiaChi, String SDT)
    {
        int id = getID(MaNCC);
        if (id == -1)
        {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp không tồn tại.", "Thông báo",  JOptionPane.ERROR_MESSAGE);   
            return ;
        }
        
        DataBase.TruyVan(TruyVan.Update(MaNCC, TenNCC, DiaChi, SDT));

        getInstance().getDanhSachNCC().get(id).setMaNhaCungCap(MaNCC);
        getInstance().getDanhSachNCC().get(id).setTenNhaCungCap(TenNCC);
        getInstance().getDanhSachNCC().get(id).setDiaChi(DiaChi);
        getInstance().getDanhSachNCC().get(id).setSDT(SDT);
    }
    
    public void Insert(String TenNCC, String DiaChi, String SDT)
    {
        String MaNCC = "NCC" + (getInstance().DanhSachNCC.size()+1);
        DataBase.TruyVan(TruyVan.Insert(MaNCC, TenNCC, DiaChi, SDT));
        
        NhaCungCap ncc = new NhaCungCap( MaNCC, TenNCC, DiaChi, SDT);
        getInstance().DanhSachNCC.add(ncc);
    }
    
    public void Delete(String MaNCC)
    {
        int id = getID(MaNCC);
        if (id == -1)
        {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp không tồn tại.", "Thông báo",  JOptionPane.ERROR_MESSAGE);   
            return ;
        }
        DataBase.TruyVan(TruyVan.XoaNhaCungCap(MaNCC));
        getInstance().DanhSachNCC.remove(id);
        RefreshListSQL();
    }
    
    void RefreshListSQL()
    {
        for (int i=0 ; i<getInstance().getDanhSachNCC().size();i++)
        {
            String MaNCC = "NCC"+ (i+1);
            DataBase.TruyVan(TruyVan.Update(getInstance().getDanhSachNCC().get(i).getMaNhaCungCap(), MaNCC));
            getInstance().getDanhSachNCC().get(i).setMaNhaCungCap(MaNCC);
        }
    }
}
