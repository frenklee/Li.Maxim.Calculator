
import java.util.Scanner;




public class BB {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input:");
        String input = sc.nextLine();
        char[] a = input.toCharArray();
        Expression val = new Expression(a);
        val.calc();
    }
}

class Expression
{
    char[] a;
    char[] first = new char[100];
    char[] second = new char[100];
    int x = 0;
    int y = 0;
    char op = 0;
    int result=0;
    int firstNum=0;
    int secondNum=0;
    boolean fflag = false;

    Expression(char[] input)
    {
       this.a = input;
    }

    void calc()
    {
        try {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == ' ') {
                    continue;
                }
                if (!Character.isLetter(a[i]) && !Character.isDigit(a[i]) && (a[i] != '+' && a[i] != '-' && a[i] != '*' && a[i] != '/')) {
                    throw new Exception("Wrong operand!");

                }
                if (a[i] == '+' || a[i] == '-' || a[i] == '*' || a[i] == '/') {
                    op = a[i];
                    continue;
                }
                if (op == 0) {
                    first[x++] = a[i];
                }
                if (op != 0) {
                    second[y++] = a[i];
                }
            }
            char[] firstTemp = new char[x];
            char[] secondTemp = new char[y];
            for (int i = 0; i < x; i++) {
                firstTemp[i] = first[i];
            }
            for (int i = 0; i < y; i++) {
                secondTemp[i] = second[i];
            }
            if (arab(firstTemp) && arab(secondTemp)) {
                firstNum = toNumber(firstTemp);
                secondNum = toNumber(secondTemp);
            } else if (!arab(firstTemp) && !arab(secondTemp)) {
                fflag = true;
                firstNum = toNumber(RomaToArab(firstTemp));
                secondNum = toNumber(RomaToArab(secondTemp));
            } else {
                System.out.println("Arabic and Roman numbers together are not allowed!");
                System.exit(0);
            }


            switch (op) {
                case ('+') -> result = firstNum + secondNum;
                case ('-') -> result = firstNum - secondNum;
                case ('*') -> result = firstNum * secondNum;
                case ('/') -> result = firstNum / secondNum;
                default -> throw new Exception("Wrong operand!");
            }
            if (fflag) {
                System.out.println("Output:");
                ArabToRoma(result);
            } else {
                System.out.println("Output:");
                System.out.println(result);
            }
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
}
    boolean arab(char[] a)
    {

        boolean flag = true;
        for(int i = 0; i<a.length;i++)
        {
            if(!Character.isDigit(a[i]))
                flag = false;
        }

        return flag;
    }
    char[] RomaToArab(char[] a) {
        int res=0;
        char[] result;
        char[] temp = a;

        try {
            if(temp.length<=4)
            {
                if(temp.length==1)
                {
                    if(temp[0]=='I')
                    {
                        res = 1;
                    }
                    else
                    {
                        if(temp[0]=='V')
                        {
                            res = 5;
                        }
                        else
                        {
                            if(temp[0]=='X')
                            {
                                res = 10;
                            }
                            else
                            {
                                throw new Exception("Wrong number!");
                            }
                        }
                    }
                }
                else {
                    if(temp.length==2)
                    {
                        if(temp[0]=='I')
                        {
                            if(temp[1]=='I')
                            {
                                res = 2;
                            }
                            else
                            {
                                if (temp[1] == 'V')
                                {
                                    res = 4;
                                }
                                else
                                {
                                    if(temp[1]=='X')
                                    {
                                        res = 9;
                                    }
                                    else
                                    {
                                        throw new Exception("Wrong number!");
                                    }
                                }
                            }
                        }
                        if(temp[0]=='V')
                        {
                            if(temp[1]=='I')
                            {
                                res = 6;
                            }
                            else
                            {
                                throw new Exception("Wrong number!");
                            }
                        }

                    }
                    else
                    {
                        if(temp.length==3)
                        {
                            if(temp[0]=='I')
                            {
                                if(temp[1]=='I')
                                {
                                    if (temp[2] == 'I')
                                    {
                                        res = 3;
                                    }
                                    else
                                    {
                                        throw new Exception("Wrong number!");
                                    }
                                }
                                else
                                {
                                    throw new Exception("Wrong number!");
                                }
                            }
                            else
                            {
                                if(temp[0]=='V')
                                {

                                    if(temp[1]=='I')
                                    {
                                        if(temp[2]=='I')
                                        {
                                            res = 7;
                                        }
                                        else
                                        {
                                            throw new Exception("Wrong number!");
                                        }
                                    }
                                    else
                                    {
                                        throw new Exception("Wrong number!");
                                    }
                                }
                                else
                                {
                                    throw new Exception("Wrong number!");
                                }
                            }

                        }
                        else
                        {
                            if(temp.length==4)
                            {
                                if(temp[0]=='V')
                                {
                                    if(temp[1]=='I')
                                    {
                                        if(temp[2]=='I')
                                        {
                                            if(temp[3]=='I')
                                            {
                                                res = 8;
                                            }
                                            else
                                            {
                                                throw new Exception("Wrong number!");
                                            }
                                        }
                                        else
                                        {
                                            throw new Exception("Wrong number!");
                                        }
                                    }
                                    else
                                    {
                                        throw new Exception("Wrong number!");
                                    }
                                }
                                else
                                {
                                    throw new Exception("Wrong number!");
                                }
                            }
                        }
                    }
                }
            }
            else
            {

                throw new Exception("Wrong number!");
            }

        } catch (Exception o)
        {
            System.out.println(o.getMessage());
            System.exit(0);
        }
        if(res == 10)
        {
            result = new char[2];
            result[0]='1';
            result[1]='0';
        }
        else
        {
            result = new char[1];
            result[0]=(char)(res+'0');
        }
        return result;
    }

    void ArabToRoma(int input)
    {
        int temp = 0;
        int counter = 0;
        char[] result = new char[10];
        if(input/10==0 && input==10)
        {
            switch(input)
            {
                case (1):
                    System.out.println("I");
                    break;
                case (2):
                    System.out.println("II");
                    break;
                case (3):
                    System.out.println("III");
                    break;
                case (4):
                    System.out.println("IV");
                    break;
                case (5):
                    System.out.println("V");
                    break;
                case (6):
                    System.out.println("VI");
                    break;
                case (7):
                    System.out.println("VII");
                    break;
                case (8):
                    System.out.println("VIII");
                    break;
                case (9):
                    System.out.println("IX");
                    break;
                case (10):
                    System.out.println("X");
                    break;


            }

        }
        else
        {
            if(input<100)
            {
                int[] f = new int[2];
                int pw = 1;
                int count=0;
                while(input!=0)
                {
                    temp=(int)(input/Math.pow(10, pw));
                    f[counter++]=temp;
                    input-=temp*Math.pow(10, pw);
                    pw--;
                }
                switch(f[0])
                {
                    case (1):
                        System.out.print("X");
                        break;
                    case (2):
                        System.out.print("XX");
                        break;
                    case (3):
                        System.out.print("XXX");
                        break;
                    case (4):
                        System.out.print("XL");
                        break;
                    case (5):
                        System.out.print("L");
                        break;
                    case (6):
                        System.out.print("LX");
                        break;
                    case (7):
                        System.out.print("LXX");
                        break;
                    case (8):
                        System.out.print("LXXX");
                        break;
                    case (9):
                        System.out.print("XC");
                        break;
                    default:
                        break;
                }
                switch(f[1])
                {
                    case (1):
                        System.out.println("I");
                        break;
                    case (2):
                        System.out.println("II");
                        break;
                    case (3):
                        System.out.println("III");
                        break;
                    case (4):
                        System.out.println("IV");
                        break;
                    case (5):
                        System.out.println("V");
                        break;
                    case (6):
                        System.out.println("VI");
                        break;
                    case (7):
                        System.out.println("VII");
                        break;
                    case (8):
                        System.out.println("VIII");
                        break;
                    case (9):
                        System.out.println("IX");
                        break;
                    case (10):
                        System.out.println("X");
                        break;
                    default:
                        break;


                }

            }
            else
            {
                System.out.println("C");
            }
        }

    }



    int toNumber(char[] a) {
        int result = 0;
        int flag = 0;
        try {
            if (a[0] == '1' && a.length == 2) {

                if (a[1] == '0') {

                    flag = 1;
                } else {

                    throw new Exception("Number is out of range!");
                }

            }
            if (a.length == 2 && a[0] != '1') {

                throw new Exception("Number is out of range!");
            }
            if (a.length > 2) {

                throw new Exception("Number is out of range!");
            }

            if (a[0] == '1' && flag == 1) {

                result = 10;
            } else {
                switch (a[0]) {
                    case ('1') -> result = 1;

                    case ('2') -> result = 2;

                    case ('3') -> result = 3;

                    case ('4') -> result = 4;

                    case ('5') -> result = 5;

                    case ('6') -> result = 6;

                    case ('7') -> result = 7;

                    case ('8') -> result = 8;

                    case ('9') -> result = 9;

                    default -> {

                        throw new Exception("Invalid number!");

                    }

                }
            }
            return result;
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        return result;
    }
}
