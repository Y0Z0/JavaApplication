public class RefaClass {
    //問題クラス(リファクタリング対象)
    /*
    class Book {
        private String title;
        private String authorName;
        private String authorEmail;
        private String publisherName;
        private String publisherAddress;
        private String publisherPhoneNumber;
        private String isbn;
        private double price;
    }
    */

    //ここからリファクタリングしたもの
    static class PublisherInfo {
        private String publisherName;
        private String publisherAddress;
        private String publisherPhoneNumber;
    }

    static class BookInfo {
        private String title;
        private String authorName;
        private String authorEmail;
        private String isbn;
        private double price;
    }

    static class NewBook {
        private BookInfo bookInfo;
        private PublisherInfo publisherInfo;
    }
}
