package com.ib315168;

import com.ib315168.models.Operand;
import com.ib315168.models.Operator;
import com.ib315168.models.Token;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PostFixCalcTest
{
  private PostFixCalc calc;
  private ArrayList<Token> expression;

  @org.junit.jupiter.api.BeforeEach void setUp()
  {
    expression = new ArrayList<>();
    calc = new PostFixCalcImpl();
    System.out.println("------------------> Begin test");
  }

  @org.junit.jupiter.api.AfterEach void tearDown()
  {
    System.out.println("End of test <------------------");
  }

  // Zero - empty expression
  @Test public void emptyExpression()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      calc.evaluateExpression(expression);
    });
  }

  // One
  @Test public void simpleExpression() {
    expression.add(new Operand(3));
    expression.add(new Operand(4));
    expression.add(new Operator('+'));

    assertEquals(7, calc.evaluateExpression(expression));
  }


  // Many
  @Test public void complexExpression() {
    expression.add(new Operand(100));
    expression.add(new Operand(200));
    expression.add(new Operator('+'));
    expression.add(new Operand(2));
    expression.add(new Operator('/'));
    expression.add(new Operand(5));
    expression.add(new Operator('*'));
    expression.add(new Operand(7));
    expression.add(new Operator('+'));

    assertEquals(757, calc.evaluateExpression(expression));
  }

  // Boundary
  @Test public void maxValueExpression() {
    expression.add(new Operand( Integer.MAX_VALUE-1));
    expression.add(new Operand(1));
    expression.add(new Operator('+'));

    assertEquals(Integer.MAX_VALUE, calc.evaluateExpression(expression));
  }

  @Test public void wraparoundExpression() {
    expression.add(new Operand( Integer.MAX_VALUE));
    expression.add(new Operand(1));
    expression.add(new Operator('+'));

    assertEquals(Integer.MIN_VALUE, calc.evaluateExpression(expression));
  }

  // Exceptions
  @Test public void noOperators()
  {
    expression.add(new Operand(4));
    expression.add(new Operand(3));

    assertThrows(IllegalArgumentException.class, () -> {
      calc.evaluateExpression(expression);
    });
  }

  @Test public void noOperands()
  {
    expression.add(new Operator('+'));
    expression.add(new Operator('-'));

    assertThrows(IllegalArgumentException.class, () -> {
      calc.evaluateExpression(expression);
    });
  }
}