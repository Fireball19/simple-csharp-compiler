using System;

namespace WrongArgNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            Add(1);
        }

        static int Add(int a, int b) {
            return a + b;
        }
    }
}