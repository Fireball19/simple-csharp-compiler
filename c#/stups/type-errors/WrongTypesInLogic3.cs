using System;

namespace WrongTypesInLogic3
{
    class Program
    {
        static void Main(string[] args)
        {
            bool b = !"string" && (true || true);
        }
    }
}