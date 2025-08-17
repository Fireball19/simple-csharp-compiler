using System;

namespace CallDoubleFunctionWithIntArg
{
    class Program
    {
        static void Main(string[] args)
        {
			DoubleFunction(5);
        }
		
		static double DoubleFunction(double d) {
			return d;
		}
    }
}