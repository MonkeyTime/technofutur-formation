using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MMO
{
    interface ICharacter
    {
        string name { get; }
        int level { get; }
        int life { get; }
        double power { get; }

        void Attack(Character character);
        void Caring(Potion potion);
        void Aid(Character character, Buff buff);
        void Equip(Arm arm);
        void UnEquip(Arm arm);
        void Equip(Bag bag, Arm arm);
        void UnEquip(Bag bag, Arm arm);
    }
}
