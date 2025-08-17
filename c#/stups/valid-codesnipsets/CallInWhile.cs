using System;

namespace CallInWhile
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 0;
			while (i < 5) {
			    i = i + 1;
				VoidFunction();
			}
        }
		
		static void VoidFunction() {
		}
    }
}