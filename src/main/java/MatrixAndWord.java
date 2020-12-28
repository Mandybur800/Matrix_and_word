public class MatrixAndWord {
    public String getCoordinate(String matrixString, String word) {
        char[][] matrix = getMatrix(matrixString);
        word = word.toUpperCase();
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[i].length - 1; j++) {
                String result;
                if (word.charAt(0) == matrix[i][j]) {
                    char[][] arr = cloneMatrix(matrix);
                    arr[i][j] = '#';
                    result = checkForWord(arr, i, j, word.substring(1),
                            ("[" + (i - 1) + "," + (j - 1) + "]"));
                    if (!result.equals("ERROR")) {
                        System.out.println(word);
                        System.out.println(result);
                        return result;
                    }
                }
            }
            System.out.println();
        }
        throw new RuntimeException("Word was not find!");
    }

    private String checkForWord(char[][] matrix, int positionX,
                                       int positionY, String word, String result) {
        if (word.isEmpty()) {
            return result;
        }
        if (word.charAt(0) == matrix[positionX + 1][positionY]) {
            char[][] arr = cloneMatrix(matrix);
            arr[positionX + 1][positionY] = '#';
            String localResult = result;
            localResult += ("->[" + (positionX) + "," + (positionY - 1) + "]");
            localResult = checkForWord(arr, positionX + 1, positionY,
                    word.substring(1), localResult);
            if (!localResult.equals("ERROR")) {
                return localResult;
            }
        }
        if (word.charAt(0) == matrix[positionX - 1][positionY]) {
            char[][] arr = cloneMatrix(matrix);
            arr[positionX - 1][positionY] = '#';
            String localResult = result;
            localResult += ("->[" + (positionX - 2) + "," + (positionY - 1) + "]");
            localResult = checkForWord(arr, positionX - 1, positionY,
                    word.substring(1), localResult);
            if (!localResult.equals("ERROR")) {
                return localResult;
            }
        }
        if (word.charAt(0) == matrix[positionX][positionY + 1]) {
            char[][] arr = cloneMatrix(matrix);
            arr[positionX][positionY + 1] = '#';
            String localResult = result;
            localResult += ("->[" + (positionX - 1) + "," + (positionY) + "]");
            localResult = checkForWord(arr, positionX, positionY + 1,
                    word.substring(1), localResult);
            if (!localResult.equals("ERROR")) {
                return localResult;
            }
        }
        if (word.charAt(0) == matrix[positionX][positionY - 1]) {
            char[][] arr = cloneMatrix(matrix);
            arr[positionX][positionY - 1] = '#';
            String localResult = result;
            localResult += ("->[" + (positionX - 1) + "," + (positionY - 2) + "]");
            localResult = checkForWord(arr, positionX, positionY - 1,
                    word.substring(1), localResult);
            if (!localResult.equals("ERROR")) {
                return localResult;
            }
        }
        return "ERROR";
    }

    private char[][] cloneMatrix(char[][] matrix) {
        char[][] arr = new char[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            arr[i] = matrix[i].clone();
        }
        return arr;
    }

    private char[][] getMatrix(String matrix) {
        double side = Math.sqrt(matrix.length());
        if (side % 1 != 0) {
            throw new RuntimeException("Incorrect matrix!");
        }
        matrix = matrix.toUpperCase();
        int index = 0;
        char[][] array = new char[(int) side + 2][(int) side + 2];
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array[i].length - 1; j++) {
                array[i][j] = matrix.charAt(index++);
            }
        }
        return array;
    }
}
