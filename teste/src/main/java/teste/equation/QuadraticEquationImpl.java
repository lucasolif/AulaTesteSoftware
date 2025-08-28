package teste.equation;

import java.security.InvalidParameterException;

public final class QuadraticEquationImpl implements QuadraticEquation{

	final double a, b, c;
	
	public QuadraticEquationImpl(double a, double b, double c) throws InvalidParameterException {
		
		this.a = a;
		this.b = b;
		this.c = c;
		
		if(Double.compare(a, 0.0) == 0) {
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
		return 0;
	}

	@Override
	public double valueFor(double x) {
		return 0;
	}

}
