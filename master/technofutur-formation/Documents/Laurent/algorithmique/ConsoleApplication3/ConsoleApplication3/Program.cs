using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Program
    {
        static void Main(string[] args)
        {
            string  firstName, lastName;
            int     age;

            Console.Write("Quel est votre nom ? \r\n");
            lastName = Console.ReadLine();

            Console.Write("Quel est votre prénom ? \r\n");
            firstName = Console.ReadLine();

            Console.Write("Quel est votre age ? \r\n");
            age = int.Parse(Console.ReadLine());

            Console.Write("\r\nBonjour " + firstName + " " + lastName + ", Vous avez " + age + " ans");

            Console.Read();
        }
    }
}
