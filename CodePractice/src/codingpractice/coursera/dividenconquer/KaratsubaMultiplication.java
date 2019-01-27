package codingpractice.coursera.dividenconquer;

import java.math.BigInteger;

public class KaratsubaMultiplication {
	public BigInteger karatsubaMult(BigInteger x, BigInteger y) {
		BigInteger ten = new BigInteger("10");
		BigInteger product = null;
		
		// check negative
		boolean isNeg = false;
		if(x.signum() == y.signum())
			isNeg = false;
		else
			isNeg = true;
		
		x = x.abs();
		y = y.abs();
		
		if(x.toString().length() == 1) {
			// less than 10
			if(isNeg)
				return x.multiply(y).multiply(new BigInteger("-1"));
			else
				return x.multiply(y);
		}
		
		int length = x.toString().length();
		BigInteger x0 = new BigInteger(x.toString().substring(0, length/2));
		BigInteger x1 = new BigInteger(x.toString().substring(length/2, length));
		length = y.toString().length();
		BigInteger y0 = new BigInteger(y.toString().substring(0, length/2));
		BigInteger y1 = new BigInteger(y.toString().substring(length/2, length));
		
		BigInteger u = karatsubaMult(x0, y0);
		BigInteger v = karatsubaMult(x1.subtract(x0), y1.subtract(y0));
		BigInteger w = karatsubaMult(x1, y1);
		BigInteger z = ten.pow(length/2).multiply(u.add(w).subtract(v));
		product = u.multiply(ten.pow(length)).add(z).add(w);
		
		if(isNeg)
			return product.multiply(new BigInteger("-1"));
		else
			return product;
	}
}
