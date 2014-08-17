using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication2
{
    class Program
    {

        public bool TestPair(int val)
        {
            return val % 2 == 0;
        }

        static void Main(string[] args)
        {
            int val;
            bool ok;
            string retry;

           do {
               
               do {

                   Console.WriteLine("Enter a number for verification");

                    string entry = Console.ReadLine();

                    ok = int.TryParse(entry, out val);

                    if (!ok)
                    {
                        Console.WriteLine("Please enter a number");
                    }

               } while (!ok);

                Program obj = new Program();

                if (obj.TestPair(val))
                {
                    Console.WriteLine("This number is pair");
                }
                else
                {
                    Console.WriteLine("This number is impair");
                }

                Console.WriteLine("New test ? [y|n]");

                retry = Console.ReadLine();

           } while (retry == "y");
        }
    }
}
