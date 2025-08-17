using System;

namespace FahrenheitToCelsius
{
    class Program
    {
        static void Main(string[] args)
        {
            double fahrenheit = 32;
            double celsius = ToCelsius(fahrenheit);
            Console.WriteLine(fahrenheit);
            Console.WriteLine("Fahrenheit in Celsius.");
            Console.WriteLine(celsius);
        }

        static double ToCelsius(double fahrenheit) {
            return (fahrenheit - 32) * 5 / 9;
        }
    }
}