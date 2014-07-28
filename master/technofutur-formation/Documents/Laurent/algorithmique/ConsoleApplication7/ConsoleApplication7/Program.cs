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
            int podium;
            string rebuild;

            do
            {
                Console.WriteLine("Quelle place avez-vous obtenu ?");

                podium = int.Parse(Console.ReadLine());

                if (podium <= 0)
                {
                    Console.WriteLine("La place doit être un entier positif supérieur à zéro");
                }
                else if (podium == 1)
                {
                    Console.WriteLine("Vous êtes le grand gagnant sur la première marche, médaillé d'or");
                }
                else if (podium == 2)
                {
                    Console.WriteLine("Vous êtes sur la deuxième marche, médaillé d'argent");
                }
                else if(podium == 3)
                {
                    Console.WriteLine("Vous êtes sur la troisième marche, médaillé de bronze");
                }
                else
                {
                    Console.WriteLine("Vous ne faite pas partie du podium");
                }

                switch (podium)
                {
                    case 1: 
                        Console.WriteLine("Vous êtes le grand gagnant sur la première marche, médaillé d'or");
                    break;

                    case 2:
                        Console.WriteLine("Vous êtes sur la deuxième marche, médaillé d'argent");
                    break;

                    case 3:
                        Console.WriteLine("Vous êtes sur la troisième marche, médaillé de bronze");
                    break;

                    default:
                        if (podium <= 0)
                        {
                            Console.WriteLine("La place doit être un entier positif supérieur à zéro");
                        }
                        else
                        {
                            Console.WriteLine("Vous ne faite pas partie du podium");
                        }
                    break;
                }

                Console.WriteLine("Continue ? yes or no");

                rebuild = Console.ReadLine();


            } while (rebuild == "yes");
        }
    }
}
