/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

public class LoginData 
{
    String userName;
    String password;
    
    public LoginData()
    {
        
    }
    public LoginData(String userName,String password)
    {
       this.userName=userName;
       this.password=password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
