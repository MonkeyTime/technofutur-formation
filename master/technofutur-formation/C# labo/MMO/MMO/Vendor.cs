using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    class Vendor : IA
    {
        /**
         * Constructor
         * 
         * @param string        The character name
         * @param int           The classe id
         * @param               The race id
         * @param params Arm[]  The arms sell by the vendor
         * 
         */
        public Vendor(string name, int class_id, int race_id, params Arm[] items) : base(name, class_id, race_id) 
        {
            foreach (Arm item in items)
            {
                this.bag.Push(item);
            }
        }
        
        /**
         * Sell
         * 
         * Method for a vendor to open its bag and sell items to player
         * 
         * @param Character     The character buyer
         * 
         * @return void
         * 
         */
        public void Sell(Character player)
        {
            Console.WriteLine("\nAchetez tout ce que vous voulez chez " + this.name + " le " + this.classe_name + ". Pièce d'or disponible: " + player.gold + ". Tapez 0 pour quitter");

            int i = 0;
            string choice = "";

            foreach (Arm item in this.bag.emplacements)
            {
                i++;

                Console.Write("\nTapez " + i + " pour acheter pour une pièce d'or une "); ConsoleColor color = ConsoleColor.DarkMagenta;  Console.ForegroundColor = color; Console.Write(item.type); Console.ResetColor(); Console.Write(" +" + item.power + " puissance d'attaque\n");
            }

            Console.WriteLine("");

            choice = Console.ReadLine();

            if (choice != "0")
            {
                int selected = (int.Parse(choice) - 1);

                if (player.gold > 0)
                {
                    player.bag.Push(this.bag.emplacements.ElementAt(selected));
                    player.gold--;
                }
                else
                {
                    Console.WriteLine("\nDésolé, vous n'avez plus assez d'or.\n");
                }
            }

            Console.WriteLine("");
        }
    }
}
