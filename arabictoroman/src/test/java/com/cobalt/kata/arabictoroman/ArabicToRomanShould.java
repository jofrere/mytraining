package com.cobalt.kata.arabictoroman;

import org.junit.Test;

import com.cobalt.kata.arabictoroman.exception.NotAcceptedNumberException;

import junit.framework.Assert;

public class ArabicToRomanShould {
	
	@Test
	public void one_digit_one() {
		Assert.assertEquals("I", ArabicToRoman.convert(1));
	}
	
	@Test
	public void one_digit_two() {
		Assert.assertEquals("II", ArabicToRoman.convert(2));
	}
	
	@Test
	public void one_digit_three() {
		Assert.assertEquals("III", ArabicToRoman.convert(3));
	}
	
	@Test
	public void one_digit_four() {
		Assert.assertEquals("IV", ArabicToRoman.convert(4));
	}
	
	@Test
	public void one_digit_five() {
		Assert.assertEquals("V", ArabicToRoman.convert(5));
	}
	
	@Test
	public void one_digit_six() {
		Assert.assertEquals("VI", ArabicToRoman.convert(6));
	}
	@Test
	public void one_digit_nine() {
		Assert.assertEquals("IX", ArabicToRoman.convert(9));
	}
	@Test
	public void two_digit_ten() {
		Assert.assertEquals("X", ArabicToRoman.convert(10));
	}
	@Test
	public void two_digit_eleven() {
		Assert.assertEquals("XI", ArabicToRoman.convert(11));
	}
	
	@Test
	public void two_digit_fourty_five() {
		Assert.assertEquals("XLV", ArabicToRoman.convert(45));
	}
	@Test
	public void two_digit_fifty_six() {
		Assert.assertEquals("LVI", ArabicToRoman.convert(56));
	}
	@Test
	public void two_digit_sixty_eight() {
		Assert.assertEquals("LXVIII", ArabicToRoman.convert(68));
	}
	@Test
	public void two_digit_ninety_nine() {
		Assert.assertEquals("XCIX", ArabicToRoman.convert(99));
	}

	@Test
	public void three_digit_four_hundred_ninety_nine() {
		Assert.assertEquals("CDXCIX", ArabicToRoman.convert(499));
	}
	@Test
	public void three_digit_nine_hundred_ninety_nine() {
		Assert.assertEquals("CMXCIX", ArabicToRoman.convert(999));
	}
	
	@Test
	public void four_digit_3845() {
		Assert.assertEquals("MMMDCCCXLV", ArabicToRoman.convert(3845));
	}
	
	@Test(expected = NotAcceptedNumberException.class)
	public void returnExceptionOnNegativeValue() {
		ArabicToRoman.convert(-100);
	}
}
