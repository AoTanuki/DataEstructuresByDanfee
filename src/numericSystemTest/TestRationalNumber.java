package numericSystemTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import numericSystem.RationalNumber;

class TestRationalNumber {

	
	

	RationalNumber<Number> a;
	RationalNumber<Number> b;
	RationalNumber<Number> c;
	RationalNumber<Number> d;
	RationalNumber<Number> e;
	ArrayList<Integer> arra = new ArrayList<>();
	String cc;

	public void setUpEscenario1() {
		a = new RationalNumber<Number>(1, 2);
		b = new RationalNumber<Number>(6, 4);
		c = new RationalNumber<Number>(-13, 23);
		d = new RationalNumber<Number>(-100, 28);
		e = new RationalNumber<Number>(0, 1);
	}

	@Test
	public void testRationalDivision() {
		setUpEscenario1();
		a.divideRational(b);
		b.divideRational(new RationalNumber<Number>(0, 1));
		boolean prueba = true;
		prueba = prueba && (a.getNumerator().intValue() == 1 && a.getDenominator().intValue() == 3);
		prueba = prueba && (c.getNumerator().intValue() == -13 && c.getDenominator().intValue() == 23);
		assertTrue(prueba);
	}
	
	@Test
	public void testSquaredRational() {
		setUpEscenario1();
		a.squaredRational();
		b.squaredRational();
		boolean prueba = true;
		prueba = prueba && (a.getNumerator().intValue() == 1 && a.getDenominator().intValue() == 4);
		prueba = prueba && (b.getNumerator().intValue() == 9 && b.getDenominator().intValue() == 4);
		assertTrue(prueba);
	}
	
	@Test
	public void testInverse(){
		setUpEscenario1();
		a.rationalInverse();
		b.rationalInverse();
		c.rationalInverse();
		d.rationalInverse();
		e.rationalInverse();
		boolean prueba = true;
		prueba = prueba && (a.getNumerator().intValue() == 2 && a.getDenominator().intValue() == 1);
		prueba = prueba && (b.getNumerator().intValue() == 2 && b.getDenominator().intValue() == 3);
		prueba = prueba && (c.getNumerator().intValue() == 23 && c.getDenominator().intValue() == -13);
		prueba = prueba && (d.getNumerator().intValue() == 7 && d.getDenominator().intValue() == -25);
		prueba = prueba && (e.getNumerator().intValue() == 0 && e.getDenominator().intValue() == 1);
		assertTrue(prueba);
	}
	
	@Test
	public void testMultipliying() {
		setUpEscenario1();
		a.multiplyRational(b);
		b.multiplyRational(new RationalNumber<Number>(0, 1));
		boolean prueba = true;
		prueba = prueba && (a.getNumerator().intValue() == 3 && a.getDenominator().intValue() == 4);
		prueba = prueba && (b.getNumerator().intValue() == 0);
		assertTrue(prueba);
	}

	@Test
	public void testSimplification() {
		setUpEscenario1();
		a.simplifyRational();
		b.simplifyRational();
		c.simplifyRational();
		d.simplifyRational();
		boolean prueba = true;
		prueba = prueba && (a.getNumerator().intValue() == 1 && a.getDenominator().intValue() == 2);
		prueba = prueba && (b.getNumerator().intValue() == 3 && b.getDenominator().intValue() == 2);
		prueba = prueba && (c.getNumerator().intValue() == -13 && c.getDenominator().intValue() == 23);
		prueba = prueba && (d.getNumerator().intValue() == -25 && d.getDenominator().intValue() == 7);
		assertTrue(prueba);
	}

	@Test
	public void testAddingRational() {
		setUpEscenario1();
		a.addRational(b);
		b.addRational(c);
		c.addRational(new RationalNumber<Number>(10, 23));
		d.addRational(new RationalNumber<Number>(-40, 28));
		boolean prueba = true;
		prueba = prueba && (a.getNumerator().intValue() == 2 && a.getDenominator().intValue() == 1);
		prueba = prueba && (b.getNumerator().intValue() == 43 && b.getDenominator().intValue() == 46);
		prueba = prueba && (c.getNumerator().intValue() == -3 && c.getDenominator().intValue() == 23);
		prueba = prueba && (d.getNumerator().intValue() == -5 && d.getDenominator().intValue() == 1);
		assertTrue(prueba);
	}
	
	@Test
	public void testSubstractRational(){
		setUpEscenario1();
		a.substractRational(b);
		b.substractRational(c);
		c.substractRational(new RationalNumber<Number>(10, 23));
		d.substractRational(new RationalNumber<Number>(-40, 28));
		boolean prueba = true;
		prueba = prueba && (a.getNumerator().intValue() == -1 && a.getDenominator().intValue() == 1);
		prueba = prueba && (b.getNumerator().intValue() == 95 && b.getDenominator().intValue() == 46);
		prueba = prueba && (c.getNumerator().intValue() == -1 && c.getDenominator().intValue() == 1);
		prueba = prueba && (d.getNumerator().intValue() == -15 && d.getDenominator().intValue() == 7);
		assertTrue(prueba);
	}
}
