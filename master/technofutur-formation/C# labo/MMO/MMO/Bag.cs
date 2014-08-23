using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    class Bag : IBag
    {
        public List<Arm> emplacements { get; private set; }

        /**
         * Constructor
         * 
         */
        public Bag()
        {
            this.emplacements = new List<Arm>();
            this.emplacements.Capacity = 3;
        }

        /**
         * Push
         * 
         * Method to push an arm in the bag
         * 
         * @param Arm   The arm to push in the bag
         * 
         * @return void
         * 
         */
        public void Push(Arm arm)
        {
            if (this.emplacements.Count == 3)
            {
                Console.WriteLine("Votre sac est plein.\n");
            }
            else
            {
                this.emplacements.Add(arm);

                //Console.WriteLine("\nVous avez encore " + (3 - this.emplacements.Count) + " emplacements libre dans votre sac\n");
            }
        }

        /**
         * Remove
         * 
         * Remove an arm from the bag
         * 
         * @param Arm   The arm to remove
         * 
         * @return void
         * 
         */
        public void Remove(Arm arm)
        {
            this.emplacements.Remove(arm);

            Console.WriteLine("\nVous avez encore " + (3 - this.emplacements.Count) + " emplacements libre dans votre sac\n");
        }

        /**
         * Display
         * 
         * Method to display the player bag
         * 
         * @param Character The player
         * 
         * @return void
         * 
         */
        public void Display(Character player)
        {
            int i = 0;

            Console.Write("\nEquipez vous: ");

            foreach (Arm arm in player.bag.emplacements)
            {
                i++;

                if (i == 1)
                {
                    Console.WriteLine("\n");
                }

                Console.Write("* Arme "); ConsoleColor color = ConsoleColor.DarkMagenta; Console.ForegroundColor = color; Console.Write(arm.type); Console.ResetColor(); Console.Write(" (" + arm.power + " puissance d'attaque) ? choisissez " + i + " pour équiper. S" + i + " pour supprimer, 0 pour fermer votre sac\n\n");
            }

            if (i == 0)
            {
                Console.Write("votre sac est vide.\n\n");
            }
            else
            {
                 string choice = "";

                 do
                 {
                     int selected = 0;

                     choice = Console.ReadLine();

                     if (choice != "0" && (choice == "1" || choice == "2" || choice == "3"))
                     {
                         selected = (int.Parse(choice) - 1);

                         if (this.emplacements.Capacity >= selected + 1)
                         {
                             Arm arm = player._arm;

                             player.Equip(player.bag, player.bag.emplacements.ElementAt(selected));

                             this.Push(arm);
                         }
                         else
                         {
                             Console.WriteLine("Cette arme n'existe pas");
                         }
                     }

                     if (choice == "S1" || choice == "S2" || choice == "S3")
                     {
                         if (choice == "S1")
                         {
                             selected = 0;
                         }
                         else if (choice == "S2")
                         {
                             selected = 1;
                         }
                         else
                         {
                             selected = 2;
                         }

                         player.bag.Remove(player.bag.emplacements.ElementAt(selected));
                     }

                 } while (choice != "0" && choice != "1" && choice != "2" && choice != "3" && choice != "S1" && choice != "S2" && choice != "S3");
                 
                Console.WriteLine();
            }
        }
    }
}
