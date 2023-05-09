package lamqtaSpaska.creatures;

import lamqtaSpaska.items.*;
import lamqtaSpaska.items.shields.BasicShield;
import lamqtaSpaska.items.shields.ShieldOfZeus;
import lamqtaSpaska.items.weapons.Escalibur;
import lamqtaSpaska.items.weapons.Miolnir;
import lamqtaSpaska.items.weapons.Mk4;

import java.util.Random;

public class Bastard extends Creature{


    protected int dropChance = 80;
    protected int goldChance = 5;

    public Bastard(String name) {
        super(name);
        this.maxHealth = 20;
        this.health = maxHealth;
        this.damage = 2;
        this.armor = 0;
        this.dodgeChance = 0;
    }

    public Item dropItem() {
        Random r = new Random();
        Item item = new Item();
        int chance = r.nextInt(100);
        if (chance < goldChance) {
            int extraChance = r.nextInt(8);
            switch (extraChance) {
                case 0 -> item = new ZeusArmor();
                case 1 -> item = new ZeusBoots();
                case 2 -> item = new ZeusGloves();
                case 3 -> item = new ZeusPants();
                case 4 -> item = new ShieldOfZeus();
                case 5 -> item = new Escalibur();
                case 6 -> item = new ZeusHead();
                case 7 -> item = new Miolnir();
            }
            } else if (chance < dropChance){
            int ch = r.nextInt(7);
            switch (ch) {
                case 0 -> item = new BasicArmor();
                case 1 -> item = new BasicBoots();
                case 2 -> item = new BasicGloves();
                case 3 -> item = new BasicPants();
                case 4 -> item = new BasicShield();
                case 5 -> item = new Mk4();
                case 6 -> item = new BasicHead();
            }
        }

        return item;
    }
}
