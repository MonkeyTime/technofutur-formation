using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exos
{
    public delegate void Init();
    public delegate void Render(String msg);
    public delegate int Calculate();

    public class EventExample
    {
        public int x { set; private get; }
        public int y { set; private get; }
        private int total = 0;

        public void Write()
        {
            Console.WriteLine("Hello World\n");
        }


        public void WriteSomething(string message)
        {
            Console.WriteLine(message);
        }

        public int Addition()
        {
            return this.total += (this.x + this.y);
        }


        public int Substract()
        {
            return this.total += (this.x - this.y);
        }


        public int Division()
        {
            return this.total += (this.x / this.y);
        }


        public int Multiplication()
        {
            return this.total += (this.x * this.y);
        }

        public void Execute(string str)
        {
            Init SayHello = null;

            SayHello += Write;

            if (SayHello != null)
            {
                SayHello();

                Calculate all = null;

                all += this.Addition;
                all += this.Substract;
                all += this.Division;
                all += this.Multiplication;

                if (all != null)
                {
                    Render render = null;

                    render += this.WriteSomething;

                    if (render != null)
                    {
                        int result = all();

                        render(str + "\n" + result.ToString());
                    }
                }
            }
        }
    }
}
