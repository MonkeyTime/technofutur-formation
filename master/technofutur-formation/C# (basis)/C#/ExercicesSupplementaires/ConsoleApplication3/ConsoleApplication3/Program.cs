using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> _monkeys_paddocks  = new List<int>();
            List<int> _crocodiles_paddocks = new List<int>();

            //Test monkey
            Monkey monkey1 = new Monkey("Marcel", 8, 60, 12);

            //Test monkey paddocks
            Paddock monkeysPaddock = new Paddock(monkey1, 8, _monkeys_paddocks);

            //Test monkey life
            monkey1.Sleep(14);

            monkey1.Eat(0.200);
            
            monkey1.Eat(0.800);

            monkey1.Drink(0.400);

            //Test croco
            Crocodile croco1 = new Crocodile("Gerald", 10, 230, 288);

            //Test croco paddocks
            Paddock crocosPaddock = new Paddock(croco1, 1, _crocodiles_paddocks);

            //Test croco life
            croco1.Sleep(16);

            croco1.Eat(0.200);

            croco1.Eat(0.400);

            croco1.Drink(0.250);

            //Test same paddock for 2 animals
            Crocodile croco2 = new Crocodile("Alfred", 30, 280, 0);
            new Paddock(croco2, 2, _crocodiles_paddocks);

            Crocodile croco3 = new Crocodile("Marcel", 50, 240, 0);
            new Paddock(croco3, 2, _crocodiles_paddocks);

            Console.ReadLine();
        }
    }
}
