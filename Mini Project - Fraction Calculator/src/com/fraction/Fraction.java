package com.fraction;

public class Fraction {
	protected int numerator;
	protected int denominator;
	private static int count = 0;
	public int d = 0;
	
	public void setNumerator(int n) {
		this.numerator = n;
	}
	
	public float getValue(){
		return (float) (numerator/denominator);
	}
	
	public void setDenominator(int d) throws ZeroDenominatorException{
		if (d != 0)
			denominator = d;
		else
			throw new ZeroDenominatorException("Denominator Cant be Zero");
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public Fraction() {
		this.numerator = 0;
		this.denominator = 1;
		incrementCount();
	}
	
	public Fraction(int n, int d) throws ZeroDenominatorException{
		if (d != 0) {
			this.numerator = n;
			this.denominator = d;
			incrementCount();
		}
		else {
			throw new ZeroDenominatorException("Denominator Cant be Zero, initializing denominator to 1");
		}
	}
	
	public Fraction(int n) {
		this.numerator = n;
		this.denominator = 1;
		incrementCount();
	}
	 
	public Fraction (String s) {
		int slashIndex = s.indexOf('/');
		this.numerator = Integer.parseInt(s.substring(0, slashIndex));
		this.denominator = Integer.parseInt(s.substring(slashIndex + 1));
		incrementCount();
	}
	
	public static void incrementCount() {
		count++;
	}
	
	public static void printCount() {
		System.out.println("count = " + count);
	}
	 
	public Fraction inverse() {
		Fraction f = new Fraction();
		try {
		f = new Fraction(denominator, numerator);
		}
		catch (ZeroDenominatorException zde) {
		zde.getMessage();
		}
		return f;
	}
	
	public Fraction reduce() {
		int min = (numerator < denominator) ? numerator : denominator;
		int i = 2;
		while (i <= min) {
			if (numerator % i == 0 && denominator % i == 0) {
				numerator /= i;
				denominator /= i;
			} 
			else
				++i;
		}
		Fraction f = new Fraction();
		try {
			f = new Fraction(numerator , denominator);
		}
		catch (ZeroDenominatorException zde) {
			zde.getMessage();
		}
		return f;
	}
	
	public boolean isProper() {
		if (this.numerator < this.denominator)
			return true;
		else
			return false;
	}
	
	public void print() {
		System.out.print(this.numerator + "/" + this.denominator);
	}
	
	/** This method adds two fractions and returns the sum */
	public Fraction add(Fraction second) {
		Fraction i = new Fraction();
		try {
			i = new Fraction(this.getNumerator() * second.getDenominator() + second.getNumerator() * this.getDenominator(), this.getDenominator() * second.getDenominator());
		}
		catch (ZeroDenominatorException zde) {
			zde.getMessage();
		}
		i.reduce();
		return i;
	}
	
	/** This method subtracts two fractions and returns the difference */
	public Fraction subtract(Fraction second) {
		Fraction i = new Fraction();
		try {
			i = new Fraction(this.getNumerator() * second.getDenominator() - second.getNumerator() * this.getDenominator(), this.getDenominator() * second.getDenominator());
		}
		catch (ZeroDenominatorException zde) {
			zde.getMessage();
		}
		i.reduce();
		return i;
	}
	
	public Fraction multiply(Fraction frac) {
		int n, d;
		n = this.numerator * frac.getNumerator();
		d = this.denominator * frac.getDenominator();
		Fraction i = new Fraction();
		try {
			i = new Fraction(n , d);
		}
		catch (ZeroDenominatorException zde) {
			zde.getMessage();
		}
		i.reduce();
		return i;
	}
	
	public Fraction divide(Fraction frac) {
		int n, d;
		frac = frac.inverse();
		n = this.getNumerator() * frac.getNumerator();
		d = this.getDenominator() * frac.getDenominator();
		Fraction i = new Fraction();
		try {
			i = new Fraction(n , d);
		}
		catch (ZeroDenominatorException zde) {
			zde.getMessage();
		}
		i.reduce();
		return i;
	}
}
