package ThongTin;

public class NhaCungCap {
	public String MaNhaCungCap;
	public String TenNhaCungCap;
	public String DiaChi;
	public String SDT;

	public NhaCungCap()
	{
		
	}
	
	public NhaCungCap(String ma,String ten, String diachi,String sdt)
	{
		this.MaNhaCungCap = ma;
		this.TenNhaCungCap = ten;
		this.DiaChi = diachi;
		this.SDT = sdt;
	}
	
	public void setMaNhaCungCap(String ma)
	{
		this.MaNhaCungCap = ma;
	}
	
	public void setTenNhaCungCap(String ten)
	{
		this.TenNhaCungCap = ten;
	}
	
	public void setDiaChi(String dc)
	{
		this.DiaChi = dc;
	}
	
	public void setSDT(String sdt)
	{
		this.SDT = sdt;
	}
	
	public String getMaNhaCungCap()
	{
		return this.MaNhaCungCap;
	}
	
	public String getTenNhaCungCap()
	{
		return this.TenNhaCungCap;
	}

	public String getDiaChi()
	{
		return this.DiaChi;
	}
	
	public String getSDT()
	{
		return this.SDT;
	}
}
