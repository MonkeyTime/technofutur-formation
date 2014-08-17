using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication8
{
    interface ICustomer
    {
        double Sold { get; }

        void IncreaseSold(double sum);
        void DecreaseSold(double sum, double credit);
    }
}
