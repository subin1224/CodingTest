package subin;

public class DefangingAnIP {
    public static void main(String[] args) {
        String str="1.1.1.1";
        System.out.println(defangIPaddr(str));
    }

    public static String defangIPaddr(String address) {
        /*
        https://leetcode.com/problems/defanging-an-ip-address/
        */
        return address.replace(".", "[.]");
    }
}
