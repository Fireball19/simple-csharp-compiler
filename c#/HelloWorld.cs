using System;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            double a2 = 5;
            int i2 = 5;
            double aa = 5.5 + -6;
            bool b2 = 5.5 == 5;

            bool b = true != true;
            double ddd = 5.5;
            int a = 5;
            double dd = 6.5;
            int ii = 6;

            int i = 5;
            double d = 5.5 + i;
            a = i2;

            Console.WriteLine(5.5 + 7 + 8);

            Test8("TEST8", 5 + 5, (2 + 2) * 5);
            Console.WriteLine(a2);
            Console.WriteLine(Test7(5, 5));
            Console.WriteLine(aa);
            Console.WriteLine(Test6());
            Console.WriteLine(b2);


            Console.WriteLine(d);
            Console.WriteLine(Test2(5));


            Console.WriteLine("Hallo" == "Hallo"); // true
            Console.WriteLine("Hallo" != "Hallo2"); // true
            Console.WriteLine("Hallo" != "Hallo"); // false
            Console.WriteLine(5.65 + 1.35);
            Console.WriteLine(5.65 - 1.35);
            Console.WriteLine(-+1.35);
            Console.WriteLine(1.35 % 0.5);
            Console.WriteLine(5.5 * 10.5);
            Console.WriteLine(4.4 / 2.2);
            Console.WriteLine((4 + 6) + (2 * 2));
            Console.WriteLine(5 + 5.5);
            Console.WriteLine((5 + 5.5) + 7);
            Console.WriteLine(5 == 3);

            Test5("Hallo");

            Console.WriteLine(d);
            Console.WriteLine(a);
            Console.WriteLine(dd);
            Console.WriteLine(ii);

            Console.WriteLine(5);
            Console.WriteLine(99.9);
            Console.WriteLine(true);
            Console.WriteLine("Hello World!");
            Console.WriteLine();
            Console.WriteLine(5 + 5);
            Console.WriteLine(5 + 5 + 8);
            Console.WriteLine(5 - 5);
            Console.WriteLine(5 % 5);
            Console.WriteLine(5 * 5);
            Console.WriteLine(5 / 5);
            Console.WriteLine(true && true);
            Console.WriteLine(false || false);
            Console.WriteLine(-15);
            Console.WriteLine(2 + 4 * 8); // 34
            Console.WriteLine((2 + 4) * 8); // 48
            Test4(5);
            Console.WriteLine(!true);
            Console.WriteLine(!false);

            if (false) {
                Console.WriteLine(true);
            } else {
                Console.WriteLine(false);
            }

            Console.WriteLine(Test(5));
            Console.WriteLine(true != true); // false
            Console.WriteLine(b);            // false
            Console.WriteLine(true == true); // true
            Console.WriteLine(5 <= 5);       // true
            Console.WriteLine(6 > 7);        // false

            Console.WriteLine(true != false);
        }

        static int Test(int i) {
            return i;
        }

        static double Test2(int i) {
            return i;
        }

        static double Test77(double d) {
            return d;
        }

        static bool Test3() {
            return true;
        }

        static void Test4(int i) {
            Console.WriteLine(i);
        }

        static void Test5(string t) {
            Console.WriteLine(t);
        }

        static double Test7(int i, int a) {
            return i + a;
        }

       static double Test6() {
            return 5 + 5;
       }

       static void Test8(string s, int i, double d) {
        Console.WriteLine(s);
        Console.WriteLine(i + d);
       }
    }
}