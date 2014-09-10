using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication8
{
    delegate void PassageEnNegatifEventHandler(Compte account);

    abstract class Compte : IBanker
    {
        public string Number { get; private set; }
        public Personne Holder { get; private set; }
        public double Sold { get; private set; }
        
        public event PassageEnNegatifEventHandler PassageEnNegatifTrigger = null;

        /**
         * Constructor
         * 
         * @param string    Account number
         * @param Personne  The holder Personne object
         * 
         */
        public Compte(string number, Personne holder)
        {
            this.Number = number;
            this.Holder = holder;
        }

        /**
         * Constructor
         * 
         * @param string    Account number
         * @param Personne  The holder object
         * @param double    The current account sold
         * 
         */
        public Compte(string number, Personne holder, double sold) : this(number, holder)
        {
            this.Sold = sold;
        }

        protected void ExecuteNegatifEventHandler()
        {
            PassageEnNegatifEventHandler handler = this.PassageEnNegatifTrigger;
            
            if (handler != null)
            {
                handler(this);
            }
        }


        /** 
         * CalculerInteret
         * 
         * @return double
         * 
         */
        protected abstract double CalculerInteret();

        /** 
         * AppliqueInteret
         * 
         * @ return void
         * 
         */
        public void AppliquerInteret()
        {
            this.Sold += this.CalculerInteret();
        }

        /** 
         * GetSold
         * 
         * @return double sold
         * 
         */
        public double GetSold()
        {
            return this.Sold;
        }

        /** 
         * increaseSold
         * 
         * @return void
         * 
         */

        public void IncreaseSold(double sum) 
        {
            if (sum <= 0)
            {
                throw new ArgumentOutOfRangeException();
            }

            this.Sold += sum;
        }

        /** 
         * decreaseSold
         * 
         * @return void
         * 
         */

        public void DecreaseSold(double sum, double credit = 0)
        {
            if (sum <= 0)
            {
                throw new ArgumentOutOfRangeException();
            }

            if (this.Sold + credit - sum < 0)
            {
                throw new SoldeInsuffisantException();
            }

            this.Sold -= sum;
        }


        /**
         * Deposit
         * 
         * The sum to deposit
         * 
         * @param double sum
         * 
         * @return void
         * 
         */
        public void Deposit(double sum)
        {
            this.Sold += sum;

            Console.WriteLine("Sold: " + this.Sold + "\n");
        }

        /**
         * Withdraw
         * 
         * The sum to withdraw
         * 
         * @param double sum
         * 
         * @return void
         * 
         */
        protected void Withdraw() {}
    }
}
