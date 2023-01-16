using System;

namespace RgbToCYMK
{
    class Program
    {
        static void Main(string[] args)
        {
            RgbToCYMK(120, 60, 60);
        }

        static void RgbToCYMK(int r, int g, int b) {
            double percentageR = r / 255.0 * 100;
            double percentageG = g / 255.0 * 100;
            double percentageB = b / 255.0 * 100;
            double c;
            double m;
            double y;
            double k;

            k = percentageR;

            if (k < percentageG) k = percentageG;
            if (k < percentageB) k = percentageB;

            c = (100 - percentageR - k) / (100 - k) * 100;
            m = (100 - percentageG - k) / (100 - k) * 100;
            y = (100 - percentageB - k) / (100 - k) * 100;

            Console.WriteLine(c); // 11.111111111111125
            Console.WriteLine(m); // 55.55555555555556
            Console.WriteLine(y); // 55.55555555555556
            Console.WriteLine(k); // 47.05882352941176
        }
    }
}