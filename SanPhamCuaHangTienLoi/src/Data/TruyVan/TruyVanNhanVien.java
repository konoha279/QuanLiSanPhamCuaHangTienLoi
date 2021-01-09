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
public class TruyVanNhanVien {

    String DBname = new DBConnect().getInstance().DBname;

    public TruyVanNhanVien() {
    }
    
    public String Insert(String TenNV,String DiaChi,String SDT,String CMND)
    {
        return  "insert into NhanVien(TenNhanVien,DiaChi,SDT,CMND) values ('"+ TenNV +"','" +DiaChi+ "','"+ SDT +"','" +CMND+ "');"
                + "\n" +
                "SELECT * FROM NhanVien";
    }
    
    public String Insert(String TenNV,String DiaChi,String SDT,String CMND, String NgayVaoLam)
    {
        return  "insert into NhanVien(TenNhanVien,DiaChi,SDT,CMND,NgayVaoLam) values ('"+ TenNV +"','" +DiaChi+ "','"+ SDT +"','" +CMND+ "','"+NgayVaoLam+"');"
                + "\n" +
                "SELECT * FROM NhanVien";
    }
    
    public String Update(String TNV,String DC,String SDT,String CMND)
    {
        return "USE "+DBname+" UPDATE NhanVien SET TenNhanVien = '"+TNV+"', DiaChi = '"+DC+"', SDT = '"+SDT+"', CMND = '"+CMND+"' WHERE CMND = "+CMND+";" 
                +"\n"+
                " SELECT * FROM NhanVien";        
    }
    
    public String Update(String TNV,String DC,String SDT,String CMND, String NgayVaoLam)
    {
        return "USE "+DBname+" UPDATE NhanVien SET TenNhanVien = '"+TNV+"', DiaChi = '"+DC+"', SDT = '"+SDT+"', CMND = '"+CMND+"', NgayVaoLam = '"+NgayVaoLam+"' WHERE CMND = "+CMND+";" 
                +"\n"+
                " SELECT * FROM NhanVien";        
    }
    
    public String Update(int ID,String CMND)
    {
        return "USE "+DBname+" UPDATE NhanVien SET ID = "+ID+" WHERE CMND = "+CMND+";" 
                +"\n"+
                " SELECT * FROM NhanVien";        
    }
    
    
    public String XoaNhanVien(String CMND)
    {
        return "USE "+DBname+" DELETE FROM NhanVien where CMND = "+CMND+";"
                +"\n"+
                " SELECT * FROM NhanVien;"; 
    }


}
