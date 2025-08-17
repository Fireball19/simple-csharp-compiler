using System;

namespace WhileWithBoolExpression
{
    class Program
    {
        static void Main(string[] args)
        {
            bool b = true;

            while (true && b) {
                b = false;
            }
        }
    }
}