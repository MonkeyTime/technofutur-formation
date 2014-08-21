using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    class Bag : IBag
    {
        public List<Arm> emplacements { get; set; }

        public Bag()
        {
            //this.emplacements.Capacity = 3;
        }

        public void Push(Arm arm)
        {
            this.emplacements.Add(arm);
        }

        public void Remove(Arm arm)
        {
            this.emplacements.Remove(arm);
        }


        public void Display()
        {
            foreach (Arm arm in emplacements)
            {
                
            }
        }
    }
}
