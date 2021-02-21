package com.codingame.chucknorris;

import java.util.Scanner;
import java.util.stream.Collectors;

class Solution
{
    private static final String SEPARATOR = " ";
    private static final char ZERO = '0';
    private static final char ONE = '1';
    
    public static void main(String[] args)
    {
        final Scanner in = new Scanner(System.in);
        final String message = in.nextLine();
        
        final String binaryMessage = getBinaryString(message);
        
        final StringBuilder sb = encodeChuckNorris(binaryMessage);
        System.out.println(sb.toString());
    }
    
    public String solve(String message)
    {
        final String binaryMessage = getBinaryString(message);
        return encodeChuckNorris(binaryMessage).toString();
    }
    
    private static String getBinaryString(final String message)
    {
        return message.chars()
                      .mapToObj(Integer::toBinaryString)
                      .map(v -> v.length() == 7 ? v : ZERO + v)
                      .collect(Collectors.joining());
    }
    
    private static StringBuilder encodeChuckNorris(final String binaryMessage)
    {
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < binaryMessage.length(); )
        {
            char currentChar;
            if(binaryMessage.charAt(i) == ZERO)
            {
                currentChar = ZERO;
                sb.append(ZERO).append(ZERO);
            }
            else
            {
                currentChar = ONE;
                sb.append(ZERO);
            }
            sb.append(SEPARATOR);
            while(binaryMessage.charAt(i) == currentChar)
            {
                sb.append(ZERO);
                i++;
                if(i >= binaryMessage.length())
                {
                    break;
                }
            }
            if(i < binaryMessage.length())
            {
                sb.append(SEPARATOR);
            }
        }
        return sb;
    }
}
