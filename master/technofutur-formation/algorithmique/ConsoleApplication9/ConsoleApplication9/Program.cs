using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication9
{
    class Program
    {
        static void Main(string[] args)
        {
            int choix, i = 0;

            choix = int.Parse(Console.ReadLine());

            while (i < choix)
            {
                Console.WriteLine("Bonjour");
                i++;
            }

            Console.Read();
        }
    }
}
