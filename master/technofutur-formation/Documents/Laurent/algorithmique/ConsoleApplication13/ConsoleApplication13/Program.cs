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
            int i, nbrPlayer, latest = -1, player = -1;
            int[] scores = new int[MAX_PLAYER];

            Console.WriteLine("Combien de joueurs ?");
            nbrPlayer = int.Parse(Console.ReadLine());

            if (nbrPlayer > 0 && nbrPlayer <= MAX_PLAYER)
            {
                i = 0;

                while (i <= (nbrPlayer - 1))
                {
                    Console.WriteLine("Quel score pour le joueur " + (i + 1));
                    scores[i] = int.Parse(Console.ReadLine());
                    i++;
                }

                i = 0;
                
                while (i <= (nbrPlayer - 1))
                {
                    Console.WriteLine("joueur " + (i + 1) + " a fait çà en " + scores[i] + " coup" + (scores[i] > 1 ? "s" : ""));

                    if (latest == -1 || scores[i] < latest)
                    {
                        latest = scores[i];
                        player = i + 1;
                    }  
   
                    i++;
                }

                Console.WriteLine("le joueur " + player + " a fait çà en " + latest + " coup" + (latest > 1 ? "s" : "") + " et gagne");

                Console.Read();
            }
        }
    }
}
