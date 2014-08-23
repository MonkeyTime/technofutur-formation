using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    class Orc : Character
    {
        /**
         * Constructor
         * 
         * @param string    The character name
         * @param int       The classe id
         * @param           The race id
         * 
         */
        public Orc(string name, int class_id, int race_id) : base(name, class_id, race_id) { } 
    }
}
