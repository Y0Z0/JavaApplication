public class SamplePrac {
    public static void main (String[] args){
        User user = new User();
        System.out.println(user.authorityCode);
    }

    static class User {
        //0 が admin, 1 が guest
        Authrity authorityCode = Authrity.GUEST;
    }

    enum Authrity {
        ADMIN,
        GUEST;
    }
}
