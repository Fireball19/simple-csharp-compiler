using System;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = StringMethod() + IntMethod();
        }

        static string StringMethod() {
            return "string";
        }

        static int IntMethod() {
            return 99;
        }
    }
}