using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Program
    {
        public enum CarType: byte
        {
            Sports = 0,
            Familly = 1,
            Break = 2
        }

        static void Main(string[] args)
        {
            Random rand = new Random();

            Console.WriteLine((int)CarType.Sports + " - " + (int)CarType.Familly + " - " + (int)CarType.Break);

            //en 1 ligne 
            CarType r2 = (CarType)rand.Next(Enum.GetValues(typeof(CarType)).Length);

            int r = rand.Next(0, 3);

            Console.WriteLine("Rand " + r);

            if (r == (int)CarType.Break)
            {
                Console.WriteLine("Break");
            }
            else if (r == (int)CarType.Familly)
            {
                Console.WriteLine("Familly");
            }
            else
            {
                Console.WriteLine("Sports");
            }


            Console.ReadLine();
        }
    }
}
