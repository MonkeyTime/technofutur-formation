using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr1 = {1,2,3,4,5,6,7,8,9,0};

            int[] arr2 = new int[10];

            int[] arr3 = new int[10];
            for (int i = 0; i < arr3.Length; i++)
            {
                arr3[i] = arr1[i];
            }
        }
    }
}
