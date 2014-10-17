package be.technofutur.tableaumultiplication;

public class TableauMultiplication {

	public static void main(String[] args) {
		
		int[][] arrayInt;
		int nbr = 10; //change nbr for others result.
		int k = 1;
		
		arrayInt = new int[nbr][nbr];
		
		for(int i = 0; i < nbr; i++) {
			
			for(int j = 0; j < nbr; j++) {

				arrayInt[i][j] = j + 1;
			}
		}
		
		for(int i = 0; i < nbr; i++) {
			
			for(int j = 0; j < nbr; j++) {

				System.out.println(arrayInt[i][j] + " * " + k + " = " + (arrayInt[i][j] * k));
			}
			
			k++;
			
			System.out.println("\n");
		}
	}
}
