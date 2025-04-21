package com.kaba4cow.siprefix;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * The {@code SIPrefix} enum represents the International System of Units (SI) prefixes, each associated with a specific
 * power-of-ten exponent and its corresponding symbol.
 * <p>
 * It provides utility methods for parsing, formatting, and comparing string values that include SI prefixes.
 * <p>
 */
public enum SIPrefix {

	QUECTO("q", -30), //
	RONTO("r", -27), //
	YOCTO("y", -24), //
	ZEPTO("z", -21), //
	ATTO("a", -18), //
	FEMTO("f", -15), //
	PICO("p", -12), //
	NANO("n", -9), //
	MICRO("u", -6), //
	MILLI("m", -3), //
	CENTI("c", -2), //
	DECI("d", -1), //
	NONE("", 0), //
	DEKA("da", +1), //
	HECTO("h", +2), //
	KILO("k", +3), //
	MEGA("M", +6), //
	GIGA("G", +9), //
	TERA("T", +12), //
	PETA("P", +15), //
	EXA("E", +18), //
	ZETTA("Z", +21), //
	YOTTA("Y", +24), //
	RONNA("R", +27), //
	QUETTA("Q", +30);

	private final String prefix;
	private final int exponent;

	private SIPrefix(String prefix, int exponent) {
		this.prefix = prefix;
		this.exponent = exponent;
	}

	/**
	 * Returns a string with an appropriate SI prefix for a given numeric string. The number is scaled and the closest fitting
	 * SI prefix is applied.
	 *
	 * @param input the numeric value as a string
	 * 
	 * @return the normalized value with an SI prefix
	 * 
	 * @throws NumberFormatException if the input is not a valid number
	 */
	public static String normalizeValue(String input) {
		BigDecimal value = parseValue(input);
		if (value.compareTo(BigDecimal.ZERO) == 0)
			return "0";
		int exponent = value.precision() - value.scale() - 1;
		int rounded = Math.max(QUECTO.exponent, Math.min(QUETTA.exponent, (int) (Math.floor(exponent / 3.0) * 3.0)));
		SIPrefix best = NONE;
		for (SIPrefix prefix : SIPrefix.values())
			if (prefix.exponent == rounded) {
				best = prefix;
				break;
			}
		return value.scaleByPowerOfTen(-best.exponent).stripTrailingZeros().toPlainString() + best.getPrefix();
	}

	/**
	 * Parses the SI prefix from the end of a string.
	 *
	 * @param string the input string
	 * 
	 * @return the matching {@code SIPrefix} constant
	 * 
	 * @throws NumberFormatException if the string is not a valid number
	 */
	public static SIPrefix parsePrefix(String string) {
		for (SIPrefix prefix : SIPrefix.values())
			if (string.endsWith(prefix.prefix) && !prefix.prefix.isEmpty())
				return prefix;
		if (string.matches("\\d+"))
			return NONE;
		throw new NumberFormatException("Unknown prefix in string: ".concat(string));
	}

	/**
	 * Parses a numeric string that may include an SI prefix into a {@link BigDecimal}.
	 *
	 * @param string the input string
	 * 
	 * @return the parsed {@link BigDecimal} value
	 * 
	 * @throws NumberFormatException if the string is not a valid number
	 */
	public static BigDecimal parseValue(String string) {
		for (SIPrefix prefix : SIPrefix.values())
			if (!prefix.prefix.isEmpty() && string.endsWith(prefix.prefix))
				return new BigDecimal(string.substring(0, string.length() - prefix.prefix.length()))
						.multiply(prefix.getMultiplier());
		return new BigDecimal(string);
	}

	/**
	 * Compares two string values that may include SI prefixes for equality.
	 *
	 * @param value1 the first value
	 * @param value2 the second value
	 * 
	 * @return {@code true} if both values are numerically equal, {@code false} otherwise
	 */
	public static boolean valuesEqual(String value1, String value2) {
		return compareValues(value1, value2) == 0;
	}

	/**
	 * Compares two string values that may include SI prefixes.
	 *
	 * @param value1 the first value
	 * @param value2 the second value
	 * 
	 * @return a negative integer, zero, or a positive integer as the first value is less than, equal to, or greater than the
	 *             second
	 */
	public static int compareValues(String value1, String value2) {
		return parseValue(value1).compareTo(parseValue(value2));
	}

	/**
	 * Returns the symbol of the SI prefix.
	 *
	 * @return the SI prefix symbol
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * Returns the power-of-ten exponent associated with this prefix.
	 *
	 * @return the base-10 exponent
	 */
	public int getExponent() {
		return exponent;
	}

	/**
	 * Returns the multiplier represented by this prefix as a {@code BigDecimal}.
	 *
	 * @return the multiplier
	 */
	public BigDecimal getMultiplier() {
		return BigDecimal.TEN.pow(exponent, MathContext.DECIMAL64);
	}

}
