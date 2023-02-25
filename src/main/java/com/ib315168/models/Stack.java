package com.ib315168.models;

import java.util.LinkedList;

public class Stack
{
  private static Stack INSTANCE = null;
  private LinkedList<Token> stack;

  private Stack()
  {
    this.stack = new LinkedList<>();
  }

  public void push(Token token) {
    stack.push(token);
  }

  public Token pop() {
    return stack.pop();
  }

  public int size() {
    return stack.size();
  }

  public static Stack getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new Stack();
    }

    return INSTANCE;
  }

  // Debug purposes only
  public void visualize() {
    System.out.println("------------------------------");
    for(Token token : stack) {
      System.out.println(token.get());
    }
    System.out.println("------------------------------");
  }
}
