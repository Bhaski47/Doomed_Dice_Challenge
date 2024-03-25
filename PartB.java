import java.util.Arrays;

public class PartB {

    // Calculate scaling factor based on the sum of die faces
    public static double calculateScalingFactor(int[] dieA, int[] dieB) {
        double sumA = Arrays.stream(dieA).sum(); // Sum of die A faces
        double sumB = Arrays.stream(dieB).sum(); // Sum of die B faces
        return sumA / sumB;
    }

    // Adjust die B spots based on scaling factor
    public static int[] adjustDieBSpots(int[] dieB, double scalingFactor, int[] originalFrequency, int totalCombinationsBefore) {
        int[] adjustedFrequency = new int[originalFrequency.length];

        // Adjust frequency of each sum after reattaching spots
        for (int i = 0; i < originalFrequency.length; i++) {
            adjustedFrequency[i] = (int) Math.round(originalFrequency[i] * scalingFactor);
        }

        int totalCombinationsAfter = Arrays.stream(adjustedFrequency).sum(); // Total combinations after adjustment

        // Adjust spots in die B to maintain original probabilities
        int[] adjustedDieB = new int[dieB.length];
        for (int i = 0; i < dieB.length; i++) {
            adjustedDieB[i] = (int) Math.round(dieB[i] * totalCombinationsBefore / (double) totalCombinationsAfter);
        }
        return adjustedDieB;
    }

    // Calculate probabilities based on frequency list
    public static double[] calculateProbabilities(int[] frequencyList, int totalCombinations) {
        double[] probabilities = new double[frequencyList.length];
        for (int i = 0; i < frequencyList.length; i++) {
            probabilities[i] = frequencyList[i] / (double) totalCombinations;
        }
        return probabilities;
    }

    // Print probabilities with a given prefix
    public static void printProbabilities(double[] probabilities, String prefix) {
        for (int i = 0; i < probabilities.length; i++) {
            System.out.printf("%sP(Sum=%d) = %.4f%n", prefix, i, probabilities[i]);
        }
    }

    // Perform the adjustment of dice A and B
    public static int[] undoomDice(int[] dieA, int[] dieB) {
        // Calculate scaling factor based on die A and die B sums
        double scalingFactor = calculateScalingFactor(dieA, dieB);

        // Limit the values of die A to be within 1 and 4
        int[] a = Arrays.stream(dieA).map(spots -> Math.min(4, spots)).toArray();

        // Calculate total combinations before adjustment
        int totalCombinationsBefore = dieA.length * dieB.length;

        // Calculate original frequency of each sum
        int[] originalFrequency = new int[Arrays.stream(dieA).max().getAsInt() + Arrays.stream(dieB).max().getAsInt() + 1];
        for (int faceA : dieA) {
            for (int faceB : dieB) {
                originalFrequency[faceA + faceB]++;
            }
        }

        // Calculate adjusted frequency of each sum after reattaching spots
        int[] adjustedFrequency = new int[originalFrequency.length];
        for (int i = 0; i < originalFrequency.length; i++) {
            adjustedFrequency[i] = (int) Math.round(originalFrequency[i] * scalingFactor);
        }

        // Calculate total combinations after adjustment
        int totalCombinationsAfter = Arrays.stream(adjustedFrequency).sum();

        // Adjust spots in die B to maintain original probabilities
        int[] b = adjustDieBSpots(dieB, scalingFactor, originalFrequency, totalCombinationsBefore);

        // Calculate probabilities before and after reattachment
        double[] originalProbabilities = calculateProbabilities(originalFrequency, totalCombinationsBefore);
        double[] adjustedProbabilities = calculateProbabilities(adjustedFrequency, totalCombinationsAfter);

        // Print probabilities before and after reattachment
        System.out.println("Probabilities before reattachment:");
        printProbabilities(originalProbabilities, "  ");

        System.out.println("\nProbabilities after reattachment:");
        printProbabilities(adjustedProbabilities, "  ");

        return a;
    }

    public static void main(String[] args) {
        // Example dice values
        int[] dieA = {1, 2, 3, 4, 5, 6};
        int[] dieB = dieA;

        // Perform dice adjustment
        int[] newDieA = undoomDice(dieA, dieB);

        // Display modified values of die A
        System.out.println("\nModified Values of the dice:");
        System.out.println("New Die A: " + Arrays.toString(newDieA));
        System.out.println("New Die B: " + Arrays.toString(dieB));
    }
}
