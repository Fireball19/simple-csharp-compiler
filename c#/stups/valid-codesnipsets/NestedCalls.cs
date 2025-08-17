using System;

namespace NestedCalls
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = Function1(Function2(Add(5, 2)));
            Console.WriteLine(i);
        }

        static int Function1(int i) {
            return i;
        }

        static int Function2(int i) {
            return i;
        }

        static int Add(int i, int a) {
            return i + a;
        }
    }
}