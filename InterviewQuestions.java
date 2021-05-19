
package interviewquestions;

import java.util.*;


public class InterviewQuestions {

    
    public static void main(String[] args) {
        
        System.out.println(isPalendrome("RaceCar"));
        System.out.println(isPalendrome("HelloWorld"));
        System.out.println(isPalendrome("W"));
        System.out.println("---------------");
        System.out.println(IsBalancedExpression("{()}(){()}"));
        System.out.println(IsBalancedExpression("{(})"));
        System.out.println(IsBalancedExpression("{(5 + 6) - (3 * 4)}"));
        System.out.println("---------------");
        System.out.println(EvaluateExpression("45+34*-"));
        System.out.println(EvaluateExpression("138*+"));
        System.out.println(EvaluateExpression("6+38*"));   
        System.out.println(EvaluateExpression("65+38*7")); 

        
       
    }//main
    
    
        public static boolean isPalendrome(String input) {
        
        String myString = "";
        Stack<Character> myStack = new Stack<Character>();
        
        char[] array = input.toCharArray();
        
              for(int i = 0; i < input.length(); i++) {
                  myStack.add(array[i]);//adding chars into stack
              }
        
              for(int i =0; i < input.length(); i++) {
                 myString += myStack.pop();//popping stack elements into a string
              }
              
             // System.out.println(myString);
              
              if(myString.toLowerCase().equals(input.toLowerCase())) {
                  return true;
              }
              else {
                  return false;
              }     
        
              
    }//isPalindrome
    
    
    
        
        public static boolean IsBalancedExpression(String input) {
            
            char[] array = input.toCharArray();
            Stack<Character> myStack = new Stack<Character>();
            
            for(int i = 0; i < array.length; i++) {
                
                if(array[i]=='{' || array[i]=='(') {
                    myStack.push(array[i]);
                }
                
                else if( array[i]=='}' || array[i]==')') {
                    char x = myStack.pop();
                    char y = array[i];
                    if( x =='(' && y == '}') {
                        return false;
                    }
                    else if( x == '{' && y == ')') {
                        return false;
                    }
                }//else if
            }//for loop

            
            return true;
            
            
        }//method
        
        
        public static int EvaluateExpression(String input) {
            
            char[] array = input.toCharArray();
            Stack<Integer> myStack = new Stack<Integer>();
            
            for(int i = 0; i < array.length; i++) {
                
                if(Character.isDigit(array[i])) {
                    myStack.push(Character.getNumericValue(array[i]));
                    //System.out.println(myStack);
                }
                else if(array[i]=='+'||array[i]=='-'||array[i]=='*'||array[i]=='/') {
                    
                    if(myStack.size()< 2) {
                        System.out.println("Invalid Expression");
                        return 0;
                    }
                    else if(array[i]=='+') {
                        int a = myStack.pop();
                        int b = myStack.pop();
                        int total = a+b;
                        myStack.push(total);
                       // System.out.println(myStack);
                    }
                    else if(array[i]=='-') {
                        int a = myStack.pop();
                        int b = myStack.pop();
                        int total = b-a;
                        myStack.push(total);
                        //System.out.println(myStack);
                    }
                    else if(array[i]=='*') {
                        int a = myStack.pop();
                        int b = myStack.pop();
                        int total = a*b;
                        myStack.push(total);
                       // System.out.println(myStack);
                    }
                    else if(array[i]=='/') {
                        int a = myStack.pop();
                        int b = myStack.pop();
                        int total = b/a;
                        myStack.push(total);
                       // System.out.println(myStack);
                    }
                 
                    
                }//big else if
          
            }//for loop
            
            if(myStack.size()>=3) {
                System.out.println("Invalid Expression");
                return 0;
            }
            
           // System.out.println(myStack);
            return myStack.pop();
        }
        
    
    
    
}//class
