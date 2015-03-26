

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
		 String LetterKey = "LEARNINGISAMUSTTHINGEVERYONEMUSTDO";
		 String plainText = "w;~-c;u/{(m7v7p(d>h<w/|?u&r;n#d#k(y!i?y4}6`7s4c0}?i?q#n'p;|4|$q8~2d z({=x5d,k'o>h;r&g3}6~.i;i>|.k\"w5}5:t!k\"d/n\"c-k*f'k'q%d x!x2d3f/i$v!y-l%b;s4`!u>p'q0e4d#s)a-l#d)h s4s$`%c4b6`'e2v0y*|=u/c$v k9i1y+f)o-t'd3z1}?j!j-a9`9a#y0i&~1a7n%k(z6q7`6f.g\"l:k#`+'~9`5}%k1a7r9t?~?j$~*a6r*e,z1+g=r?s\"k?e'i!r\"z8s4v/i+l5l;n+r j#r5b$g3j,k?o+}-h<y7n<r$i*n%w>{2f?m&d6b5r#j2k3j+d>w/c$t7c5x?z\"t#z0q%m9~1|7x*s5o-x5g?r;p$c)/`)l%}5e3`4b/n'j=q w;p8m<l5p9q%h)s*p3f2e2h:i?f+{!{:y4r!f1}){2j't1v'a(p)|1d'~3p:t\"s<j!u1~;c$e,k$w>o9x.`2g0c&|*~9q#f+l/~+n#`5x u?q6q))k<{2b5o7g0~;w!`/y-`7e0x!c$i>{(m\"o)e-8l$c&t!k*b8h8v.c0s<p'p2s>o:h0y+g5z7v8o9r0j:u-a#v=v1}%|%})z;y,f'n'v2p'a j>y0|$a&c4`8q4y(e$c5c6l-;|.|+i;j\"{9h;k=t1e$r?i:v4x?i1k*|(c;h,b+l%a,y;s16e.k(x\"a+n+a&v.w6z#{!p:c!p7z\"w#s;h!c1r;|.g0~-n(p(q a,k!q2q$v;~7q){/j&c){?m9t\"w8m!c+~7n!s=e?m$c.o'l s0i>q8j&i,n4q?j\"v;h!s9`8}6q2s$e2s+|1}/k%k*x!c0r*i\"c;p!`#n!m?k<z7v>r:v7v3a*n-c1`,u3j?~9i\"l>w.w#z2d7m8~)e\"n$b8a0~$i?k**k?f!o;~<y0x1p5r:{4|:~3g7p r;l(d5t#a-e1g=e\"k9l#o%a(m k8w:t&g+d%d(d5|$q%r;|.k=e#v4~3u7d%i.k8j0`)h\"r5t0c+3r;t!x7x<m.f>j#{4x l/n n\"l9o:r#k-y;x)~9z,m?}2w2g!k#{3c;s%u\"{)d=x9c;c(r84s0d-`5p5l+|0|>o*i%|>h#b%c2z#a&j'b-=z t#z=|;s=j9z-n4f0`+f\"g(f,d#s8~9k2u3x9q#v!r?s0i>{8j!f>o:{#v0g?l!q+}7e?~9k;j=q:h*~9j8y5c7v:h/h?x5}?i<n&o;}2s>q$`0{,b.o&t6|3x/n;l x?v?q82{.i!s;t6a'k:v&c&r#b)d.g=|=z#u/u2j.}8j9i%6r:p=u9p$q8}6*i-t\"`-a-o;|&c&d4b1w.{:k(,k;|,~7`$h9x/{>d3q=w-{1<z\"q=n9a.k\"r;y6s4a$a$g!w?k>v\"o7r9~=|5o.o(`3p=s+m<h<u1a%l9a-w&g*m'v1b*x.k<}%t%u\"v?w<{:`7d&o x3i.h2{3d6z(x=m:i/";

        //in front of any " we have to insert \ ,and the problem is if it is(\")  already present in the cipher then what  we have to do.

	     String Numberedkey="26";
		     
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