package teste.equation;

public interface QuadraticEquation {
	
	double discriminat();
	boolean isUperward();
	boolean isDownward();
	int howManyRealRoots();
	double realRoots();
	double valueFor(double x);

}
