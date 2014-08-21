using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    class Program
    {
        static void Main(string[] args)
        {
            string choice = "";

            Bag Bag = new Bag();

            do 
            {
                Console.WriteLine("1 Player vs IA, 2 Go to Shop, 3 Open bag, 4 Player vs Player, 0 quit\n");

                choice = Console.ReadLine();

                switch (choice)
                {
                    case "1":
                        
                        Human Player = new Human("Agila", 1, 0);
                        IA IA = new IA("Anibal", 0, 1);
                        
                        Arm player_arm = new Arm("Epée", 5);
                        Arm ia_arm = new Arm("Hache", 5);

                        Player.Equip(player_arm);
                        IA.Equip(ia_arm);

                        Fight Fight = new Fight(Player, IA);
                        Fight.Start();

                    break;

                    case "2":
                    break;

                    case "3":

                        Bag.Display();

                    break;

                    case "4":
                    break;

                    default:
                    break;
                }


            } while(choice != "0");
        }
    }
}
