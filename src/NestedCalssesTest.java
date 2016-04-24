/**
 * Created by Polika on 24.04.2016.
 */
public class NestedCalssesTest {
    int notStaticVar;
    static int staticVar;

    public void notStaticMethod(){

    }

    public static void StaticMethod(){}



    public static class NestedClass{
        int nonStaticVarNested;
        static int staticVarNested;
        void notStaticMethod() {
          // int i =  nonStaticVar; - не можем ... мы не видим нестатического контекста внешнего касса
            // из статического вложенного класса
            int j = staticVar;


        }

        static void  staticMethod(){

        }
    }

    public class InnerClass{
        int nonStaticVarInner;
        //static int staticVar; - Нельзя... как ее вызвать??мы не можем
        // обратиться к статическому контексту нестатического класса

        void notStaticMethod(){
            int i = NestedCalssesTest.this.notStaticVar;
            int j = NestedCalssesTest.staticVar;
        }

       // static void staticMethod(){ - Нельзя... как его вызвать?? мы не можем
        // обратиться к статическому контексту нестатического класса,



    }
    public static void main(String[] args) {
        NestedCalssesTest.NestedClass.staticMethod();

        NestedCalssesTest.NestedClass nested = new NestedClass();
        nested.notStaticMethod();


         new NestedCalssesTest().new InnerClass();
    }
}
