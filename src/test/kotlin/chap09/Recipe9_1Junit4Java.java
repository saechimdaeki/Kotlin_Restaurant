package chap09;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  Junit4
public class Recipe9_1Junit4Java {

    private static List<String> strings =
        Arrays.asList("this", "is", "a", "list", "of", "strings");

    private List<Integer> modifiable = new ArrayList<>();

    @BeforeClass
    public static void runBefore() {
        System.out.println("BeforeClass : " + strings);
    }

    @Before
    public void initialize() {
        System.out.println("Before: " + modifiable);
        modifiable.add(3);
        modifiable.add(1);
        modifiable.add(4);
        modifiable.add(1);
        modifiable.add(5);
    }

    @Test
    public void test1() {
        //...
    }

    @After
    public void finish() {
        System.out.println("After: " + modifiable);
    }

    @AfterClass
    public static void runAfter() {
        System.out.println("AfterClass: " + strings);
    }

}
