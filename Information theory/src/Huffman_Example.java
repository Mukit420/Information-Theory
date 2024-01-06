import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman_Example{
	public static void printdata(HuffmanNode root,String str) {
		if(root.left==null&root.right==null&Character.isLetter(root.c)) {
			System.out.println(root.c+":"+str);
			return;
		}
		printdata(root.left,str+"0");
		printdata(root.right,str+"1");
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=6;
		char[]chardata= {'a','b','c','d','e','f'};
		int[]intdata= {5,9,12,13,16,45};
		
		PriorityQueue<HuffmanNode>q=new PriorityQueue<HuffmanNode>(n,new Mycomparator());
		for(int i=0;i<n;i++) {
			HuffmanNode hu=new HuffmanNode();
			hu.data=intdata[i];
			hu.c=chardata[i];
			hu.left=null;
			hu.right=null;
			q.add(hu);
		}
		HuffmanNode root=null;
		while(q.size()>1) {
			HuffmanNode x=q.peek();
			q.poll();
			HuffmanNode y=q.peek();
			q.poll();
			HuffmanNode f=new HuffmanNode();
			f.data=x.data+y.data;
			f.c='-';
			f.left=x;
			f.right=y;
			q.add(f);
			root=f;
			
			
			
		}
		printdata(root,"");
	}
}
class HuffmanNode{
	int data;
	char c;
	HuffmanNode left;
	HuffmanNode right;
}
class Mycomparator implements Comparator<HuffmanNode>{

	@Override
	public int compare(HuffmanNode x, HuffmanNode y) {
		// TODO Auto-generated method stub
		return x.data-y.data;
	}
	
}