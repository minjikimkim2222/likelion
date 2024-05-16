package annotation;

public class Service {
    @PrintAnnotation
    public void method01(){
        System.out.println("method01 run !!");
    }
    @PrintAnnotation("&")
    public void method02(){
        System.out.println("method02 run !!");
    }
    @PrintAnnotation(value = "#", number=10)
    public void method03(){
        System.out.println("method03 run !!");
    }
    public void method04(){
        System.out.println("method04 run !!");
    }
}
