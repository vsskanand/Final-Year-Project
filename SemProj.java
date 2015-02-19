

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




public class SemProj
{
	public static void main(String args[])
	{
		 String LetterKey = "LEARN";
		 String plainText = "BAPATLA BAPATLA BAPATLA";
		 
		 
	     String Numberedkey="3";
		     Cipher3 c =new Cipher3();
		     String semiParialCipher=c.Keyencode(LetterKey , Integer.parseInt(Numberedkey));//caesar cipher
		     
		     String partialCipher = c.VigenereEncrypt(plainText, semiParialCipher);// vigenere cipher
		     System.out.println("keyCaesar:     "+semiParialCipher );
		        System.out.println("vigeneer cipher:    "+partialCipher);
		     String sPartial=partialCipher;
		     
		     String res =c.operation( sPartial,Numberedkey); // ex-or operation for first element in string
				
				System.out.println(""+res);
				String FinalAnswer=res;
				
				String finalCipher;
				for(int i=1;i<sPartial.length();i++) // ex-or operation for remaining  elements in string
				{
					int a=sPartial.charAt(i);
					 int b=res.charAt(0);
					int d= (a)^(b); // ex-or opn
					 finalCipher = new Character((char) d).toString();
					//res=res.concat(finalCipher);
					res=finalCipher;
					//res=res.concat(finalCipher);
					
					//System.out.println(""+finalCipher);
					FinalAnswer = FinalAnswer.concat(finalCipher);
					
					
				}
				System.out.println(""+FinalAnswer);
		}

}