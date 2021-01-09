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
public class TruyVanPhieuNhap {
    String DBname = new DBConnect().getInstance().DBname;

    public TruyVanPhieuNhap() {
    }

    public String Insert(String MaPN,String MaSP,int SoLuong,String NgayLap,String CMND,String MaNCC)
    {
        return  "insert into PhieuNhap(MaPhieuNhap,MaSanPham,SoLuong,NgayLap,CMND_NhanVien,MaNhaCungCap) values ('"+MaPN.trim()+"','"+MaSP.trim()+"',"+SoLuong+",'"+NgayLap+"','"+CMND.trim()+"','"+MaNCC.trim()+"');"
                + "\n" +
                "SELECT * FROM PhieuNhap";
    }
    
    public String Update(String MaPN,String MaSP,int SoLuong,String NgayLap,String CMND,String MaNCC)
    {
        return "USE "+DBname+" UPDATE PhieuNhap SET MaSanPham = '"+MaSP+"', SoLuong = "+SoLuong+", NgayLap = '"+NgayLap+"', CMND_NhanVien = '"+CMND+"', MaNhaCungCap = '"+MaNCC+"' WHERE MaPhieuNhap = '"+MaPN+"';" 
                +"\n"+
                " SELECT * FROM PhieuNhap";        
    }
   
    
    public String Update(String MaPNCu,String MaPNMoi)
    {
        return "USE "+DBname+" UPDATE PhieuNhap SET MaPhieuNhap = '"+MaPNMoi+"' WHERE MaPhieuNhap = '"+MaPNCu+"';" 
                +"\n"+
                " SELECT * FROM PhieuNhap";        
    }
    
    
    public String Xoa(String MaPN)
    {
        return "USE "+DBname+" DELETE FROM PhieuNhap where MaPhieuNhap = '"+MaPN+"';"
                +"\n"+
                " SELECT * FROM PhieuNhap;"; 
    }
}
