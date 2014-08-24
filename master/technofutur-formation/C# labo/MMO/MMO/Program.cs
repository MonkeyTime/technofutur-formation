using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net.Sockets;
using System.Threading;
using System.Net;

namespace MMO
{
    class Program
    {
        static void Main(string[] args)
        {
            string choice = "";
            int i = 0;
            
            Human Player = new Human("Agila", 1, 0);
            Arm player_arm = new Arm("Epée", 5);
            
            do 
            {
                Console.WriteLine("1 Player vs IA, 2 Go to vendor, 3 Open bag, 4 Player vs Player, 0 quit, /clear (clear console)\n");

                choice = Console.ReadLine();

                switch (choice)
                {
                    case "1":

                        if (i == 0)
                        {
                            Player.Equip(player_arm);
                        }
                        Player.Prepare();

                        IA IA = new IA("Anibal", 0, 1);
                        Arm ia_arm = new Arm("Hache", 5);
                        
                        IA.Equip(ia_arm);
                        IA.Prepare();

                        Fight Fight = new Fight(Player, IA);
                        Fight.Start();

                        i++;

                    break;

                    case "2":

                        Vendor Vendor = new Vendor("Brocabancaloucouloss", 0, 1, new Arm("Epée", 15), new Arm("Hache", 15), new Arm("Pugilat", 15));
                        Vendor.Sell(Player);

                    break;

                    case "3":
                        
                        Bag Bag = new Bag();
                        Bag.Display(Player);

                    break;

                    case "4":

                        Player.Equip(player_arm);
                        Player.Prepare();

                        Orc Orc = new Orc("Anibal", 0, 1);
                        Arm orc_arm = new Arm("Hache", 5);
                        
                        Orc.Equip(orc_arm);
                        Orc.Prepare();

                        Fight fight = new Fight(Player, Orc);
                        fight.Start(null);

                        i++;

                    break;

                    case "/clear":

                        Console.Clear();
                    
                    break;

                    default:
                    break;

                }

            } while(choice != "0");
        }
    }
}
