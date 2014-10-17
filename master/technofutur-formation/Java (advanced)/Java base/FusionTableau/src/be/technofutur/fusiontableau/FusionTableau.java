package be.technofutur.fusiontableau;
import java.util.Random;

public class FusionTableau {

	public static void main(String[] args) {
		
		int[] arr1;
		int[] arr2;
		int[] arr3;
		int randr1, randr2, nbr1, nbr2;
		
		Random Random = new Random();
		randr1 = Random.nextInt(11);
		arr1 = new int[randr1];
		randr2 = Random.nextInt(11);
		arr2 = new int[randr2];
		
			
		//populate first tab
		for(int i = 0; i < randr1; i++) {
		
			nbr1 = Random.nextInt(11);
			arr1[i] = nbr1;
		}
		
		//populate second tab
		for(int i = 0; i < randr2; i++) {
			
			nbr2 = Random.nextInt(11);
			arr2[i] = nbr2;
		}
		
		//merge arr1 and arr2 in arr3
		arr3 = new int[arr1.length + arr2.length];
		
		for(int i = 0; i < randr1; i++) {
				arr3[i] = arr1[i];
		}
		
		for(int i = randr1; i < (randr1 + randr2); i++) {
			arr3[i] = arr2[i];
		}
		
		for(int i = 0; i < arr3.length; i++) {
			
			System.out.println("key -> " + i + ", value -> " + arr3[i] + "\n");
		}
	}
}
