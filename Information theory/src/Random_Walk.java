import java.util.LinkedList;
import java.util.Scanner;

public class Random_Walk{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int vertices=sc.nextInt();
		Double[][]adjacency_matrix=new Double[vertices][vertices];
		Double[][]Stationary_matrix=new Double[vertices][vertices];
		LinkedList<Double>in=new LinkedList<>();
		LinkedList<Double>in1=new LinkedList<>();
		LinkedList<Double>in2=new LinkedList<>();
		LinkedList<Double>in3=new LinkedList<>();
		for(int row=0;row<vertices;row++) {
			double rowsum=0;
			for(int col=0;col<vertices;col++) {
				adjacency_matrix[col][row]=sc.nextDouble();
				in1.add(adjacency_matrix[col][row]);
				rowsum+=adjacency_matrix[col][row];
			}
			in.add(rowsum);
			for(int col=0;col<vertices;col++) {
				if(rowsum!=0) {
					Stationary_matrix[col][row]= (adjacency_matrix[col][row])/rowsum;
					System.out.print(Stationary_matrix[col][row]+" ");
				}
			}
			System.out.println();
		}
		System.out.println(in);
		for(int i=0;i<in1.size();i++) {
			if(in1.get(i)==0.0) {
				in1.remove(i);
			}
		}
		System.out.println(in1);
		Double sum=0.0;
		for(int i=0;i<in.size();i++) {
			sum+=in.get(i);
		}
		for(int i=0;i<in1.size();i++) {
			in2.add(in1.get(i)/sum);
		}
		System.out.println(in2);
		Double sum1=0.0;
		for(int i=0;i<in2.size();i++) {
			sum1+=in2.get(i)*(Math.log10(1/in2.get(i))*3.33);
		}
		System.out.println(sum1);
		for(int i=0;i<in.size();i++) {
			in3.add(in.get(i)/sum);
		}
		Double sum2=0.0;
		for(int i=0;i<in3.size();i++) {
			sum2+=in3.get(i)*(Math.log10(1/in3.get(i))*3.33);
		}
		System.out.println(sum2);
		System.out.println("Entropy rate:"+(sum1-sum2));
	}
}