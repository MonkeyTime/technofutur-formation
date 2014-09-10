using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exos
{
    class Program
    {
        static void Main(string[] args)
        {
            EventExample example = new EventExample();

            example.x = 10;
            example.y = 2;

            example.Execute("We chain some calculations... and its equal to...\n");

            Console.ReadLine();
        } 
    }
}
