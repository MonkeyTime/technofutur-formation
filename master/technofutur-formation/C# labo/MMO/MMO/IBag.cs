using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    interface IBag
    {
        List<Arm> emplacements { get; }

        void Display(Character player);
    }
}
