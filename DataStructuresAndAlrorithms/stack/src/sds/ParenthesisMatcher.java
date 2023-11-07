package sds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Math Parenthesis in an Expression
 */
public class ParenthesisMatcher {

    private static final Map<Character, Character> matchingParentMap = new HashMap<>();
    private static final Set<Character> openingParentSet = new HashSet<>();

    static {
        matchingParentMap.put(')', '(');
        matchingParentMap.put(']', '[');
        matchingParentMap.put('}', '{');
        openingParentSet.addAll(matchingParentMap.values());
    }

    public static void main(String[] args) {
        System.out.println(String.format(
                "Has matching parens %s? : %s", "(abcd)", hasMatchingParenthesis("(abcd)")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}", hasMatchingParenthesis("{{{{}}")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}})", hasMatchingParenthesis("{{{{}}})")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}}()", hasMatchingParenthesis("{{{}}}()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}]()", hasMatchingParenthesis("{{{}}]()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{}}([]){}{}{}{}{[[[[]]]]}",
                hasMatchingParenthesis("{{}}([]){}{}{}{}{[[[[]]]]}")));

    }

    public static boolean hasMatchingParenthesis(String input){
        try {
            Stack<Character> parentStack = new Stack<>();
            for(int i = 0; i < input.length(); i++){
                char ch = input.charAt(i);
                // Add to the stack for on opening parenthesis
                if(openingParentSet.contains(ch)){
                    parentStack.push(ch);
                }

                if(matchingParentMap.containsKey(ch)){
                    Character lastParenthesis = parentStack.pop();
                    if( lastParenthesis != matchingParentMap.get(ch)){
                        return false;
                    }
                }
            }
            return parentStack.isEmpty();
        } catch(Stack.StackOverflowException soe) {
            System.err.println("Stack Overflow");
        } catch(Stack.StackUnderflowException sue) {
            System.err.println("Stack Underflow");
        }
        return false;
    }
}
