using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication8
{
    class SoldeInsuffisantException : ArgumentOutOfRangeException
    {
        public SoldeInsuffisantException(string message = null) : base(message) {}
    }
}
