public class FruitsPair <T extends Fruits>{
    public T first;
    public T second;

    public FruitsPair(T first, T second){
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString(){
        return "(" + this.first + this.second + ")";
    }
}
