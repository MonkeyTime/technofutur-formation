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
            
            do {
                
                Console.WriteLine("\r\nQuel age avez vous ?");

                age = int.Parse(Console.ReadLine());

                if (age >= 18)
                {
                    Console.WriteLine("Vous êtes majeur");
                }
                else
                {
                    Console.WriteLine("Vous êtes mineur");
                }

                Console.WriteLine("Continue ? y or n");

                rebuild = Console.ReadLine();


            } while (rebuild == "y");

            Console.Read();
        }
    }
}
