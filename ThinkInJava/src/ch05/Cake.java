package ch05;

/**
 * Created by wsn on 2018/4/16.
 */
public class Cake {

    void f(){
        System.out.println("This is Cake friendly f()");
    }

    protected void pro() {
        System.out.println("This is Cake protected pro()");
    }

    private void pri() {
        System.out.println("This is Cake private pri()");
    }
    public static void main(String[] args)
    {
        System.out.println("This is Cake");
        Pie pie = new Pie();
        pie.f();
        pie.pro();
    }

}
