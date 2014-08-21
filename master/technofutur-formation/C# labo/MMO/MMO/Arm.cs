using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    class Arm : IArm
    {
        public string type { get; private set; }
        public int power { get; private set; }

        public Arm(string type, int power) 
        {
            this.type = type;
            this.power = power;
        }
    }
}
