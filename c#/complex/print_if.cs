using System;

namespace FibonacciRecursive
{
    class Program
    {
        static void Main(string[] args)
        {
            Smaller(3);
            Greater(7);
        }

        static void Smaller(double s)
        {
            if (s < 5.0) {
                Console.WriteLine("smaller than 5.");
            }
        }

        static void Greater(double s)
        {
            if (s > 2.0) {
            Console.WriteLine("greater than 2.");
            }
        }
    }
}