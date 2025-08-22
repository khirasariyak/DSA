import java.io.FileNotFoundException;
import java.io.IOException;

public class OOPsTrickySnippets {

    // Snippet 1: Method Overloading and Overriding Mix
    static class Snippet1 {
        static class Parent {
            void show(Object obj) {
                System.out.println("Parent Object");
            }

            void show(String str) {
                System.out.println("Parent String");
            }
        }

        static class Child extends Parent {
            @Override
            void show(Object obj) {
                System.out.println("Child Object");
            }

            void show(Integer i) {
                System.out.println("Child Integer");
            }
        }

        public static void main(String[] args) {
            System.out.println("Snippet 1 Output:");
            Parent p = new Child();

            p.show("Hello");      // Parent String
            p.show(10);           // Child Object

            // p.show(10.5);      // Child Object if uncommented
            System.out.println();
        }
    }

    // Snippet 2: Constructor and Method Overriding
    static class Snippet2 {
        static class Base {
            Base() {
                System.out.println("Base constructor");
                overrideMe();
            }

            void overrideMe() {
                System.out.println("Base overrideMe");
            }
        }

        static class Derived extends Base {
            int x = 10;

            Derived() {
                System.out.println("Derived constructor");
            }

            @Override
            void overrideMe() {
                System.out.println("Derived overrideMe, x = " + x);
            }
        }

        public static void main(String[] args) {
            System.out.println("Snippet 2 Output:");
            Base b = new Derived();
            System.out.println();
        }
    }

    // Snippet 3: Static vs Instance Methods and Polymorphism
    static class Snippet3 {
        static class A {
            static void staticMethod() {
                System.out.println("A staticMethod");
            }

            void instanceMethod() {
                System.out.println("A instanceMethod");
            }
        }

        static class B extends A {
            static void staticMethod() {
                System.out.println("B staticMethod");
            }

            @Override
            void instanceMethod() {
                System.out.println("B instanceMethod");
            }
        }

        public static void main(String[] args) {
            System.out.println("Snippet 3 Output:");
            A a = new B();
            a.staticMethod();    // A staticMethod
            a.instanceMethod();  // B instanceMethod

            B b = new B();
            b.staticMethod();    // B staticMethod
            b.instanceMethod();  // B instanceMethod
            System.out.println();
        }
    }

    // Snippet 4: Constructor Chaining & Field Initialization Order
    static class Snippet4 {
        static class Parent {
            int x = 10;

            Parent() {
                System.out.println("Parent constructor, x = " + x);
                this.print();
            }

            void print() {
                System.out.println("Parent print, x = " + x);
            }
        }

        static class Child extends Parent {
            int x = 20;

            Child() {
                System.out.println("Child constructor, x = " + x);
            }

            @Override
            void print() {
                System.out.println("Child print, x = " + x);
            }
        }

        public static void main(String[] args) {
            System.out.println("Snippet 4 Output:");
            Parent p = new Child();
            System.out.println();
        }
    }

    // Snippet 5: Interface Default Methods vs Class Methods
    static class Snippet5 {
        interface InterfaceA {
            default void hello() {
                System.out.println("Hello from InterfaceA");
            }
        }

        static class ClassB {
            public void hello() {
                System.out.println("Hello from ClassB");
            }
        }

        static class ClassC extends ClassB implements InterfaceA {
            // No override of hello()
        }

        public static void main(String[] args) {
            System.out.println("Snippet 5 Output:");
            ClassC obj = new ClassC();
            obj.hello();  // Hello from ClassB
            System.out.println();
        }
    }

    // Snippet 6: Exceptions in Overriding Methods
    static class Snippet6 {
        static class Parent {
            void show() throws Exception {
                System.out.println("Parent show");
            }
        }

        static class Child extends Parent {
            @Override
            void show() {
                System.out.println("Child show");
            }
        }

        public static void main(String[] args) {
            System.out.println("Snippet 6 Output:");
            Parent p = new Child();
            try {
                p.show();
            } catch (Exception e) {
                System.out.println("Exception caught");
            }
            System.out.println();
        }
    }

    // Snippet 7: Checked Exceptions and Overriding
    static class Snippet7 {
        static class Parent {
            void process() throws IOException {
                System.out.println("Parent process");
            }
        }

        static class Child extends Parent {
            @Override
            void process() throws FileNotFoundException {
                System.out.println("Child process");
            }
        }

        static class Child2 extends Parent {
            // Uncommenting below will cause compile error:
            // @Override
            // void process() throws Exception {
            //     System.out.println("Child2 process");
            // }
        }

        public static void main(String[] args) {
            System.out.println("Snippet 7 Output:");
            Parent p1 = new Child();
            Parent p2 = new Child2();

            try {
                p1.process();
            } catch (IOException e) {
                System.out.println("Caught IOException");
            }

            // Uncommenting below block will cause compile error
            /*
            try {
                p2.process();
            } catch (Exception e) {
                System.out.println("Caught Exception");
            }
            */
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Snippet1.main(args);
        Snippet2.main(args);
        Snippet3.main(args);
        Snippet4.main(args);
        Snippet5.main(args);
        Snippet6.main(args);
        Snippet7.main(args);
    }
}