using System;

namespace IfWhileIf
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 0;

            if (true) {
                while (i < 5) {
                    i = i + 1;
                    if (i > 2) {
                        Console.WriteLine("i greater than 2.");
                    }
                }
            }
        }
    }
}