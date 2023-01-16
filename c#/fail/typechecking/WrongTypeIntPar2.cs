using System;

namespace WrongTypeIntPar2
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = (5 + 10 - (5 / 5)) + (10 + 10 * (4 - false));
        }
    }
}