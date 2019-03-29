import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DishService dishService = new DishService();
		Scanner in;
		String input;
		
		do {
			in = new Scanner(System.in);
			
			System.out.flush();
		    
		    System.out.println("| Dish Type   | Morning        | Night  |");
			System.out.println("| 1 (entrée)  | eggs           | steak  |");
			System.out.println("| 2 (side)    | toast          | potato |");
			System.out.println("| 3 (drink)   | coffee         | wine   |");
			System.out.println("| 4 (dessert) | not applicable | cake   |");
			System.out.println("");
			System.out.print("Input: ");
			input = in.nextLine();
			
			System.out.println("");
			System.out.println("Output: " + dishService.outputBuilder(input));
			System.out.println("");
			System.out.println("");
			System.out.print("Quit (y): ");
			input = in.nextLine();
		} while (!input.equalsIgnoreCase("y"));
		
		in.close();
	}

}
