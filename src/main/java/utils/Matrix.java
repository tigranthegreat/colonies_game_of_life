package utils;

import core.ColonyCell;

public class Matrix<ElemType> {

    private int width, height;
    private ElemType[][] matrixElements;

    public Matrix(int height, int width) {
        this.height = height;
        this.width = width;
        this.matrixElements = (ElemType[][]) new Object[height][width];
    }

    public Matrix(Matrix<ElemType> other) {
        this.width = other.getWidth();
        this.height = other.getHeight();
    }

    public ElemType get(int y, int x) {
        return this.matrixElements[y][x];
    }

    public void setMatrixElements(ElemType[][] matElems) {
        this.matrixElements = matElems;
    }

    public void set(ElemType val, int y, int x) {
//        System.out.println(this.matrixElements[y][x]);
        this.matrixElements[y][x] = val;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        String strRepr = "";
        strRepr += "(" + this.height + ", " + this.width + ")";
        for (int i = 0; i < height; ++i) {
            strRepr += "\n";
            for (int j = 0; j < width; ++j)
                strRepr += this.get(i, j).toString() + "\t";
        }
        return strRepr;
    }

    public static Matrix<Integer> convertCellToIntegerMatrix(Matrix<ColonyCell> cellMatrix) {
        Matrix<Integer> intMatrix = new Matrix<Integer>(cellMatrix.getHeight(), cellMatrix.getWidth());
        for (int i = 0; i < cellMatrix.getHeight(); ++i) {
            for (int j = 0; j < cellMatrix.getWidth(); ++j) {
                intMatrix.set(cellMatrix.get(i, j).getColonyIndex(), i, j);
            }
        }
        return intMatrix;
    }

    public static Matrix<ColonyCell> convertIntToCellMatrix(Matrix<Integer> intMatrix) {
        Matrix<ColonyCell> cellMatrix = new Matrix<>(intMatrix.getHeight(), intMatrix.getWidth());
        for (int i = 0; i < intMatrix.getHeight(); ++i) {
            for (int j = 0; j < intMatrix.getWidth(); ++j) {
                cellMatrix.set(new ColonyCell(intMatrix.get(i, j)), i, j);
            }
        }
        return cellMatrix;
    }

//    public static Matrix<ColonyCell> convertIntToColonyCellMatrix(Matrix<Integer> intMatrix) {
//        Matrix<ColonyCell> cellMatrix = new Matrix<>(intMatrix.getHeight(), intMatrix.getWidth());
//        for (int i = 0; i < intMatrix.getHeight(); ++i) {
//            for (int j = 0; j < intMatrix.getWidth(); ++j)
//                cellMatrix.set(new ColonyCell(intMatrix.get(i, j)), i, j);
//        }
//        return cellMatrix;
//    }

}
