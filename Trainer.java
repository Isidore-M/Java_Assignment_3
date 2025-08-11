import pokemon.Pokemon;
import java.util.ArrayList;

public class Trainer {
    private String name;
    private ArrayList<Pokemon> collection = new ArrayList<>();

    public Trainer(String name) {
        this.name = name;
    }

    // Getters & Setters
    public String getName() { 
        return name; }
    public void setName(String name) { 
        this.name = name; }

    public ArrayList<Pokemon> getCollection() {
         return collection; 
        }
    public void addPokemon(Pokemon p) { 
        collection.add(p); }
        
    public int getCollectionSize() {
        return collection.size();
}
}