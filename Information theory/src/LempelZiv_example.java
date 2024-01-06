import java.util.LinkedList;
import java.util.Scanner;

public class LempelZiv_example {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String str1 = "";
		LinkedList<String> in = new LinkedList<>();
		LinkedList<String> in2 = new LinkedList<>();
		LinkedList<String> in3 = new LinkedList<>();
		LinkedList<Integer> in4 = new LinkedList<>();
		LinkedList<String> in5 = new LinkedList<>();
		LinkedList<String> in6 = new LinkedList<>();
		LinkedList<String> in7 = new LinkedList<>();
		in.add("0");
		in.add("1");
		for (int i = 0; i < str.length(); i++) {
			str1 += str.charAt(i);
			if (!in.contains(str1)) {
				in.add(str1);
				str1 = "";
			}
		}

		System.out.println(in);
		for (int i = 0; i < in.size(); i++) {
			String str2 = in.get(i);
			String str3 = "";
			String str4 = "";
			str4 += str2.charAt(str2.length() - 1);
			in2.add(str4);
			// System.out.print(str4 + " ");

			for (int j = 0; j < str2.length() - 1; j++) {
				str3 += str2.charAt(j);
			}

			// System.out.print(str3+" ");
			in3.add(str3);

		}
		for (int i = 0; i < in3.size(); i++) {
			if (in3.get(i) == "") {
				in3.set(i, "0");
			}
		}
		System.out.println(in2);
		System.out.println(in3);
		for (int i = 0; i < in3.size(); i++) {
			if (in.contains(in3.get(i))) {
				in4.add(in.indexOf(in3.get(i)) + 1);
			}
		}
		System.out.println(in4);
		for (int i = 0; i < in4.size(); i++) {
			in5.add(Integer.toBinaryString(in4.get(i)));
		}
		System.out.println(in5);
		for (int i = 0; i < in4.size(); i++) {
			String stra = in5.get(i);
			String strb = in2.get(i);
			if (in.get(i).length() == 1) {
				String strc = in.get(i);
				in6.add(strc);
			} else {
				String strc = in5.get(i) + in2.get(i);
				in6.add(strc);
			}
		}
		System.out.println(in6);
	}

}
