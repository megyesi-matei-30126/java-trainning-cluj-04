public class Test {
    public static void main(String[] args) {
        /*EX 1 */
        Integer integer1 = 127;
        Integer integer2 = 127;
        System.out.println(integer1.equals(integer2));
        System.out.println(integer2 == integer1);

        /*EX 2*/
        Integer integer3 = Integer.valueOf(127);
        Integer integer4 = Integer.valueOf(127);
        System.out.println(integer3.equals(integer4));
        System.out.println(integer3 == integer4);
        
    }
}
