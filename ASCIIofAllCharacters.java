/*public class ASCIIofAllCharacters {
	public static void main(String[] args) 
	{
		int i;
		
		for(i = 0; i <= 255; i++)
		{
			System.out.println(" The ASCII value of " + (char)i + "  =  " + i);
		}
	}
}*/
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;
public class ASCIIofAllCharacters {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String answer;
		int ans = -1;
		do{
			try{
				System.out.println("Obscure \n" +
						"=======" + "\n1. Make Obsure" +
						"\n2. Make readable" + "\n3. Print Obscure" +
						"\n4. Print Obscure" + "\n0. Exit");
				File fileName = new File("C:\\Users\\Jackmay\\OneDrive\\Documents\\Java projects and Assignments\\1DV506\\Cj222xq_assign4\\src\\lovecraft.txt");
				BufferedReader inputStream = null;
				//System.out.println(fileName + " statistics: ");

				try {
					inputStream = new BufferedReader(new FileReader(fileName));
				} catch (FileNotFoundException e) {
					System.out.println("Error opening the file " + fileName);
				}

				assert inputStream != null;

				String line;

				System.out.print("==> ");
				answer = sc.nextLine();
				
				ans = Integer.parseInt(answer);  
				
				/*catch(NumberFormatException e){
					System.out.println("This is not an option.");
				}*/
				if (ans == 1) {
					int d = 0;
					String file = "obscured.txt";
					PrintWriter outStream = null;
					try {
						outStream = new PrintWriter(file);
					} catch (FileNotFoundException e) {
						System.out.println("Error opening the file");
					}
					while (d <5){
						line = inputStream.readLine();
						/*while ((line = inputStream.readLine()) != null) {
							for (int a=0; a<line.length(); a++){
								char i = line.charAt(a);
								System.out.print(i+"\n");
						}
						;
							
						}*/
						assert outStream != null;
						for (int a=0; a<line.length(); a++){
								char i = line.charAt(a);
								int asci = (int) i;
								
								outStream.println((char)(asci+3));
						}
						
						
						/*for (int count : obs) {
							assert outStream != null;
							outStream.println((char)count + "\n");
						}
						
						outStream.close();*/
						
						d++;
						
					}
				}
			
			}
			catch (NumberFormatException e) {
					System.out.println("This is not an option.");
			}
		}while(ans !=0);

    }
}

/*import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.io.FileNotFoundException;


public class ObscureLovecraft {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Obscure \n"+
                "======="+ "\n1. Make Obsure"+
                "\n2. Make readable"+ "\n3. Print Obscure"+
                "\n4. Print Obscure"+ "\n0. Exit");
        File fileName = new File("C:\\Users\\Jackmay\\OneDrive\\Documents\\Java projects and Assignments\\1DV506\\Cj222xq_assign4\\src\\lovecraft.txt");
        BufferedReader inputStream = null;
        //System.out.println(fileName + " statistics: ");

        try{
            inputStream = new BufferedReader(new FileReader(fileName));
        }
        catch (FileNotFoundException e){
            System.out.println("Error opening the file " + fileName);
        }

        assert inputStream != null;

        String line;


        System.out.print("==> ");
        int ans = -1;
        try{
            ans = sc.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("This is not an option.");
        }

        if (ans == 1) {

            byte[] bytes;
            ArrayList<Byte> obs = new ArrayList<>();
            while ((line = inputStream.readLine()) != null) {
                /*for (int a=0; a<line.length(); a++) {
                    char i = line.charAt(a);
                    System.out.print(i + "\n");
                }
                bytes = line.getBytes(StandardCharsets.US_ASCII);

                for (int a = 0; a < bytes.length; a++) {
                    obs.add(a, (byte) (bytes[a] + 3));
                    //System.out.print(obs[a]+" ");
                }
            }
            String file = "obscured.txt";
            PrintWriter outStream = null;
            try {
                outStream = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                System.out.println("Error opening the file");
            }
            for (int count : obs) {
                assert outStream != null;
                outStream.println((char)count + "\n");
            }
            assert outStream != null;
            outStream.close();

        }

    }
}*/
