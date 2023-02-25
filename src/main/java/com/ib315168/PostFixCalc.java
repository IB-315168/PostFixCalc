package com.ib315168;

import com.ib315168.models.Token;

import java.util.ArrayList;

public interface PostFixCalc
{
  int evaluateExpression(ArrayList<Token> tokenList);
}
