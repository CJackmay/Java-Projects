public class Conjecture{
	public static void main(String[] args){
		int n = 15;
		int count = 0;
		while (n!=1){
			System.out.print(n+" ");
			if(n% 2 ==0)
				n= n/2;
			else
				n = (3*n)+1;
			count++;
		}
		System.out.println();
		System.out.println(count);
	}
}
		