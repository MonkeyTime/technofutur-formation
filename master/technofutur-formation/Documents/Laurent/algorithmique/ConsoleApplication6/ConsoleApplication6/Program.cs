using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication5
{
    class Program
    {
        static void Main(string[] args)
        {
            int age;
            string rebuild;

            do
            {
                Console.WriteLine("Quel age avez vous ?");

                age = int.Parse(Console.ReadLine());

                if (age < 0)
                {
                    Console.WriteLine("L'âge doit être un entier positif");
                }
                else if(age >= 0 && age < 12)
                {
                    Console.WriteLine("Vous êtes un enfant");
                }
                else if (age >= 12 && age < 18)
                {
                    Console.WriteLine("Vous êtes un ado");
                }
                else
                {
                    Console.WriteLine("Vous êtes un adulte");
                }

                Console.WriteLine("Continue ? yes or no");

                rebuild = Console.ReadLine();


            } while (rebuild == "yes");
        }
    }
}
