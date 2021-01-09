package ThongTin;

import java.sql.Date;

public class PhieuNhapHang {
        public String MaPhieuNhap;
	public String MaSanPham;
	public int SoLuongSP;
	public Date NgayLap;	
	public String CMND_NhanVien;
        public String MaNhaCungCap;
	
	public PhieuNhapHang()
	{

	}

    public PhieuNhapHang(String MaPhieuNhap, String MaSanPham, int SoLuongSP, Date NgayLap, String CMNDNhanVien, String MaNhaCungCap) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.MaSanPham = MaSanPham;
        this.SoLuongSP = SoLuongSP;
        this.NgayLap = NgayLap;
        this.CMND_NhanVien = CMNDNhanVien;
        this.MaNhaCungCap = MaNhaCungCap;
    }
	
	

    public String getMaPhieuNhap() {
        return MaPhieuNhap;
    }

    public void setMaPhieuNhap(String MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
    }


    public int getSoLuongSP() {
        return SoLuongSP;
    }

    public void setSoLuongSP(int SoLuongSP) {
        this.SoLuongSP = SoLuongSP;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getCMND_NhanVien() {
        return CMND_NhanVien;
    }

    public void setCMND_NhanVien(String CMND_NhanVien) {
        this.CMND_NhanVien = CMND_NhanVien;
    }



    public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

        
        
    
}
