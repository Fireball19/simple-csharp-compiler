using System;

namespace WhileIf3
{
    class Program
    {
        static void Main(string[] args)
        {
            string s1 = "string";
            string s2 = "string2";
            string s3 = "string3";
            string s4 = "string4";
            int i = 7;

            while(i != 0) {
                i = i - 1;
                if ((s1 == s1) && (s3 != s4) && (s2 == s2)) {
                    Console.WriteLine("if...");
                }
                Console.WriteLine("while...");
            }
        }
    }
}