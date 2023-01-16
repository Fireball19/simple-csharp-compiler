using System;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            FunctionVoid();
            FunctionInt();
            FunctionString();
        }

        static void FunctionVoid() {
        }

        static int FunctionInt() {
            return 5;
        }

        static string FunctionString() {
            return "string";
        }
    }
}