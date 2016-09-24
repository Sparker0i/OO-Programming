import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;
import java.awt.event.*;

/*
 * @Project
 * Implementing a Fraction Calculator using SWING
 * Subject : Object Oriented Programming (15CSE201)
 * @author : Aaditya Menon
 * Roll Number : AM.EN.U4CSE15001 */

public class FractionCalculator extends JFrame {
	JTextField numInput, denInput;
	int a;
	Fraction temp, temp1, result;
	static Fraction m1, m2;
	int k = 1, x = 0, y = 0, z = 0;
	char ch;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, zero, clr, pow2, pow3, exp,
			fac, plus, min, div, rec, mul, eq, addSub, mr, mc, mp,
			mm, sqrt;								//Buttons
	Container cont;													//Container
	JPanel numPanel, denPanel, buttonpanel;							//Panel/Layout

	FractionCalculator() {
		cont = getContentPane();									//Layer To Hold Objects
		cont.setLayout(new BorderLayout());							//BL arranges components in Regions E , W , N , S, Center. Each region has only one component
		numPanel = new JPanel();									//Layout
		denPanel = new JPanel();
		numInput = new JTextField(25);
		numInput.setHorizontalAlignment(SwingConstants.RIGHT);		//So that the Text when typed appears from right than the left
		numInput.addKeyListener(new KeyAdapter() {					//To listen to the keyboard events
			public void keyTyped(KeyEvent keyevent) {				//To recognize which key was pressed
				char c = keyevent.getKeyChar();						//Getting Key ASCII Value
				if (c >= '0' && c <= '9') {
				} 
				else {
					keyevent.consume();								//To Ignore if any other key was pressed
				}
			}
		});
		numPanel.add(numInput);										//To add the text field to the desired panel
		denInput = new JTextField(25);
		denInput.setHorizontalAlignment(SwingConstants.RIGHT);		//So that the Text when typed appears from right than the left
		denInput.addKeyListener(new KeyAdapter() {					//To listen to the keyboard events
			public void keyTyped(KeyEvent keyevent) {				//To recognize which key was pressed
				char c = keyevent.getKeyChar();						//Getting Key ASCII Value
				if (c >= '0' && c <= '9') {
				} 
				else {
					keyevent.consume();								//To Ignore if any other key was pressed
				}
			}
		});
		TextAction action = new TextAction("")
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		            JTextComponent textField = getFocusedComponent();
		            String s = e.getActionCommand();							//The Value of s will be the text written on the button; eg. if "MR" button was clicked, the function will get the event of the variable mr, which has the text "MR"
		    		//For Buttons 1 to 9 then 0
		    			if (s.equals("1")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "1");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "1");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("2")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "2");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "2");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("3")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "3");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "3");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("4")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "4");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "4");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("5")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "5");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "5");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("6")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "6");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "6");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("7")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "7");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "7");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("8")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "8");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "8");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("9")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "9");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "9");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("0")) {
		    				if (z == 0) {
		    					textField.setText(textField.getText() + "0");
		    				} else {
		    					textField.setText("");
		    					textField.setText(textField.getText() + "0");
		    					z = 0;
		    				}
		    			}
		    			if (s.equals("AC")) {
		    				numInput.setText("");										//Clears Input Field
		    				denInput.setText("");
		    				x = 0;
		    				y = 0;
		    				z = 0;
		    			}
		    			if (s.equals("log")) {
		    				if (textField.getText().equals("")) {
		    					textField.setText("");									//If Input text is null, let it do nothing
		    				} else {
		    					a = (int) Math.log(Integer.parseInt(textField.getText()));	//Parses the String, gets its Log					
		    					textField.setText("");
		    					textField.setText(textField.getText() + a);				//Sets it back to the text input
		    				}
		    			}
		    			if (s.equals("1/x")) {
		    				if (numInput.getText().equals("") || Integer.parseInt(numInput.getText()) == 0) {						//If input text is null, this snippet doesn't care less.
		    					numInput.setText("0");
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    				}
		    				else {
		    					String s1 = numInput.getText() , s2 = denInput.getText();
		    					numInput.setText(s2);
		    					denInput.setText(s1);
		    				}
		    			}
		    			/*if (s.equals("Exp")) {
		    				if (textField.getText().equals("")) {
		    					textField.setText("");
		    				} else {
		    					a = (int) Math.exp(Integer.parseInt(textField.getText()));	//Calculates e ^ a
		    					textField.setText("");
		    					textField.setText(textField.getText() + a);				//Sets it back to the text field.
		    				}
		    			}*/
		    			if (s.equals("x^2")) {
		    				if (numInput.getText().equals("") && denInput.getText().equals("")) {
		    					numInput.setText("0");
		    					denInput.setText("1");
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    				}
		    				else {
		    					int a = Integer.parseInt(numInput.getText()) , b = Integer.parseInt(denInput.getText());
		    					numInput.setText(Integer.toString(a * a));
		    					denInput.setText(Integer.toString(b * b));
		    				}
		    			}
		    			if (s.equals("x^3")) {
		    				if (textField.getText().equals("")) {
		    					textField.setText("");
		    				} else {
		    					a = (int) Math.pow(Integer.parseInt(textField.getText()), 3);	//Parses the number, cubes it
		    					textField.setText("");
		    					textField.setText(textField.getText() + a);
		    				}
		    			}
		    			if (s.equals("+/-")) {										//I've modified this one for my purposes, look at this only if you could care less.
		    					a = Integer.parseInt(textField.getText());
		    					a *= -1;
		    					textField.setText("" + a);
		    			}
		    			/*if (s.equals(".")) {
		    				if (y == 0) {											//I don't get this completely, but I think it means if it hasn't already been done
		    					textField.setText(textField.getText() + ".");
		    					y = 1;
		    				} else {
		    					textField.setText(textField.getText());
		    				}
		    			}*/
		    			if (s.equals("+")) {
		    				/*if (textField.getText().equals("")) {						//If null, sets the addend to be 0, and the operator as +
		    					textField.setText("");
		    					temp = 0;
		    					ch = '+';
		    				}*/
		    				if (numInput.getText().equals("") && denInput.getText().equals("")) {
		    					numInput.setText("0");
		    					denInput.setText("1");
		    					temp = new Fraction(0,1);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					temp = new Fraction(0 , 1);
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(0 , 1);
		    				}
		    				else {
		    					temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
		    					numInput.setText("0");									//Sets input box empty so as to enter the next number
		    					denInput.setText("1");
		    					ch = '+';											//Sets the operator to +
		    					y = 0;												//Don't know the function of these
		    					x = 0;
		    				}
		    				textField.requestFocus();
		    			}
		    			if (s.equals("-")) {
		    				if (numInput.getText().equals("") && denInput.getText().equals("")) {
		    					numInput.setText("0");
		    					denInput.setText("1");
		    					temp = new Fraction(0,1);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					temp = new Fraction(0 , 1);
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(0 , 1);
		    				}
		    				else {
		    					temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
		    					numInput.setText("0");									//Sets input box empty so as to enter the next number
		    					denInput.setText("1");
		    					ch = '-';											//Sets the operator to +
		    					y = 0;												//Don't know the function of these
		    					x = 0;
		    				}
		    				textField.requestFocus();
		    			}
		    			if (s.equals("/")) {										//Similar to +
		    				if (numInput.getText().equals("") && denInput.getText().equals("")) {
		    					numInput.setText("0");
		    					denInput.setText("1");
		    					temp = new Fraction(0,1);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					temp = new Fraction(0 , 1);
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(0 , 1);
		    				}
		    				else {
		    					temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
		    					numInput.setText("0");									//Sets input box empty so as to enter the next number
		    					denInput.setText("1");
		    					ch = '/';											//Sets the operator to +
		    					y = 0;												//Don't know the function of these
		    					x = 0;
		    				}
		    				textField.requestFocus();
		    			}
		    			if (s.equals("*")) {										//Similar to +
		    				if (numInput.getText().equals("") && denInput.getText().equals("")) {
		    					numInput.setText("0");
		    					denInput.setText("1");
		    					temp = new Fraction(0,1);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					temp = new Fraction(0 , 1);
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(0 , 1);
		    				}
		    				else {
		    					temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
		    					numInput.setText("0");									//Sets input box empty so as to enter the next number
		    					denInput.setText("1");
		    					ch = '*';											//Sets the operator to +
		    					y = 0;												//Don't know the function of these
		    					x = 0;
		    				}
		    				textField.requestFocus();
		    			}
		    			if (s.equals("MC")) {										//Clears variable stored in memory
		    				m1 = new Fraction(0 , 1);
		    				numInput.setText("0");
		    				denInput.setText("1");
		    			}
		    			if (s.equals("MR")) {
		    				numInput.setText("");
		    				denInput.setText("");
		    				numInput.setText(numInput.getText() + m1.getNumerator());					//Retrieves variable stored in memory
		    				denInput.setText(denInput.getText() + m1.getDenominator());
		    			}
		    			if (s.equals("M+")) {
		    				if (k == 1) {
		    					m1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//No variable exists in memory, thus adds text input value to the memory
		    					k++;
		    				} else {
		    					m1 = m1.add(new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText())));			//Variable in memory exists, thus adds this value to the one in memory
		    					textField.setText("" + m1);							//Displays the new result in input field
		    				}
		    			}
		    			if (s.equals("M-")) {
		    				if (k == 1) {
		    					m1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//No variable exists in memory, thus adds this variable to the memory
		    					k++;
		    				} else {
		    					m1 = m1.subtract(new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText())));			//Variable already exists in memory, subtracts this value from the one stored in memory
		    					textField.setText("" + m1);
		    				}
		    			}
		    			if (s.equals("Sqrt")) {
		    				if (textField.getText().equals("")) {						//Doesnt care less if the text input is empty
		    					textField.setText("");
		    				} else {
		    					a = (int) Math.sqrt(Integer.parseInt(textField.getText()));	//Else calculates the square root
		    					textField.setText("");
		    					textField.setText(textField.getText() + a);
		    				}
		    			}
		    			if (s.equals("=")) {										//Does something when = button is pressed
		    				if (textField.getText().equals("")) {
		    					textField.setText("");
		    				} else {
		    					if (numInput.getText().equals("") && denInput.getText().equals("")) {
			    					temp1 = new Fraction(0,1);
			    				} 
			    				else if (numInput.getText().equals("")) {
			    					numInput.setText("0");
			    					temp1 = new Fraction(0 , 1);
			    				}
			    				else if (denInput.getText().equals("")) {
			    					denInput.setText("1");
			    					temp1 = new Fraction(0 , 1);
			    				}
			    				else {
			    					temp1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
			    				}
			    				textField.requestFocus();
		    					switch (ch) {
		    					case '+':
		    						result = temp.add(temp1);
		    						break;
		    					case '-':
		    						result = temp.subtract(temp1);
		    						break;
		    					case '/':
		    						result = temp.divide(temp1);
		    						break;
		    					case '*':
		    						result = temp.multiply(temp1);
		    						break;
		    					}
		    					numInput.setText(Integer.toString(result.getNumerator()));
		    					denInput.setText(Integer.toString(result.getDenominator()));
		    					z = 1;
		    					temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));
		    					temp1 = new Fraction(0 , 1);
		    				}
		    			}
		    			/*if (s.equals("n!")) {										//Calculates n! and puts the value in the input box
		    				if (textField.getText().equals("")) {
		    					textField.setText("");
		    				} else {
		    					a = fact(Integer.parseInt(textField.getText()));
		    					textField.setText("");
		    					textField.setText(textField.getText() + a);
		    				}
		    			}*/
		    			textField.requestFocus();
		    			}
		};
		denPanel.add(denInput);										//To add the text field to the desired panel
		buttonpanel = new JPanel();									//A New Panel For Buttons
		buttonpanel.setLayout(new GridLayout(7, 4, 2, 2));			//To arrange buttons in a rectangular grid of width 4 and height 8, with a vertical gap of 2 and horizontal gap of 2
		mr = new JButton("MR");										//Create A new Button with a label "MR"
		buttonpanel.add(mr);										//Add it to layout
		mr.addActionListener(action);									//addActionListener(action) automatically invokes actionPerformed(buttonText) {Its there below, don't be too lazy} . eg. action one invokes actionPerformed(mr)
		mc = new JButton("MC");										//Similar Procedure for all buttons
		buttonpanel.add(mc);
		mc.addActionListener(action);

		mp = new JButton("M+");
		buttonpanel.add(mp);
		mp.addActionListener(action);

		mm = new JButton("M-");
		buttonpanel.add(mm);
		mm.addActionListener(action);

		b1 = new JButton("1");
		buttonpanel.add(b1);
		b1.addActionListener(action);
		b2 = new JButton("2");
		buttonpanel.add(b2);
		b2.addActionListener(action);
		b3 = new JButton("3");
		buttonpanel.add(b3);
		b3.addActionListener(action);

		b4 = new JButton("4");
		buttonpanel.add(b4);
		b4.addActionListener(action);
		b5 = new JButton("5");
		buttonpanel.add(b5);
		b5.addActionListener(action);
		b6 = new JButton("6");
		buttonpanel.add(b6);
		b6.addActionListener(action);

		b7 = new JButton("7");
		buttonpanel.add(b7);
		b7.addActionListener(action);
		b8 = new JButton("8");
		buttonpanel.add(b8);
		b8.addActionListener(action);
		b9 = new JButton("9");
		buttonpanel.add(b9);
		b9.addActionListener(action);

		zero = new JButton("0");
		buttonpanel.add(zero);
		zero.addActionListener(action);

		plus = new JButton("+");
		buttonpanel.add(plus);
		plus.addActionListener(action);

		min = new JButton("-");
		buttonpanel.add(min);
		min.addActionListener(action);

		mul = new JButton("*");
		buttonpanel.add(mul);
		mul.addActionListener(action);

		div = new JButton("/");
		div.addActionListener(action);
		buttonpanel.add(div);

		addSub = new JButton("+/-");
		buttonpanel.add(addSub);
		addSub.addActionListener(action);

		eq = new JButton("=");
		buttonpanel.add(eq);
		eq.addActionListener(action);

		rec = new JButton("1/x");
		buttonpanel.add(rec);
		rec.addActionListener(action);
		sqrt = new JButton("Sqrt");
		buttonpanel.add(sqrt);
		sqrt.addActionListener(action);

		pow2 = new JButton("x^2");
		buttonpanel.add(pow2);
		pow2.addActionListener(action);
		pow3 = new JButton("x^3");
		buttonpanel.add(pow3);
		pow3.addActionListener(action);
		exp = new JButton("Exp");
		exp.addActionListener(action);
		buttonpanel.add(exp);
		fac = new JButton("n!");
		fac.addActionListener(action);
		buttonpanel.add(fac);

		clr = new JButton("AC");
		buttonpanel.add(clr);
		clr.addActionListener(action);
		cont.add("South", buttonpanel);								//Adds ButtonPanel to the South Region
		cont.add("Center" , denPanel);								//Adds Denominator Input Panel to Center Region
		cont.add("North", numPanel);								//Adds Numerator Panel to the North Region
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//What To Do When Close Has Been Clicked
	}

	double fact(double x) {
		if (x < 0) {
			return 0;	
		}
		double i, s = 1;
		for (i = 2; i <= x; i += 1.0)
			s *= i;
		return s;
	}

	public static void main(String args[]) {
		try {														//If the OS is Windows, the buttons and the text box will look like those you see in the Windows Operating System, else displays in the default Swing style
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
		FractionCalculator f = new FractionCalculator();
		f.setTitle("Scientific Calculator");
		f.pack();
		f.setVisible(true);
	}
}