import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
public class PartB {
    static ArrayList<ArrayList<Integer>> diceA = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> diceB = new ArrayList<>();
    static HashMap<Integer, Integer> originalSums = new HashMap<>();
    static HashMap<Integer, Double> originalPossibility = new HashMap<>();
    static int totCombination;
    public static void main(String[] args) {
        int[] Die_A = {1,2,3,4,5,6};
        int[] Die_B = {1,2,3,4,5,6};
        System.out.print("Original DiceA = ");
        Arrays.toString(Die_A);
        System.out.print("Original DiceB = ");
        Arrays.toString(Die_B);
        totCombination = Die_A.length * Die_B.length;
        for (int i:Die_A) {
            for (int j:Die_B) {
                int sum = i+j;
                int occurrences = originalSums.getOrDefault(sum,0) + 1;
                originalSums.put(sum,occurrences);
            }
        }
        for (int key : originalSums.keySet()) {
            originalPossibility.put(key,(double) originalSums.get(key)/totCombination);
        }
        System.out.println("\nOriginal Probabilities: ");
        for (int key : originalPossibility.keySet()) {
            System.out.println("P(Sum = " + key + ")  Occurrence = " + originalSums.get(key) + "  Probability = " + originalPossibility.get(key));
        }
        System.out.println();
        changeDice(Die_A,Die_B);
    }
    static void changeDice(int[] Die_A, int[] Die_B) {
        for (int i = 1; i < 5; i++) {
            ArrayList<Integer> tempA = new ArrayList<>();
            tempA.add(i);
            diceAPossibility(i, tempA);
        }
        for (int j = 1; j < 12; j++) {
            ArrayList<Integer> tempB = new ArrayList<>();
            tempB.add(j);
            diceBPossibility(j, tempB);
        }
        System.out.println("Undooming Dice A and Dice B...");
        for (ArrayList<Integer> i : diceA) {
            for (ArrayList<Integer> j : diceB) {
                HashMap<Integer, Integer> temp = new HashMap<>();
                for (int k = 0; k < i.size(); k++) {
                    for (int l = 0; l < j.size(); l++) {
                        int sum = i.get(k) + j.get(l);
                        temp.put(sum, temp.getOrDefault(sum, 0) + 1);
                    }
                }
                int c = 0;
                for (Integer key : temp.keySet()) {
                    if (temp.get(key).equals(originalSums.getOrDefault(key, -1))) {
                        c++;
                    }
                }
                if (c == 11) {
                    System.out.println("Transformed Dice A -> " + i);
                    System.out.println("Transformed Dice B -> " + j);
                    System.out.println("\nProbability of Dice After Transforming:");
                    for (Integer key : temp.keySet()) {
                        System.out.println("P(Sum = " + key + ") Occurrence = " + temp.get(key) + "  Probability = " + ((double) temp.get(key) / totCombination));
                    }
                    return;
                }
            }
        }
    }
    static void diceAPossibility(int number, ArrayList<Integer> temp) {
        if (number > 4) return;
        if (temp.size() > 6) return;
        if (temp.size() == 6) {
            if (!diceA.contains(temp)) {
                diceA.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = number; i <= 5; i++) {
            ArrayList<Integer> newTemp = new ArrayList<>(temp);
            newTemp.add(i);
            diceAPossibility(i, newTemp);
        }
    }
    static void diceBPossibility(int number, ArrayList<Integer> temp) {
        if (number > 11) return;
        if (temp.size() > 6) return;
        if (temp.size() == 6) {
            if (!diceB.contains(temp)) {
                diceB.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = number + 1; i <= 12; i++) {
            ArrayList<Integer> newTemp = new ArrayList<>(temp);
            newTemp.add(i);
            diceBPossibility(i, newTemp);
        }
    }
    static void printArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
