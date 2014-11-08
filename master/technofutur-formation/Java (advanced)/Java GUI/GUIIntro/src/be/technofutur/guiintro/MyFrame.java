package be.technofutur.guiintro;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5746660396637658520L;
	
	private JLabel labelResult = null;
	private JTextField txtOperand1 = null;
	private JTextField txtOperator = null;
	private JTextField txtOperand2 = null;
	
	private JButton button = null;
	private GridBagLayout appLayout = null;

	public MyFrame(String title, int width, int height, int x, int y) {
		
		super();
		this.setTitle(title);
		this.setLocation(x, y);
		this.setSize(width, height);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
		this.init();
	}
	
	public void init() {
		
		this.setLayout(this.getAppLayout());

		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx=0;
		cons.gridy=0;
		cons.fill = GridBagConstraints.HORIZONTAL;
		this.add(getTxtOperand1(), cons);

		cons.gridx=1;
		cons.gridy=0;
		cons.fill = GridBagConstraints.HORIZONTAL;
		this.add(getTxtOperator(), cons);

		cons.gridx=2;
		cons.gridy=0;
		cons.fill = GridBagConstraints.HORIZONTAL;
		this.add(getTxtOperand2(), cons);

		cons.gridx=3;
		cons.gridy=0;
		cons.fill = GridBagConstraints.HORIZONTAL;
		this.add(getLabelResult(), cons);

		cons.gridx=0;
		cons.gridy=1;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridwidth=3;
		this.add(getButton(), cons);
		
	}
	
	public JLabel getLabelResult() {
		
		if(this.labelResult == null) {
			
			this.labelResult = new JLabel("label");
			this.labelResult.setPreferredSize(new Dimension(65, 50));
		}

		return this.labelResult;
	}

	public JTextField getTxtOperand1() {
		
		if(this.txtOperand1 == null) {
			
			this.txtOperand1 = new JTextField("operand1");
			this.txtOperand1.setPreferredSize(new Dimension(130, 50));
		}
		
		return this.txtOperand1;
	}

	public JTextField getTxtOperator() {
		
		if(this.txtOperator == null) {
			
			this.txtOperator = new JTextField("operator");
			this.txtOperator.setPreferredSize(new Dimension(50, 50));
		}
		
		return this.txtOperator;
	}

	public JTextField getTxtOperand2() {
		
		if(this.txtOperand2 == null) {
			
			this.txtOperand2 = new JTextField("operand2");
			this.txtOperand2.setPreferredSize(new Dimension(130, 50));
		}
		
		return this.txtOperand2;
	}

	public JButton getButton() {
		
		if(this.button == null) {
			
			this.button = new JButton("=");
			this.button.setPreferredSize(new Dimension(130, 50));
		}

		return this.button;
	}

	public GridBagLayout getAppLayout() {
		
		if(this.appLayout == null) {
			
			this.appLayout = new GridBagLayout();
		}
		
		return this.appLayout;
	}
	
	class ComputeListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			JButton btn = (JButton) e.getSource();
			String name = btn.getText();
			System.out.println(name + " button clicked.");
			
			String op1 = MyFrame.this.txtOperand1.getText();
			String op2 = MyFrame.this.txtOperand2.getText();
			String op  = MyFrame.this.txtOperator.getText();
			
			double doubleOp1 = 0;
			double doubleOp2 = 0;
			double result = 0;
			
			try {
				
				doubleOp1 = Double.parseDouble(op1);
				doubleOp2 = Double.parseDouble(op2);
				
			} catch(NumberFormatException e1) {
				
				e1.printStackTrace();
			}
			
			switch(op) {
				
				case("+"):
					setResult(doubleOp1 + doubleOp2);
				break;
				
				case("-"):
					setResult(doubleOp1 - doubleOp2);
				break;
				
				case("*"):
					setResult(doubleOp1 * doubleOp2);
				break;
				
				case("/"):
					
					if(doubleOp2 == 0) {
						
						throw new NumberFormatException("Division par zéro !");
					}
				
					setResult(doubleOp1 / doubleOp2);
					
				break;
				
				case("%"):
					
					setResult(doubleOp1 % doubleOp2);
					
				break;
				
				default :
					setResult(0.0);
				return;
			}
			
			System.out.println(op1 + " " + op + " " + " " + op2 + " = " + result);
		}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		
		
		public double setResult(double r) {
			
			return r;
		}
	}

}
