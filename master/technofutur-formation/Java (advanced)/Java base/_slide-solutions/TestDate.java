package be.techno.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class TestDate {

	
	public static void main(String[] args) throws ParseException   {		
		
		// Date courante
		Date date = new Date();
		//System.out.println(date);
		
		// Pour le pattern voir la javadoc de la classe
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		// Formattage de la date courante
		System.out.println(sdf.format(date));
		
	
		//sdf.setLenient(false);
		// On cr�e une nouvelle date � partir d'un string
		Date d = sdf.parse("10/13/1987 14:56:12");
		//System.out.println(d); 
		
		// R�cuperation du calendrier
		Calendar cal = Calendar.getInstance();
		//System.out.println(cal.getTime());
		
		cal.setTime(d);
		//System.out.println(cal.getTime());
		
		// R�cuperation d'un champ de la date courante
		//System.out.println(cal.get(Calendar.YEAR));
		
		// Op�ration sur la date courante
		cal.add(Calendar.YEAR, -5);
		
		//System.out.println(cal.getTime());
		
		
	}
	
}
