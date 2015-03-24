

import java.io.*;

class Cipher3 {
   public static String Keyencode(String enc, int offset)
    {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) 
        {
            if (Character.isLetter(i)) 
            {
                if (Character.isUpperCase(i))
                {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                } 
                else 
                {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                }
            }
            else 
            {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }
    static String VigenereEncrypt(String text, final String key) 
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) 
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
    String operation( String s1 , String k1)
   	{  
   		 int a=s1.charAt(0);
   		 int b=k1.charAt(0);
   		int c= (a)^(b);
   		String s2 = new Character((char) c).toString();
   		
   		return s2;
   	}
}




public class A1
{
	public static void main(String args[])
	{
		 String LetterKey = "LEARN";
		 String plainText = "Anand Is a Genius";
     String[] PT = plainText.split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+");
     int size = PT.length;
     String pt1;
	     String Numberedkey="3";
	     String newStr="";
       int i,j;
	     
	     for (i=0; i<size; i++)
         {  
            pt1 = PT[i];
           //Break into words
           // System.out.println(""+pt1);
            // Ascci range for a-z A-Z
           for (j=0;j<pt1.length();j++)
         { 
            if (pt1.charAt(j)>64 && pt1.charAt(j)<121)
            {
                   newStr+=pt1.charAt(j);
                   
             }
             
           System.out.println("String after filter "+newStr+" ");
         }
         
         }
	     
       //String l = "sofia, malgré tout aimait : la laitue et le choux !"; 
        //String X[] = l.split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+");

        //System.out.println(X[1]);

	     /*
	      
public class Main {
 
    public static void main(String[] args) {
        String str="gasd@!dfas%";
        String newStr="";
          for (int i=0;i<plainText.length();i++)
          {
              //Ascci range for a-z A-Z
              if (plainText.charAt(i)>64&&plainText.charAt(i)<121)
              {
                    newStr+=str.charAt(i);
                    
              }
              
              
          }
         
         System.out.println("String before filter "+str);
        System.out.println("String after filter "+newStr);
        
 
    
 
}
}*/
		     Cipher3 c =new Cipher3();
		     String semiParialCipher=c.Keyencode(LetterKey , Integer.parseInt(Numberedkey));//caesar cipher
		     
		     String partialCipher = c.VigenereEncrypt(newStr, semiParialCipher);// vigenere cipher
		     System.out.println("keyCaesar:     "+semiParialCipher );
		        System.out.println("vigeneer cipher:    "+partialCipher);
		     String sPartial=partialCipher;
		     
		     String res =c.operation( sPartial,Numberedkey); // ex-or operation for first element in string
				 
        System.out.println(""+res);
				String finalCipher,resultci="";
				for( j=1;j<sPartial.length();j++) // ex-or operation for remaining  elements in string
				{
					int a=sPartial.charAt(j);
					 int b=res.charAt(0);
					int d= (a)^(b);
					 finalCipher = new Character((char) d).toString();
					res=finalCipher;
					resultci+=finalCipher;
					}

         
				System.out.println(""+resultci);
				
		}
	}




