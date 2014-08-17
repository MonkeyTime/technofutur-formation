using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Entrez un nombre pour addition");

            string value1 = Console.ReadLine();

            Console.WriteLine("Entrez le deuxième nombre pour addition");

            string value2 = Console.ReadLine();

            int total = int.Parse(value1) + int.Parse(value2);

            Console.WriteLine(string.Format("L'addition de {0} + {1} = {2}", value1, value2, total));

            Console.ReadLine();

            Console.WriteLine("Entrez un nombre pour addition");

            string value3 = Console.ReadLine();

            Console.WriteLine("Entrez le deuxième nombre pour addition");

            string value4 = Console.ReadLine();

            int tp1, tp2;

            bool try1 = int.TryParse(value3, out tp1);

            bool try2 = int.TryParse(value4, out tp2);

            if(try1 && try2)
            {
                int total2 = tp1 + tp2;

                Console.WriteLine(string.Format("L'addition de {0} + {1} = {2}", value3, value4, total2));
            }
            else
            {
                Console.WriteLine("Something goes wrong, please restart the process.");
            }

            Console.ReadLine();
        }
    }
}
