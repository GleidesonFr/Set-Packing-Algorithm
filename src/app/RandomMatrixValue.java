package app;

import java.util.Random;

import promptInterface.Printer;

public class RandomMatrixValue {

    public static int[][] initRandomMatrixValues(int valueI, int valueJ){
        int Matrix[][] = new int[valueI][valueJ];
        Random random = new Random();

        for(int i = 0; i < valueI; i++){
            for(int j = 0; j < valueJ; j++){
                Matrix[i][j] = random.nextInt(2);
            }
        }
        
        Printer.printArray(Matrix, valueI, valueJ);

        return Matrix;
    }
}
