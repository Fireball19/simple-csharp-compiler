using System;

namespace AbsoluteDifference
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 10;
            int j = 5;

            while(i > 0) {
                i = i - 1;
                Console.WriteLine("-");
                while(j > 0) {
                    j = j - 1;
                    Console.WriteLine("*");
                }
            }
        }
    }
}