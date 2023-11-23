package model;


public class Inventory  {
    private static String    id;
    private static String name;
    private static String    quant;
    private static String last_update;

    
    public Inventory(){

    }

    public String getId() {
        return id;
    }

    public void setId(String newId) {
        Inventory.id = newId;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        Inventory.name = newName;
    }

    public String getQuant() {
        return quant;
    }

    public void setQuant(String newQuant) {
        Inventory.quant = newQuant;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String newLast_update) {
        Inventory.last_update = newLast_update;
    }

    
    public Inventory(String id, String name , String quant, String last_update) {
        Inventory.id = id;
        Inventory.name = name;
        Inventory.quant = quant;
        Inventory.last_update = last_update;
    }

    public Inventory(String quant, String last_update) {
        Inventory.quant= quant;
        Inventory.last_update = last_update;
    }
      

}
