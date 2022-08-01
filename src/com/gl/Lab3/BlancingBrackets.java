package com.gl.Lab3;

import java.util.Stack;

public class BlancingBrackets {
	static boolean checkingBracketsBalanced(String strBalanceBrackets) {
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<strBalanceBrackets.length();i++)
		{
			char character = strBalanceBrackets.charAt(i);
			if(character == '{'|| character =='['|| character=='(') 
			{
			stack.push(character);
			continue;
			}
			if(stack.isEmpty())
				return false;
			char c;
			switch(character) {
			case'}':
				c=stack.pop();
				if(c=='('|| c=='[')
					return false;
				break;
			case')':
				c=stack.pop();
				if(c=='{'|| c=='[')
					return false;
				break;
			case']':
				c=stack.pop();
				if(c=='('|| c=='{')
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}
	public static void main(String[] args) {
		String strBracketExpression1="([[{}]])";
		String strBracketExpression2="([[{}]]))";
		Boolean result1;
		result1= checkingBracketsBalanced(strBracketExpression1);
		if(result1)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
		Boolean result2;
		result2= checkingBracketsBalanced(strBracketExpression2);
		if(result2)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}
