using System;

namespace CallInIf
{
    class Program
    {
        static void Main(string[] args)
        {
			if (true) {
				VoidFunction();
			}
        }
		
		static void VoidFunction() {
		}
    }
}