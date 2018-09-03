package numericSystem;

public interface IRationalNumber<T> {

	public void addRational(T rationalToBeAdded);
	public void substractRational(T rationalToBeSubstracted);
	public void multiplyRational(T rationalFactor);
	public void divideRational(T rationalQuocient);
	public void simplifyRational();
	public void rationalInverse();
	public void squaredRational();
	public Number getNumerator();
	public Number getDenominator();
	public String toString();
}
