package tests.practice;

import org.junit.*;

public class Q02 {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class calisti");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Tum testler calistirildi. After class calisti");
    }

    @Before
    public void before(){
        System.out.println("Yeni bir test calisiyor");
    }

    @After
    public void after(){
        System.out.println("Test sonlandirildi.Siradaki teste geciliyor");
    }

    @Test
    public void test01(){
        System.out.println("1 numarali test calistiriliyor");
    }

    @Test
    public void test02(){
        System.out.println("2 numarali test calistiriliyor");
    }

    @Test
    public void test03(){
        System.out.println("3 numarali test calistiriliyor");
    }



}
