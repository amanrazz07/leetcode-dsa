import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static int findMaximumDecimal(int totalBlocks, List<Integer> onesLengths, List<Integer> zerosLengths) {
        long modLimit = 1000000007;

        Collections.sort(onesLengths, Collections.reverseOrder());
        Collections.sort(zerosLengths);

        long finalDecimal = 0;

        for (int i = 0; i < totalBlocks; i++) {
            long onesMultiplier = calculateModularPower(2, onesLengths.get(i), modLimit);
            finalDecimal = (finalDecimal * onesMultiplier) % modLimit;
            finalDecimal = (finalDecimal + onesMultiplier - 1 + modLimit) % modLimit;

            long zerosMultiplier = calculateModularPower(2, zerosLengths.get(i), modLimit);
            finalDecimal = (finalDecimal * zerosMultiplier) % modLimit;
        }

        return (int) finalDecimal;
    }

    private static long calculateModularPower(long baseNum, long exponentNum, long modLimit) {
        long powerResult = 1;
        baseNum %= modLimit;

        while (exponentNum > 0) {
            if ((exponentNum & 1) == 1) {
                powerResult = (powerResult * baseNum) % modLimit;
            }
            exponentNum >>= 1;
            baseNum = (baseNum * baseNum) % modLimit;
        }

        return powerResult;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        if (!inputScanner.hasNextInt()) return;

        int totalBlocks = inputScanner.nextInt();

        List<Integer> onesLengths = new ArrayList<>(totalBlocks);
        for (int i = 0; i < totalBlocks; i++) {
            onesLengths.add(inputScanner.nextInt());
        }

        List<Integer> zerosLengths = new ArrayList<>(totalBlocks);
        for (int i = 0; i < totalBlocks; i++) {
            zerosLengths.add(inputScanner.nextInt());
        }

        int maximumDecimal = findMaximumDecimal(totalBlocks, onesLengths, zerosLengths);
        System.out.println(maximumDecimal);

        inputScanner.close();
    }
}