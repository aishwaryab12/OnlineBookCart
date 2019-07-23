/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import db.DBController;
import java.util.ArrayList;
import login.LoginData;

public class UserList {
    
    ArrayList <LoginData> userList;
    
    public UserList()
    {
        userList=new ArrayList<LoginData>();
//        userList.add(new LoginData("A","B"));
//        userList.add(new LoginData("ash","ash123"));
//        userList.add(new LoginData("adi","adi123"));
//        userList.add(new LoginData("swati","swati123"));
        DBController objofDBContoller=new DBController();
        userList=objofDBContoller.getusers();
        
    }

    public ArrayList<LoginData> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<LoginData> userList) {
        this.userList = userList;
    }
    
    
}
