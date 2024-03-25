/*
    Part-A
    2.Calculate and display the distribution of all possible combinations that can be
    obtained when rolling both Die A and Die B together.
*/
public class PartA2 {
    public static void main(String[] args) {
        int dieA=6,dieB=6;
        int i,j;
        for(i=1;i<=dieA;i++){
            for(j=1;j<=dieB;j++){
                System.out.print(" ( "+i+" , "+j+" ) "); //Printing all the distribution of all possible combinations that can be obtained when rolling both Die A and Die B together
            }
            System.out.println();
        }
    }
}
