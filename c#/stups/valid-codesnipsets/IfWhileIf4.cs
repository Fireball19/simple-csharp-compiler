using System;

namespace IfWhileIf4
{
    class Program
    {
        static void Main(string[] args)
        {
            double d = 7.5;

            if (d >= 7.5 && d < 8.0) {
                while (d > 1.0) {
                    d = d - 1.0;
                    if (d > 3.0) {
                        Console.WriteLine("d greater than 3.0.");
                    }
                }
            }
        }
    }
}