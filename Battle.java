import pokemon.*;
import printing.*;
import artefact.*;
import attack.*;

import java.util.*;

public class Battle {
    private static Ink ink = new Ink();
    public static void main(String[] args) {
        ink.welcome();
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.print(". Trainer, enter your name: ");
        String trainerName = scan.nextLine();
        Trainer player = new Trainer(trainerName);
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String BLUE = "\u001B[34m";
    

        // Pokémon choices
        Pokemon[] pokemonChoices = { new Fire(), new Water(), new Electric(), new Rock() };
        System.out.printf("\n ----- Hi" + BLUE + " %s "+ RESET+ "Before entering the Arena, pick your Pokémon Type : -----\n\n",trainerName );
        for (int i = 0; i < pokemonChoices.length; i++) {
            System.out.println((i+1) + ". " + pokemonChoices[i].getName());
        }
        System.out.println("");
        int choice = getChoice(scan, 1, pokemonChoices.length);
        Pokemon chosenPokemon = pokemonChoices[choice-1];
        player.addPokemon(chosenPokemon);
        ink.line();
        // Artefact choices
        Artefact[] artefactChoices = { new flameAmulet(), new hydroShield(), new electricDome(), new stoneArmor() };
        System.out.printf("\n Now, Choose your Artefact: %n%n");
        for (int i = 0; i < artefactChoices.length; i++) {
            System.out.println((i+1) + ". " + artefactChoices[i].getName());
        }
        System.out.println("");
        choice = getChoice(scan, 1, artefactChoices.length);
        Artefact chosenArtefact = artefactChoices[choice-1];

        // Apply artefact bonus
        chosenPokemon.setAttack(chosenPokemon.getAttack() + chosenArtefact.getBonusAttack());
        chosenPokemon.setHealth(chosenPokemon.getHealth() + chosenArtefact.getBonusHealth());
         ink.line();
          System.out.println(" You have a "+BLUE+ chosenPokemon.getName()+" type Pokemon"+RESET);
          System.out.println("  with "+ BLUE+chosenPokemon.getHealth()+" Health points"+RESET+ " And "+BLUE+ chosenArtefact.getName()+ RESET+ " as Artefact");
        // Opponent
        Pokemon opponent = pokemonChoices[rand.nextInt(pokemonChoices.length)];
       
        System.out.println("\n Your opponent is a " +RED+ opponent.getName()+ " Pokemon type" +RESET);
        System.out.println("  with "+ RED+ opponent.getHealth()+" Health points " +RESET+ "and a Secret Artefact" );
         ink.line();
          System.out.println(BLUE +"The Battle now begins"+ RESET);
         ink.line();
        // Battle loop
        while (chosenPokemon.isAlive() && opponent.isAlive()) {
            // Player turn
            ink.attackMenu();
            int attackChoice = getChoice(scan, 1, 3);
            attackType playerAttack = attackType.values()[attackChoice - 1];
            ink.line();
            int damage = chosenPokemon.performAttack(playerAttack);
            System.out.println(" You strike your opponent with " + RED + damage + " points damage!"+ RESET);
            opponent.takeDamage(damage);
            System.out.println( GREEN + " Your Opponent's Health is now: " + opponent.getHealth()+ RESET);
            if (!opponent.isAlive()) break;
            ink.line();

            // Opponent turn
            attackType opponentAttack = attackType.values()[rand.nextInt(3)];
            System.out.println("\nYour Opponent chooses " + opponentAttack + " attack!");
            damage = opponent.performAttack(opponentAttack);
            System.out.println("And  hits you with " + damage + " points damage!");
            chosenPokemon.takeDamage(damage);
            System.out.println(BLUE + " Your Health is now :  " + chosenPokemon.getHealth()+"points"+ RESET);
        }
         ink.line();
        if (chosenPokemon.isAlive()) {
            System.out.println(BLUE + "\n Great " + trainerName +" You won!"+RESET);
            player.addPokemon(opponent);
        } else {
            System.out.println("\n Sorry You lost...");
        }
        System.out.printf(" your Pokedock now has now "+ player.getCollectionSize() + " Pokemons %n%n");
        scan.close();
        ink.goodbye();
    }

    private static int getChoice(Scanner scan, int min, int max) {
        int choice;
        while (true) {
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                if (choice >= min && choice <= max) return choice;
            } else {
                scan.next();
            }
            System.out.print("Invalid choice, try again: ");
            
        }
        
        
    }
    
}