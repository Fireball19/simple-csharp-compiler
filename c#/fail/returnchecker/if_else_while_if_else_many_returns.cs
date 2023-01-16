using System;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
        }

        static int Test() {
            if (true) {
                return 1;
                return 2;
            } else {
                return 3;
                return 4;
                while (true) {
                    return 5;
                    if (true) {
                    } else {
                        return 6;
                        return 7;
                        return 8;
                    }
                    return 9;
                    return 10;
                }
                // here would be a 100% guaranteed return
            }
        }
    }
}