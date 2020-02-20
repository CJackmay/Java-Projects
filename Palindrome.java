import java.util.Scanner;

public class Palindrome
{
	public static boolean palinCheck(String forward)
	{
		boolean render = true;
		forward = forward.trim();
		String without = forward.replaceAll("\\s", "");
	    String backward="";
		
		String res;
		res = without.toLowerCase();
	 
	    for(int i=res.length()-1; i>=0; i--)
	    	backward = backward + res.charAt(i);
	    
	    boolean check = res.equals(backward);
	    
		if (check){
	    	render = true;
			System.out.println("That was a palindrome");
		}
		else if (res.equals("stop")){
			render = false;
		}
		else{
			render = false;
			System.out.println("That wasn't a palindrome");
		}
		return render;
	}  
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		boolean stop = false;
		do{
			System.out.print("Enter a word or sentence: ");
			String start =sc.nextLine();
			palinCheck(start);
			
			stop = (start.equals("stop"));
			/*if ()
				break;*/
			
	    }while (!stop);
		sc.close();
	}
}
			