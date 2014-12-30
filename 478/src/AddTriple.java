public class AddTriple {
    private int x =0;
    private int y =0;
    private int z =0;

    public AddTriple() { }

    public void add(final Triple t) {
        this.x += t.x;
        this.y += t.y;
        this.z += t.z;
    }

    public boolean unary() {
        return x == y && y == z;
    }
}
