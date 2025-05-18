package com.kaba4cow.siprefix;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * The {@code SIDecimal} class represents a decimal number that can be formatted and parsed using SI prefixes.
 * <p>
 * It extends {@link BigDecimal} to provide all standard numeric operations while adding support for SI prefixes in string
 * representation.
 * <p>
 * 
 * @see SIPrefix
 */
public class SIDecimal extends BigDecimal {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new {@code SIDecimal} with the specified {@link BigDecimal} value.
	 * 
	 * @param val the {@link BigDecimal} value
	 */
	public SIDecimal(BigDecimal val) {
		super(val.unscaledValue(), val.scale());
	}

	/**
	 * Constructs a new {@code SIDecimal} with the specified double value.
	 * 
	 * @param val the double value
	 */
	public SIDecimal(double val) {
		super(val, MathContext.DECIMAL64);
	}

	/**
	 * Constructs a new {@code SIDecimal} with the specified long value.
	 * 
	 * @param val the long value
	 */
	public SIDecimal(long val) {
		super(val);
	}

	/**
	 * Constructs a new {@code SIDecimal} with the specified int value.
	 * 
	 * @param val the int value
	 */
	public SIDecimal(int val) {
		super(val);
	}

	/**
	 * Constructs a new {@code SIDecimal} with the specified string value. The string can include SI prefixes which will be
	 * parsed automatically.
	 * 
	 * @param val the string representation of the value with optional SI prefix
	 * 
	 * @throws NumberFormatException if the string is not a valid number
	 */
	public SIDecimal(String val) {
		super(SIPrefix.parseValue(val).toPlainString());
	}

	/**
	 * Parses a string into an {@code SIDecimal}. The string can include SI prefixes which will be parsed automatically.
	 * 
	 * @param s the string to parse
	 * 
	 * @return the parsed {@code SIDecimal}
	 * 
	 * @throws NumberFormatException if the string is not a valid number
	 */
	public static SIDecimal valueOf(String s) {
		return new SIDecimal(s);
	}

	/**
	 * Returns an {@code SIDecimal} whose value is the absolute value of this {@code SIDecimal}.
	 * 
	 * @return the absolute value of this {@code SIDecimal}
	 */
	@Override
	public SIDecimal abs() {
		return new SIDecimal(super.abs());
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (this + augend).
	 * 
	 * @param augend value to be added to this {@code SIDecimal}
	 * 
	 * @return this + augend
	 */
	@Override
	public SIDecimal add(BigDecimal augend) {
		return new SIDecimal(super.add(augend));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (this + augend).
	 * 
	 * @param augend value to be added to this {@code SIDecimal}
	 * 
	 * @return this + augend
	 */
	public SIDecimal add(SIDecimal augend) {
		return new SIDecimal(super.add(augend));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (this - subtrahend).
	 * 
	 * @param subtrahend value to be subtracted from this {@code SIDecimal}
	 * 
	 * @return this - subtrahend
	 */
	@Override
	public SIDecimal subtract(BigDecimal subtrahend) {
		return new SIDecimal(super.subtract(subtrahend));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (this - subtrahend).
	 * 
	 * @param subtrahend value to be subtracted from this {@code SIDecimal}
	 * 
	 * @return this - subtrahend
	 */
	public SIDecimal subtract(SIDecimal subtrahend) {
		return new SIDecimal(super.subtract(subtrahend));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (this * multiplicand).
	 * 
	 * @param multiplicand value to be multiplied by this {@code SIDecimal}
	 * 
	 * @return this * multiplicand
	 */
	@Override
	public SIDecimal multiply(BigDecimal multiplicand) {
		return new SIDecimal(super.multiply(multiplicand));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (this * multiplicand).
	 * 
	 * @param multiplicand value to be multiplied by this {@code SIDecimal}
	 * 
	 * @return this * multiplicand
	 */
	public SIDecimal multiply(SIDecimal multiplicand) {
		return new SIDecimal(super.multiply(multiplicand));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (this / divisor).
	 * 
	 * @param divisor value by which this {@code SIDecimal} is to be divided
	 * 
	 * @return this / divisor
	 * 
	 * @throws ArithmeticException if divisor is zero
	 */
	@Override
	public SIDecimal divide(BigDecimal divisor) {
		return new SIDecimal(super.divide(divisor, MathContext.DECIMAL64));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (this / divisor).
	 * 
	 * @param divisor value by which this {@code SIDecimal} is to be divided
	 * 
	 * @return this / divisor
	 * 
	 * @throws ArithmeticException if divisor is zero
	 */
	public SIDecimal divide(SIDecimal divisor) {
		return new SIDecimal(super.divide(divisor, MathContext.DECIMAL64));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (this / divisor), with the specified rounding mode.
	 * 
	 * @param divisor      value by which this {@code SIDecimal} is to be divided
	 * @param roundingMode the rounding mode to apply
	 * 
	 * @return this / divisor
	 * 
	 * @throws ArithmeticException if divisor is zero
	 */
	@Override
	public SIDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
		return new SIDecimal(super.divide(divisor, MathContext.DECIMAL64).setScale(scale(), roundingMode));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (this / divisor), with the specified context.
	 * 
	 * @param divisor value by which this {@code SIDecimal} is to be divided
	 * @param mc      the context to use
	 * 
	 * @return this / divisor
	 * 
	 * @throws ArithmeticException if divisor is zero
	 */
	@Override
	public SIDecimal divide(BigDecimal divisor, MathContext mc) {
		return new SIDecimal(super.divide(divisor, mc));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is raised to the power of n.
	 * 
	 * @param n power to raise this {@code SIDecimal} to
	 * 
	 * @return this^n
	 */
	@Override
	public SIDecimal pow(int n) {
		return new SIDecimal(super.pow(n, MathContext.DECIMAL64));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is raised to the power of n, using the specified context.
	 * 
	 * @param n  power to raise this {@code SIDecimal} to
	 * @param mc the context to use
	 * 
	 * @return this^n
	 */
	@Override
	public SIDecimal pow(int n, MathContext mc) {
		return new SIDecimal(super.pow(n, mc));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is the negation of this {@code SIDecimal}.
	 * 
	 * @return -this
	 */
	@Override
	public SIDecimal negate() {
		return new SIDecimal(super.negate());
	}

	/**
	 * Returns an {@code SIDecimal} whose value is the negation of this {@code SIDecimal}, using the specified context.
	 * 
	 * @param mc the context to use
	 * 
	 * @return -this
	 */
	@Override
	public SIDecimal negate(MathContext mc) {
		return new SIDecimal(super.negate(mc));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (+this).
	 * 
	 * @return +this
	 */
	@Override
	public SIDecimal plus() {
		return new SIDecimal(super.plus());
	}

	/**
	 * Returns an {@code SIDecimal} whose value is (+this), using the specified context.
	 * 
	 * @param mc the context to use
	 * 
	 * @return +this
	 */
	@Override
	public SIDecimal plus(MathContext mc) {
		return new SIDecimal(super.plus(mc));
	}

	/**
	 * Returns the SI prefix that would be used when converting this value to a string.
	 * 
	 * @return the SIPrefix enum that represents the appropriate prefix for this value
	 */
	public SIPrefix getPrefix() {
		if (this.compareTo(BigDecimal.ZERO) == 0)
			return SIPrefix.NONE;
		BigDecimal absValue = this.abs();
		int exponent = absValue.precision() - absValue.scale() - 1;
		int rounded = Math.max(SIPrefix.QUECTO.getExponent(),
				Math.min(SIPrefix.QUETTA.getExponent(), (int) (Math.floor(exponent / 3.0) * 3.0)));
		for (SIPrefix prefix : SIPrefix.values())
			if (prefix.getExponent() == rounded)
				return prefix;
		return SIPrefix.NONE;
	}

	/**
	 * Returns the value of this {@code SIDecimal} scaled according to its SI prefix. For example, if this value is 1500 and the
	 * prefix is KILO, this method returns 1.5.
	 * 
	 * @return the scaled value according to the appropriate SI prefix
	 */
	public BigDecimal getScaledValue() {
		return super.movePointLeft(getPrefix().getExponent()).stripTrailingZeros();
	}

	/**
	 * Returns an {@code SIDecimal} whose value is this {@code SIDecimal} with the specified scale.
	 * 
	 * @param newScale     scale of the result
	 * @param roundingMode the rounding mode to apply
	 * 
	 * @return this {@code SIDecimal} with the specified scale and rounding mode
	 */
	@Override
	public SIDecimal setScale(int newScale, RoundingMode roundingMode) {
		return new SIDecimal(super.setScale(newScale, roundingMode));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is this {@code SIDecimal} with the specified scale.
	 * 
	 * @param newScale scale of the result
	 * 
	 * @return this {@code SIDecimal} with the specified scale
	 * 
	 * @throws ArithmeticException if rounding would be necessary
	 */
	@Override
	public SIDecimal setScale(int newScale) {
		return new SIDecimal(super.setScale(newScale));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is this {@code SIDecimal} with no fractional part.
	 * 
	 * @param roundingMode the rounding mode to apply
	 * 
	 * @return this {@code SIDecimal} with no fractional part
	 */
	public SIDecimal setScale(RoundingMode roundingMode) {
		return new SIDecimal(super.setScale(0, roundingMode));
	}

	/**
	 * Returns an {@code SIDecimal} whose scale is the specified value, and whose value is numerically equal to this
	 * {@code SIDecimal}'s.
	 * 
	 * @param newScale scale of the result
	 * 
	 * @return a numerically equal {@code SIDecimal} with the specified scale
	 * 
	 * @throws ArithmeticException if this is not exactly representable with the specified scale
	 */
	@Override
	public SIDecimal movePointLeft(int newScale) {
		return new SIDecimal(super.movePointLeft(newScale));
	}

	/**
	 * Returns an {@code SIDecimal} whose scale is the specified value, and whose value is numerically equal to this
	 * {@code SIDecimal}'s.
	 * 
	 * @param newScale scale of the result
	 * 
	 * @return a numerically equal {@code SIDecimal} with the specified scale
	 * 
	 * @throws ArithmeticException if this is not exactly representable with the specified scale
	 */
	@Override
	public SIDecimal movePointRight(int newScale) {
		return new SIDecimal(super.movePointRight(newScale));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is the remainder of this {@code SIDecimal} divided by the specified divisor.
	 * 
	 * @param divisor value by which this {@code SIDecimal} is to be divided
	 * 
	 * @return this % divisor
	 */
	@Override
	public SIDecimal remainder(BigDecimal divisor) {
		return new SIDecimal(super.remainder(divisor));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is the remainder of this {@code SIDecimal} divided by the specified divisor.
	 * 
	 * @param divisor value by which this {@code SIDecimal} is to be divided
	 * @param mc      the context to use
	 * 
	 * @return this % divisor
	 */
	@Override
	public SIDecimal remainder(BigDecimal divisor, MathContext mc) {
		return new SIDecimal(super.remainder(divisor, mc));
	}

	/**
	 * Returns an {@code SIDecimal} whose value is this {@code SIDecimal} rounded according to the specified context.
	 * 
	 * @param mc the context to use
	 * 
	 * @return this {@code SIDecimal} rounded according to the specified context
	 */
	@Override
	public SIDecimal round(MathContext mc) {
		return new SIDecimal(super.round(mc));
	}

	/**
	 * Returns the maximum of this {@code SIDecimal} and the specified {@code SIDecimal}.
	 * 
	 * @param val value with which the maximum is to be computed
	 * 
	 * @return the {@code SIDecimal} whose value is the greater of this and val
	 */
	public SIDecimal max(SIDecimal val) {
		return new SIDecimal(super.max(val));
	}

	/**
	 * Returns the minimum of this {@code SIDecimal} and the specified {@code SIDecimal}.
	 * 
	 * @param val value with which the minimum is to be computed
	 * 
	 * @return the {@code SIDecimal} whose value is the lesser of this and val
	 */
	public SIDecimal min(SIDecimal val) {
		return new SIDecimal(super.min(val));
	}

	/**
	 * Converts a double to an {@code SIDecimal}.
	 * 
	 * @param val the double to convert
	 * 
	 * @return an {@code SIDecimal} whose value is equal to or approximately equal to the value of val
	 */
	public static SIDecimal valueOf(double val) {
		return new SIDecimal(val);
	}

	/**
	 * Converts a long to an {@code SIDecimal}.
	 * 
	 * @param val the long to convert
	 * 
	 * @return an {@code SIDecimal} whose value is equal to the value of val
	 */
	public static SIDecimal valueOf(long val) {
		return new SIDecimal(val);
	}

	/**
	 * Returns the plain string representation of this {@code SIDecimal} without using SI prefixes.
	 * 
	 * @return the plain string representation
	 */
	@Override
	public String toPlainString() {
		return super.toPlainString();
	}

	/**
	 * Returns the string representation of this {@code SIDecimal} with the specified scale and using the appropriate SI prefix.
	 * 
	 * @param scale        the number of digits after the decimal point
	 * @param roundingMode the rounding mode to use
	 * 
	 * @return the string representation with SI prefix and specified scale
	 */
	public String toString(int scale, RoundingMode roundingMode) {
		return SIPrefix.normalizeValue(super.setScale(scale, roundingMode).toPlainString());
	}

	/**
	 * Returns the string representation of this {@code SIDecimal} using appropriate SI prefixes.
	 * 
	 * @return the string representation with SI prefix
	 */
	@Override
	public String toString() {
		return SIPrefix.normalizeValue(super.toPlainString());
	}

}