public class RefaSubclass {
    /*
    class Employee {
        public static final int ENGINEER = 0;
        public static final int MANAGER = 1;
        public static final int INTERN = 2;

        private String name;
        private int type;

        public Employee(String name, int type) {
            this.name = name;
            this.type = type;
        }
    }
     */

    public static class Employee {
        public enum TypeCode {
            ENGINEER, MANAGER, INTERN
        }

        private String name;
        private TypeCode typeCode;

        public Employee(String name, TypeCode typeCode) {
            this.name = name;
            this.typeCode = typeCode;
        }
    }

    /*拡張性含めたサンプル
    public static class Employee {
        private String name;
    }

    class Engineer {
        内部処理
    }
    class Manager {
        内部処理
    }
    class Intern {
        内部処理
    }
     */
}
