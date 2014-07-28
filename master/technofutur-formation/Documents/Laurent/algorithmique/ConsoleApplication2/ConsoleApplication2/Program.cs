using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication2
{
    class Program
    {
        static void Main(string[] args)
        {

            int birthYear, age;

            Console.WriteLine("Quelle est votre année de naissance ?");

            birthYear = int.Parse(Console.ReadLine());

            age = DateTime.Now.Year - birthYear;

            Console.WriteLine("Tu es né en " + birthYear + " et tu as ~ " + age + " ans");

            Console.Read();
        }
    }
}
