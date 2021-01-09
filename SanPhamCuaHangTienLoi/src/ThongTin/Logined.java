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
public class Logined {
    
    public static Logined Instance = null;
    public int idLogin;
    public String User;
    public String Pass;

    public Logined() {
    }

    public Logined(int idLogin, String User, String Pass) {
        this.idLogin = idLogin;
        this.User = User;
        this.Pass = Pass;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
   
    //singleton
    public static Logined getInstance()
    {
        if (Instance == null)
            Instance = new Logined();
        
        return Instance;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
}
