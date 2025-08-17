using System;

namespace IfNoElse2
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 0;

            if (true != false) a = 5;

            Console.WriteLine(a);
        }
    }
}