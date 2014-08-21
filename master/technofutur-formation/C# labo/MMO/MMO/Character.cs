using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    class Character : ICharacter, IClasse, IRace, IDisposable
    {
        //ICharacter
        public string name { get; set; }
        public int level { get; protected set; }
        public int life { get; protected set;  }
        public int max_life { get; protected set; }
        public double power { get; protected set; }
        public double std_power { get; protected set; }
        public int dodge_chance { get; private set; }
        public int critic_chance { get; private set; }
        public int miss_chance { get; private set; }

        //IClasse
        public int classe_id { get; private set; }
        public string classe_name { get; private set; }

        protected static string[] _classe_name = { "Guerrier", "Paladin" };

        //IRace
        public int race_id { get; private set; }
        public string race_name { get; private set; }

        protected static string[] _race_name = { "Humain", "Orc" };


        public Character(string name, int classe_id, int race_id)
        {
            this.name = name;
            this.classe_id = classe_id;
            this.race_id = race_id;
            this.race_name = _race_name[race_id];
            this.classe_name = _classe_name[classe_id];
            this.max_life = 100;
            this.life = this.max_life;
            this.level = 1;
            this.dodge_chance = 20;
            this.critic_chance = 40;
            this.miss_chance = 20;
            this.power = 1;
            this.std_power = this.power;
        }

        public void Dispose() {} //IDisposable

        public void Attack(Character character)
        {
            Random rand = new Random();

            double dodge = rand.Next(1 , 101);

            if (dodge < this.dodge_chance)
            {
                Console.WriteLine("\n* " + "Le " + this.classe_name + " " + this.race_name + " " + this.name + " a raté son coup, à " + character.name + " de jouer");
            }
            else
            {
                rand = new Random();

                double critic = rand.Next(1, 101);

                double tmp_power = this.power;

                if (critic < character.critic_chance)
                {
                    this.power *= 1 + (critic / 100);

                    character.life -= (int)this.power;

                    Console.Write("\n* " + "Le " + character.classe_name + " " + character.race_name + " " + character.name + " perd "); ConsoleColor color = ConsoleColor.DarkMagenta; Console.ForegroundColor = color; Console.Write(this.power); Console.ResetColor(); Console.Write(" (Coup critique) points de vie (Reste " + character.life + ")\n");

                    this.power = tmp_power;
                }
                else
                {
                    character.life -= (int)this.power;

                    Console.WriteLine("\n* " + "Le " + character.classe_name + " " + character.race_name + " " + character.name + " perd " + this.power + " points de vie (Reste " + character.life + ")");
                }

                if (character.life < 1)
                {
                    Console.WriteLine("\n* " + "Le " + character.classe_name + " " + character.race_name + " " + character.name + " est mort\n");

                    this.power = this.std_power;

                    character.Dispose();
                }
            }
        }

        public void Caring(Potion potion)
        {
            Random rand = new Random();

            double miss = rand.Next(1 , 101);

            if (miss < this.miss_chance)
            {
                Console.WriteLine("\n* " + "Le " + this.classe_name + " " + this.race_name + " " + this.name + " a renverser sa potion ! Ah ciii mâââlin...");
            }
            else
            {
                this.life += potion.life;

                Console.Write("\n* " + "Potion bue par " + this.name + ", " + potion.life + " points de vie (ajouté " + (this.life <= 100 ? potion.life.ToString() : (potion.life - (this.life - this.max_life)).ToString()) + ", perdu " + (this.life <= 100 ? "0" : (this.life - this.max_life).ToString()) + ").");

                if (this.life > this.max_life)
                {
                    this.life = this.max_life;
                }
                
                Console.Write(" Total de vie (" + this.life + ")\n");
            }
        }

        public void Aid(Character character, Buff buff)
        {
            if (buff.type == "Force")
            {
                character.power += buff.power;
                Console.Write("\n* " + character.name + " gagne un buff de "); ConsoleColor color = ConsoleColor.DarkMagenta; Console.ForegroundColor = color; Console.Write(buff.type + ": +" + buff.power); Console.ResetColor(); Console.Write(". Sa puissance d'attaque est de " + character.power + "\n");
            }

            if (buff.type == "Vie")
            {
                character.life += buff.power;
                Console.WriteLine("\n* " + character.name + " gagne un buff de "); ConsoleColor color = ConsoleColor.DarkMagenta; Console.ForegroundColor = color; Console.Write(buff.type + ": +" + buff.power); Console.ResetColor(); Console.Write(". Son total de point de vie est de " + character.life);
            }
        }

        public void Equip(Arm arm)
        {
            this.power += arm.power;
            Console.Write("\n* " + this.name + " s'est équipé d'une arme de type "); ConsoleColor color = ConsoleColor.DarkMagenta; Console.ForegroundColor = color; Console.Write(arm.type + ": +" + arm.power); Console.ResetColor(); Console.Write(". Son total de puissance d'attaque est maintenant de " + this.power + "\n");
        }

        public void UnEquip(Arm arm)
        {
            this.power -= arm.power;
            Console.WriteLine("\n* " + this.name + " a enlever son arme "); ConsoleColor color = ConsoleColor.DarkMagenta; Console.ForegroundColor = color; Console.Write(arm.type + ": +" + arm.power); Console.ResetColor(); Console.Write(". Son total de puissance d'attaque est maintenant de " + this.power);
        }

        public void Equip(Bag bag, Arm arm)
        {
            this.power += arm.power;
            bag.Remove(arm);
            Console.WriteLine("\n* " + this.name + " s'est équipé d'une arme de type "); ConsoleColor color = ConsoleColor.DarkMagenta; Console.ForegroundColor = color; Console.Write(arm.type + ": +" + arm.power); Console.ResetColor(); Console.Write(". Son total de puissance d'attaque est maintenant de " + this.power);
        }

        public void UnEquip(Bag bag, Arm arm)
        {
            this.power -= arm.power;
            bag.Push(arm);
            Console.WriteLine("\n* " + this.name + " a enlever son arme "); ConsoleColor color = ConsoleColor.DarkMagenta; Console.ForegroundColor = color; Console.Write(arm.type + ": +" + arm.power); Console.ResetColor(); Console.Write(". Son total de puissance d'attaque est maintenant de " + this.power);
        }
    }
}
