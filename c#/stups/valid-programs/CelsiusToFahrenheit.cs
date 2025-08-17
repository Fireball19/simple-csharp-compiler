using System;

namespace CelsiusToFahrenheit
{
    class Program
    {
        static void Main(string[] args)
        {
            double celsius = 32;
            double fahrenheit = ToFahrenheit(celsius);
            Console.WriteLine(celsius);
            Console.WriteLine("Celsius in Fahrenheit.");
            Console.WriteLine(fahrenheit);
        }

        static double ToFahrenheit(double celsius) {
            return celsius * 1.8 + 32;
        }
    }
}