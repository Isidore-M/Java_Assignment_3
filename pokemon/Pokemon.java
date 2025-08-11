package pokemon;

import attack.attackType;

public abstract class Pokemon {
    private String name;
    private int Health;
    private int attack;

    public Pokemon(String name, int hp, int attack) {
        this.name = name;
        this.Health = hp;
        this.attack = attack;
    }

    // Getters & Setters
    public String getName() { 
        return name; 
    }
    public void setName(String name) {
         this.name = name; 
        }

    public int getHealth() { 
        return Health; 
    }
    public void setHealth(int Health) {
         this.Health = Health; 
        }

    public int getAttack() {
         return attack; 
        }
    public void setAttack(int attack) {
         this.attack = attack; 
        }

    public void takeDamage(int damage) {
        this.Health -= damage;
        if (this.Health < 0) this.Health = 0;
    }

    public boolean isAlive() {
        return Health > 0;
    }

    public int performAttack(attackType type) {
        switch (type) {
            case NORMAL:
                return attack; // base attack
            case HEAVY:
                // Heavy hits harder but 25% chance to miss
                if (Math.random() < 0.25) {
                    System.out.println(name + "'s heavy attack missed!");
                    return 0;
                }
                return attack + 10;
            case SPECIAL:
                return attack + 5;
            default:
                return attack;
        }
    }
}