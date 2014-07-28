using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            int a, b, c;
           
            a = 5;
            b = 6;

            Console.WriteLine("a = " + a + " / b = " + b);

            c = a;
            a = b;
            b = c;

            Console.WriteLine("a = " + a + " / b = " + b);

            Console.Read();
        }
    }
}
