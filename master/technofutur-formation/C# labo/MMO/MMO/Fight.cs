using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    class Fight : IFight
    {
        protected Character _player = null;
        protected Character _latest_player = null;

        public Fight(Character player1, Character player2)
        {
            Random rand = new Random();
            int r = rand.Next(1, 3);

            if (r == 1)
            {
                this._player = player1;
                this._latest_player = player2;
            }
            else
            {
                this._player = player2;
                this._latest_player = player1;
            }

            Console.WriteLine("\n* Le " + this._player.classe_name + " " + this._player.race_name + " " + this._player.name + " lance un défi joueur contre joueur au " + this._latest_player.classe_name + " " + this._latest_player.race_name + " " + this._latest_player.name + ". " + this._player.name + " commence.");
        }

        public void Start()
        {
            while (this._player.life > 0)
            {
                if (this._latest_player is IA && this._player is Human)
                {
                    Console.WriteLine("\n* " + this._player.name + ", à toi de jouer. 1 attaquer, 2 boire une potion, 3 s'ajouter buff de force\n");

                    string choice = Console.ReadLine();

                    switch (choice)
                    {
                        case "1":

                            this._player.Attack(this._latest_player);
                            
                            this._SwitchPlayer("to IA");

                            break;

                        case "2":

                            Potion potion = new Potion(20);
                            this._player.Caring(potion);
                            
                            this._SwitchPlayer("to IA");

                            break;

                        case "3":

                            Buff buff = new Buff("Force", 10);
                            this._player.Aid(this._player, buff);
                            
                            this._SwitchPlayer("to IA");

                            break;

                        default:
                            break;
                    }
                }
                else
                {
                    Console.WriteLine("\n* " + this._player.name + ", à toi de jouer. " + this._player.name + " joue automatiquement");

                    Random rand = new Random();

                    string choice = "";

                    if (this._player.life > 90)
                    {
                        do
                        {
                            choice = rand.Next(1, 4).ToString();

                        } while (choice == "2");
                    }
                    else 
                    {
                        choice = rand.Next(1, 4).ToString();
                    }

                    switch (choice)
                    {
                        case "1":

                            this._player.Attack(this._latest_player);
                            
                            this._SwitchPlayer("to Player");

                            break;

                        case "2":

                            Potion potion = new Potion(20);
                            this._player.Caring(potion);
                            
                            this._SwitchPlayer("to Player");

                            break;

                        case "3":

                            Buff buff = new Buff("Force", 10);
                            this._player.Aid(this._player, buff);
                            
                            this._SwitchPlayer("to Player");

                            break;

                        default:
                            break;
                    }
                }
            }
        }

        protected void _SwitchPlayer(string to)
        {
            switch (to)
            {
                case "to Player":

                    Character tmp_player1 = this._player;
                    this._player = null;
                    this._player = this._latest_player;
                    this._latest_player = null;
                    this._latest_player = (IA)tmp_player1;

                break;

                case "to IA":

                    Character tmp_player2 = this._player;
                    this._player = null;
                    this._player = this._latest_player;
                    this._latest_player = null;
                    this._latest_player = (Human)tmp_player2;

                break;

                default:
                break;
            }     
        }
    }
}
