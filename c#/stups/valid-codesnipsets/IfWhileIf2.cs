using System;

namespace IfWhileIf2
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 0;
            int j = 5;

            if (i < j) {
                while (i > -5 && j > 0) {
                    i = i - 1;
                    j = j - 1;
                    if (true) {
                        Console.WriteLine("Calculating...");
                    }
                }
            }
        }
    }
}