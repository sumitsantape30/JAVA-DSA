Check the error

Will following code generate any error ?

public class Main {
    public static void func(int a) {
        int b = a;
        b = b + 10;
    }

    public static void main(String[] args) {
        int a = 10;
        func(a);
        System.out.println(b);
    }
}

Options
Yes 
No

Correct Answer: yes
Solution Description
####Code will generate error as we are trying to print value of variable b in main and
there isn't any variable b created or accessible in main. Variable b in the code is created
inside function _func_ and is local to this function and not accessible outside it.
