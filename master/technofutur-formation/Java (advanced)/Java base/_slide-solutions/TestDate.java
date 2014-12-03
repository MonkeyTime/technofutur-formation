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
		// On crée une nouvelle date à partir d'un string
		Date d = sdf.parse("10/13/1987 14:56:12");
		//System.out.println(d); 
		
		// Récuperation du calendrier
		Calendar cal = Calendar.getInstance();
		//System.out.println(cal.getTime());
		
		cal.setTime(d);
		//System.out.println(cal.getTime());
		
		// Récuperation d'un champ de la date courante
		//System.out.println(cal.get(Calendar.YEAR));
		
		// Opération sur la date courante
		cal.add(Calendar.YEAR, -5);
		
		//System.out.println(cal.getTime());
		
		
	}
	
}
