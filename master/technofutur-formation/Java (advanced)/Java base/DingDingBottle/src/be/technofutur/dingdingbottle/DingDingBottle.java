package be.technofutur.dingdingbottle;

public class DingDingBottle {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 100; i++) {
			
			Integer test = new Integer(i);
			String str = "";
			str = test.toString();
			int total = 0;
			
			String[] strArray = str.split("");
			
			for(int j = 0; j < strArray.length; j++) {
				
				total += Integer.parseInt(strArray[j]);
			}
			
			if(i % 5 == 0 && i % 7 == 0) {
				
				System.out.println("ding-ding bottle\n");
				
			} else if (i % 5 == 0 || total == 5 || i % 10 == 5) {
				
				System.out.println("ding-ding\n");
				
			} else if (i % 7 == 0 || total == 7 || i % 10 == 7) {
				
				System.out.println("bottle\n");
				
			} else {
				
				System.out.println(i + "\n");
			}
		}
	}

}
