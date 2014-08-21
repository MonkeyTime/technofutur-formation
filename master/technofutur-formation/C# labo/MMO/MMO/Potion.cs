using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    class Potion
    {
        public int life { get; private set; }

        public Potion(int life) 
        {
            this.life = life;
        }
    }
}
