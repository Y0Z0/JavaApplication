public class Apple extends Fruits {
    Apple(int price, String madeIn, String color) {
        super(price, madeIn, color);
    }

    @Override
    String getDetail(){
        return "これはりんごで生産地は" + this.madeIn + " 色:" + this.color;
    }
}

