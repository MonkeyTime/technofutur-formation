using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication19
{
    class Program
    {
        /**
         * proc1
         * 
         * do nothing
         * 
         **/
        void proc1()
        {

        }

        /**
         * proc2
         * 
         * do nothing
         * 
         **/
        void proc2()
        {

        }

        /**
         * proc3
         * 
         * do nothing
         * 
         **/
        void proc3()
        {

        }

        static void Main(string[] args)
        {
            int choice;

            Program ProgObject = new Program();

            do
            {
                Console.WriteLine("choisissez menu: 1, 2 ou 3, 0 pour exit");
                choice = int.Parse(Console.ReadLine());

                switch (choice)
                {
                    case 1 :
                        ProgObject.proc1();
                    break;

                    case 2:
                        ProgObject.proc2();
                    break;

                    case 3:
                        ProgObject.proc3();
                    break;

                    default:
                    case 0:

                    break;
                }

            } while (choice != 0);
        }
    }
}
