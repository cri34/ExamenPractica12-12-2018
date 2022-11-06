public class Examen {
    //1
    private boolean[] checkPrimeNumbersToMaxNumber(int maxNumber) {
        boolean[] isPrimeNumber = new boolean[maxNumber];
        final int maxOperator = (int) Math.sqrt(maxNumber);

        for (int index = 1; index < isPrimeNumber.length; index++) {
            isPrimeNumber[index] = true;
        }
        for (int operator = 2; operator <= maxOperator; operator++) {
            for (int number = 2; number * operator <= isPrimeNumber.length; number++) {
                if (isPrimeNumber[(number * operator) - 1]) {
                    isPrimeNumber[(number * operator) - 1] = false;
                }
            }
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
        System.out.println();
    }

    //2 descomposición de factores
    public void returnFactorDecomposition(int numberToDescompose) {
        int[] primeNumbers = returnPrimeNumbersToMaxNumber(numberToDescompose);
        int dividend = numberToDescompose;
        int indexDivider = 0;
        System.out.println("Factor Descomposition of number "+ numberToDescompose);
        while (dividend != 1) {
            if (dividend % primeNumbers[indexDivider] == 0) {
                dividend = dividend / primeNumbers[indexDivider];
                System.out.print(" "+primeNumbers[indexDivider]);
            }
            if (dividend % primeNumbers[indexDivider] != 0){
                indexDivider++;
            }
        }
        System.out.println();
    }
}
