using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication8
{
    class Program
    {
        static void Main(string[] args)
        {
            bool a, b, c, d, e, f;

            a = true;
            b = false;
            c = !a; //c = false
            e = !c; //e = true
            f = !b; //f = true

            if((!(a && b)) || (c && a) && (f || e)) {
                Console.WriteLine("1");

                if(!(((f || b) || (!(c || b)) && (e || c)))) {
                    Console.WriteLine("2");
                }
            }
            else {
                Console.WriteLine("3");
            }
            Console.Read();
        }
    }
}
