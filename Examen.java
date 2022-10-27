public class Examen {
    private int returnIndexFirstPosiblePrimeNumber(boolean[] isPrimeNumber, int primeNumberOperator) {
        int index;
        int indexNumber = 0;
        for (index = 0; index < isPrimeNumber.length; index++) {
            indexNumber = index + 1;
            if (isPrimeNumber[index] && indexNumber > primeNumberOperator) {
                break;
            }
        }
        return indexNumber;
    }

    private boolean[] checkPrimeNumbersToMaxNumber(int maxNumber) {
        boolean[] isPrimeNumber = new boolean[maxNumber];
        int maxIteration = (int) Math.sqrt(maxNumber);
        int currentPrimeNumberOperator = 2;
        int indCurrentPrimeNumberOperator = currentPrimeNumberOperator - 1;
        int indexNumber;
        int iteration = 0;
        final int firstIteration = 1;
        while (++iteration <= maxIteration) {
            for (int index = indCurrentPrimeNumberOperator; index < isPrimeNumber.length; index++) {
                indexNumber = index + 1;
                if (iteration == firstIteration || isPrimeNumber[index]) {
                    isPrimeNumber[index] = indexNumber % currentPrimeNumberOperator != 0 || indexNumber == currentPrimeNumberOperator;
                }
            }
            currentPrimeNumberOperator = returnIndexFirstPosiblePrimeNumber(isPrimeNumber, currentPrimeNumberOperator);
        }
        return isPrimeNumber;
    }

    public int[] returnPrimeNumbersToMaxNumber(int maxNumber) {
        boolean[] isPrimeNumbers = checkPrimeNumbersToMaxNumber(maxNumber);
        int countQuantityPrimeNum = 0;
        for (int index = 0; index < isPrimeNumbers.length; index++) {
            if (isPrimeNumbers[index]) {
                countQuantityPrimeNum++;
            }
        }
        int[] primeNumbers = new int[countQuantityPrimeNum];
        int indexPrimeNumbers = 0;
        for (int index = 0; index < isPrimeNumbers.length; index++) {
            if (isPrimeNumbers[index]) {
                primeNumbers[indexPrimeNumbers++] = index + 1;
            }
        }
        return primeNumbers;
    }


    public void printArray(int[] array) {
        int changeLine = 15;
        int currentCountToChangeLine = 0;
        for (int index = 0; index < array.length; index++) {
            if (currentCountToChangeLine == changeLine) {
                System.out.println();
                currentCountToChangeLine = 0;
            }
            currentCountToChangeLine++;
            System.out.print(" " + array[index]);
        }
    }
}
