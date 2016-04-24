/**
 * Created by Polika on 24.04.2016.
 */
public class NestedCalssesTest {
    int notStaticVar;
    static int staticVar;

    public void notStaticMethod(){

    }

    public static void staticMethod(){}



    public static class NestedClass{
        int nonStaticVarNested;
        static int staticVarNested;
        void notStaticMethod() {
          // int i =  nonStaticVar; - не можем ... мы не видим нестатического контекста внешнего касса
            // из статического вложенного класса
            int j = staticVar;

            //NestedCalssesTest.this.notStaticMethod(); из статического вложенного класса
            // невозможно обраттиться  экземпляру внешнего класса (this)
        }

        static void  staticMethod(){
            //NestedCalssesTest.this.notStaticMethod();из статического вложенного класса
            // невозможно обраттиться  экземпляру внешнего класса (this)
        }
    }

    public class InnerClass{
        int nonStaticVarInner;
        //static int staticVar; - Нельзя... как ее вызвать??мы не можем
        // обратиться к статическому контексту нестатического класса

        void notStaticMethod(){ // из нестатического метода внутреннего нестатического класса
            // можно обратиться к чему угодно(любым членам) из внешнего класса
            int i = NestedCalssesTest.this.notStaticVar;
            int j = NestedCalssesTest.staticVar;
            NestedCalssesTest.this.notStaticMethod();
            int k = NestedCalssesTest.this.notStaticVar;
            int l = NestedCalssesTest.this.staticVar;
            NestedCalssesTest.this.notStaticMethod();
            NestedCalssesTest.this.staticMethod();
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
