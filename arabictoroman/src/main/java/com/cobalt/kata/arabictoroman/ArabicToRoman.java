package com.cobalt.kata.arabictoroman;

import com.cobalt.kata.arabictoroman.exception.NotAcceptedNumberException;

public class ArabicToRoman {

	public static String convert(Integer numberToConvert) {
		if (numberToConvert < 0 || numberToConvert > 3999) 
				throw new NotAcceptedNumberException();
		
		if (numberToConvert == 0)
				return "";
		
		StringBuffer workingChain = new StringBuffer();
		String stringValue = numberToConvert.toString();
		String reverseStringValue = reverseString(stringValue);
		
		for (int indice = 0; indice < reverseStringValue.length(); indice++) {
			int digit = Character.getNumericValue(reverseStringValue.charAt(indice));
			if (indice == 0) {
				buildUnit(workingChain, digit);
			} else if (indice == 1) {
				AppendTens(workingChain, digit);
			} else if (indice == 2) {
				AppendHundreds(workingChain, digit);
			}  else {
				AppendThousands(workingChain, digit);
			} 
		}
		
		return workingChain.toString();
	}

	private static void buildUnit(StringBuffer workingChain, int digit) {
		workingChain.append(convertsUnit(digit));
	}
	
	private static void AppendTens(StringBuffer workingChain, int digit) {
		workingChain.insert(0, convertsTens(digit));
	}
	
	private static void AppendHundreds(StringBuffer workingChain, int digit) {
		workingChain.insert(0, convertsHundreds(digit));
	}
	
	private static void AppendThousands(StringBuffer workingChain, int digit) {
		workingChain.insert(0, convertsThousands(digit));
	}
	
	private static String convertsUnit(int unit) {
		return convertDigitToRomanSymbol(unit, "I", "V", "X");
	}
	
	private static String convertsTens(int tens) {
		return convertDigitToRomanSymbol(tens, "X", "L", "C");
	}
	
	private static String convertsHundreds(int hundreds) {
		return convertDigitToRomanSymbol(hundreds, "C", "D", "M");
	}
	
	private static String convertsThousands(int thousands) {
		return convertDigitToRomanSymbol(thousands, "M", "", "");
	}
	
	private static String convertDigitToRomanSymbol(int digit, String unitSymbol, String midSymbol, String highSymbol) {
		StringBuffer result = new StringBuffer();
		if (digit != 0) {
			result.append(determineAppropriateSymbol(digit, midSymbol, highSymbol));

			int remain = digit % 5;
			if (isRemainLessOrEqualThan3(remain)) {
				appendUnits(unitSymbol, result, remain);
			} else if (isRemainEqualTo4(remain)) {
				insertUnitBefore(unitSymbol, result);
			}
		}
		return result.toString();
	}

	private static String determineAppropriateSymbol(int digit, String midSymbol, String highSymbol) {
		String result= "";
		int whole = digit / 5;
		int remain = digit % 5;
		if (remain <= 3 && whole == 1) {
			result = midSymbol;
		} else if (remain > 3) {
			if (whole == 1) {
				result = highSymbol;
			} else {
				result = midSymbol;
			}
		}
		return result;
	}
	private static void insertUnitBefore(String unitSymbol, StringBuffer result) {
		result.insert(0, unitSymbol);
	}


	private static void appendUnits(String unitSymbol, StringBuffer result, int remain) {
		for (int i = 0; i < remain; i++) {
			result.append(unitSymbol);
		}
	}
	
	
	
	private static String reverseString(String stringToReverse) {
		return new StringBuilder(stringToReverse).reverse().toString();
	}
	
	
	
	private static boolean isRemainLessOrEqualThan3(int remain) {
		return remain <= 3;
	}
	
	private static boolean isRemainEqualTo4(int remain) {
		return remain == 4;
	}
}
