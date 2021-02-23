package com.acme;

import java.util.stream.Collectors;

class SpacifyString
{
    private static final String EXPECTED = "H e l l o   w o r l d !";
    private static final String EXPECTED_EMPTY = "";
    
    public static void main(String... args)
    {
        check(1, EXPECTED, spacify("Hello world!"));
        check(2, EXPECTED, spacify(" Hello world!"));
        check(3, EXPECTED, spacify("Hello world! "));
        check(4, EXPECTED, spacify(" Hello world! "));
        check(5, EXPECTED_EMPTY, spacify(""));
        check(6, EXPECTED_EMPTY, spacify(" "));
        check(7, EXPECTED_EMPTY, spacify("    "));
        check(8, EXPECTED_EMPTY, spacify(null));
    }
    
    private static void check(int index, String expected, String actual)
    {
        if(expected.equals(actual))
        {
            System.out.println(index + " - OK");
        }
        else
        {
            System.out.println(index + " - FAILED with result [" + actual + "]");
        }
    }
    
    private static String spacify(final String str)
    {
        if(str == null)
        {
            return EXPECTED_EMPTY;
        }
        final String spacified = str.chars().mapToObj(v -> (char) v + " ").collect(Collectors.joining());
        return spacified.strip();
    }
}
