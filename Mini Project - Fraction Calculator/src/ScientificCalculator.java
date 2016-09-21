import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ScientificCalculator extends JFrame implements ActionListener {
	JTextField tfield;
	double temp, temp1, result, a;
	static double m1, m2;
	int k = 1, x = 0, y = 0, z = 0;
	char ch;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, zero, clr, pow2, pow3, exp,
			fac, plus, min, div, log, rec, mul, eq, addSub, dot, mr, mc, mp,
			mm, sqrt, sin, cos, tan;					//Buttons
	Container cont;										//Container
	JPanel textPanel, buttonpanel;						//Panel/Layout

	ScientificCalculator() {
		cont = getContentPane();			//Layer To Hold Objects
		cont.setLayout(new BorderLayout());		//BL arranges components in Regions E , W , N , S, Center. Each region has only one component
		JPanel textpanel = new JPanel();		//Layout
		tfield = new JTextField(25);
		tfield.setHorizontalAlignment(SwingConstants.RIGHT);		//So that the Text when typed appears from right than the left
		tfield.addKeyListener(new KeyAdapter() {					//To listen to the keyboard events
			public void keyTyped(KeyEvent keyevent) {				//To recognize which key was pressed
				char c = keyevent.getKeyChar();						//Getting Key ASCII Value
				if (c >= '0' && c <= '9') {
				} else {
					keyevent.consume();								//To Ignore if any other key was pressed
				}
			}
		});
		textpanel.add(tfield);										//To add the text field to the desired panel
		buttonpanel = new JPanel();									//A New Panel For Buttons
		buttonpanel.setLayout(new GridLayout(8, 4, 2, 2));			//To arrange buttons in a rectangular grid of width 4 and height 8, with a vertical gap of 2 and horizontal gap of 2
		mr = new JButton("MR");										//Create A new Button with a label "MR"
		buttonpanel.add(mr);										//Add it to layout
		mr.addActionListener(this);									//addActionListener(this) automatically invokes actionPerformed(buttonText) {Its there below, don't be too lazy} . eg. this one invokes actionPerformed(mr)
		mc = new JButton("MC");										//Similar Procedure for all buttons
		buttonpanel.add(mc);
		mc.addActionListener(this);

		mp = new JButton("M+");
		buttonpanel.add(mp);
		mp.addActionListener(this);

		mm = new JButton("M-");
		buttonpanel.add(mm);
		mm.addActionListener(this);

		b1 = new JButton("1");
		buttonpanel.add(b1);
		b1.addActionListener(this);
		b2 = new JButton("2");
		buttonpanel.add(b2);
		b2.addActionListener(this);
		b3 = new JButton("3");
		buttonpanel.add(b3);
		b3.addActionListener(this);

		b4 = new JButton("4");
		buttonpanel.add(b4);
		b4.addActionListener(this);
		b5 = new JButton("5");
		buttonpanel.add(b5);
		b5.addActionListener(this);
		b6 = new JButton("6");
		buttonpanel.add(b6);
		b6.addActionListener(this);

		b7 = new JButton("7");
		buttonpanel.add(b7);
		b7.addActionListener(this);
		b8 = new JButton("8");
		buttonpanel.add(b8);
		b8.addActionListener(this);
		b9 = new JButton("9");
		buttonpanel.add(b9);
		b9.addActionListener(this);

		zero = new JButton("0");
		buttonpanel.add(zero);
		zero.addActionListener(this);

		plus = new JButton("+");
		buttonpanel.add(plus);
		plus.addActionListener(this);

		min = new JButton("-");
		buttonpanel.add(min);
		min.addActionListener(this);

		mul = new JButton("*");
		buttonpanel.add(mul);
		mul.addActionListener(this);

		div = new JButton("/");
		div.addActionListener(this);
		buttonpanel.add(div);

		addSub = new JButton("+/-");
		buttonpanel.add(addSub);
		addSub.addActionListener(this);

		dot = new JButton(".");
		buttonpanel.add(dot);
		dot.addActionListener(this);

		eq = new JButton("=");
		buttonpanel.add(eq);
		eq.addActionListener(this);

		rec = new JButton("1/x");
		buttonpanel.add(rec);
		rec.addActionListener(this);
		sqrt = new JButton("Sqrt");
		buttonpanel.add(sqrt);
		sqrt.addActionListener(this);
		log = new JButton("log");
		buttonpanel.add(log);
		log.addActionListener(this);

		sin = new JButton("SIN");
		buttonpanel.add(sin);
		sin.addActionListener(this);
		cos = new JButton("COS");
		buttonpanel.add(cos);
		cos.addActionListener(this);
		tan = new JButton("TAN");
		buttonpanel.add(tan);
		tan.addActionListener(this);
		pow2 = new JButton("x^2");
		buttonpanel.add(pow2);
		pow2.addActionListener(this);
		pow3 = new JButton("x^3");
		buttonpanel.add(pow3);
		pow3.addActionListener(this);
		exp = new JButton("Exp");
		exp.addActionListener(this);
		buttonpanel.add(exp);
		fac = new JButton("n!");
		fac.addActionListener(this);
		buttonpanel.add(fac);

		clr = new JButton("AC");
		buttonpanel.add(clr);
		clr.addActionListener(this);
		cont.add("Center", buttonpanel);							//Adds ButtonPanel to the Center Region
		cont.add("North", textpanel);								//Add Input Panel to the North Region
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//What To Do When Close Has Been Clicked
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();				//The Value of s will be the text written on the button; eg. if "MR" button was clicked, the function will get the event of the variable mr, which has the text "MR"
		//For Buttons 1 to 9 then 0
		if (s.equals("1")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "1");
			} else {
				tfield.setText("");
				tfield.setText(tfield.getText() + "1");
				z = 0;
			}
		}
		if (s.equals("2")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "2");
			} else {
				tfield.setText("");
				tfield.setText(tfield.getText() + "2");
				z = 0;
			}
		}
		if (s.equals("3")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "3");
			} else {
				tfield.setText("");
				tfield.setText(tfield.getText() + "3");
				z = 0;
			}
		}
		if (s.equals("4")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "4");
			} else {
				tfield.setText("");
				tfield.setText(tfield.getText() + "4");
				z = 0;
			}
		}
		if (s.equals("5")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "5");
			} else {
				tfield.setText("");
				tfield.setText(tfield.getText() + "5");
				z = 0;
			}
		}
		if (s.equals("6")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "6");
			} else {
				tfield.setText("");
				tfield.setText(tfield.getText() + "6");
				z = 0;
			}
		}
		if (s.equals("7")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "7");
			} else {
				tfield.setText("");
				tfield.setText(tfield.getText() + "7");
				z = 0;
			}
		}
		if (s.equals("8")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "8");
			} else {
				tfield.setText("");
				tfield.setText(tfield.getText() + "8");
				z = 0;
			}
		}
		if (s.equals("9")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "9");
			} else {
				tfield.setText("");
				tfield.setText(tfield.getText() + "9");
				z = 0;
			}
		}
		if (s.equals("0")) {
			if (z == 0) {
				tfield.setText(tfield.getText() + "0");
			} else {
				tfield.setText("");
				tfield.setText(tfield.getText() + "0");
				z = 0;
			}
		}
		if (s.equals("AC")) {
			tfield.setText("");										//Clears Input Field
			x = 0;
			y = 0;
			z = 0;
		}
		if (s.equals("log")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");									//If Input text is null, let it do nothing
			} else {
				a = Math.log(Double.parseDouble(tfield.getText()));	//Parses the String, gets its Log					
				tfield.setText("");
				tfield.setText(tfield.getText() + a);				//Sets it back to the text input
			}
		}
		if (s.equals("1/x")) {
			if (tfield.getText().equals("")) {						//If input text is null, this snippet doesn't care less.
				tfield.setText("");
			} else {
				a = 1 / Double.parseDouble(tfield.getText());		//Inverts the number after parsing it
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
		if (s.equals("Exp")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
			} else {
				a = Math.exp(Double.parseDouble(tfield.getText()));	//Calculates e ^ a
				tfield.setText("");
				tfield.setText(tfield.getText() + a);				//Sets it back to the text field.
			}
		}
		if (s.equals("x^2")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
			} else {
				a = Math.pow(Double.parseDouble(tfield.getText()), 2);	//Parses the number, squares it
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
		if (s.equals("x^3")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
			} else {
				a = Math.pow(Double.parseDouble(tfield.getText()), 3);	//Parses the number, cubes it
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
		if (s.equals("+/-")) {										//I've modified this one for my purposes, look at this only if you could care less.
				a = Double.parseDouble(tfield.getText());
				a *= -1;
				tfield.setText("" + a);
		}
		if (s.equals(".")) {
			if (y == 0) {											//I don't get this completely, but I think it means if it hasn't already been done
				tfield.setText(tfield.getText() + ".");
				y = 1;
			} else {
				tfield.setText(tfield.getText());
			}
		}
		if (s.equals("+")) {
			if (tfield.getText().equals("")) {						//If null, sets the addend to be 0
				tfield.setText("");
				temp = 0;
				ch = '+';
			} else {
				temp = Double.parseDouble(tfield.getText());
				tfield.setText("");
				ch = '+';
				y = 0;
				x = 0;
			}
			//tfield.requestFocus();
		}
		if (s.equals("-")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
				temp = 0;
				ch = '-';
			} else {
				x = 0;
				y = 0;
				temp = Double.parseDouble(tfield.getText());
				tfield.setText("");
				ch = '-';
			}
			tfield.requestFocus();
		}
		if (s.equals("/")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
				temp = 1;
				ch = '/';
			} else {
				x = 0;
				y = 0;
				temp = Double.parseDouble(tfield.getText());
				ch = '/';
				tfield.setText("");
			}
			tfield.requestFocus();
		}
		if (s.equals("*")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
				temp = 1;
				ch = '*';
			} else {
				x = 0;
				y = 0;
				temp = Double.parseDouble(tfield.getText());
				ch = '*';
				tfield.setText("");
			}
			tfield.requestFocus();
		}
		if (s.equals("MC")) {
			m1 = 0;
			tfield.setText("");
		}
		if (s.equals("MR")) {
			tfield.setText("");
			tfield.setText(tfield.getText() + m1);
		}
		if (s.equals("M+")) {
			if (k == 1) {
				m1 = Double.parseDouble(tfield.getText());
				k++;
			} else {
				m1 += Double.parseDouble(tfield.getText());
				tfield.setText("" + m1);
			}
		}
		if (s.equals("M-")) {
			if (k == 1) {
				m1 = Double.parseDouble(tfield.getText());
				k++;
			} else {
				m1 -= Double.parseDouble(tfield.getText());
				tfield.setText("" + m1);
			}
		}
		if (s.equals("Sqrt")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
			} else {
				a = Math.sqrt(Double.parseDouble(tfield.getText()));
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
		if (s.equals("SIN")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
			} else {
				a = Math.sin(Double.parseDouble(tfield.getText()));
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
		if (s.equals("COS")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
			} else {
				a = Math.cos(Double.parseDouble(tfield.getText()));
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
		if (s.equals("TAN")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
			} else {
				a = Math.tan(Double.parseDouble(tfield.getText()));
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
		if (s.equals("=")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
			} else {
				temp1 = Double.parseDouble(tfield.getText());
				switch (ch) {
				case '+':
					result = temp + temp1;
					break;
				case '-':
					result = temp - temp1;
					break;
				case '/':
					result = temp / temp1;
					break;
				case '*':
					result = temp * temp1;
					break;
				}
				tfield.setText("");
				tfield.setText(tfield.getText() + result);
				z = 1;
			}
		}
		if (s.equals("n!")) {
			if (tfield.getText().equals("")) {
				tfield.setText("");
			} else {
				a = fact(Double.parseDouble(tfield.getText()));
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
		tfield.requestFocus();
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
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
		ScientificCalculator f = new ScientificCalculator();
		f.setTitle("Scientific Calculator");
		f.pack();
		f.setVisible(true);
	}
}