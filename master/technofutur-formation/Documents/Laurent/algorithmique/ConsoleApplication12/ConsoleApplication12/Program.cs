using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication12
{
    class Program
    {
        static void Main(string[] args)
        {
            const int RAND_MAX = 100;
            int nbrHidden, nbrUsr, count, nbrGame = 0, latest = -1;
            string retry;

            do 
            {
                Random RandomInstance = new Random();
                nbrHidden = RandomInstance.Next(RAND_MAX);
                count = 0;
                nbrGame++;

                do 
                {
                    Console.WriteLine("Choisissez un nombre entre 0 et 100");
                    nbrUsr = int.Parse(Console.ReadLine());

                    if (nbrUsr >= 0 && nbrUsr <= 100)
                    {
                        count++;

                        if (nbrUsr > nbrHidden)
                        {
                            Console.WriteLine("C'est moins\r\n");
                        }

                        if (nbrUsr < nbrHidden)
                        {
                            Console.WriteLine("C'est plus\r\n");
                        }
                    }
                    else
                    {
                        Console.WriteLine(nbrUsr + " n'est pas compris entre 0 et 100");
                    }

                } while (nbrUsr != nbrHidden);

                if (count < latest || latest == -1/*première partie*/)
                {
                    latest = count;
                }

                Console.Write("Bravo, vous avez réussi en " + count + " coup");

                if (count > 1)
                {
                    Console.Write("s\r\n");
                }
                else
                {
                    Console.Write("\r\n");
                }

                Console.Write("Voulez-vous rejouer ? [yes/no]\r\n");

                retry = Console.ReadLine();

            } while (retry.ToLower() == "yes");

            Console.Write("Vous avez fait " + nbrGame + " partie");

            if (nbrGame > 1)
            {
                Console.Write("s !\r\n");
            }
            else
            {
                Console.Write(" !\r\n");
            }

            Console.Write("Meilleure performance en " + best + " coup");

            if (best > 1)
            {
                Console.Write("s !\r\n");
            }
            else
            {
                Console.Write(" !\r\n");
            }

            Console.Read();
        }
    }
}
