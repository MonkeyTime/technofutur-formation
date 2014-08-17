using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication8
{
    interface IBanker : ICustomer
    {
        Personne Holder { get; }
        string Number { get; }

        void AppliquerInteret();
    }
}
