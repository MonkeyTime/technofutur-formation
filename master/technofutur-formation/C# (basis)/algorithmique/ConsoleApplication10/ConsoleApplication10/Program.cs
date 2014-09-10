using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication10
{
    class Program
    {
        static void Main(string[] args)
        {
            const string vraimdp = "1234";
            string mdp;

            do {
                Console.WriteLine("Votre mdp: ");
                mdp = Console.ReadLine();

            } while (mdp != vraimdp);

            Console.WriteLine("Connecté");

            Console.Read();
        }
    }
}
