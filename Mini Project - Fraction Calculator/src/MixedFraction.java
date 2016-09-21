public class MixedFraction extends Fraction {
	private int wholeNum;

	MixedFraction(int w , int n , int d) {
		super(n,d);
		wholeNum = w;
	}

	MixedFraction() {
		super(1,2);
		wholeNum = 1;
	}

	public void setWholeNum(int w) {
		wholeNum = w;
	}

	public int getWholeNum () {
		return wholeNum;
	}

	public void print() {
      System.out.print(wholeNum + "(");
      //System.out.print(" " + numerator + "/" + denominator);    Error if num,den are not protected
      super.print();
      System.out.println(")");
    }

    public Fraction toFraction() {
		this.setNumerator(getWholeNum() * getNumerator());
		return this;
	}

	public MixedFraction add(MixedFraction mFrac) {
		Fraction f1 = toFraction();
		Fraction f2 = mFrac.toFraction();
		Fraction sum = f1.add(f2);
		return sum.toMixedFraction();
	}

	public MixedFraction reduce() {
		MixedFraction z = this;
		if (getNumerator() > getDenominator())
		{
			z.setWholeNum(getWholeNum() + getNumerator() / getDenominator());
			z.setNumerator(getNumerator() % getDenominator());
		}
		return z;
	}

	public boolean equals(MixedFraction f) {
		MixedFraction f1 = this.reduce();
		MixedFraction f2 = f.reduce();
		if (f1.getNumerator() == f2.getDenominator() && f1.getDenominator() == f2.getDenominator() && f1.getWholeNum() == f2.getWholeNum())
			return true;
		else
			return false;
	}

  public MixedFraction subtract(MixedFraction mFrac) {
		Fraction f1 = toFraction();
		Fraction f2 = mFrac.toFraction();
		Fraction sum = f1.subtract(f2);
		return sum.toMixedFraction();
	}
}
