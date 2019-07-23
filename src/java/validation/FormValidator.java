/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.ArrayList;

public class FormValidator
{
    
    public boolean isvalidaddress(String data)
    {
         
        if(data.length()>250)
        {
            return false;
        }
        for(int i=0;i<data.length();i++)
        {
           if(data.charAt(i)=='$' ||data.charAt(i)=='~' || data.charAt(i)=='`' || data.charAt(i)=='@' || data.charAt(i)=='^')
           {
               return false;
           }
        }
        return true;
        
        
    }
    // phone validation
    public boolean isValidContact(String data)
    {
        if(data.length()==13)
        {
            
            
            if(data.charAt(0)!=43)
            {
                //System.out.println("+");
                return false;
            }
            else
            {
                if(data.charAt(1)!=57 || data.charAt(2)!=49)
                {
                    //System.out.println("91");
                    return false;
                }
                else
                {
                    for(int i=3;i<data.length();i++)
                    {
                        
                        if(!(data.charAt(i)>=48 && data.charAt(i)<=57))
                        {
                            //System.out.println("no");
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        
        else if(data.length()==10)
        {
            for (int i = 0; i < data.length(); i++)
            {
                
                if(!(data.charAt(i)>=48 && data.charAt(i)<=57))
                {
                    return false;
                }
                
            }
            return true;
        }
        
        else
        {
            return false;
        }
    }
    
    
    //username validation
    
    public boolean isValidUserName(String data)
    {
        if(data.length()<=10 || data.length()>=15)
        {
            // System.out.println("len");
            return false;
        }
        int asciival;
        
        for(int i=0;i< data.length();i++)
        {
            asciival=data.charAt(i);
            if(i == 0)
            {
                if((asciival >=48 && asciival<=57))
                {
                    //System.out.println("first char number");
                    return false;
                }
            }
            
            if(asciival == 64)
            {
                //System.out.println("@");
                return false;
            }
        }
        return true;
    }
    
    //email id
    
    public boolean isValidEmailID(String data)
    {
        char[] onlyUsername=new char[20];
        
        int count=0;
        int chk=0;
        char[] test=new char[20];
        char[] test1=new char[20];
        
        if((!data.contains("@")) && !data.contains("."))
        {
            //System.out.println("@ .");
            return false;
        }
        
        for(int i=0;data.charAt(i)!='@';i++)
        {
            onlyUsername[i]=data.charAt(i);
            count++;
            
        }
        
        String passUserName=new String(onlyUsername);
        
        int i=0,j=0,dot=0;
        
        if(!(isValidUserName(passUserName.trim())))
        {
            //System.out.println("username");
            return false;
        }
        
        chk=data.charAt(count);
        
        if(chk!=64)
        {
            //System.out.println("@");
            return false;
        }
        
        
        for( i=count+1,j=0;data.charAt(i)!='.';i++)
        {
            if(!((data.charAt(i)>=0 && data.charAt(i)<=9)||(Character.isAlphabetic(data.charAt(i)))))
            {
                return false;
            }
            
            test[j]=data.charAt(i);
            j++;
        }
        
        String t=new String(test);
        String t1=t.trim();
        //System.out.println(t1);
        
        if((t1.length()<5 && t1.length()>10 ) &&(( t1.charAt(0)<'a' && t1.charAt(0)>'z')||( t1.charAt(0)<'A' && t1.charAt(0)>'Z')))
        {
            return false;
        }
        j=0;
        
        
        for(int k=i;k<data.length();k++)
        {
            test1[j]=data.charAt(k);
            j++;
        }
        
        if(test1[0]=='.' && test1[1]=='c'&&test1[2]=='o'&&test1[3]=='m')
        {
            return true;
        }
        return false;
        
    }
    
    //password
    
    public String isValidPassword(String pass)
    {
        boolean hasletter=false;
        boolean hasnumber=false;
        boolean hassymbol=false;
        ArrayList<Character> symbol=new ArrayList<Character>();
        symbol.add('@');
        symbol.add('$');
        symbol.add('!');
        symbol.add('%');
        symbol.add('^');
        symbol.add('&');
        symbol.add('*');
        symbol.add('(');
        symbol.add(')');
        symbol.add('_');
        symbol.add('+');
        symbol.add('-');
        symbol.add('/');
        symbol.add('?');
        symbol.add(':');
        symbol.add('#');
        
        
        
        if(pass.length()<10 || pass.length()>15)
        {
            return "invalid";
        }
        
        for(int i=0;i<pass.length();i++)
        {
            
            
            if(Character.isAlphabetic(pass.charAt(i)))
            {
                hasletter=true;
                //System.out.println("letter");
            }
            if(Character.isDigit(pass.charAt(i)))
            {
                hasnumber=true;
                //System.out.println("digit");
            }
            if(symbol.contains(pass.charAt(i)))
            {
                //System.out.println("symbol");
                hassymbol=true;
            }
        }
        
        if(hasletter==true && hasnumber==true && hassymbol==true)
            return "strong";
        
        else if(hasletter==true && hasnumber==true)
            return "medium";
        
        else if(hasletter==true && hassymbol==true)
            return "medium";
        
        else if(hasnumber==true && hassymbol==true)
            return "medium";
        
        
        else if(hasletter==true || hasnumber==true || hassymbol==true)
            return "weak";
        
        
        return "invalid";
        
    }
    
    //date of birth
    
    public boolean isValidDOB(String data)
    {
        int asciival[]=new int[10];
        boolean flag=false;
        
        if(data.length()!=10)
        {
            return false;
        }
        
        for(int i=0;i<data.length();i++)
        {
            asciival[i]=data.charAt(i);
        }
        
        if(asciival[2]!=45 || asciival[5]!=45)
        {
            return false;
        }
        
        if(asciival[6]!=48 && asciival[6]!=49 && asciival[6]!=50) // Y1.Y2.Y3.Y4 Y1==0,1,2
        {
            return false;
        }
        
        if(asciival[6]==48 || asciival[6]==49)  //Y1=0 or 1 then Y2,Y3,Y4= 0 TO 9
        {
            
            if((asciival[7]>=48 && asciival[7]<=57)&&(asciival[8]>=48 && asciival[8]<=57)&&(asciival[9]>=48 && asciival[9]<=57))
            {
                flag=true;
            }
            else
            {
                return false;
            }
            
        }
        
        if(asciival[6]==50) //Y1=2  THEN (Y2 0 OR 1) ( Y3 0 OR 1)
        {
            if((asciival[7]==48 || asciival[7]==49) && (asciival[8]==48 || asciival[8]==49))
            {
                flag=true;
            }
            else
            {
                return false;
            }
            
        }
        
        if(asciival[8]==48)
        {
            if(asciival[9]>=48 && asciival[9]<=57)
            {
                flag=true;
            }
            else
            {
                return false;
            }
        }
        
        if(asciival[8]==49)
        {
            if(asciival[9]>=48 && asciival[9]<=55)
            {
                flag=true;
            }
            else
            {
                return false;
            }
        }
        
        if(asciival[3]!=48 && asciival[3]!=49)
        {
            return false;
        }
        
        if(asciival[3]==48)
        {
            if(asciival[4]>=49 && asciival[4]<=57)
            {
                flag=true;
            }
            else
            {
                return false;
            }
        }
        
        if(asciival[3]==49)
        {
            if(asciival[4]==48 || asciival[4]==49 || asciival[4]==50)
            {
                flag=true;
            }
            else
            {
                return false;
            }
        }
        
        if(asciival[0]<48 || asciival[0]>51)
        {
            return false;
        }
        
        if(asciival[0]==48 || asciival[0]==49 || asciival[0]==50)
        {
            if(asciival[1]>=48 && asciival[1]<=57)
            {
                flag=true;
            }
            else
            {
                return false;
            }
        }
        
        if(asciival[0]==51)
        {
            if(asciival[1]==48 || asciival[1]==49)
            {
                flag=true;
            }
            else
            {
                return false;
            }
        }
        
        return flag;
    }
    
}
