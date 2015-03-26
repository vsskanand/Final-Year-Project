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




public class Pro1
{
	public static void main(String args[])
	{
		 String LetterKey = "LEARNINGISAMUSTTHINGEVERYONEMUSTDO";
		 String plainText = "The Bapatla Engineering College is one of the seven educational institutions sponsored by the Bapatla Education Society and was established in 1981 with a vision to impart quality technical education and is affiliated to Acharya Nagarjuna University. The College is a little away from the din and bustle of Bapatla, a town with a historic and hoary past, about 75 Km. south of Vijayawada on Chennai-Vijayawada rail route. The college offers B.Tech. programmes in 9 faculties of Engineering- Civil, Computer Science, Electronics and Communications, Electrical and Electronics, Electronics and Instrumentation, Mechanical which are twice AICTE-NBA accredited, Chemical Engineering, Information Technology which are accredited once and Bio-Technology. The college also offers 5 Post Graduate programmes in Communication Engineering & Signal Processing, Computer Science, Structures, Power Systems and CAD/CAM. The Bapatla Engineering College is one of the seven educational institutions sponsored by the Bapatla Education Society and was established in 1981 with a vision to impart quality technical education and is affiliated to Acharya Nagarjuna University. The College is a little away from the din and bustle of Bapatla, a town with a historic and hoary past, about 75 Km. south of Vijayawada on Chennai-Vijayawada rail route. The college offers B.Tech. programmes in 9 faculties of Engineering- Civil, Computer Science, Electronics and Communications, Electrical and Electronics, Electronics and Instrumentation, Mechanical which are twice AICTE-NBA accredited, Chemical Engineering, Information Technology which are accredited once and Bio-Technology. The college also offers 5 Post Graduate programmes in Communication Engineering & Signal Processing, Computer Science, Structures, Power Systems and CAD/CAM.";
	     String Numberedkey="26";
	     String newStr="";
	     int m=0;
	     StringBuffer sb = new StringBuffer();
	  for (int i=0;i<plainText.length();i++)
         {
             //Ascci range for a-z A-Z
             if (!(plainText.charAt(i)>64&&plainText.charAt(i)<=122))
             {
                   newStr+=plainText.charAt(i);
                  m= newStr.length();
                   
             }
             
             //System.out.println("String after filter "+newStr+m);
             
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
		     
		     String partialCipher = c.VigenereEncrypt(plainText, semiParialCipher);// vigenere cipher
		     System.out.println("keyCaesar:     "+semiParialCipher );
		        System.out.println("vigeneer cipher:    "+partialCipher);
		     String sPartial=partialCipher;
		     
		     String res =c.operation( sPartial,Numberedkey); // ex-or operation for first element in string
				System.out.println(""+res);
				String finalCipher,resultci="";
				for(int i=1;i<sPartial.length();i++) // ex-or operation for remaining  elements in string
				{
					int a=sPartial.charAt(i);
					 int b=res.charAt(0);
					int d= (a)^(b);
					 finalCipher = new Character((char) d).toString();
					res=finalCipher;
					resultci+=finalCipher;
					}
				sb.append(resultci);
		    	 int len=resultci.length();
		    	 int count=0;
		    	 for (int i=0;i<len;i++)
		    	 {
		    		int a = resultci.charAt(i);
		    	 if(a==34&&count==0)
			     {
		    		 count++;
		    		
		    		//sb.setLength(i+1);
		    		 } 
		    	 if(a==34&&count>=1)
			     {   count++;
		    		sb.insert(i+count-2, "\\");
		    		
		    		//sb.setLength(i+1);
		    		
		    } 
		    	 }
		    	 
		    	 System.out.println(sb.toString());
				
				
				
		}
	
	}