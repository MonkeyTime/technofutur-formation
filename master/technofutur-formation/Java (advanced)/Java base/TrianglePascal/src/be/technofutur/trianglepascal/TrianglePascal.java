package be.technofutur.trianglepascal;

public class TrianglePascal {

	public static void main(String[] args) {
		
		for(int i = 0; i < 9; i++) {
			
			int [][]  pascal = new int[i][i + 1];
			
			for(int j = 0; j < i; j++) {
				
				pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1];
				
				System.out.println("   " + pascal[i][j] + "   ");
				
				if(i == 8) System.out.println("\n");
			}
		}
	}

}
