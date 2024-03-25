/* 
    Part-A
    1. How many total combinations are possible? Show the math along with the code!
*/

public class PartA1 {
    public static void main(String[] args) {
        int dieA=6,dieB=6,sum=0;
        for(int i=1;i<=dieA;i++){
            for(int j=1;j<=dieB;j++){
                sum+=1;
            }
        }
        System.out.print("The Total Combination Of 2 Die : "+dieA*dieB);
    }
}
