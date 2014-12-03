package be.wvn.swing.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblResult;
	private JTextField txtOperand1;
	private JTextField txtOperator;
	private JTextField txtOperand2;
	
	private JButton btCompute;
	
	private GridBagLayout gl;
	
	public MyFrame(String title, int width, int height, int x, int y) {
		super();
		this.setTitle(title);
		this.setLocation(x, y);
		this.setSize(width, height);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		init();
		
		this.setVisible(true);
		this.pack();
	}
	
	public void init() {
		this.setLayout(getGl());

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
		this.add(getLblResult(), cons);

		cons.gridx=0;
		cons.gridy=1;
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridwidth=3;
		this.add(getBtCompute(), cons);

	}
	
	public JLabel getLblResult() {
		if(lblResult==null) {
			lblResult = new JLabel("0");
			lblResult.setPreferredSize(new Dimension(50,25));
		}
		return lblResult;
	}

	public JTextField getTxtOperand1() {
		if(txtOperand1==null) {
			txtOperand1 = new JTextField();
			txtOperand1.setPreferredSize(new Dimension(100, 25));
		}
		return txtOperand1;
	}

	public JTextField getTxtOperator() {
		if(txtOperator==null) {
			txtOperator = new JTextField();
			txtOperator.setPreferredSize(new Dimension(40, 25));
		}
		return txtOperator;
	}

	public JTextField getTxtOperand2() {
		if(txtOperand2==null) {
			txtOperand2 = new JTextField();
			txtOperand2.setPreferredSize(new Dimension(100, 25));
		}
		return txtOperand2;
	}

	public JButton getBtCompute() {
		if(btCompute==null) {
			btCompute = new JButton("Compute!");
			btCompute.setPreferredSize(new Dimension(100, 25));
			
			btCompute.addMouseListener(new ComputeListener());
		}
		return btCompute;
	}

	public GridBagLayout getGl() {
		if(gl==null) {
			gl = new GridBagLayout();
		}
		return gl;
	}
	
	class ComputeListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			JButton bt = (JButton) event.getSource();
			String btName = bt.getText();
			System.out.println(btName + " button clicked!");
			
			String operand1Str = getTxtOperand1().getText();
			String operand2Str = getTxtOperand2().getText();
			String operatorStr = getTxtOperator().getText();
			
			System.out.println("Compute : " + operand1Str + operatorStr + operand2Str);
			
			Double operand1 = 0.;
			Double operand2 = 0.;
			try {
				operand1 = Double.parseDouble(operand1Str);
				operand2 = Double.parseDouble(operand2Str);
				System.out.println("Operands valid");
			}
			catch(NumberFormatException exception) {
				System.out.println("Operands invalid");
				setResult(0.);
				return;
			}
			
			switch(operatorStr) {
				case "+":
					setResult(operand1+operand2);
					break;
				case "-":
					setResult(operand1-operand2);
					break;
				case "*":
					setResult(operand1*operand2);
					break;
				case "/":
					setResult(operand1/operand2);
					break;
				case "%":
					setResult(operand1%operand2);
					break;
				default:
					System.out.println("Operator invalid");
					setResult(0.);
					return;
			}
			
		}
		
		public void setResult(Double result) {
			getLblResult().setText(result.toString());
		}

		@Override
		public void mouseEntered(MouseEvent e) { }
		@Override
		public void mouseExited(MouseEvent e) { }
		@Override
		public void mousePressed(MouseEvent e) { }
		@Override
		public void mouseReleased(MouseEvent e) { }
		
	}
	
}
