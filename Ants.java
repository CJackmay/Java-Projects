import java.util.Random;
import java.util.*;
import java.util.Arrays;

public class Ants
{
	public static void main(String[] args)
	{
		System.out.println("Ants");
		System.out.println("=====");
		int totalsum = 0;
		for (int s = 0; s < 10; s++){
			System.out.print("Number of Steps in simulation " + (s+1) +": ");
			Random rand = new Random();
			int assign = 0, count = 0;
			int[][] board = new int[8][8];
			
			for (int i = 0; i < board.length; i++){
				for (int k = 0; k < board[i].length; k++)
					board[i][k] = 0;
			}
			
			//right= 0, left = 1, down = 2, forward = 3;
			
			
			int x = rand.nextInt(8);
			int y = rand.nextInt(8);
			
			board[x][y] = 1;
			
			while (assign != 63){
				int step = rand.nextInt(4);
				//System.out.println(step);
				if (step == 0){
					if (y < 7)
						y += 1;
						if (board[x][y] != 1){
							assign ++;
						}
						board[x][y] = 1;
				}
				if (step == 1){
					if (y > 0)
						y -= 1;
						if (board[x][y] != 1){
							assign ++;
						}
						board[x][y] = 1;
				}		
				
				if (step == 2){
					if (x > 0)
						x -= 1;
						if (board[x][y] != 1){
							assign ++;
						}
						board[x][y] = 1;
				}
				
				if (step == 3){
					if (x < 7)
						x += 1;
						if (board[x][y] != 1){
							assign ++;
						}
						board[x][y] = 1;
				}
				count++;
			}
			totalsum = totalsum +count;
			System.out.print(count + "\n");
			/*System.out.println(x);
			System.out.println(y);
			//System.out.println(count);
			
			/*for (int i = 0; i < board.length; i++){
				System.out.println("");
				for (int k = 0; k < board[i].length; k++)
					//board[i][k] = 0;
					System.out.print("|" + board[i][k]);
			}*/
		}
		double average = totalsum/10;
		
		System.out.println("Average amount of steps: " + average);
		
	}
}