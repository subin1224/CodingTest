package subin_Study;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "test";
        String str2 = new String("test");

        System.out.println(str1);
        System.out.println(str2);

        System.out.println( str1==str2 );

        String str3 = "test";
        String str4 = new String("test");

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
        System.out.println(System.identityHashCode(str3));
        System.out.println(System.identityHashCode(str4));
    }
}
