public class Quadruple<A> {
    public A first;
    public A second;
    public A third;
    public A fourth;

    public Quadruple(A first, A second, A third, A fourth){
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ")";
    }

    public static <A> Quadruple<A> getQuadrupleBy(Pair<Pair<A>> pairPair) {
        A first = pairPair.first.first;
        A second = pairPair.first.second;
        A third = pairPair.second.first;
        A fourth = pairPair.second.second;

        return new Quadruple<>(first, second, third, fourth);
    }

}
