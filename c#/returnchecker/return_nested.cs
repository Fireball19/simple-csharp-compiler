using System;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)
        {
            if (true) {
                return;
            } else {
                return;
                if (true) {
                    return;
                    while(false) return;
                } else {
                    return;
                }
            }
        }

        static int IntReturn() {
            if (true) {

            } else {

                if (true) {

                } else {
                    while(true);
                }
            }

            return 6;
        }

        static double DoubleReturn() {
            return 7.7;

            if (true) {
                if (true) {
                    if (true) {
                        if (true) {
                            return 5.5;
                        }
                    }
                }
            }
        }

        static bool BoolReturn() {
            return true;

            while(true) {
                if (true) {
                    return false;
                }
            }
        }

        static string StringReturn() {
            return "string";

            if (true) {

            } else {
                if (true) {
                 return "hallo";
                }
            }


            return "string";
        }
    }
}