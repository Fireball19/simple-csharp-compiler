using System;

namespace WrongTypesInArithmetic
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 5 + 5 - 3 + (3 + 5) + true;
        }
    }
}