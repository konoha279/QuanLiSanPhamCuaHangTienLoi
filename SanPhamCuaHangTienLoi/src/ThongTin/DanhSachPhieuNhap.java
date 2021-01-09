/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongTin;

import Data.DBConnect;
import Data.TruyVan.TruyVanPhieuNhap;
import Form.TaoNhaCungCapNhanh;
import Form.TaoNhanVienNhanh;
import Form.TaoSanPhamNhanh;
import Main.Main;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DanhSachPhieuNhap {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 

    public static DanhSachPhieuNhap Instance = null;
    DBConnect DataBase = new DBConnect();
    TruyVanPhieuNhap TruyVan = new TruyVanPhieuNhap();
    
    public List<PhieuNhapHang> DanhSachPN = new ArrayList<>();

    public DanhSachPhieuNhap() {
    }

    public static DanhSachPhieuNhap getInstance() {
        if (Instance == null)
            Instance = new DanhSachPhieuNhap();
        
        return Instance;
    }

    public void setDanhSachPhieuNhap(List<PhieuNhapHang> DanhSachPhieuNhap) {
        this.DanhSachPN = DanhSachPhieuNhap;
    }

    public List<PhieuNhapHang> getDanhSachPhieuNhap() {
        return DanhSachPN;
    }
    
    public void AddList(String MaPhieuNhap, String MaSanPham, int SoLuong, Date NgayLap, String CMND_NhanVien, String MaNhaCungCap)
    {
        PhieuNhapHang PhieuNhap = new PhieuNhapHang(MaPhieuNhap, MaSanPham, SoLuong, NgayLap, CMND_NhanVien, MaNhaCungCap);
        DanhSachPN.add(PhieuNhap);
    }
    
    int GetID(String MaPN)
    {
        for (int i=0; i<getInstance().getDanhSachPhieuNhap().size();i++)
        {
            if (getInstance().getDanhSachPhieuNhap().get(i).getMaPhieuNhap().equals(MaPN))
                return i;
        }
        return -1;
    }
    
    public void getData() throws SQLException
    {
        Connection con= null;
        Statement sta=null;
        try {
            con = new DBConnect().getInstance().getBConnect();

            sta = con.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM PhieuNhap");
            
            while (rs.next())
            {
                String MaPhieuNhap = rs.getString("MaPhieuNhap").trim();
                String MaSP = rs.getString("MaSanPham").trim();
                int SoLuong = rs.getInt("SoLuong");
                Date NgayLap= Date.valueOf(rs.getString("NgayLap"));
                String CMND= rs.getString("CMND_NhanVien");
                String MaNhaCungCap= rs.getString("MaNhaCungCap").trim();
                
                AddList(MaPhieuNhap, MaSP, SoLuong, NgayLap, CMND, MaNhaCungCap);
            }
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DanhSachPhieuNhap.class.getName()).log(Level.SEVERE, null,ex);
        }  
    }
    
    
    Boolean CheckNCC(String MaNCC)
    {
        if (new DanhSachNhaCungCap().getInstance().getID(MaNCC) != -1)
        {
            return true;
        }
        return false;
    }
    Boolean CheckSanPham(String MaSP)
    {
        if (new DanhSachSanPham().getInstance().getID(MaSP) != -1)
        {
            return true;
        }
        return false;
    }
     
    Boolean CheckNhanVien(String CMND)
    {
        if (new DanhSachNhanVien().getInstance().GetID(CMND) != -1)
        {
            return true;
        }
        return false;
    }
    
    void ThemNhanh(String MaSP, String CMND, String MaNCC)
    {
        if (!CheckSanPham(MaSP))
        {
            int reply = JOptionPane.showConfirmDialog(null, "Mã sản phẩm chưa tốn tại!\nBạn có muốn thêm sản phẩm không ?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                new TaoSanPhamNhanh().show();
                return;
            } else {
                return;
            }
        }
        
        if (!CheckNCC(MaNCC))
        {
            int reply = JOptionPane.showConfirmDialog(null, "Mã nhà cung cấp chưa tốn tại!\nBạn có muốn thêm nhà cung cấp không ?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                new TaoNhaCungCapNhanh().show();
                return;
            } else {
                return;
            }
        }
        
        if (!CheckNhanVien(CMND))
        {
            int reply = JOptionPane.showConfirmDialog(null, "Nhân viên chưa tốn tại!\nBạn có muốn thêm nhà nhân viên không ?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                new TaoNhanVienNhanh().show();
                return;
            } else {
                return;
            }
        }
    }

    public void Insert(String MaSP,int SoLuong,String NgayLap,String CMND,String MaNCC)
    {
        if (CheckNCC(MaNCC) && CheckNhanVien(CMND) && CheckSanPham(MaSP))
        {
            int IDSanPham = new DanhSachSanPham().getInstance().getID(MaSP);
            int SoLuongHienTai = new DanhSachSanPham().getInstance().getDanhSachSP().get(IDSanPham).getSoLuong();
            new DanhSachSanPham().getInstance().getDanhSachSP().get(IDSanPham).setSoLuong(SoLuong+SoLuongHienTai);
            new DanhSachSanPham().getInstance().Update(IDSanPham);

            String MaPN = "PN" + (getInstance().getDanhSachPhieuNhap().size()+1);
            DataBase.TruyVan(TruyVan.Insert(MaPN, MaSP, SoLuong, NgayLap, CMND, MaNCC));
            AddList(MaPN, MaSP, SoLuong, Date.valueOf(NgayLap), CMND, MaNCC);
        }
        else
            ThemNhanh(MaSP, CMND, MaNCC);
        
        
    }
    
    public void Update(String MaPN,String MaSP,int SoLuong,String NgayLap,String CMND,String MaNCC, int SoLuongCu)
    {
        
        int id = GetID(MaPN);
        
        if (CheckNCC(MaNCC) && CheckNhanVien(CMND) && CheckSanPham(MaSP))
        {
            int IDSanPham = new DanhSachSanPham().getInstance().getID(MaSP);
            int SoLuongHienTai = new DanhSachSanPham().getInstance().getDanhSachSP().get(IDSanPham).getSoLuong();
            int SoLuongThem = SoLuong - SoLuongCu;
            new DanhSachSanPham().getInstance().getDanhSachSP().get(IDSanPham).setSoLuong(SoLuongHienTai+SoLuongThem);
            new DanhSachSanPham().getInstance().Update(IDSanPham);

            DataBase.TruyVan(TruyVan.Update(MaPN, MaSP, SoLuong, NgayLap, CMND, MaNCC));

            getInstance().getDanhSachPhieuNhap().get(id).setMaNhaCungCap(MaNCC);
            getInstance().getDanhSachPhieuNhap().get(id).setMaSanPham(MaSP);
            getInstance().getDanhSachPhieuNhap().get(id).setNgayLap(Date.valueOf(NgayLap));
            getInstance().getDanhSachPhieuNhap().get(id).setSoLuongSP(SoLuong);
            getInstance().getDanhSachPhieuNhap().get(id).setCMND_NhanVien(CMND);
        }
        else
        {
            ThemNhanh(MaSP, CMND, MaNCC);
        }
        
    }
    
    public void Xoa(String MaPN)
    {
        int id = GetID(MaPN);
        getInstance().getDanhSachPhieuNhap().remove(id);
        DataBase.TruyVan(TruyVan.Xoa(MaPN));
        Reset();
    }
    
    public void Reset()
    {
        for (int i=0 ;i< getInstance().getDanhSachPhieuNhap().size();i++)
        {
            String MaPN= "PN" + (i+1);
            DataBase.TruyVan(TruyVan.Update(getInstance().getDanhSachPhieuNhap().get(i).MaPhieuNhap, MaPN));
            getInstance().getDanhSachPhieuNhap().get(i).setMaPhieuNhap(MaPN);
        }
    }
}
