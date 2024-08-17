
/*
Problem Description
You are given an integer A in decimal (base 10).
Return a string denoting the binary (base 2) form of the integer A.



Problem Constraints
1 <= A <= 109



Input Format
The first line of input contains the integer T, denoting the number of test cases.
Next T lines contain a single integer A, denoting the integer for that test case.



Output Format
Print T lines. In each line, print the string denoting the binary representation of A.



Example Input
Input 1:

 1
 10
Input 2:

 2
 10
 11


Example Output
Output 1:

 1010
Output 2:

 1010
 1011


Example Explanation
Explanation 1:

The binary form of 10 is given by -> '1010'
Explanation 2:

The binary form of 11 is given by -> '1011' 
*/
import java.util.*;

public class DecimalToBinary {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int num = sc.nextInt();
            String str = "";
            while (num > 0) {
                int rem = num % 2;
                num = num / 2;
                str = rem + str;
            }
            System.out.println(str);
        }

    }
}

// 969937577
// 1437203209
