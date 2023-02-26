# PostFixCalc
Postfix expression calculator - ADS1 Assignment 1

![CodeFactor Grade](https://img.shields.io/codefactor/grade/github/IB-315168/PostFixCalc/master)

## Usage
- Use an instance of `PostFixCalcImpl` class

- Construct your expression in form of an ArrayList using postfix notation
  - Use `Operand` to wrap your numbers
  - Use `Operator` to wrap your operators
  
### Method
  
```java
  int evaluateExpression(ArrayList<Token> tokenList)
```
  
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `tokenList` | `ArrayList<Token>` | **Required**. Your postfix expression |

For further reference, see usage example in `Main`.
  
   
 ## Exceptions
 If expression is invalid (invalid amount of operands or operators/incorrect order/any other case):
 - `evaluateExpression` will throw an IllegalArgumentException
 - Stack will be cleared
