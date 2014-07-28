using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication13
{
    class Program
    {
        static void Main(string[] args)
        {
            const int MAX_PLAYER = 50000;
            int nbrPlayer, latest = -1, player = -1, j = 0;
            int[] scores = new int[MAX_PLAYER];
            string quit;

            do 
            {
                do 
                {
                    Console.WriteLine("Combien de joueurs ?");

                    if(j > 0)
                    {
                        Console.WriteLine("choisissez un nombre de joueur entre 1 et 50k");
                    }

                    nbrPlayer = int.Parse(Console.ReadLine());
                    j++;

                } while (nbrPlayer <= 0 || nbrPlayer > MAX_PLAYER);

                j = 0;

                for (int i = 0; i < nbrPlayer; i++)
                {
                    Console.WriteLine("Quel score pour le joueur " + (i + 1));
                    scores[i] = int.Parse(Console.ReadLine());
                }

                for (int i = 0; i < nbrPlayer; i++)
                {
                    Console.WriteLine("joueur " + (i + 1) + " a fait çà en " + scores[i] + " coup" + (scores[i] > 1 ? "s" : ""));

                    //normally we must verify also the equality
                    if (latest == -1 || scores[i] < latest)
                    {
                        latest = scores[i];
                        player = i + 1;
                    }
                }

                Console.WriteLine("le joueur " + player + " a fait çà en " + latest + " coup" + (latest > 1 ? "s" : "") + " et gagne");

                Console.WriteLine("Quit ? [yes/no]");

                quit = Console.ReadLine();

            } while (quit.ToLower() == "no");
        }
    }
}

