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
public class TruyVanNhaCungCap {
    String DBname = new DBConnect().getInstance().DBname;

    public TruyVanNhaCungCap() {
    }

    public String Insert(String MaNCC,String TenNCC,String DiaChi, String SDT)
    {
        return "declare @id int;\n" 
                + "\n" +
                "insert into NhaCungCap(MaNCC,TenNCC,DiaChi,SDT) values ('"+MaNCC+"','"+ TenNCC +"','" +DiaChi+ "','"+ SDT +"');"
                + "\n" +
                "SELECT * FROM NhaCungCap";
    }
    
    public String Update(String MaNCC,String TenNCC,String DiaChi, String SDT)
    {
        return "USE "+DBname+" UPDATE NhaCungCap SET TenNCC = '"+TenNCC+"', DiaChi = '"+DiaChi+"' , SDT = '"+SDT+"' WHERE MaNCC = '"+MaNCC+"';" 
                +"\n"+
                " SELECT * FROM NhaCungCap";        
    }    
    
    public String XoaNhaCungCap(String MaNCC)
    {
        return "USE "+DBname+" DELETE FROM NhaCungCap WHERE MaNCC = '"+MaNCC+"';"
                +"\n"+
                " SELECT * FROM NhaCungCap;"; 
    }
    
    public String Update(String MaNCCCu, String MaNCCMoi)
    {
        return "USE "+DBname+" UPDATE NhaCungCap SET MaNCC = '"+MaNCCMoi+"' WHERE MaNCC = '"+MaNCCCu+"';" 
                +"\n"+
                " SELECT * FROM NhaCungCap";        
    }
    
}
