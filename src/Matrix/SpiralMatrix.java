package Matrix;

public class SpiralMatrix {
    public void spiralPrint(int[][]matrix, int r, int c){
        int i,k = 0,l=0;
        while (k< r && l< c){
            for(i=l; i < c; i++){ // l-> R
                System.out.print(matrix[k][i] + " ");
            }
            k++;
            for(i =k; i < r; i++) { // T->B
                System.out.print(matrix[i][c-1] + " ");
            }
            c--;
            if(k<r){
                for (i=c-1; i >=l; i--) { //R->L
                    System.out.print(matrix[r-1][i] + " ");
                }
                r--;
            }
            if (l<c){
                for (i=r-1; i >=k; i--) { // B->T
                    System.out.print(matrix[i][l] + " ");
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };

        SpiralMatrix sm = new SpiralMatrix();
        sm.spiralPrint(matrix, 4, 4);
    }
}
