package artefact;

public abstract class Artefact {
    private String name;
    private int bonusAttack;
    private int bonusHealth;

    public Artefact(String name, int bonusAttack, int bonusHealth) {
        this.name = name;
        this.bonusAttack = bonusAttack;
        this.bonusHealth = bonusHealth;
    }

    // Getters & Setters
    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }

    public int getBonusAttack() { 
        return bonusAttack; 
    }
    public void setBonusAttack(int bonusAttack) { this.bonusAttack = bonusAttack; 
    }

    public int getBonusHealth() { return bonusHealth; }
    public void setBonusHealth(int bonusHealth) { this.bonusHealth = bonusHealth; }
}