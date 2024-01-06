import java.util.Scanner;

public class Hamming {

	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       String str=sc.next();
       String p1="",p2="",p4="";
       String er_detection="";
       StringBuilder myName = new StringBuilder(str);
       
		for (int i = 6; i >= 0; i--) {
			if (i == 6 | i == 4 | i == 2 | i == 0) {
				p1 += str.charAt(i);
			}
		}
		for (int i = 6; i >= 0; i--) {
			if (i == 5 | i == 4 | i == 1 | i == 0) {
				p2 += str.charAt(i);
			}
		}
		for (int i = 6; i >= 0; i--) {
			if (i == 3| i == 2 | i == 1 | i == 0) {
				p4 += str.charAt(i);
			}
		}
      
       int count1=0,count2=0,count3=0,count4=0;
       for(int i=0;i<p1.length();i++) {
    	   if(p1.charAt(i)=='1') {
    		   count1++;
    	   }
       }
       for(int i=0;i<p2.length();i++) {
    	   if(p2.charAt(i)=='1') {
    		   count2++;
    	   }
       }
       for(int i=0;i<p4.length();i++) {
    	   if(p4.charAt(i)=='1') {
    		   count3++;
    	   }
       }
       if(count3%2==0) {
    	   er_detection+='0';
       }
       else {
    	   er_detection+='1';
       }
       
       if(count2%2==0) {
    	   er_detection+='0';
       }
       else {
    	   er_detection+='1';
       }
       
       if(count1%2==0) {
    	   er_detection+='0';
       }
       else {
    	   er_detection+='1';
       }
       for(int i=0;i<er_detection.length();i++) {
    	   if(er_detection.charAt(i)=='0') {
    		   count4++;
    	   }
       }
       if(count4==er_detection.length()) {
    	   System.out.println("Error free code");
       }
       else {
    	   int decimal = Integer.parseInt(er_detection, 2);
    	   System.out.println(decimal);
    	   if(str.charAt(str.length()-decimal)=='0') {
    		   myName.setCharAt(str.length()-decimal, '1');   
    	   }
    	   else
    		   myName.setCharAt(str.length()-decimal, '0');
    	   System.out.println(myName);
       }
     }
	}


