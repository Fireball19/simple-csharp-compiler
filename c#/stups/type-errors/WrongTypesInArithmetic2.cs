using System;

namespace WrongTypesInArithmetic2
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 5 + 5 - 3 + (3 + false) + 5 * 7 / 7;
        }
    }
}