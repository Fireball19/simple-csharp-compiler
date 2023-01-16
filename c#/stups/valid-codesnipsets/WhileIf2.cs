using System;

namespace WhileIf2
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 15;

            while(i > 5) if (true) i = i - 2;

            Console.WriteLine(i);
        }
    }
}