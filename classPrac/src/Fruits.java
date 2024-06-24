import java.util.Objects;

public class Fruits extends Food{
    String color;

    public Fruits(int price, String madeIn, String color) {
        this.price = price;
        this.madeIn = madeIn;
        this.color = color;
    }

    String getDetail(){
        return "生産地" + this.madeIn + "色" + this.color;
    }

    boolean isMadeInJapan(){
        if (this.madeIn.equals("Japan")){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "果物の値段は" + this.price + "円です。";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null /*|| getClass() != o.getClass() (クラス名まで一致判定したいときON)*/) return false;
        Fruits fruits = (Fruits) o;
        return price == fruits.price &&
                Objects.equals(madeIn, fruits.madeIn) &&
                Objects.equals(color, fruits.color);
    }

    /*hash更新用*/
    @Override
    public int hashCode() {
        return Objects.hash(price, madeIn, color);
    }

}
