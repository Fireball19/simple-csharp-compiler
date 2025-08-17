using System;

namespace WrongReturnValue
{
    class Program
    {
        static void Main(string[] args)
        {
        }

        static int Inc(int a) {
            return false;
        }
    }
}