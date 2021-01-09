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
public class TruyVanDanhSachSanPham {
    
    String DBname = new DBConnect().getInstance().DBname;

    public String Insert(String MaSP,String TenSP,int SoLuong,String LoaiSanPham, int GiaTien, String DonViTinh)
    {
        return "declare @id int;\n" 
                + "\n" +
                "insert into SanPham(MaSP,TenSP,SoLuong,LoaiSanPham,GiaTien,DonViTinh) values ('"+MaSP+"','"+ TenSP +"'," +SoLuong+ ",'"+ LoaiSanPham +"'," +GiaTien+ ",'" +DonViTinh+ "');"
                + "\n" +
                "SELECT * FROM SanPham";
    }
    
    public String Update(String MaSP,String TenSP,int SoLuong,String LoaiSanPham, int GiaTien, String DonViTinh)
    {
        return "USE "+DBname+" UPDATE SanPham SET TenSP = '"+TenSP+"', SoLuong = "+SoLuong+", LoaiSanPham = '"+LoaiSanPham+"' , GiaTien = "+GiaTien+" , DonViTinh = '"+DonViTinh+"' WHERE MaSP = '"+MaSP+"';" 
                +"\n"+
                " SELECT * FROM SanPham";        
    }
    
    
    public String Update(String MaSPMoi, String MaSPCu)
    {
        return "USE "+DBname+" UPDATE SanPham SET MaSP = '"+MaSPMoi+"' WHERE MaSP = '"+MaSPCu+"';" 
                +"\n"+
                " SELECT * FROM SanPham";        
    }
    
    
    public String XoaSanPham(String MaSP)
    {
        return "USE "+DBname+" DELETE FROM SanPham WHERE MaSP = '"+MaSP+"';"
                +"\n"+
                " SELECT * FROM SanPham;"; 
    }
}
