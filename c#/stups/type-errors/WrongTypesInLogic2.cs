using System;

namespace WrongTypesInLogic2
{
    class Program
    {
        static void Main(string[] args)
        {
            bool b = true || false && !true || (false || !7);
        }
    }
}