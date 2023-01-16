using System;

namespace WhileIf
{
    class Program
    {
        static void Main(string[] args)
        {
            bool b = true;

            while(b) {
                if (true) {
                    b = false;
                    Console.WriteLine("Terminating...");
                }
            }
        }
    }
}