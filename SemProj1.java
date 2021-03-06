

import java.io.*;

class Cipher3
{
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
    
    static String VigenereDecrypt(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
    /*
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
     }*/
    
    
    String operation( String s1 , String k1)
   	{
        int a=s1.charAt(0);
        int b=k1.charAt(0);
        int c= (a)^(b);
        String s2 = new Character((char) c).toString();
        
        return s2;
   	}
}




public class SemProj1
{
    public static void main(String args[])
    {
        char PT;
        String plainText="";
        String PT1="";
        String finalAnswer1="";
        Cipher3 c =new Cipher3();
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println(args[0] + " does not exist.");
            return;
        }
        if (!(file.isFile() && file.canRead())) {
            System.out.println(file.getName() + " cannot be read from.");
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            
            while (fis.available() > 0) {
                PT = (char) fis.read();
                PT1 = new Character((char) PT).toString();
                plainText = plainText.concat(PT1);
                
                
                
                //System.out.print(plaintText+"\n");
                String LetterKey = "ITDEPARTMENT";
                //String plainText = "c+x-g=u";
                
                String Numberedkey="470";
                
                
                String semiParialCipher=c.Keyencode(LetterKey , Integer.parseInt(Numberedkey));//caesar cipher -> OHDUQ
                
                String partialCipher = c.VigenereDecrypt(plainText, semiParialCipher);// vigenere cipher
                
                //System.out.println("\n Final Key:     "+semiParialCipher );
                
                char samp = plainText.charAt(0); // First letter
                //System.out.println("\n EX - OR of first letter i.e :  "+samp+" and "+ Numberedkey+" we get "+samp+"\n");
                
                //String sPartial=partialCipher;// why ??
                
                String sPartial = plainText;
                
                String Conv = Character.toString(samp); // string conversion
                
                
                String res =c.operation( Conv, Numberedkey); // ex-or operation for first element in string
                
                //System.out.println("\n"+res); // Here comes P
                
                String finalCipher;
                
                //System.out.println(" Final Cipher is : ");
                for(int i=1;i<sPartial.length();i++) // ex-or operation for remaining  elements in string
                    
                {
                    int a=sPartial.charAt(i-1);
                    
                    int b=sPartial.charAt(i);
                    int d= (a)^(b); // ex-or opn
                    finalCipher = new Character((char) d).toString();
                    res=res.concat(finalCipher);		
                }
                
                //System.out.println(""+res+"\n");
                
                //PHSUJZH and OHDUQ vigenere decryption
                
                String finalAnswer = c.VigenereDecrypt(res, semiParialCipher);
                
                finalAnswer1 = finalAnswer;
                //System.out.println("After doing Vigenere decryption between "+semiParialCipher+" and "+res+"\n");
                //System.out.println("Final Plain Text we get is : "+finalAnswer+"\n");
                
            }
            System.out.println("\n\n\n Final Plain Text we get is : "+finalAnswer1+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}