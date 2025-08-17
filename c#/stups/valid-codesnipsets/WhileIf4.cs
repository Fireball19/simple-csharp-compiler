using System;

namespace WhileIf4
{
    class Program
    {
        static void Main(string[] args)
        {
            string s = "string";

            while(s == "string") {
                s = "new string";
                if (!false) {
                    Console.WriteLine("if...");
                }
            }
        }
    }
}