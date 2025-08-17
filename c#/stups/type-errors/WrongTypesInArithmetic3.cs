using System;

namespace WrongTypesInArithmetic3
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 5 + 5 - 3 + (3 + 5) - (6 + "string" - 8 / 4 + (2 + 4));
        }
    }
}