package lamqtaSpaska.creatures;


import lamqtaSpaska.items.*;
import lamqtaSpaska.items.shields.Shield;
import lamqtaSpaska.items.weapons.Weapon;

import java.util.ArrayList;

public class Hero extends Creature {

    private Header head = new Header();
    private Armor body = new Armor();
    private Boots boots = new Boots();
    private Gloves gloves = new Gloves();
    private Pants pants = new Pants();
    private Shield shield = new Shield();
    private Weapon weapon = new Weapon();
    private int money = 0;
    protected ArrayList<Item> loot = new ArrayList<>();
    private int sleepsInHana = 0;
    private int monsterKills = 0;



    public Hero(String name) {
        super(name);
        this.maxHealth = 100;
        this.health = maxHealth;
        this.damage = 5;
        this.armor = 0;
        this.dodgeChance = 0;
    }
    public int getSleepsInHana() {
        return sleepsInHana;
    }

    public void setSleepsInHana() {
        this.sleepsInHana++;
    }

    public int getMonsterKills() {
        return monsterKills;
    }

    public void setMonsterKills() {
        this.monsterKills++;
    }

    protected void setHealth(int health) {
            this.health = health - getBonusHealth();
        }
    @Override
    protected int getHealth() {
        return (this.health + getBonusHealth());
    }

    @Override
    protected int getDamage() {
        return (this.damage + getBonusDMG());
    }

    protected int getArmor() {
        return (getBonusArmor());
    }

    public int getMoney() {
        return money;
    }

    public void chargeMoney(int money) {
        this.money -= money;
    }

    public void findGold(int rewad){
        this.money += rewad;
    }

    public Item sellItem(int num) {
        Item item = loot.get(num - 1);
        this.money += loot.get(num - 1).getPrice();
        loot.remove(num - 1);
        return item;
    }



    public void equipFromLoot(int num) {
        num--;

        if (loot.get(num) instanceof Header) {
            if (head.getName().equals("null")) {
                this.head = (Header) loot.get(num);
                loot.remove(loot.get(num));
            } else {
                Item item = this.head;
                head = (Header) loot.get(num);
                loot.remove(loot.get(num));
                loot.add(item);
            }
        }
        else if (loot.get(num) instanceof Armor) {
            if (body.getName().equals("null")) {
                this.body = (Armor) loot.get(num);
                loot.remove(loot.get(num));
            } else {
                Item item = this.body;
                this.body = (Armor) loot.get(num);
                loot.remove(loot.get(num));
                loot.add(item);
            }
        }
        else if (loot.get(num) instanceof Pants) {
            if (pants.getName().equals("null")) {
                this.pants = (Pants) loot.get(num);
                loot.remove(loot.get(num));
            } else {
                Item item = this.pants;
                this.pants = (Pants) loot.get(num);
                loot.remove(loot.get(num));
                loot.add(item);
            }
        }
        else if (loot.get(num) instanceof Boots) {
            if (boots.getName().equals("null")) {
                this.boots = (Boots) loot.get(num);
                loot.remove(loot.get(num));
            } else {
                Item item = this.boots;
                this.boots = (Boots) loot.get(num);
                loot.remove(loot.get(num));
                loot.add(item);
            }
        }
        else if (loot.get(num) instanceof Gloves) {
            if (gloves.getName().equals("null")) {
                this.gloves = (Gloves) loot.get(num);
                loot.remove(loot.get(num));
            } else {
                Item item = this.gloves;
                this.gloves = (Gloves) loot.get(num);
                loot.remove(loot.get(num));
                loot.add(item);
            }
        }
        else if (loot.get(num) instanceof Weapon) {
            if (weapon.getName().equals("null")) {
                this.weapon = (Weapon) loot.get(num);
                loot.remove(num);
            } else {
                Item item = this.weapon;
                this.weapon = (Weapon) loot.get(num);
                loot.remove(num);
                loot.add(item);
            }
        }
        else if (loot.get(num) instanceof Shield) {
            if (shield.getName().equals("null")) {
                this.shield = (Shield) loot.get(num);
                loot.remove(num);
            } else {
                Item item = this.shield;
                this.shield = (Shield) loot.get(num);
                loot.remove(num);
                loot.add(item);
            }
        }
        System.out.println("Item equipped.");
    }

    public void getDroppedItem(Item item) {
        if (loot.size() <= 5) {
            loot.add(item);
        } else {
            System.out.println("You dont have space.");
        }
    }

    public void removeItemFromloot(int num) {
        loot.remove(num - 1);
    }

    private int getBonusHealth() {
        return this.weapon.getBonusHealth() + this.shield.getBonusHealth() + head.getBonusHealth()
                + body.getBonusHealth() + pants.getBonusHealth() + boots.getBonusHealth() + gloves.getBonusHealth();
    }

    private int getBonusDMG() {
        return weapon.getBonusDMG() + shield.getBonusDMG() + head.getBonusDMG()
                + body.getBonusDMG() + pants.getBonusDMG() + boots.getBonusDMG() + gloves.getBonusDMG();
    }

    private int getBonusArmor() {
        return weapon.getBonusArmor() + shield.getBonusArmor() + head.getBonusArmor() +
                body.getBonusArmor() + pants.getBonusArmor() + boots.getBonusArmor() + gloves.getBonusArmor();
    }


    public void showLoot() {
        for (int i = 0; i < loot.size(); i++) {
            System.out.println((i + 1) + " - " + loot.get(i).showInfo());
        }
    }

    public void showStats() {
        System.out.println("Your health : " + getHealth());
        System.out.println("Your armor : " + getArmor());
        System.out.println("Your dmg : " + getDamage());
    }
    public void showFinalStats(){
        showStats();
        System.out.println("Sleeps in hana : " + getSleepsInHana());
        System.out.println("Money left : " + getMoney());
        System.out.println("Monster Kills : " + getMonsterKills());
    }

    public int getLootSize() {
        return loot.size();
    }
}
