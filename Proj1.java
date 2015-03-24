

import java.io.*;

public class Proj1
{
  public static void main(String args[])
  {
    String str="gasd@!dfas%";
    String str2="This College is one of the few Colleges out of 570+ Engineering Colleges in Andhra Pradesh, which is accredited by the National Board of Accreditation (NBA) of the All India Council for Technical Education (AICTE), New Delhi. The six B. Tech. Courses which are accredited twice are: Civil, CSE, ECE, EEE, EIE & Mechanical. Apart from the above two more B. Tech courses viz., IT and Chemical Engineering are also accredited recently.";
        String newStr="";
          for (int i=0;i<str.length();i++)
          {
              //Ascci range for a-z A-Z
              if (str.charAt(i)>64 && str.charAt(i)<121)
              {
                    System.out.println(i);
                    newStr+=str.charAt(i);
                    
              }
              
              
          }
       
         System.out.println("String before filter \n"+str);
        System.out.println("String after filter \n"+newStr);

       // System.out.println("String before filter \n\n"+str2);
        //System.out.println("String after filter \n\n"+newStr1);
        
 
     

}

}