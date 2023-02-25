package com.ib315168.models;

import java.util.Arrays;

public class Operator implements Token
{
  private char value;

  public Operator(char value)
  {
    this.value = value;
  }

  @Override public Character get()
  {
    return value;
  }

  @Override public void set(Object value) throws Exception
  {
    if (!(value instanceof Character) || !(Arrays.asList('+', '-', '/', '*')
        .contains((char) value)))
    {
      throw new Exception("Unrecognized symbol: " + value.toString());
    }

    this.value = (char) value;
  }
}
