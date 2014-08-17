using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication8
{
    sealed class Courant : Compte
    {
        private double _CreditLine;
        public double CreditLine { 
            get {

                return _CreditLine;
            } 
            set { 
                
                if(value < 0) {

                    throw new ArgumentOutOfRangeException();
                }

                _CreditLine = value;
            }
        }

        /**
         * Constructor
         * 
         * @param Personne  The holder object
         * @param string    Account number
         * @param double    The authorized credit line
         * 
         */
        public Courant(Personne holder, string account, double credit) : base(account, holder)
        {
            this.CreditLine = credit;
        }

        /**
         * Constructor
         * 
         * @param Personne  The holder object
         * @param string    Account number
         * @param double    The current sold
         * @param double    The authorized credit line
         * 
         */
        public Courant(Personne holder, string account, double sold, double credit) : base(account, holder, sold)
        {
            this.CreditLine = credit;
        }

        /** 
         * CalculerInteret
         * 
         * @return double  Total annual interest for this account
         * 
         */
        protected override double CalculerInteret()
        {
            return this.Sold < 0 ? this.Sold * 0.0975 : this.Sold * 0.03;
        }

        /** 
         * Withdraw
         * 
         * Decrease the sold on action Withdrawal if the sold for this account is sufficient
         * 
         * @param  double   The sum to withdraw
         * 
         * @return void
         * 
         */
        public void Withdraw(double sum)
        {
            if (this.Sold >= 0 && (this.Sold - sum) < 0)
            {
                this.ExecuteNegatifEventHandler();
            }

            if ((this.Sold - sum) >= (0 - this.CreditLine))
            {
                this.DecreaseSold(sum, this.CreditLine);

                Console.WriteLine("Sold: " + this.Sold + "\n");
            }
            else
            {
                Console.WriteLine("Solde insuffisant.");
            }
        } 
    }
}
