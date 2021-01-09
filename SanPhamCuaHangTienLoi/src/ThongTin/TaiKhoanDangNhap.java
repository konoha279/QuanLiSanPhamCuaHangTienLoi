/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongTin;

/**
 *
 * @author ASUS
 */
public class TaiKhoanDangNhap {
        public String User;
	public String Password;
        public Boolean isAdmin;
	
	public TaiKhoanDangNhap()
	{
		
	}
	
	public TaiKhoanDangNhap(String user, String password, Boolean isadmin) {
		this.User = user;
		this.Password = password;
                this.isAdmin = isadmin;
	}
	
	public void setUser(String user)
	{
		this.User = user;
	}
	
	public void setPassword(String pass)
	{
		this.Password = pass;
	}

        public Boolean getIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(Boolean isAdmin) {
            this.isAdmin = isAdmin;
        }
	
	public String getUser()
	{
		return this.User;
	}
	
	public String getPassword()
	{
		return this.Password;
	}
        
        public Boolean Login(String user, String pass)
        {
            if (this.User.equals(user) && this.Password.equals(pass))
            {
                return true;
            }
            return false;
        }
}
