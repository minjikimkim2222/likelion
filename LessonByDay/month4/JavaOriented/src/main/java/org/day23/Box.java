package org.day23;

public class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    // getter, setter

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    // toString

    @Override
    public String toString() {
        return "Box {" +
                "content=" + content +
                '}';
    }

    public static void main(String[] args) {

        // Box main test
        Box<String> stringBox = new Box<>("pen");
        System.out.println(stringBox.toString()); // Box {content=pen}

        // SpecialBox main test
        SpecialBox<Integer> specialBox = new SpecialBox<>(1);
        specialBox.printContent(); // special box contains : 1

        // ColoredBox main test
        ColoredBox<String, String> coloredBox = new ColoredBox<>("hello", "yellow");
        System.out.println(coloredBox.toString()); // Colored box with color : yellow containing : hello

    }
}

// Box를 상속받는 SpecialBox 정의
class SpecialBox<T> extends Box<T>{

    public SpecialBox(T content){
        super(content);
    }

    public void printContent(){
        System.out.println("special box contains : " + getContent());
    }


}

// Box를 상속받으면서, 새로운 타입 파라미터 C를 추가한, ColoredBox 클래스
class ColoredBox<T, C> extends Box<T> {
    private C color;
    public ColoredBox(T content, C color){
        super(content);
        this.color = color;
    }

    public C getColor(){
        return this.color;
    }

    public String toString(){
        return "Colored box with color : " + color + " containing : " + super.getContent();
    }
}