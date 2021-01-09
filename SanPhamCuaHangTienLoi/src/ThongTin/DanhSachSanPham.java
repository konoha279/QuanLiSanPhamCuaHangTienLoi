/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongTin;

//import Data.DBConnect;
import Data.DBConnect;
import Data.TruyVan.TruyVanDanhSachSanPham;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DanhSachSanPham {
    
    public static DanhSachSanPham Instance = null;
    TruyVanDanhSachSanPham truyVan = new TruyVanDanhSachSanPham();
    DBConnect dataBase = new DBConnect();
    
    public List<SanPham> DanhSachSP = new ArrayList<>();
    
    public DanhSachSanPham() {
        
    }
    
    //singleton
    public static DanhSachSanPham getInstance()
    {
        if (Instance == null)
            Instance = new DanhSachSanPham();
        
        return Instance;
    }

    public List<SanPham> getDanhSachSP() {
        return DanhSachSP;
    }

    public void setDanhSachSP(List<SanPham> DanhSachSP) {
        this.DanhSachSP = DanhSachSP;
    }

    public DanhSachSanPham(List<SanPham> DanhSachSP) {
        this.DanhSachSP = DanhSachSP;
    }
    
    public void AddSanPham(SanPham sp)
    {
        this.DanhSachSP.add(sp);
    }
    
    public void RemoveSanPham(SanPham sp)
    {
        this.DanhSachSP.remove(sp);
    }
    
    public void RemoveAll()
    {
        this.DanhSachSP.removeAll(this.DanhSachSP);
    }
    
    public void addList(String MSP,String TenSP,int SoLuong, String loaiSanPham,String donvitinh,int Gia)
    {
        SanPham sp= new SanPham(MSP, TenSP,SoLuong, LoaiSanPham.valueOf(loaiSanPham), DonViTinh.valueOf(donvitinh), Gia);
        AddSanPham(sp);
    }
   
    public void getData() throws SQLException
    {
        
        try {
            Connection connect = new DBConnect().getInstance().getBConnect();

            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SanPham");
            
            while (rs.next())
            {
                String MaSP = rs.getString("MaSP").replaceAll("\\s+", "");
                String TenSP = rs.getString("TenSP");
                int SoLuong =  rs.getInt("SoLuong");
                String LoaiSanPham = rs.getString("LoaiSanPham").replaceAll("\\s+", "");
                int GiaTien = rs.getInt("GiaTien");
                String DonViTinh = rs.getString("DonViTinh").replaceAll("\\s+", "");
                getInstance().addList(MaSP, TenSP, SoLuong, LoaiSanPham, DonViTinh, GiaTien);
            }
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger("Có lỗi xảy ra.");
        }
        
    }
    
    public int getID(String MaSP)
    {
        for (int i=0; i< DanhSachSP.size(); i++)
        {
            if (getInstance().DanhSachSP.get(i).MaSanPham.equals(MaSP))
                return i;
        }
        return -1;
    }
    
    public void Update(String MaSP,String TenSP,int SoLuong,String loaiSanPham, int GiaTien, String donViTinh)
    {
        int id = getID(MaSP);
        
        if (id == -1)
        {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm không tồn tại.", "Thông báo",  JOptionPane.ERROR_MESSAGE);   
            return ;
        }
       
        getInstance().getDanhSachSP().get(id).setTenSanPham(TenSP);
        getInstance().getDanhSachSP().get(id).setSoLuong(SoLuong);
        getInstance().getDanhSachSP().get(id).setLoaiSanPham(LoaiSanPham.valueOf(loaiSanPham));
        getInstance().getDanhSachSP().get(id).setDonViTinh(DonViTinh.valueOf(donViTinh));
        getInstance().getDanhSachSP().get(id).setGia(GiaTien);
        
        dataBase.TruyVan(truyVan.Update(MaSP, TenSP, SoLuong, loaiSanPham, GiaTien, donViTinh));      
    }
    
    public void Update(int ID)
    {
        String MaSP = getInstance().getDanhSachSP().get(ID).getMaSanPham();
        String TenSP = getInstance().getDanhSachSP().get(ID).getTenSanPham();
        int SoLuong = getInstance().getDanhSachSP().get(ID).getSoLuong();
        String LoaiSanPham = getInstance().getDanhSachSP().get(ID).getLoaiSanPham().toString();
        int Gia = getInstance().getDanhSachSP().get(ID).getGia();
        String DonViTinh = getInstance().getDanhSachSP().get(ID).getDonViTinh().toString();
        
        dataBase.TruyVan(truyVan.Update(MaSP, TenSP, SoLuong, LoaiSanPham, Gia, DonViTinh));
    }
     

    public void Insert(String MaSP,String TenSP,int SoLuong,String loaiSanPham, int GiaTien, String donViTinh)
    {
        int id = getID(MaSP);
        if (id != -1)
        {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm đã tồn tại.", "Thông báo",  JOptionPane.ERROR_MESSAGE);   
            return ;
        }
        dataBase.TruyVan(truyVan.Insert(MaSP, TenSP, SoLuong, loaiSanPham, GiaTien, donViTinh));
        
        addList(MaSP, TenSP, SoLuong, loaiSanPham, donViTinh, GiaTien);
        JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo",  JOptionPane.INFORMATION_MESSAGE);   

    }
    
    public void Delete(String MaSP)
    {
        int id = getID(MaSP);
        if (id == -1)
        {
            JOptionPane.showMessageDialog(null, "Mã sản phẩm không tồn tại.", "Thông báo",  JOptionPane.ERROR_MESSAGE);   
            return ;
        }
        dataBase.TruyVan(truyVan.XoaSanPham(MaSP));
        getInstance().getDanhSachSP().remove(id);
    }
    
}
