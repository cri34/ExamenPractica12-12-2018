public class ExamenTest {
    static String text = "Programa un mètode static que donats un text i un subtext ens retorni una versió del text eliminant les aparicions del subtext. El mètode ha de retornar un string amb el text eliminades les aparicions del subtext. Has de tractar els strings de forma matricial, l’únic mètode de la classe String que pots emprar és length().";
    static char[] delimitors = {' ', '.', ',', ';'};

    public static void main(String[] args) {
        Examen e = new Examen();

        e.printArray(e.returnPrimeNumbersToMaxNumber(1000));
        e.returnFactorDecomposition(4923);
        System.out.println(returnStringWithoutWordsEntered("text"));
    }
//3 quitar palabra de un texto
    public static String returnStringWithoutWordsEntered(String wordEntered) {
        String textWithoutWordsEntered = "";
        String word = "";
        boolean delimiter = false;
        char[] textChars = new char[text.length()];
        for (int index = 0; index < textChars.length; index++) {
            textChars[index] = text.charAt(index);
        }

        for (int index = 0; index < textChars.length; index++) {
            for (int indDelimiter = 0; indDelimiter < delimitors.length; indDelimiter++) {
                if (textChars[index] == delimitors[indDelimiter]) {
                    delimiter = true;
                    break;
                }
            }

            if (delimiter) {
                if (!word.equals(wordEntered)) {
                    textWithoutWordsEntered += word + textChars[index];
                }
                word = "";
                delimiter = false;
                continue;
            }
            word += textChars[index];
        }
        return textWithoutWordsEntered;
    }
}

