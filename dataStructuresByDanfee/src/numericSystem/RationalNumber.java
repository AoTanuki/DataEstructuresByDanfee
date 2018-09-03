package numericSystem;

public class RationalNumber<E extends Number> implements IRationalNumber<RationalNumber<E>> {

	private E numerator;
	private E denominator;

	public RationalNumber(E numerator, E denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
		simplifyRational();
	}

	// 0= ninguno ; 1=short ; 2=integer ; 3=long
	private char numberType(E number) {
		char numberType = '0';

		if (number instanceof Short)
			numberType = '1';

		if (number instanceof Integer)
			numberType = '2';

		if (number instanceof Long)
			numberType = '3';

		return numberType;
	}

	private boolean isDenominatorZero() {
		boolean isZero = false;
		char denominatorNumberType = numberType(denominator);

		switch (denominatorNumberType) {
		case '1':
			if (this.denominator.shortValue() == 0)
				isZero = true;
			break;

		case '2':
			if (this.denominator.intValue() == 0)
				isZero = true;
			break;

		case '3':
			if (this.denominator.longValue() == 0)
				isZero = true;
			break;
		}

		return isZero;
	}

	private boolean isNumeratorZero() {
		boolean isZero = false;
		char denominatorNumberType = numberType(numerator);

		switch (denominatorNumberType) {
		case '1':
			if (this.numerator.shortValue() == 0)
				isZero = true;
			break;

		case '2':
			if (this.numerator.intValue() == 0)
				isZero = true;
			break;

		case '3':
			if (this.numerator.longValue() == 0)
				isZero = true;
			break;
		}

		return isZero;
	}

	// https://en.wikipedia.org/wiki/Greatest_common_divisor#Using_Euclid's_algorithm
	private Number euclidsAlgorithm(Number number1, Number number2) {
		if (number1 instanceof Long && number2 instanceof Long) {
			if (number2.floatValue() == 0)
				return number1;
			else
				return euclidsAlgorithm(number2, new Long(number1.longValue() % number2.longValue()));
		} else if (number1 instanceof Integer && number2 instanceof Integer) {

			if (number2.intValue() == 0)
				return number1;
			else
				return euclidsAlgorithm(number2, new Integer(number1.intValue() % number2.intValue()));
		} else {

			if (number2.shortValue() == 0)
				return number1;
			else
				return euclidsAlgorithm(number2, new Short((short) (number1.shortValue() % number2.shortValue())));
		}

	}
	
	public E multiplyNumbers(E number1, E number2)
	{
		E factor = null;
		char number1Type = numberType(number1);
		char number2Type = numberType(number2);
		
		if(number1Type == '1' || number2Type == '1')
		{
			short factorValue = (short) (number1.shortValue() * number2.shortValue());
			factor = (E) new Short(factorValue);
		}else if(number1Type == '2' || number2Type == '2') {
			int factorValue = number1.intValue()*number2.intValue();
			factor = (E) new Integer(factorValue);
		}else if(number1Type == '3' || number2Type == '3') {
			long factorValue = number1.longValue()*number2.longValue();
			factor = (E) new Long(factorValue);
		}
		return factor;
	}

	public E addNumbers(E number1, E number2)
	{
		E factor = null;
		char number1Type = numberType(number1);
		char number2Type = numberType(number2);
		
		if(number1Type == '1' || number2Type == '1')
		{
			short factorValue = (short) (number1.shortValue() + number2.shortValue());
			factor = (E) new Short(factorValue);
		}else if(number1Type == '2' || number2Type == '2') {
			int factorValue = number1.intValue()+number2.intValue();
			factor = (E) new Integer(factorValue);
		}else if(number1Type == '3' || number2Type == '3') {
			long factorValue = number1.longValue()+number2.longValue();
			factor = (E) new Long(factorValue);
		}
		return factor;
	}
	
	private E squareNumber(E number) {
		E squareNumber = null;

		if (number instanceof Short)
			squareNumber = (E) new Short((short) Math.pow((double)number.shortValue(),2));

		if (number instanceof Integer)
			squareNumber = (E) new Integer((int) Math.pow((double)number.intValue(),2));

		if (number instanceof Long)
			squareNumber = (E) new Long((long) Math.pow((double) number.shortValue(),2));

		return squareNumber;
	}

	
	public E substractNumbers(E number1, E number2)
	{
		E factor = null;
		char number1Type = numberType(number1);
		char number2Type = numberType(number2);
		
		if(number1Type == '1' || number2Type == '1')
		{
			short factorValue = (short) (number1.shortValue() - number2.shortValue());
			factor = (E) new Short(factorValue);
		}else if(number1Type == '2' || number2Type == '2') {
			int factorValue = number1.intValue() - number2.intValue();
			factor = (E) new Integer(factorValue);
		}else if(number1Type == '3' || number2Type == '3') {
			long factorValue = number1.longValue() - number2.longValue();
			factor = (E) new Long(factorValue);
		}
		return factor;
	}
	
	
	@Override
	public void addRational(RationalNumber<E> rationalToBeAdded) {
				
		E factor1 = multiplyNumbers(this.numerator, (E) rationalToBeAdded.getDenominator());
		E factor2 = multiplyNumbers((E) rationalToBeAdded.getNumerator(), this.denominator);
		
		this.numerator = addNumbers( factor1, factor2);
		this.denominator = multiplyNumbers(this.denominator, (E) rationalToBeAdded.getDenominator());
		
		simplifyRational();
	}

	@Override
	public void substractRational(RationalNumber<E> rationalToBeSubstracted) {
		
		E factor1 = multiplyNumbers(this.numerator, (E) rationalToBeSubstracted.getDenominator());
		E factor2 = multiplyNumbers((E) rationalToBeSubstracted.getNumerator(), this.denominator);
		
		this.numerator = substractNumbers( factor1, factor2);
		this.denominator = multiplyNumbers(this.denominator, (E) rationalToBeSubstracted.getDenominator());
		simplifyRational();
	}

	@Override
	public void multiplyRational(RationalNumber<E> rationalFactor) {
		
		this.numerator = multiplyNumbers( this.numerator, (E) rationalFactor.getNumerator());
		this.denominator = multiplyNumbers(this.denominator, (E)rationalFactor.getDenominator());
		
		simplifyRational();
	}

	@Override
	public void divideRational(RationalNumber<E> rationalQuocient) {
		
		this.numerator = multiplyNumbers( this.numerator,(E)rationalQuocient.getDenominator() );
		this.denominator = multiplyNumbers(this.denominator,(E) rationalQuocient.getNumerator() );
		
		simplifyRational();
	}

	@Override
	public void simplifyRational() {
	

		if (!isDenominatorZero()) {

			char numeratorNumberType = numberType(this.numerator);
			char denominatorNumberType = numberType(this.denominator);

			// LONG
			if (numeratorNumberType == '3' || denominatorNumberType == '3') {
				long numeratorVal = this.numerator.longValue();
				long denominatorVal = this.denominator.longValue();

				if (numeratorVal == denominatorVal) {
					this.numerator = (E) new Long(1);
					this.denominator = (E) new Long(1);

					if (numeratorVal < 0) {
						this.numerator = (E) new Long(-1);
					} else if (denominatorVal < 0) {
						this.denominator = (E) new Long(-1);
					}
				} else {

					long gcd = Math.abs(euclidsAlgorithm(this.numerator, this.denominator).longValue());
					this.numerator = (E) new Long(numeratorVal / gcd);
					this.denominator = (E) new Long(denominatorVal / gcd);
				}
			}

			// Integer
			else if (numeratorNumberType == '2' || denominatorNumberType == '2') {

				int numeratorVal = this.numerator.intValue();
				int denominatorVal = this.denominator.intValue();

				if (numeratorVal == denominatorVal) {
					this.numerator = (E) new Integer(1);
					this.denominator = (E) new Integer(1);

					if (numeratorVal < 0) {
						this.numerator = (E) new Integer(-1);
					} else if (denominatorVal < 0) {
						this.denominator = (E) new Integer(-1);
					}
				} else {

					int gcd = Math.abs(euclidsAlgorithm(this.numerator, this.denominator).intValue());
					this.numerator = (E) new Integer(numeratorVal / gcd);
					this.denominator = (E) new Integer(denominatorVal / gcd);
				}

			}
			// Short
			else if (numeratorNumberType == '1' || denominatorNumberType == '1') {

				short numeratorVal = this.numerator.shortValue();
				short denominatorVal = this.denominator.shortValue();

				if (numeratorVal == denominatorVal) {
					this.numerator = (E) new Short((short) 1);
					this.denominator = (E) new Short((short) 1);

					if (numeratorVal < 0) {
						this.numerator = (E) new Short((short) -1);
					} else if (denominatorVal < 0) {
						this.denominator = (E) new Short((short) -1);
					}
				} else {

					short gcd = (short) Math.abs(euclidsAlgorithm(this.numerator, this.denominator).shortValue());
					this.numerator = (E) new Short((short) (numeratorVal / gcd));
					this.denominator = (E) new Short((short) (denominatorVal / gcd));
				}
			}
		}

	}

	@Override
	public void rationalInverse() {

		if (!isNumeratorZero()) {
			E temp = this.numerator;
			this.numerator = this.denominator;
			this.denominator = temp;
		}
	}

	@Override
	public void squaredRational() {
		// TODO Auto-generated method stub
		this.numerator = squareNumber(numerator);
		this.denominator = squareNumber(denominator);
		
		simplifyRational();
	}

	@Override
	public Number getNumerator() {
		return this.numerator;
	}

	@Override
	public Number getDenominator() {
		return this.denominator;
	}

}