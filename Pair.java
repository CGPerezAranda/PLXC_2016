public class Pair {
    private static Integer dim1;
    private static Integer dim2; 

    public Pair(Integer dim1, Integer dim2) {
        Pair.dim1 = dim1;
        Pair.dim2 = dim2;
    }

    public Integer getDim1() {
        return dim1;
    }

    public void setDim1(Integer dim1) {
        Pair.dim1 = dim1;
    }

    public Integer getDim2() {
        return dim2;
    }

    public void setDim2(Integer dim2) {
        Pair.dim2 = dim2;
    }
}
