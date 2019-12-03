import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostfixTest {
	Postfix postfix;
	
	public PostfixTest() {
		postfix = new Postfix();
	}
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testEvaluate() throws StackUnderflow, IncorrectString {
		postfix.evaluate("34+");
		assertEquals(7, postfix.evaluate("34+"));
		
		postfix.evaluate("43-");
		assertEquals(1, postfix.evaluate("43-"));
		
		postfix.evaluate("34*");
		assertEquals(12, postfix.evaluate("34*"));
		
		postfix.evaluate("84/");
		assertEquals(2, postfix.evaluate("84/"));
		
		postfix.evaluate("23^");
		assertEquals(8, postfix.evaluate("23^"));
		
		postfix.evaluate("12+3*");
		assertEquals(9, postfix.evaluate("12+3*"));
		
		postfix.equals("23-");
		assertEquals(-1, postfix.evaluate("23-"));
		
		postfix.evaluate("93/3*");
		assertEquals(9, postfix.evaluate("93/3*"));
		
		postfix.evaluate("42^2^");
		assertEquals(256, postfix.evaluate("42^2^"));
		
		postfix.evaluate("24-4*");
		assertEquals(-8, postfix.evaluate("24-4*"));	
	}
	
	@Test 
	void testPrelab() throws StackUnderflow, IncorrectString{
		postfix.evaluate("12*3+");
		assertEquals(5, postfix.evaluate("12*3+"));
		
		postfix.evaluate("23*1+");
		assertEquals(7, postfix.evaluate("23*1+"));
		
		postfix.evaluate("12+34^-");
		assertEquals(-78, postfix.evaluate("12+34^-"));
		
		postfix.evaluate("12^34*-");
		assertEquals(-11, postfix.evaluate("12^34*-"));
		
		postfix.evaluate("123*+45^-6+");
		assertEquals(-1011, postfix.evaluate("123*+45^-6+"));
		
		postfix.evaluate("12+3*456-^+");
		assertEquals(9, postfix.evaluate("12+3*456-^+"));
		
		postfix.evaluate("12+34/+5+678+*+");
		assertEquals(98, postfix.evaluate("12+34/+5+678+*+"));
		
		postfix.evaluate("91-2-32*-1-");
		assertEquals(-1, postfix.evaluate("91-2-32*-1-"));
	}
	
	@Test
	void testInfixToPostfix() throws StackUnderflow, IncorrectString{
		postfix.evaluate(postfix.infixToPostfix("1*2+3"));
		assertEquals(5, postfix.evaluate(postfix.infixToPostfix("1*2+3")));
		
		postfix.evaluate(postfix.infixToPostfix("1+2*3"));
		assertEquals(7, postfix.evaluate(postfix.infixToPostfix("1+2*3")));
		
		postfix.evaluate(postfix.infixToPostfix("1+2-3^4"));
		assertEquals(-78, postfix.evaluate(postfix.infixToPostfix("1+2-3^4")));
		
		postfix.evaluate(postfix.infixToPostfix("1^2-3*4"));
		assertEquals(-11, postfix.evaluate(postfix.infixToPostfix("1^2-3*4")));
		
		postfix.evaluate(postfix.infixToPostfix("1+2*3-4^5+6"));
		assertEquals(-1011, postfix.evaluate(postfix.infixToPostfix("1+2*3-4^5+6")));
		
		postfix.evaluate(postfix.infixToPostfix("(1+2)*3+(4^(5-6))"));
		assertEquals(9, postfix.evaluate(postfix.infixToPostfix("(1+2)*3+(4^(5-6))")));
		
		postfix.evaluate(postfix.infixToPostfix("1+2+3/4+5+6*(7+8)"));
		assertEquals(98, postfix.evaluate(postfix.infixToPostfix("1+2+3/4+5+6*(7+8)")));
		
		postfix.evaluate(postfix.infixToPostfix("9-1-2-3*2-1"));
		assertEquals(-1, postfix.evaluate(postfix.infixToPostfix("9-1-2-3*2-1")));
	}

}
