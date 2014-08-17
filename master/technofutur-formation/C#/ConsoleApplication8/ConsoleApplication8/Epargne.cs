using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication8
{
    sealed class Epargne : Compte
    {
        public DateTime DateDernierRetrait{get; private set;}

        /**
         * Constructor
         * 
         * @param Personne  The Personne object
         * @param string    The current account
         * 
         */
        public Epargne(Personne holder, string account) : base(account, holder) {}

        /** 
         * CalculerInteret
         * 
         * Return bank interest based on latest sold from this account
         * 
         * @return double
         * 
         */
        protected override double CalculerInteret()
        {
            return (this.Sold * 0.045);
        }

        /**
         * Withdraw
         * 
         * Decrease the sold on action Withdrawal if the sold for this account is sufficient
         * 
         * @param double sum
         * 
         * @return void
         * 
         */
        public void Withdraw(double sum)
        {
            if ((this.Sold - sum) >= 0)
            {
                this.DecreaseSold(sum);
                this.DateDernierRetrait = DateTime.Now;

                Console.WriteLine("Solde épargne: " + this.Sold + "\n");
            }
            else
            {
                Console.WriteLine("Solde insuffisant.");
            }
        }
    }
}
