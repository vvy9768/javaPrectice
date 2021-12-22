package pgm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

public class ReverseStringWithSplChr {


	public static  String revStringWithoutChangePla_OfSplChar(String str) {
		char strChr []=str.toCharArray();
		int l= strChr.length-1;
		  for (int i = 0; i < l;) {
			if (isAlphabatic1(strChr[i]) && isAlphabatic1(strChr[l])) {
				char temp=strChr[i];
				strChr[i]=strChr[l];
				strChr[l]=temp;
				i++;
				l--;
				
			}
			else if(!isAlphabatic1(strChr[i])) {
				i++;
			}else if(!isAlphabatic1(strChr[l])) {
				l--;
			}
			
		}return String.valueOf(strChr);
		
	}
	public static boolean isAlphabatic1(char c) {
		if((c>=65 && c<=90) ||((c>=97 && c<=122)) ) {
			return true;
		}
		return false;
	}


	public static String reverseStringWithSplChar(String str ) {
		char ch[]=str.toCharArray();
		
		 int l= ch.length-1;
		 for (int i = 0; i < l;) {
			if(isAlphabatic(ch[i])&&(isAlphabatic(ch[l])))
			{
					       char temp=ch[i];
					           ch[i]=ch[l];
					            ch[l]=temp;
					              	i++;
					            	l--;
					   	     }
			else if(!isAlphabatic(ch[i])) {
				i++;
			}else if(!isAlphabatic(ch[l])) {
				l--;
			}
			}return String.valueOf(ch);
		}
		
	
	public static boolean isAlphabatic(char c) {
		Pattern p = Pattern.compile("[a-zA-Z]");//. represents single character 
		String str=Character.toString(c);
				Matcher m = p.matcher(str);  
		boolean b = m.matches(); 
	//	System.out.println(b);
			return b;
		}
	
	public static void revsStrWthioutChangePlcOfSplChr() {
		String str="Rahyi*&^sgf@";
		      String str1=reverseStringWithSplChar(str);
				System.out.println(str1);
				 String str2= revStringWithoutChangePla_OfSplChar(str);
			  System.out.println(str2);
	}
	
	public void reverseOfString() {
		String str= "Rahul_yadav";
		 char strChar [] =str.toCharArray();
		 for (int i = strChar.length-1; i >= 0; i--) {
		 char chr= strChar[i];
			System.out.print(chr);
		}
	}
	
	
	
	
	public void  reversrOfWord() {
		String str ="I love My India ";
        String [] strArr=str.split(" ");
        for (String ss:strArr) {	   
        for (int J = ss.length()-1;J>=0; J--) {
	     char chrArr[]=ss.toCharArray();
			System.out.print(chrArr[J]);
		}System.out.print(" ");
        }
       
        
	
	}
	public void Remove_dublicate_string() {
		
		String [] strArr= {"rahul","mahesh", "Rahul","rahul","suresh"};
		ArrayList<String> oldList= new ArrayList<String>(Arrays.asList(strArr));
		List<String> newList= new ArrayList<String>();
		
		for(String str :oldList){
			if(!newList.contains(str)) {
			newList.add(str);
			}
		}
		System.out.println(newList);
	}
	@Test
	public  String dublicate_charfrom_String() {
		String str= "VirendraKumarYadav";
		String lowStr  =str.toLowerCase();
		
		       char chrArr[]=lowStr.toCharArray();
		       int index = 0;
		       
		        // Traverse through all characters
		        for (int i = 0; i <chrArr.length; i++)
		        {
		 
		            // Check if str[i] is present before it
		            int j;
		            for (j = 0; j < i; j++)
		            {
		                if (chrArr[i] == chrArr[j])
		                {
		                    break;
		                }
		            }
		 
		            // If not present, then add it to
		            // result.
		            if (j == i)
		            {
		            	chrArr[index++] = chrArr[i];
		            }
		        }
		       

		        return String.valueOf(Arrays.copyOf(chrArr, index));
		       		    }
	
	


	
	
	public void trangle() {
		for(int i=0; i<5; i++) {
			for (int j = 4; j >=i; j--) {
				System.out.print(" ");
			}
			for(int k=0;k<=i;k++) {
				System.out.print("*"+" ");
			}
			System.out.println();
		}
	}
	
}
