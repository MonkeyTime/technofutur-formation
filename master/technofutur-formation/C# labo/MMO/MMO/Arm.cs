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
        protected static Arm[] arms = new Arm[3] { new Arm("Epée", 10), new Arm("Hache", 11), new Arm("Pugilat", 12) };

        /**
         * Constructor
         * 
         */
        public Arm(string type, int power) 
        {
            this.type = type;
            this.power = power;
        }

        /**
         * Constructor
         * 
         * Constructor overload
         * 
         */
        public Arm() { }

        /**
         * WinRandom
         * 
         * Get an random arm
         * 
         * @return Arm  The Arm
         * 
         */
        public Arm WinRandom()
        {
            Random rand = new Random();
            int r = rand.Next(0, 3);
            
            return arms[r];
        }
    }
}
