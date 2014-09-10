using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    class IA : Orc
    {
        /**
         * Constructor
         * 
         * @param string    The character name
         * @param int       The classe id
         * @param           The race id
         * 
         */
        public IA(string name, int classe_id, int race_id) : base(name, classe_id, race_id) { }
    }
}
