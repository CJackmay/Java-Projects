import java.util.Scanner;

public class Bricks
{

	//width=column, Height=row
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int width = 1;
		while (width > 0){
			System.out.print("Enter width: ");
			width = sc.nextInt();

			if (width<0){
				break;
			}
			System.out.print("Enter height: ");
			int height = sc.nextInt();

			String[][] lego = returnLego(width, height);

			for (int i = 0; i < lego.length; i++) {
				for (int k = 0; k < lego[i].length; k++)
					//lego[i][k] = 0;
					System.out.print(lego[i][k]);
				System.out.println();
			}
		}
		System.out.println("Bye!");

		sc.close();
	}

	public static String[][] returnLego(int width, int height)
	{
		String[][] brick = new String[height+2][width+2];
		brick[0][0] = "┏";
		brick[0][width+1] = "┓";
		brick[height+1][0] = "┗";
		brick[height+1][width+1] = "┛";

		for (int i = 0; i < height+2; i++){
			for (int j = 0; j < width+2; j++)
				if ((i==0 && j>0 && j<(width+1)) || (i==(height+1) && j>0 && j<(width+1))){ //check for the formation of the border of the box
					brick[i][j] = "౼";
				}
				else{
					if ( j==0 && i>0 && i<(height+1) || (j==(width+1) && i>0 && i < (height+1))){    //check for the formation of the borders of the box
						brick[i][j] = "|";
					}
					else if (i>0 && j>0 && i<height+1 && j< width+1){   //formation of dots.
						brick[i][j] = "ʘ";
					}
				}

		}
		return brick;
	}
}