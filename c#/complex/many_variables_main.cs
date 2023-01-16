using System;

namespace ManyVariablesMain
{
    class Program
    {
        static void Main(string[] args)
        {
            int add_25 = 5 + 5 + 5 + 5 + 5;
            int div_mult_8 = 8 / 4 * 4;
            int mod_0 = 9 * 9 % 9;
            int unary_minus_2 = -2;
            int plus_div_par = (5 + 5 + 5 + 5) + 12 / (2 + 2);
            double implicit_int_cast_7 = 7;
            double mult_166_375 = 5.5 * 5.5 * 5.5;
            string a_string = "I am a string.";
            string another_string = "I am another string.";
            bool string_equals_true = "a" == "a";
            bool string_not_equals_true = "b" != "a";
            bool logical_or_true = true || false;
            bool logical_and_false = true && false;
            bool unary_not_true = !false;

            Console.WriteLine(add_25);
            Console.WriteLine(div_mult_8);
            Console.WriteLine(mod_0);
            Console.WriteLine(unary_minus_2);
            Console.WriteLine(plus_div_par);
            Console.WriteLine(implicit_int_cast_7);
            Console.WriteLine(mult_166_375);
            Console.WriteLine(a_string);
            Console.WriteLine(another_string);
            Console.WriteLine(string_equals_true);
            Console.WriteLine(string_not_equals_true);
            Console.WriteLine(logical_or_true);
            Console.WriteLine(logical_and_false);
            Console.WriteLine(unary_not_true);
        }
    }
}