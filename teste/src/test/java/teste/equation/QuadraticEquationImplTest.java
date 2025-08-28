package teste.equation;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuadraticEquationImplTest {

	@Test
	void shouldInstantieateNormaly() {
		//arrange
		double a=1, b=2, c=-5;
		
		//assert
		Assertions.assertDoesNotThrow(() ->{
			//act
			new QuadraticEquationImpl(a,b,c);
		});
		
	}
	
	@Test
	void shouldThrowInvalidParameterException() {
		//arrange
		double a=0.0, b=2, c=-5;
		
		//assert
		Assertions.assertThrows(
			InvalidParameterException.class, 
			() -> {
				new QuadraticEquationImpl(a,b,c);
			}
		);
	}
	
	@Test
	void shouldIdentifyAsUpWard() {
		
		//Arrange
		double a = 0.0000000000000000000000001, b = 5, c = 3;
		QuadraticEquation equation = new QuadraticEquationImpl(a, b, c);
		
		//Act
		boolean expected = true;
		boolean obtained = equation.isUperward();
		
		//Assert
		Assertions.assertEquals(expected, obtained);
	}
	
	@Test
	void shouldIdentifyAsNotUpWard() {
		//Arrange
		double a = -0.0000000000000000000000001, b = 5, c = 3;
		QuadraticEquation equation = new QuadraticEquationImpl(a, b, c);
		
		//Act
		boolean expected = false;
		boolean obtained = equation.isUperward();
		
		//Assert
		Assertions.assertEquals(expected, obtained);
	}
	
	@Test
	void shouldIdentifyAsDownWard() {
		
		//Arrange
		double a = -0.0000000000000000000000001, b = 5, c = 3;
		QuadraticEquation equation = new QuadraticEquationImpl(a, b, c);
		
		//Act
		boolean expected = true;
		boolean obtained = equation.isDownward();
		
		//Assert
		Assertions.assertEquals(expected, obtained);
	}
	
	@Test
	void shouldIdentifyAsNotDownWard() {
		//Arrange
		double a = 0.0000000000000000000000001, b = 5, c = 3;
		QuadraticEquation equation = new QuadraticEquationImpl(a, b, c);
		
		//Act
		boolean expected = false;
		boolean obtained = equation.isDownward();
		
		//Assert
		Assertions.assertEquals(expected, obtained);
	}
	
	
	@Test
	void shouldAsDiscriminantCorrectly() {
		
		//Arrange
		double a, b , c;
		QuadraticEquation equation;
		double expected, obtained;
		
		a = 3; b = 2; c = -1; expected = 16;
		equation = new QuadraticEquationImpl(a, b, c);
		obtained = equation.discriminat();
		Assertions.assertTrue(Double.compare(expected, obtained) == 0);
		
		a = 3; b = 2; c = 1; expected = -8;
		equation = new QuadraticEquationImpl(a, b, c);
		obtained = equation.discriminat();
		Assertions.assertTrue(Double.compare(expected, obtained) == 0);
		
		a = 1; b = 2; c = 1; expected = 0;
		equation = new QuadraticEquationImpl(a, b, c);
		obtained = equation.discriminat();
		Assertions.assertTrue(Double.compare(expected, obtained) == 0);
	}
	
	void shouldReturnZeroRealRoots () {
		
		double a, b , c;
		QuadraticEquation equation;
		Integer expected, obtained;
		
		
		a = 1; b = 0; c = 1; expected = 0;
		equation = new QuadraticEquationImpl(a, b, c);
		obtained = equation.howManyRealRoots();
		Assertions.assertEquals(expected, obtained);
		
		a = 1; b = 3; c = 1; expected = 1;
		equation = new QuadraticEquationImpl(a, b, c);
		obtained = equation.howManyRealRoots();
		Assertions.assertEquals(expected, obtained);
		
		a = 1; b = 0; c = 1; expected = 2;
		equation = new QuadraticEquationImpl(a, b, c);
		obtained = equation.howManyRealRoots();
		Assertions.assertEquals(expected, obtained);
	}
	
	

}
