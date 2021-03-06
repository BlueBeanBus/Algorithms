package search.backtracking;

import java.util.BitSet;
import java.util.Stack;

/**
 * Please generate all combinations of a given string. For example, combinations of a given string
 * “abc” are “a”, “b”, “c”, “ab”, “ac”, “bc”, and “abc”.
 */
public class StringCombination {
    // ==================== solution 1 ====================
    public static void combination_solution1(String str) {
        Stack<Character> result = new Stack<Character>();
        for(int i = 1; i <= str.length(); ++ i) {
            combination(str, 0, i, result);
        }
    }

    private static void combination(String str, int index, int number, Stack<Character> result) {
        if(number == 0) {
            System.out.println(result);
            return;
        }

        if(index == str.length())
            return;

        // select the character str[index]
        result.push(str.charAt(index));
        combination(str, index + 1, number - 1, result);
        result.pop();

        // ignore the character str[index]
        combination(str, index + 1, number, result);
    }

    // ==================== solution 2 ====================
    public static void combination_solution2(String str) {
        BitSet bits = new BitSet(str.length());
        while(increment(bits, str.length()))
            print(str, bits);
    }

    private static boolean increment(BitSet bits, int length) {
        int index = length - 1;

        while(index >= 0 && bits.get(index)) {
            bits.clear(index);
            --index;
        }

        if(index < 0)
            return false;

        bits.set(index);
        return true;
    }

    private static void print(String str, BitSet bits) {
        for(int i = 0; i < str.length(); ++i) {
            if(bits.get(i))
                System.out.print(str.charAt(i));
        }

        System.out.println();
    }

    public static void main(String args[]) {
        //StringCombination.combination_solution1("");
        //StringCombination.combination_solution1("a");
        StringCombination.combination_solution2("ab");
        /*
        test("abc");
        test("abcd");*/
    }
}
