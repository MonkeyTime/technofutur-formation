using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Namespace1;
using Sub = Namespace1.Sub1;

namespace Namespace
{
    class Program
    {
        static void Main(string[] args)
        {
            Class1 class1 = new Class1();
            Sub.Class2 class2 = new Sub.Class2();
        }
    }
}
