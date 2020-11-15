import java.util.Scanner;

public class Computer {
    public static void main(String[] args) {
        int i = 0;
        double num1, num2, sum;
        char a;
        System.out.println("请输入一个简单的算式：");
        Scanner s = new Scanner(System.in);
        String equation = s.nextLine();
        char list[] = equation.toCharArray();

        for (i = 1; i < list.length - 1; i++) {
            if (list[i] == '+' || list[i] == '-' || list[i] == '*' || list[i] == '/') {
                a = list[i];
                break;
            }
        }
        try {
            if (list[0] == '+' || list[0] == '-') {
                num1 = Tool(equation, 1, i);
                if (list[0] == '-') {
                    num1 = -num1;
                }
            } else {
                num1 = Tool(equation, 0, i);
            }


            if (list[i + 1] == '+' || list[i + 1] == '-') {
                num2 = Tool(equation, i + 2, list.length);
                if (list[i + 1] == '-') {
                    num2 = -num2;
                }
            } else {
                num2 = Tool(equation, i + 1, list.length);
            }
            switch (list[i]) {
                case '+':
                    sum = num1 + num2;
                    System.out.println("=" + sum);
                    break;
                case '-':
                    sum = num1 - num2;
                    System.out.println("=" + sum);
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("输入错误！");
                    } else {
                        sum = num1 / num2;
                        System.out.println("=" + sum);
                    }
                    break;
                case '*':
                    sum = num1 * num2;
                    System.out.println("=" + sum);
                    break;
            }
        }catch (Exception e){
            System.out.println("算式输入异常！");
        }

    }

    public static double Tool(String list, int a, int b) {
        String sty = list.substring(a, b);
        double sum = Double.parseDouble(sty);
        return sum;
    }
}
