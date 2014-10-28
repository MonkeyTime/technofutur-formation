package be.technofutur.oopinternalanonymous;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OuterClass {

	/**
	 * Constructor
	 * 
	 */
	public OuterClass() {
		
	}
	
	public void outerMethod2(ActionListener list) {
		
	}
	
	/**
	 * outerMethod
	 * 
	 */
	public void outerMethod() {
		
		//Anonymous superclass or interface implementation with direct override if interface
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		};
		
		al.actionPerformed(null);
	}

}
