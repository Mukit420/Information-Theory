import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.Math;

public class Huffman {
	public static void printdata(HuffmanNode root, String str, LinkedList<Integer> in,
			LinkedList<Character>in2,LinkedList<String>in3) {
		if (root.left == null & root.right == null & Character.isLetter(root.c)) {
			in2.add(root.c);
			in3.add(str);
			in.add(str.length());
			return;
		}
		printdata(root.left, str + "0", in,in2,in3);
		printdata(root.right, str + "1", in,in2,in3);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 6;
		char[] chardata = new char[n];//taking character input
		for (int i = 0; i < n; i++) {
			chardata[i] = sc.next().charAt(0);
		}
		int[] intdata = new int[n];//taking integer input
		for (int i = 0; i < n; i++) {
			intdata[i] = sc.nextInt();
		}
		LinkedList<Integer> in = new LinkedList<>();
		LinkedList<Integer> in1 = new LinkedList<>();
		LinkedList<Character>in2=new LinkedList<>();
		LinkedList<String>in3=new LinkedList<String>();
		int sum1 = 0;
		for (int i = 0; i < n; i++) {
			in1.add(intdata[i]);
			sum1 += in1.get(i);
		}
		//System.out.println(sum1);
		System.out.println("Probability of corresponding character:");
		for (int i = 0; i < n; i++) {
			float n1 = (float) (in1.get(i)) / sum1;
			System.out.print(n1 + " ");//printing probability of corresponding character
		}
		System.out.println();
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new Mycomparator());
		for (int i = 0; i < n; i++) {
			HuffmanNode hu = new HuffmanNode();
			hu.data = intdata[i];
			hu.c = chardata[i];
			hu.left = null;
			hu.right = null;
			q.add(hu);
		}
		HuffmanNode root = null;
		while (q.size() > 1) {
			HuffmanNode x = q.peek();
			q.poll();
			HuffmanNode y = q.peek();
			q.poll();
			HuffmanNode f = new HuffmanNode();
			f.data = x.data + y.data;
			f.c = '-';
			f.left = x;
			f.right = y;
			q.add(f);
			root = f;

		}
		
		printdata(root, "", in,in2,in3);
		//System.out.println("Code length of each character:");
		//System.out.println(in);
		float sum = 0;
		for (int i = 0; i < in.size(); i++) {    ////checking the kraft inequality
			sum += 1 / Math.pow(2, in.get(i));
		}
		System.out.println("Kraft inequality:"+sum);
		if (sum <= 1) {
			System.out.println("Optimal");
			System.out.println("Huffman code:");
			for(int i=0;i<in2.size();i++) {
				System.out.println(in2.get(i)+":"+in3.get(i));
			}
		} else
			System.out.println("Not optimal");
	}
}

class HuffmanNode {
	int data;
	char c;
	HuffmanNode left;
	HuffmanNode right;
}

class Mycomparator implements Comparator<HuffmanNode> {

	public int compare(HuffmanNode x, HuffmanNode y) {
		return x.data - y.data;
	}

}
