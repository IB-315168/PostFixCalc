package com.ib315168;

import com.ib315168.models.Operand;
import com.ib315168.models.Operator;
import com.ib315168.models.Stack;
import com.ib315168.models.Token;

import java.util.ArrayList;

public class PostFixCalcImpl implements PostFixCalc
{
  private Stack stack = Stack.getInstance();

  @Override public int evaluateExpression(ArrayList<Token> tokenList)
  {
    while(stack.size() != 1 || tokenList.size() != 0) {
      Token token = tokenList.remove(0);

      while(!(token instanceof Operator)) {
        stack.push(token);
        token = tokenList.remove(0);
      }

      stack.push(calculate((Operand) stack.pop(), (Operand) stack.pop(), (Operator) token));
    }

    return getResult();
  }

  private Operand calculate(Operand operand1, Operand operand2, Operator operator) {
    return switch (operator.get())
        {
          case '+' -> new Operand(operand2.get() + operand1.get());
          case '-' -> new Operand(operand2.get() - operand1.get());
          case '*' -> new Operand(operand2.get() * operand1.get());
          case '/' -> new Operand(operand2.get() / operand1.get());
          default -> null;
        };
  }

  private int getResult() {
    return (int) stack.pop().get();
  }
}
