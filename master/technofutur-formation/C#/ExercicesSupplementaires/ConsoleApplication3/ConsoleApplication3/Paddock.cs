using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Paddock
    {
        public int latest;

        public Paddock(Crocodile animal, int num, List<int> list)
        {
            if (!list.Contains(num))
            {
                list.Add(num);
                this.latest = num;
                Console.WriteLine(animal.name + " fait partie de la famille des " + animal.familly + " et a un poid de " + animal.weight + " kg, son espérance de vie médian est encore de " + animal.lifetime + " ans et a l'enclos des crocodiles numéro " + this.latest + "\n");
            }
            else
            {
                Console.WriteLine("L'enclos des crocodiles numéro " + num + " est déjà occupé, veuillez en choisir un autre pour " + animal.name);
            }
        }

        public Paddock(Monkey animal, int num, List<int> list)
        {
            if (!list.Contains(num))
            {
                list.Add(num);
                this.latest = num;
                Console.WriteLine(animal.name + " fait partie de la famille des " + animal.familly + " et a un poid de " + animal.weight + " kg, son espérance de vie médian est encore de " + animal.lifetime + " ans et a l'enclos des crocodiles numéro " + this.latest + "\n");
            }
            else
            {
                Console.WriteLine("L'enclos des singes numéro " + num + " est déjà occupé, veuillez en choisir un autre pour " + animal.name);
            }
            
        }
    }
}
