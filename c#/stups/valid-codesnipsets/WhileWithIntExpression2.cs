using System;

namespace WhileWithIntExpression2
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 5;
            int a = 10;

            while (a - i <= 0) {
                i = i + 1;
            }
        }
    }
}