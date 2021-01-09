package ThongTin;

import java.sql.Date;

public class NhanVien {
	public String TenNhanVien;
	public String NgaySinh;
	public String DiaChi;
	public String CMND;
	public String SDT;
        public Date date;
	
	public NhanVien()
	{
		
	}
	
	public NhanVien(String tenNv,String ngaySinh, String diaChi, String cmnd, String sdt )
	{
		
		this.TenNhanVien = tenNv;
		this.NgaySinh = ngaySinh;
		this.DiaChi = diaChi;
		this.CMND = cmnd;
		this.SDT = sdt;
                
	}
        public NhanVien(String tenNv,String ngaySinh, String diaChi, String cmnd, String sdt, Date date )
	{
		
		this.TenNhanVien = tenNv;
		this.NgaySinh = ngaySinh;
		this.DiaChi = diaChi;
		this.CMND = cmnd;
		this.SDT = sdt;
                this.date =date;
	}
	
	public void setTenNhanVien(String tnv)
	{
		this.TenNhanVien = tnv;
	}
	
	public void setNgaySinh(String ngaysinh)
	{
		this.NgaySinh = ngaysinh;
	}
	
	public void setDiaChi(String dc)
	{
		this.DiaChi = dc;
	}
	
	public void setCMND(String cmnd) {
		this.CMND = cmnd;
	}
	
	public void setSDT(String SDT)
	{
		this.SDT = SDT;
	}

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }
	

	
	public String getTenNhanVien()
	{
		return this.TenNhanVien;
	}
	
	public String getNgaySinh()
	{
		return this.NgaySinh;
	}
	
	public String getDiaChi()
	{
		return this.DiaChi;
	}
	
	public String getCMND()
	{
		return this.CMND;
	}
	
	public String getSDT()
	{
		return this.SDT;
	}
}
