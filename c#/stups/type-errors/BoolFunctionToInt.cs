using System;

namespace BoolFunctionToInt
{
    class Program
    {
        static void Main(string[] args)
        {
			int i = BoolFunction();
        }

        static bool BoolFunction() {
            return true && true;
        }
    }
}