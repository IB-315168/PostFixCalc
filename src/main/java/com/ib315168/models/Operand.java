package com.ib315168.models;

import java.util.Arrays;

public class Operand implements Token
{
  private int number;

  public Operand(int number)
  {
    this.number = number;
  }

  @Override public Integer get()
  {
    return number;
  }

  @Override public void set(Object value) throws Exception
  {
    if (!(value instanceof Integer))
    {
      throw new Exception("Unrecognized symbol: " + value.toString());
    }

    this.number = (int) value;
  }
}
