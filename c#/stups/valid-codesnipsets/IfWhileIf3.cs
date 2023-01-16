using System;

namespace IfWhileIf3
{
    class Program
    {
        static void Main(string[] args)
        {
            bool b1 = true;
            bool b2 = true;
            bool b3 = false;
            bool b4 = false;
            int i = 5;

            if ((b1 && b2) || (b3 || b4)) {
                while (i > 0) {
                    i = i - 1;
                    b1 = false;
                    if (!b1) {
                        Console.WriteLine("b1 is now always false.");
                    }
                }
            }
        }
    }
}