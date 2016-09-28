import com.fraction.Fraction;
import com.fraction.ZeroDenominatorException;
import com.texthint.JTextFieldHintUI;

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

/** A Fraction Calculator that implements basic operations on Fractions like Add, Subtract, Multiply, Divide and Invert */
public class FractionCalculator extends JFrame {
	JTextField numInput, denInput;
	int a;
	Fraction temp, temp1, result;
	static Fraction m1, m2;
	int k = 1, x = 0, y = 0, z = 0;
	char ch;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, clr, pow2, pow3,
			plus, min, div, rec, mul, eq, addSub, mr, mc, mp, mm;	//Buttons
	Container cont;													//Container
	JPanel numPanel, denPanel, buttonpanel;							//Panel/Layout

	/** Constructor that does all the work*/
	FractionCalculator() {
		cont = getContentPane();									//Layer To Hold Objects
		cont.setLayout(new BorderLayout());							//BL arranges components in Regions E , W , N , S, Center. Each region has only one component
		numPanel = new JPanel();									//Layout
		denPanel = new JPanel();
		numInput = new JTextField(25);
		numInput.setUI(new JTextFieldHintUI("Numerator" , Color.GRAY));	//This is completely optional for you guys out there, this is just to show a input hint. You may remove this if you don't need it
		numInput.setHorizontalAlignment(SwingConstants.RIGHT);		//So that the Text when typed appears from right than the left
		numInput.addKeyListener(new KeyAdapter() {					//To listen to the keyboard events
			public void keyTyped(KeyEvent keyevent) {				//To recognize which key was pressed
				char c = keyevent.getKeyChar();						//Getting Key ASCII Value
				if (c >= '0' && c <= '9') {
				}
				else if (c == '\n') {								//Does something when = button is pressed
    					if (numInput.getText().equals("") && denInput.getText().equals("")) {
	    					temp1 = new Fraction(0);
	    				} 
	    				else if (numInput.getText().equals("")) {
	    					numInput.setText("0");
	    					temp1 = new Fraction(0);
	    				}
	    				else if (denInput.getText().equals("")) {
	    					denInput.setText("1");
	    					temp1 = new Fraction(0);
	    				}
	    				else {
	    					try {
	    					temp1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
	    				}
	    					catch (ZeroDenominatorException zde) {
	    						JOptionPane.showMessageDialog(null,zde.getMessage());
	    						temp1 = new Fraction(Integer.parseInt(numInput.getText()));
	    					}
	    				}
	    				numInput.requestFocus();
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
    					try {
    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));	    				
    						}
	    					catch (ZeroDenominatorException zde) {
	    						JOptionPane.showMessageDialog(null,zde.getMessage());
	    						temp = new Fraction(Integer.parseInt(numInput.getText()));
	    					}
    					temp1 = new Fraction(0);
    				numInput.requestFocus();
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
				else if (c == '\n') {										//Does something when = button is pressed
    					if (numInput.getText().equals("") && denInput.getText().equals("")) {
	    					temp1 = new Fraction(0);
	    				} 
	    				else if (numInput.getText().equals("")) {
	    					numInput.setText("0");
	    					try {
	    					temp1 = new Fraction(0 , Integer.parseInt(denInput.getText())); }
	    					catch (ZeroDenominatorException zde) {
	    						JOptionPane.showMessageDialog(null, zde.getMessage());
	    					}
	    				}
	    				else if (denInput.getText().equals("")) {
	    					denInput.setText("1");
	    					temp1 = new Fraction(0);
	    				}
	    				else {
	    					try {
	    						temp1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
	    					}
	    					catch (ZeroDenominatorException zde) {
	    						JOptionPane.showMessageDialog(null, zde.getMessage());
	    						temp1 = new Fraction(0);
	    					}
	    				}
	    				numInput.requestFocus();
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
    					try {
    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText())); 
    					}
    					catch (ZeroDenominatorException zde) {
    						JOptionPane.showMessageDialog(null , zde.getMessage());
    						temp = new Fraction(Integer.parseInt(numInput.getText()));
    					}
    					temp1 = new Fraction(0);
    				denInput.requestFocus();
    			}
				else {
					keyevent.consume();								//To Ignore if any other key was pressed
				}
			}
		});
		denInput.setUI(new JTextFieldHintUI("Denominator" , Color.GRAY));
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
		    			if (s.equals("+")) {
		    				if (numInput.getText().equals("") && denInput.getText().equals("")) {
		    					numInput.setText("0");
		    					denInput.setText("1");
		    					temp = new Fraction(0);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					try {
		    						temp = new Fraction(0 , Integer.parseInt(denInput.getText())); 
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction();
		    					}
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(Integer.parseInt(numInput.getText()));
		    				}
		    				else {
		    					try {
		    					temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
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
		    					temp = new Fraction(0);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					try {
		    					temp = new Fraction(0 , Integer.parseInt(denInput.getText())); }
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null , zde.getMessage());
		    						temp = new Fraction(0);
		    					}
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(Integer.parseInt(numInput.getText()));
		    				}
		    				else {
		    					try {
		    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
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
		    					temp = new Fraction(0);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					try {
		    						temp = new Fraction(0 , Integer.parseInt(denInput.getText())); 
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    					}
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(Integer.parseInt(numInput.getText()));
		    				}
		    				else {
		    					try {
		    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
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
		    					temp = new Fraction(0);
		    				} 
		    				else if (numInput.getText().equals("")) {
		    					numInput.setText("0");
		    					try {
		    						temp = new Fraction(0 , Integer.parseInt(denInput.getText()));
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(0);
		    					}
		    				}
		    				else if (denInput.getText().equals("")) {
		    					denInput.setText("1");
		    					temp = new Fraction(Integer.parseInt(numInput.getText()));
		    				}
		    				else {
		    					try {
		    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
		    					numInput.setText("0");									//Sets input box empty so as to enter the next number
		    					denInput.setText("1");
		    					ch = '*';											//Sets the operator to +
		    					y = 0;												//Don't know the function of these
		    					x = 0;
		    				}
		    				textField.requestFocus();
		    			}
		    			if (s.equals("MC")) {										//Clears variable stored in memory
		    				m1 = new Fraction(0);
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
		    					try {
		    						m1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//No variable exists in memory, thus adds text input value to the memory
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						m1 = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
		    					k++;
		    				} 
		    				else {
		    					try {
		    						m1 = m1.add(new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText())));			//Variable in memory exists, thus adds this value to the one in memory
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						m1 = m1.add(new Fraction(Integer.parseInt(numInput.getText())));
		    					}
		    					numInput.setText("" + m1.getNumerator());							//Displays the new result in input field
		    					denInput.setText("" + m1.getDenominator());
		    				}
		    			}
		    			if (s.equals("M-")) {
		    				if (k == 1) {
		    					try {
		    						m1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//No variable exists in memory, thus adds this variable to the memory
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						m1 = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
		    					k++;
		    				} else {
		    					try {
		    						m1 = m1.subtract(new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText())));			//Variable already exists in memory, subtracts this value from the one stored in memory
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						m1 = m1.subtract(new Fraction(Integer.parseInt(numInput.getText())));
		    					}
		    					numInput.setText("" + m1.getNumerator());							//Displays the new result in input field
		    					denInput.setText("" + m1.getDenominator());
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
			    					temp1 = new Fraction(0);
			    				} 
			    				else if (numInput.getText().equals("")) {
			    					numInput.setText("0");
			    					try {
			    						temp1 = new Fraction(0 , Integer.parseInt(denInput.getText()));
			    					}
			    					catch (ZeroDenominatorException zde) {
			    						JOptionPane.showMessageDialog(null, zde.getMessage());
			    						temp1 = new Fraction(0);
			    					}
			    				}
			    				else if (denInput.getText().equals("")) {
			    					denInput.setText("1");
			    					temp1 = new Fraction(Integer.parseInt(numInput.getText()));
			    				}
			    				else {
			    					try {
			    						temp1 = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));		//Parses the number input
			    					}
			    					catch (ZeroDenominatorException zde) {
			    						JOptionPane.showMessageDialog(null, zde.getMessage());
			    						temp1 = new Fraction(Integer.parseInt(numInput.getText()));
			    					}
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
		    					try {
		    						temp = new Fraction(Integer.parseInt(numInput.getText()) , Integer.parseInt(denInput.getText()));
		    					}
		    					catch (ZeroDenominatorException zde) {
		    						JOptionPane.showMessageDialog(null, zde.getMessage());
		    						temp = new Fraction(Integer.parseInt(numInput.getText()));
		    					}
		    					temp1 = new Fraction(0);
		    				}
		    			}
		    			textField.requestFocus();
		    			}
		};
		denPanel.add(denInput);										//To add the text field to the desired panel
		buttonpanel = new JPanel();									//A New Panel For Buttons
		buttonpanel.setLayout(new GridLayout(6, 4, 2, 2));			//To arrange buttons in a rectangular grid of width 4 and height 8, with a vertical gap of 2 and horizontal gap of 2
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
		pow2 = new JButton("x^2");
		buttonpanel.add(pow2);
		pow2.addActionListener(action);

		b4 = new JButton("4");
		buttonpanel.add(b4);
		b4.addActionListener(action);
		b5 = new JButton("5");
		buttonpanel.add(b5);
		b5.addActionListener(action);
		b6 = new JButton("6");
		buttonpanel.add(b6);
		b6.addActionListener(action);
		pow3 = new JButton("x^3");
		buttonpanel.add(pow3);
		pow3.addActionListener(action);

		b7 = new JButton("7");
		buttonpanel.add(b7);
		b7.addActionListener(action);
		b8 = new JButton("8");
		buttonpanel.add(b8);
		b8.addActionListener(action);
		b9 = new JButton("9");
		buttonpanel.add(b9);
		b9.addActionListener(action);
		rec = new JButton("1/x");
		buttonpanel.add(rec);
		rec.addActionListener(action);

		addSub = new JButton("+/-");
		buttonpanel.add(addSub);
		addSub.addActionListener(action);
		b0 = new JButton("0");
		buttonpanel.add(b0);
		b0.addActionListener(action);
		
		b1.setBackground(Color.orange);b1.setContentAreaFilled(false);b1.setOpaque(true);
		b2.setBackground(Color.orange);b2.setContentAreaFilled(false);b2.setOpaque(true);
		b3.setBackground(Color.orange);b3.setContentAreaFilled(false);b3.setOpaque(true);
		b4.setBackground(Color.orange);b4.setContentAreaFilled(false);b4.setOpaque(true);
		b5.setBackground(Color.orange);b5.setContentAreaFilled(false);b5.setOpaque(true);
		b6.setBackground(Color.orange);b6.setContentAreaFilled(false);b6.setOpaque(true);
		b7.setBackground(Color.orange);b7.setContentAreaFilled(false);b7.setOpaque(true);
		b8.setBackground(Color.orange);b8.setContentAreaFilled(false);b8.setOpaque(true);
		b9.setBackground(Color.orange);b9.setContentAreaFilled(false);b9.setOpaque(true);
		b0.setBackground(Color.orange);b0.setContentAreaFilled(false);b0.setOpaque(true);
		
		mr.setBackground(Color.red);mr.setContentAreaFilled(false);mr.setOpaque(true);
		mc.setBackground(Color.red);mc.setContentAreaFilled(false);mc.setOpaque(true);
		mp.setBackground(Color.red);mp.setContentAreaFilled(false);mp.setOpaque(true);
		mm.setBackground(Color.red);mm.setContentAreaFilled(false);mm.setOpaque(true);
		
		pow2.setBackground(Color.BLUE);pow2.setContentAreaFilled(false);pow2.setOpaque(true);
		pow3.setBackground(Color.BLUE);pow3.setContentAreaFilled(false);pow3.setOpaque(true);
		rec.setBackground(Color.BLUE);rec.setContentAreaFilled(false);rec.setOpaque(true);
		addSub.setBackground(Color.BLUE);addSub.setContentAreaFilled(false);addSub.setOpaque(true);

		plus = new JButton("+");
		buttonpanel.add(plus);
		plus.addActionListener(action);

		min = new JButton("-");
		buttonpanel.add(min);
		min.addActionListener(action);
		
		clr = new JButton("AC");
		buttonpanel.add(clr);
		clr.addActionListener(action);
		eq = new JButton("=");
		buttonpanel.add(eq);
		eq.addActionListener(action);
		
		clr.setBackground(Color.CYAN);clr.setContentAreaFilled(false);clr.setOpaque(true);
		eq.setBackground(Color.CYAN);eq.setContentAreaFilled(false);eq.setOpaque(true);

		mul = new JButton("*");
		buttonpanel.add(mul);
		mul.addActionListener(action);

		div = new JButton("/");
		div.addActionListener(action);
		buttonpanel.add(div);
		
		plus.setBackground(Color.green);plus.setContentAreaFilled(false);plus.setOpaque(true);
		min.setBackground(Color.green);min.setContentAreaFilled(false);min.setOpaque(true);
		div.setBackground(Color.green);div.setContentAreaFilled(false);div.setOpaque(true);
		mul.setBackground(Color.green);mul.setContentAreaFilled(false);mul.setOpaque(true);

		cont.add("South", buttonpanel);								//Adds ButtonPanel to the South Region
		cont.add("Center" , denPanel);								//Adds Denominator Input Panel to Center Region
		cont.add("North", numPanel);								//Adds Numerator Panel to the North Region
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//What To Do When Close Has Been Clicked
	}

	public static void main(String args[]) {
		try {														//If the OS is Windows, the buttons and the text box will look like those you see in the Windows Operating System, else displays in the default Swing style
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} 
		catch (Exception e) {}
		FractionCalculator f = new FractionCalculator();
		f.setResizable(false);
		f.setTitle("Scientific Calculator");
		f.pack();
		f.setVisible(true);
	}
}
