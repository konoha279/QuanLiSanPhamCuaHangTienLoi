package ThongTin;





public class SanPham {
	public String MaSanPham;
	public String TenSanPham;
        public int SoLuong;
	public LoaiSanPham loaiSanPham;
	public DonViTinh donViTinh;
	public int Gia;
	
	public SanPham()
	{
		
	}
	
	public SanPham(String msv,String tsp,int sl, LoaiSanPham lsp, DonViTinh dvt,int gia)
	{
		this.MaSanPham = msv;
		this.TenSanPham = tsp;
                this.SoLuong =sl;
                this.loaiSanPham = lsp;
                this.donViTinh = dvt;
		this.Gia = gia;
	}

	
	public void setMaSanPham(String msv)
	{
		this.MaSanPham = msv;
	}
	
	public String getMaSanPham()
	{
		return this.MaSanPham;
	}
	
	public void setTenSanPham(String TenSanPham)
	{
		this.TenSanPham = TenSanPham;
	}
	
	public String getTenSanPham()
	{
		return this.TenSanPham;
	}
        public void setSoLuong(int sl)
	{
		this.SoLuong=sl;
	}
        public int getSoLuong()
        {
            return this.SoLuong;
        }
	public void setLoaiSanPham(LoaiSanPham loaiSP)
	{
		this.loaiSanPham = loaiSP;
	}
	
	public LoaiSanPham getLoaiSanPham()
	{
		return this.loaiSanPham;
	}

	public void setDonViTinh(DonViTinh dvt)
	{
		this.donViTinh = dvt;
	}
	
	public DonViTinh getDonViTinh() {
		return this.donViTinh;
	}

	public void setGia(int Gia)
	{
		this.Gia = Gia;
	}
	
	public int getGia() {
		return this.Gia;
		
	}

}
