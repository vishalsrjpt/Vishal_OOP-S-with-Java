public class test{
    public static void main(String[] args) {
        try{
        int a;
        scanner sc = new scanner(System.in);
        a = sc.nextInt();

        int b;
        scanner sc1 = new scanner(System.in);
        b = sc1.nextInt();

        int c = a + b;
        System.out.println("The sum of a and b is: " + c);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("This is a finally block.");
        }
    }   
}
