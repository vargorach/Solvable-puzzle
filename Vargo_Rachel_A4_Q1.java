/*File name: Vargo_Rachel_A4_Q1
Author: Rachel Vargo
Date: 10/16/2020
The purpose of this code is for a user to check if a puzzle is solvable.
 The main input and key variables are the start integer and the squares array. 
 The output is a string letting the user know if the puzzle is solvable. 
 To use this code the user first enters the puzzle/array size and then inputs 
 each variable in the puzzle ending with a 0 in the last spot.  
*/
package puzzle;
 import java.util.Scanner;
public class Q1 {
	
	public static void main(String[] args) {
		/* length is the length of the array. It is used heavily
		 * to check if each number entered is in the span
		 * of the squares array. It has a local scope. 
		 * It is checked to make sure it is in bounds.
		 */
		int length = 0;
		/* The input Scanner is to allow the user to input the
		 * length and the integers in the array. It has local scope.
		 * 
		 */
		Scanner input = new Scanner(System.in); 
		System.out.println ("Please enter how many squares will be in the puzzle.");
		length = input.nextInt();
		while (length < 0 || length > 9) {
			System.out.println ("Invalid number. Please reenter.");
			length = input.nextInt();
		}
		/* The squares array is a key variable and is used as the puzzle.
		 *  It has local scope and is the most important element.
		 */
		int[] squares = new int[length];
		/* The start integer is input by the user and is the starting
		 * position for the puzzle. It has local scope and is a key
		 * variable. It is checked to make sure it is in bounds.
		 */
		int start = 0;
		System.out.println ("Please enter the starting number.");
		start = input.nextInt();
		while (start < 0 || start > 9) {
			System.out.println ("Invalid number. Please reenter.");
			start = input.nextInt();
		}
		squares[0] = start;
		System.out.println("Please enter single digit positive numbers "
				+ "for each puzzle spot. Enter 0 for the last slot.");
		/* The integer num is input by the user for each variable in
		 * the array. It is checked to make sure it is in bounds and
		 * has a local scope.
		 */
		int num = 0;
		System.out.println ("");
		for (int i = 0; i < length-1; i++) {
			/* The integer j is used to add the elements to the array
			 * and makes sure to start at position 1 in the array.
			 * It has local scope.
			 */
			int j = i + 1;
			num = input.nextInt();
			while (num < 0 || num > 9) {
				System.out.println ("Invalid number. Please reenter.");
			
			}
			if (i == length - 2) {
				while (num != 0) {
					System.out.println ("The last number must be 0.");
					num = input.nextInt();
				}
			}
			squares[j] = num;
		}
		for (int i = 0; i < 50; i++) {
			System.out.print("-");
		}
		System.out.println (" ");
		if (start < length) {
			Solvable(start, squares);
		}
		else {
			System.out.println ("Puzzle is unsolvable.");
		}
		input.close();
	}
	/* The Solvable method is used to see if the puzzle/array is solvable.
	 * The arguments are the start value and the square array. It is done
	 * recursively until either the puzzle is solved with true or is deemed
	 * unsolvable with false. It returns a boolean of true or false.
	 */
	public static boolean Solvable(int start, int[] squares) {
		/* The integer end is used to check for the length of the squares
		 * array and is to keep the puzzle in bounds of the array. It has
		 * a local scope.
		 */
		int end = squares.length;
		if (start > end) {
			System.out.println ("Puzzle is unsolvable.");
			return false;
		}
		if (squares[start] == 0) {
			System.out.println ("Puzzle has been solved!");
			return true;
		}
		/* The integer left is used to see if the puzzle can move to the
		 * left. It has a local scope.
		 */
		int left = start - squares[start];
		/* The integer right is used to see if the puzzle can move to the
		 * right. It has local scope.
		 */
		int right = start + squares[start];
		if (right < end && Solvable(right, squares)) {
			return true;
		}
		if (left > 0 && Solvable(left, squares)) {
			return true;
		}
			System.out.println ("Puzzle is unsolvable.");
			return false;
	}

}
