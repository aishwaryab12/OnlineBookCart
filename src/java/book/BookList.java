/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import db.DBController;
import java.util.ArrayList;

public class BookList 
{
    ArrayList<BookData> bookList;

    public ArrayList<BookData> getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList<BookData> bookList) {
        this.bookList = bookList;
    }
    public BookList()
    {
        bookList=new ArrayList<BookData>();
//        bookList.add(new BookData("Book_ID_001","LetUsC","Yashavant Kanetkar","1st","pub","500"));
//        bookList.add(new BookData("Book_ID_002","Harry Potter and the Philosopher's Stone","J.K.Rowling","1st","Bloomsbury Publishing","1000"));
//        bookList.add(new BookData("Book_ID_003","OCA/OCP Java SE 7 Programmer I & II ","Kathy Sierra & Bert Bates","3","pub3","700"));
//        bookList.add(new BookData("Book_ID_004","letUsc++","Yashavant k.","4","pub4","800"));
        
        DBController objofDBContoller=new DBController();
        bookList=objofDBContoller.getAllBooks();
        
    }
    
    
}
