package matices;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args){
        int[] teamA = {3,8,5};
        int[] teamB = {5,6,6};
        int[] oldScore = {3,2,1};
        int[] newScore = {4,3,2};
                                  // 0      1
        int[][] teamMatrices = {{3,8,5}, {5,6,6}};
        int[][] scoreMatrices = {{3,4}, {2,3}, {1,2}};
        int[][] finalResult = new int[2][2];

        // 2 rows .. 3 cols
        // 3 rows .. 2 cols
        int formula1 = (teamMatrices[0][0] * scoreMatrices[0][0]) + (teamMatrices[0][1] * scoreMatrices[1][0])   +  (teamMatrices[0][2] * scoreMatrices[2][0]) ;
        int formula2 = (teamMatrices[0][0] * scoreMatrices[0][1]) + (teamMatrices[0][1] * scoreMatrices[1][1])   +  (teamMatrices[0][2] * scoreMatrices[2][1]) ;
        int formula3 = (teamMatrices[1][0] * scoreMatrices[0][0]) + (teamMatrices[1][1] * scoreMatrices[1][0])   +  (teamMatrices[1][2] * scoreMatrices[2][0]) ;
        int formula4 = (teamMatrices[1][0] * scoreMatrices[0][1]) + (teamMatrices[1][1] * scoreMatrices[1][1])   +  (teamMatrices[1][2] * scoreMatrices[2][1]) ;


        int[][] result = {{formula1, formula2}, {formula3, formula4}};
        for (int r = 0; r < result.length; r++){
            for (int c = 0; c < result[r].length; c++){
                System.out.print(result[r][c] + " ");
            }
            System.out.println();
        }

        System.out.println("**************");

        for (int row = 0; row < teamMatrices.length; row++){
            for (int col = 0; col < scoreMatrices[col].length; col++){
                finalResult[row][col] = 0;
                finalResult[row][col] += teamMatrices[row][col] * scoreMatrices[col][row];
                System.out.print(finalResult[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println("*******************");

//   


        System.out.println("Team matrix is:");

        for (int row = 0; row < teamMatrices.length; row++){
            for (int col = 0; col < teamMatrices[row].length; col++){
                 int arrIndex = teamMatrices[row][col];
                System.out.print(arrIndex + " ");
            }
            System.out.println();
        }


        System.out.println("Score matrix is:");

        for (int row = 0; row < scoreMatrices.length; row++){
            for (int col = 0; col < scoreMatrices[row].length; col++){
                System.out.print(scoreMatrices[row][col] + " ");
            }
            System.out.println();
        }

    }
}
