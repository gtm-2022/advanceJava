

public class Runtime_Polymorphism {
    public static void main(String[] args) {
       Runtime_Polymorphism p=new Runtime_Polymorphism();
        Shape s;
        
        s=new Rectangle();
        s.draw();
        s=new Circle();
        s.draw();
        s=new Triangle();
        s.draw();

    }

    

}
    class Shape{
        
        void draw(){
            System.out.println("Drawing..");
        }
    }
    class Rectangle extends Shape{
        void draw(){
            System.out.println("Drawing Rectangle..");
        }
    }
    class Circle extends Shape{
        void draw(){
            System.out.println("Drawing Circle..");
        }
    }
    class Triangle extends Shape{
        void draw(){
            System.out.println("Drawing Triangle..");
        }
    }
  
