package other;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Matrix {

    public int[][] data;
    private int rows, cols;
    // TODO: split matrix in rows and cols (padd if not enough?)
    // TODO: vertical and horizontal split

    public Matrix() {
    }

    public Matrix(int row, int col) {
        this.rows = row;
        this.cols = col;
        this.data = new int[row][col];
    }

    public Matrix(int[][] data) {
        this.rows = data.length;
        this.cols = (rows == 0) ? 0 : data[0].length;
        this.data = Arrays.copyOf(data, data.length);
    }

    public int get(int row, int col) {
        return data[row][col];
    }

    public void set(int row, int col, int value) {
        data[row][col] = value;
    }

    public static Matrix Identity(int size) {
        Matrix eye = new Matrix(size, size);
        for (int i = 0; i < size; i++)
            eye.data[i][i] = 1;
        return eye;
    }

    public static Matrix Random(int row, int col, int high) {
        Matrix matrix = new Matrix(row, col);
        Random random = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix.data[i][j] = random.nextInt(high);
            }
        }
        return matrix;
    }

    public Matrix add(Matrix other) {
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix subtract(Matrix other) {
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows)
            throw new IllegalMatrixArgumentException();

        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    /**
     * 
     * @param a        : the matrix that needs to be divided into sub matrix
     * @param startRow : starting row of the matrix from where the matrix will be
     *                 divided
     * @param endRow   : ending row (exclusive) till where matrix will be divided
     * @param startCol : starting column of the matrix from where the matrix will be
     *                 divided
     * @param endCol   : ending column (exclusive) till where matrix will be divided
     * @return : new SquareMatrix object with the sub matrix
     */
    public Matrix subMatrix(int startRow, int endRow, int startCol, int endCol) {
        Matrix result = new Matrix(endRow - startRow, endCol - startCol);
        for (int i = 0, row = startRow; row < endRow; i++, row++) {
            System.arraycopy(this.data[row], startCol, result.data[i], 0, endCol - startCol);
        }
        return result;
    }

    public Matrix joinHorizontal(Matrix other) {
        if (this.rows != other.rows)
            throw new IllegalMatrixArgumentException();

        Matrix result = new Matrix(this.rows, this.cols + other.cols);
        for (int i = 0; i < this.rows; i++) {
            System.arraycopy(this.data[i], 0, result.data[i], 0, this.cols);
            System.arraycopy(other.data[i], 0, result.data[i], this.cols, other.cols);
        }
        return result;
    }

    public Matrix joinVertical(Matrix other) {
        if (this.cols != other.cols)
            throw new IllegalMatrixArgumentException();

        Matrix result = new Matrix(this.rows + other.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            System.arraycopy(this.data[i], 0, result.data[i], 0, this.cols);
        }
        for (int i = 0; i < other.rows; i++) {
            System.arraycopy(other.data[i], 0, result.data[i + this.rows], 0, this.cols);
        }
        return result;
    }

    public Matrix[][] split(int row, int col) {
        if (row > this.rows || col > this.cols || row <= 0 || col <= 0)
            throw new IllegalMatrixArgumentException();

        int r = Math.ceilDiv(this.rows, row);
        int c = Math.ceilDiv(this.cols, col);
        Matrix[][] matrices = new Matrix[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrices[i][j] = this.subMatrix(i * r, (i == row - 1) ? (this.rows) : (i * r + r),
                        j * c, (j == col - 1) ? (this.cols) : (j * c + c));
            }
        }
        return matrices;
    }

    public Matrix strassenMultiply(Matrix other) {
        return strassenMultiply(other, false);
    }

    public Matrix strassenMultiply(Matrix other, boolean padded) {
        if (!padded) {
            if (this.cols != other.rows)
                throw new IllegalMatrixArgumentException();

            return strassenMultiplyRecursive(this, other);
        }
        // Check if matrices are powers of 2 and if not, pad them with zeros
        int n = Math.max(Math.max(this.rows, this.cols), Math.max(other.rows, other.cols));
        int size = 1;
        while (size < n) {
            size *= 2;
        }
        Matrix aPadded = padMatrix(this, size);
        Matrix bPadded = padMatrix(other, size);

        // Actual Strassen multiplication algorithm
        Matrix result = strassenMultiplyRecursive(aPadded, bPadded);

        // Trim result to the original size
        result = trimMatrix(result, this.rows, other.cols);
        return result;
    }

    private Matrix strassenMultiplyRecursive(Matrix a, Matrix b) {
        int n = a.rows;

        if (n == 1) {
            Matrix result = new Matrix(1, 1);
            result.set(0, 0, a.get(0, 0) * b.get(0, 0));
            return result;
        }
        // Divide matrices into submatrices
        Matrix[][] aSub = a.split(2, 2);
        Matrix[][] bSub = b.split(2, 2);

        // Compute the intermediate matrices
        Matrix p1 = strassenMultiplyRecursive(aSub[0][0], bSub[0][1].subtract(bSub[1][1]));
        Matrix p2 = strassenMultiplyRecursive(aSub[0][0].add(aSub[0][1]), bSub[1][1]);
        Matrix p3 = strassenMultiplyRecursive(aSub[1][0].add(aSub[1][1]), bSub[0][0]);
        Matrix p4 = strassenMultiplyRecursive(aSub[1][1], bSub[1][0].subtract(bSub[0][0]));
        Matrix p5 = strassenMultiplyRecursive(aSub[0][0].add(aSub[1][1]), bSub[0][0].add(bSub[1][1]));
        Matrix p6 = strassenMultiplyRecursive(aSub[0][1].subtract(aSub[1][1]), bSub[1][0].add(bSub[1][1]));
        Matrix p7 = strassenMultiplyRecursive(aSub[0][0].subtract(aSub[1][0]), bSub[0][0].add(bSub[0][1]));

        // Compute result submatrices
        Matrix c11 = p5.add(p4).subtract(p2).add(p6);
        Matrix c12 = p1.add(p2);
        Matrix c21 = p3.add(p4);
        Matrix c22 = p5.add(p1).subtract(p3).subtract(p7);

        // Combine result submatrices
        return c11.joinHorizontal(c12).joinVertical(c21.joinHorizontal(c22));
    }

    private Matrix padMatrix(Matrix matrix, int size) {
        Matrix paddedMatrix = new Matrix(size, size);
        for (int i = 0; i < matrix.rows; i++) {
            System.arraycopy(matrix.data[i], 0, paddedMatrix.data[i], 0, matrix.cols);
        }
        return paddedMatrix;
    }

    private Matrix trimMatrix(Matrix matrix, int rows, int cols) {
        Matrix trimmedMatrix = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix.data[i], 0, trimmedMatrix.data[i], 0, cols);
        }
        return trimmedMatrix;
    }

    public void display() {
        for (int[] i : data) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public int[][] getData() {
        return data;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void setRows(int row) {
        this.rows = row;
    }

    public void setCols(int col) {
        this.cols = col;
    }

    @Override
    public String toString() {
        return "Matrix [data=" + Arrays.deepToString(data) + "]";
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, cols);
        result = 31 * result + Arrays.deepHashCode(data);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Matrix))
            return false;

        Matrix other = (Matrix) obj;
        if (this.rows != other.rows || this.cols != other.cols)
            return false;

        for (int i = 0; i < this.rows; i++) {
            if (!Arrays.equals(this.data[i], other.data[i]))
                return false;
        }
        return true;
    }

    private class IllegalMatrixArgumentException extends IllegalArgumentException {
        IllegalMatrixArgumentException() {
            super("Both matrices must be square of the same size");
        }
    }

}
