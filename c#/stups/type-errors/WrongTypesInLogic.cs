using System;

namespace WrongTypesInLogic
{
    class Program
    {
        static void Main(string[] args)
        {
            bool b = true || false && !5;
        }
    }
}