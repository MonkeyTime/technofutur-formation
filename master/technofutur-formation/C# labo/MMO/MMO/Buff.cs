using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    class Buff
    {
        public string type { get; private set; }
        public int power { get; private set; }

        public Buff(string type, int power)
        {
            this.type = type;
            this.power = power;
        }
    }
}
