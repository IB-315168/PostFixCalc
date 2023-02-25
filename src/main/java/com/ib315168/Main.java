package com.ib315168;

import com.ib315168.models.Operand;
import com.ib315168.models.Operator;
import com.ib315168.models.Stack;
import com.ib315168.models.Token;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
  public static void main(String[] args)
  {
    PostFixCalc calc = new PostFixCalcImpl();
    ArrayList<Token> expression = new ArrayList<>();

    expression.add(new Operand(100));
    expression.add(new Operand(200));
    expression.add(new Operator('+'));
    expression.add(new Operand(2));
    expression.add(new Operator('/'));
    expression.add(new Operand(5));
    expression.add(new Operator('*'));
    expression.add(new Operand(7));
    expression.add(new Operator('+'));

    System.out.println(calc.evaluateExpression(expression));

    System.out.println(expression.size());
  }
}