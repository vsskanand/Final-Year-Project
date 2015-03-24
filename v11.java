

import java.io.*;

class Cipher5 
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




public class v11
{
	public static void main(String args[])
	{
		 String LetterKey = "LEARN";
		 String plainText = "{4|*{?w f7d1{8|/c6u1d.|:x+e-n'd1y0f.a)d1{7f?k\"h,b;x-i/v4n9z0y8t=y>d7~:}+~'s#e2p%u=n;q+c+s8i!v5p2h:m4g&d1u'c'j?x9}+i>d/v\"u z9s%m4w>i?n e2f5`(`8`5w a#m8i&w4g({3k q9n-h*b3k2u=t.w-}9w\"p1c6e3{.},n&l9q)k:o$f6o6~9i>m'q={2p*f,u,k#l/e-~6c.a'n\"g&g,u!v#g/{+i?q3`6)x<t#e4{:h9}6f1s\"t$r<y?o)|8j%w\"j'p4y3|5g(b;o9p;s<n4x/~:i8s;|)l.d/v2p8t$}%m/z7x3w;j=n;r9q=j(},z5s&s?m7a2k=k!r8s9q2|)|?~2d'c79v4|,d)l8t%d=3{7n,b$g+|/i c'e2k#d.b;.b*l9h)|5q&l:o+y3a&e,y5b3{+y1x+x0g-k;}(j%p7n,5b.k)y?r'}1w9q2g+|5z/h+o(i<s0c6a4~).i<m\"f.w&n!p(5~+c0q+h;h l;q\"w2g6g-x!u\"c+s v:j)z5f.f1f3{\"j=h\"a%q'r5d,|.f,5~6s)5f+}-k)x>r6a2t8<v%n<t't<m5g0f1h;m8j,i<z-o:k=r4a4x<z3p&o5`&|/f/g)|)}4|+r4r$n\"s2f.c:x2`'d-x4c2z*x0e'i%m8k2~6a&v<t%(}4g4n8{?j r5s:{36g77d7m:v=l-u9l+|.*l6t9s t\"w3a+o7d+";

//in front of any " we have to insert \ ,and the problem is if it is(\")  already present in the cipher then what  we have to do.

	     String Numberedkey="3";
		     
			Cipher5 c =new Cipher5();
		  
	String semiParialCipher=c.Keyencode(LetterKey , Integer.parseInt(Numberedkey));//caesar cipher -> OHDUQ
		     
	String partialCipher = c.VigenereDecrypt(plainText, semiParialCipher);// vigenere cipher
	
	
		     
	System.out.println("\n Final Key:     "+semiParialCipher );
	
	
	char samp = plainText.charAt(0); // First letter
		     
	System.out.println("\n EX - OR of first letter i.e :  "+samp+" and "+ Numberedkey+" we get "+samp+"\n");
	
	
		     
    //String sPartial=partialCipher;// why ??
    
    String sPartial = plainText;
    
    String Conv = Character.toString(samp); // string conversion

		     
	String res =c.operation( Conv, Numberedkey); // ex-or operation for first element in string
			
	//System.out.println("\n"+res); // Here comes P
			
	String finalCipher;
			
	System.out.println(" Final Cipher is : ");		
	for(int i=1;i<sPartial.length();i++) // ex-or operation for remaining  elements in string
			
				{
					int a=sPartial.charAt(i-1);
					
					 int b=sPartial.charAt(i);
					int d= (a)^(b); // ex-or opn
					 finalCipher = new Character((char) d).toString();
					res=res.concat(finalCipher);		
				}
				
				System.out.println(""+res+"\n");
				
		//PHSUJZH and OHDUQ vigenere decryption
				
		String finalAnswer = c.VigenereDecrypt(res, semiParialCipher);
		
		System.out.println("After doing Vigenere decryption between "+semiParialCipher+" and "+res+"\n");
		System.out.println("Final Plain Text we get is : "+finalAnswer+"\n");
			
	
		}

}