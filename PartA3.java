/*
   Part-A
   3.Calculate the Probability of all Possible Sums occurring among the number of
   combinations from (2).
 */
public class PartA3 {
    private static final int MAX = 6;
    // To calculate the distribution of all possible combinations
    private static int[][] calculateCombinationDistribution() {
        int[][] distribution = new int[MAX][MAX];
        for (int i=0;i<MAX; i++) {
            for (int j=0;j<MAX;j++) {
                distribution[i][j] = i + j + 2; // Sum of Die A + Die B
            }
        }
        return distribution;
    }
    private static float[] calculateSumProbabilities(int[][] distribution) {
        float[] probabilities = new float[11]; // Probabilities for sums from 2 to 12
        int totalCombinations = MAX * MAX;
        for (int[] row : distribution) {
            for (int sum : row) {
                probabilities[sum - 2]++;
            }
        }
        for (int i=0;i<probabilities.length;i++) {
            probabilities[i] /= totalCombinations; // Calculate probabilities
        }   
        return probabilities;
    }
    public static void main(String[] args) {
        int[][] distribution = calculateCombinationDistribution();
        // To Calculate and display probabilities
        float[] probabilities = calculateSumProbabilities(distribution);
        System.out.println("\nProbability of all possible sums:");
        for (int i = 0; i < probabilities.length; i++) {
            System.out.printf("P(Sum = %d) = %.2f\n", (i + 2), probabilities[i]);
        }
    }
}
