

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




public class v1
{
	public static void main(String args[])
	{
		 String LetterKey = "LEARN";
		 String pt = "Anand Is a Genius";

     String[] words = pt.split("\\s+");
      for (int i = 0; i < words.length; i++) {
    // You may want to check for a non-word character before blindly
    // performing a replacement
    // It may also be necessary to adjust the character class
      words[i] = words[i].replaceAll("[^\\w]", "");
    }
    //String plainText="";

 //Helping code

    /* String s = "This is a sample sentence.";
String[] words = s.split("\\s+");
for (int i = 0; i < words.length; i++) {
    // You may want to check for a non-word character before blindly
    // performing a replacement
    // It may also be necessary to adjust the character class
    words[i] = words[i].replaceAll("[^\\w]", "");
}
*/

	     String Numberedkey="3";
	     String newStr="";
	     
	     for (int i=0;i<pt.length();i++)
         {  
              String plainText = words[i];
             //Ascci range for a-z A-Z
             if (plainText.charAt(i)>64&&plainText.charAt(i)<121)
             {
                   newStr+=plainText.charAt(i);
                   
             }
             
             System.out.println("String after filter "+newStr);
         }
	     
	     
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
				for(int j=1;j<sPartial.length();j++) // ex-or operation for remaining  elements in string
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




