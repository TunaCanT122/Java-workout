public class Hourglass_size {    
    public static final int hour_glass_sub_height=10;
    public static void main(String[] args) {
        linecap();
        top();
        bot();
        linecap();
    }
    public static void linecap() {
        System.out.print("+");
        for(int i=1; i <= hour_glass_sub_height*2; i++){
            System.out.print("-");
        }
        System.out.print("+");
        System.out.println();
    }
    public static void top(){
        for (int i=1; i<=hour_glass_sub_height; i++ ){
            System.out.print("|");
            for (int j=1; j<i; j++){
                System.out.print(" ");
            }
            System.out.print("\\");
            for (int j=1; j<=(hour_glass_sub_height-i)*2; j++){
                System.out.print(".");
            }
            System.out.print("/");
            for (int j=1; j<i; j++){
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();
        }
    }
    public static void bot(){
        for (int i=1; i<=hour_glass_sub_height; i++ ){
            System.out.print("|");
            for (int j=1; j<= hour_glass_sub_height-i; j++){
                System.out.print(" ");
            }
            System.out.print("/");
            for (int j=1; j<=i*2-2; j++){
                System.out.print(".");
            }
            System.out.print("\\");
            for (int j=1; j<= hour_glass_sub_height-i; j++){
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
