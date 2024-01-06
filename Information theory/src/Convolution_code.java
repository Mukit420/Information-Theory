import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Convolution_code {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		LinkedList<Character> in = new LinkedList<>();
		LinkedList<Character> in1 = new LinkedList<>();
		LinkedList<String> in2 = new LinkedList<>();
		LinkedList<Integer> in3 = new LinkedList<>();
		LinkedList<Integer> in4 = new LinkedList<>();
		LinkedList<Integer> in5 = new LinkedList<>();
		LinkedList<Character> in6 = new LinkedList<>();
		for (int i = 0; i < 3; i++) {
			in.add('0');
		}
		// System.out.println(in);
		for (int i = str.length() - 1; i >= 0; i--) {
			in.add(str.charAt(i));
			// System.out.println(in);
			for (int j = in.size() - 1; j > in.size() - 4; j--) {
				in1.add(in.get(j));
			}
			 //System.out.println(in1);
			// in2.add(in1);
		}
		for (int i = 0; i < in1.size(); i += 3) {
			String str2 = "";
			for (int j = i; j < i + 3; j++) {
				str2 += in1.get(j);
			}
			in2.add(str2);
			str2 = "";
		}
		System.out.println(in2);
		int count = 0;
		for (int i = 0; i < in2.size(); i++) {
			for (int j = 0; j < in2.get(i).length(); j++) {
				if (in2.get(i).charAt(j) == '1') {
					count++;
				}
			}
			if (count % 2 == 0) {
				in3.add(0);
			} else
				in3.add(1);
			count = 0;
		}
		System.out.println(in3);
		for (int i = 0; i < in2.size(); i++) {
			for (int j = 0; j < in2.get(i).length(); j++) {
				if (in2.get(i).charAt(0) == '1') {
					count++;
				}
				if(in2.get(i).charAt(2) == '1') {
					count++;
				}
			}

			if (count % 2 == 0) {
				in4.add(0);
			} else
				in4.add(1);
			count = 0;
		}
		//System.out.println(in4);
		for (int i = 0; i < in4.size(); i++) {
			in5.add(in3.get(i));
			in5.add(in4.get(i));
		}
		System.out.println(in5);
		for (int i = 0; i < in5.size(); i++) {
			char c = (char) (in5.get(i) + '0');
			in6.add(c);
		}
		String fstr = "";
		for (int i = 0; i < in6.size(); i++) {
			fstr += in6.get(i);
		}
		System.out.println(fstr);
	}

}
