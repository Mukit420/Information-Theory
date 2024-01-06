import java.util.LinkedList;
import java.util.Scanner;

public class Lempel_Ziv{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		String str1="";
		LinkedList<String>in=new LinkedList<>();
		LinkedList<String>in1=new LinkedList<>();
		LinkedList<String>in2=new LinkedList<>();
		LinkedList<Integer>in3=new LinkedList<>();
		LinkedList<String>in4=new LinkedList<>();
		LinkedList<String>in5=new LinkedList<>();
		in.add("0");
		in.add("1");
		for(int i=0;i<str.length();i++) {
			 str1+=str.charAt(i);
			if(!in.contains(str1)) {
				in.add(str1);
				str1="";
			}
			
		}
		System.out.println(in);
		for(int i=0;i<in.size();i++) {
			String str2=in.get(i);
			String str3="";
			String str4="";
			for(int j=0;j<in.get(i).length()-1;j++) {
				str4+=in.get(i).charAt(j);
			}
			in1.add(str4);
			str3+=str2.charAt(str2.length()-1);
			in2.add(str3);
		
		}
		for(int i=0;i<in1.size();i++) {
			if(in1.get(i)=="") {
				in1.set(i,"0");
			}
		}
		System.out.println(in1);
		System.out.println(in2);
		for(int i=0;i<in1.size();i++) {
			if(in.contains(in1.get(i))) {
				in3.add(in.indexOf(in1.get(i))+1);
			}
		}
		System.out.println(in3);
		for(int i=0;i<in3.size();i++) {
			in4.add(Integer.toBinaryString(in3.get(i)));
		}
		System.out.println(in4);
		for(int i=0;i<in.size();i++) {
			if(in.get(i).length()==1) {
				in5.add(in.get(i));
			}
			else {
				String stra=in4.get(i);
				String strb=in2.get(i);
				String strc=stra+strb;
				in5.add(strc);
			}
		}
		System.out.println(in5);
	}
}