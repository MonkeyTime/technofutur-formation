using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication8
{
    class Banque
    {
        private readonly List<Compte> _Accounts = new List<Compte>();
        public string BankName = "Fortis";

        
        public Compte this[string numero]
        {
            get
            {
                foreach (Compte compte /*object*/ in _Accounts)
                {
                    if (compte.Number == numero)
                    {
                        return compte /*object*/;
                    }
                }

                return null;
            }
            set
            {
                for (int i = 0; i < _Accounts.Count; i++)
                {
                    if (_Accounts[i].Number == numero)
                    {
                        _Accounts[i] = value;
                    }
                }
            }
        }

        /**
         * AddAccount
         * 
         * @param Compte    Compte object
         * 
         * @return void
         * 
         */

        public void AddAccount(Compte account)
        {
            _Accounts.Add(account);

            if (account is Courant)
            {
                account.PassageEnNegatifTrigger += this.PassageEnNegatifAction;
            }

            Console.WriteLine("Account added " + account.Number);
        }

        private void PassageEnNegatifAction(Compte account)
        {
            Console.WriteLine("LE compte " + account.Number + " est passé en négatif");
        }

        /**
         * DeleteAccount
         * 
         * @param string    Compte number
         * 
         * @return void
         * 
         */
        public void DeleteAccount(string numero)
        {
            _Accounts.Remove(this[numero]);

            Console.WriteLine("Account removed " + numero);
        }
    }
}
