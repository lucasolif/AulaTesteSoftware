package teste.equation;

import java.security.InvalidParameterException;

public final class QuadraticEquationImpl implements QuadraticEquation{

	final double a, b, c;
	
	public QuadraticEquationImpl(double a, double b, double c) {
		
		this.a = a;
		this.b = b;
		this.c = c;
		
		if (Double.compare(a, 0.0) == 0) {
			throw new InvalidParameterException("Invalid parameter value a:" +a);
		}
		
	}

	@Override
	public double discriminat() {
		return (Math.pow(b, 2) - 4*a*c);
		
	}

	@Override
	public boolean isUperward() {
		return this.a > 0;
	}

	@Override
	public boolean isDownward() {
		return this.a < 0;
	}

	@Override
	public int howManyRealRoots() {
		double delta = (Math.pow(b, 2) - 4*a*c);
		if (delta < 0) {
			return 0;
		} else if (delta == 0) {
			return 1;
		} else
			return 2;
	}

	@Override
	public double realRoots() {
	    double delta = discriminat();

	    if (delta < 0) {
	        return Double.NaN;
	    } else if (delta == 0) {
	        return -b / (2 * a); 
	    } else {
	        double r1 = (-b - Math.sqrt(delta)) / (2 * a);
	        double r2 = (-b + Math.sqrt(delta)) / (2 * a);
	        return Math.min(r1, r2); 
	    }
	}

	@Override
	public double valueFor(double x) {
		return a*x*x + b*x + c;
	}

}
