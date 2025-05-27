package nino.data;

public class Data {
    public int[] entry;
    public int output;

    public Data(int a, int b, int out) {
        this.entry = new int[]{a, b};
        this.output = out;
    }
}
