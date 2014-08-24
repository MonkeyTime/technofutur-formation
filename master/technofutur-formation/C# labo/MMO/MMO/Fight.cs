using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net.Sockets;
using System.Threading;
using System.Net;
using System.Media;

namespace MMO
{
    class Fight : IFight
    {
        protected Character _player = null;
        protected Character _latest_player = null;

        /**
         * Constructor
         * 
         * @param Character     Character 1
         * @param Character     Character 2
         * 
         */
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

        /**
         * Start
         * 
         * Start the fight from characters and round by round, each his round
         * 
         * @return void
         * 
         */
        public void Start()
        {

            Random newRand = new Random();

            while (this._player.life > 0)
            {
                if (this._latest_player is IA && this._player is Human)
                {
                    Console.WriteLine("\n* " + this._player.name + ", à toi de jouer. 1 attaquer, 2 boire une potion de vie, 3 s'ajouter buff de force\n");

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

                        case "444":

                            this._player.Attack(this._latest_player, "444");

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

                    else if (this._player.power >= 36 && this._player.life > 80)
                    {
                        choice = "1";
                    }

                    else if (this._player.power >= 36 && this._player.life < 80)
                    {
                        do
                        {
                            choice = rand.Next(1, 4).ToString();

                        } while (choice == "3");
                    }
                    else
                    {
                        choice = rand.Next(1, 4).ToString();
                    }

                    System.Threading.Thread.Sleep(newRand.Next(2000, 4000));
                    Console.WriteLine("\n" + choice);

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

            if (this._latest_player is Human)
            {
                Arm arm = new Arm();

                Arm arm_win = arm.WinRandom();

                this._latest_player.bag.Push(arm_win);
                this._latest_player.gold++;

                Console.Write("Vous avez gagné 1 pièce d'or (Portefeuille: " + this._latest_player.gold + " pièce" + (this._latest_player.gold > 1 ? "s" : "") + " d'or) et une arme "); ConsoleColor color = ConsoleColor.DarkMagenta; Console.ForegroundColor = color; Console.Write(arm_win.type); Console.ResetColor(); Console.Write(" +" + arm_win.power + " puissance d'attaque\n\n");
            
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

                case "to Player 1":
                case "to Player 2":

                    Character tmp_player3 = this._player;
                    this._player = null;
                    this._player = this._latest_player;
                    this._latest_player = null;
                    this._latest_player = (Character)tmp_player3;

                break;

                default:
                break;
            }     
        }

        /**
         * Start
         * 
         * Start the fight from characters and round by round, each his round
         * 
         * @param Socket    optional, the socket server (unfinished method)
         * 
         * @return void
         * 
         */
        public void Start(Socket socket = null)
        {
            while (this._player.life > 0)
            {
                if (this._latest_player is Orc && this._player is Human)
                {
                    Console.WriteLine("\n* " + this._player.name + ", à toi de jouer. 1 attaquer, 2 boire une potion de vie, 3 s'ajouter buff de force\n");

                    string choice = Console.ReadLine();

                    switch (choice)
                    {
                        case "1":

                            this._player.Attack(this._latest_player);

                            this._SwitchPlayer("to Player 2");

                            break;

                        case "2":

                            Potion potion = new Potion(20);
                            this._player.Caring(potion);

                            this._SwitchPlayer("to Player 2");

                            break;

                        case "3":

                            Buff buff = new Buff("Force", 10);
                            this._player.Aid(this._player, buff);

                            this._SwitchPlayer("to Player 2");

                            break;

                        case "444":

                            this._player.Attack(this._latest_player, "444");

                            this._SwitchPlayer("to Player 2");

                            break;

                        default:
                            break;
                    }
                }
                else
                {
                    Console.WriteLine("\n* " + this._player.name + ", à toi de jouer. 1 attaquer, 2 boire une potion de vie, 3 s'ajouter buff de force\n");

                    string choice = Console.ReadLine();

                    switch (choice)
                    {
                        case "1":

                            this._player.Attack(this._latest_player);

                            this._SwitchPlayer("to Player 1");

                            break;

                        case "2":

                            Potion potion = new Potion(20);
                            this._player.Caring(potion);

                            this._SwitchPlayer("to Player 1");

                            break;

                        case "3":

                            Buff buff = new Buff("Force", 10);
                            this._player.Aid(this._player, buff);

                            this._SwitchPlayer("to Player 1");

                            break;

                        case "444":

                            this._player.Attack(this._latest_player, "444");

                            this._SwitchPlayer("to Player 1");

                            break;

                        default:
                            break;
                    }
                }
            }

            //String path = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments);

            //SoundPlayer player = new SoundPlayer(path + "/clap-clap.wav");
            //player.Play();
            Console.Write(this._latest_player.name + ", vous avez gagné la gloire dans l'arêne (clap, clap, clap) \n\n");
        }
    }
}
