package Sprites;

import Ingredients.*;
import Recipe.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.List;

/**
 * PlateStation class represents a Plate Station in the game where the player can drop or pick up ingredients.
 * <p>
 * It extends InteractiveTileObject and provides the functionality of checking if a recipe is complete,
 * and getting the completed recipe or individual ingredients from the plate.
 * <p>
 * It also has a List of ingredients placed on the plate and two static recipes (burger and salad).
 * The checkRecipeCreated method checks if the ingredients on the plate match any of the two recipes.
 */

public class PlateStation extends InteractiveTileObject {

    /** List of ingredients placed on the plate */
    private final List<Ingredients.Ingredient> plate;

    /** Static recipe for a burger */
    public static Recipe burgerRecipe;

    /** Static recipe for a salad */
    public static Recipe saladRecipe;

    /** Static recipe for a jacketpotato */
    public static Recipe jacketPotatoRecipe;

    /** Static recipe for a pizza */
    public static Recipe pizzaRecipe;

    /** Recipe that has been completed on the plate */
    private Recipe recipeDone;

    /**
     * Constructor for the PlateStation class
     *
     * @param world the world object representing the game world
     * @param map the TiledMap object representing the game map
     * @param bdef the BodyDef object representing the plate's physical body
     * @param rectangle the Rectangle object representing the plate's hitbox
     */
    public PlateStation(final World world,
                        final TiledMap map,
                        final BodyDef bdef,
                        final Rectangle rectangle) {
        super(world, map, bdef, rectangle);
        fixture.setUserData(this);
        this.plate = new ArrayList<>();
        burgerRecipe = new BurgerRecipe();
        saladRecipe = new SaladRecipe();
        jacketPotatoRecipe = new JacketPotatoRecipe();
        pizzaRecipe = new PizzaRecipe();
        this.recipeDone = null;
    }

    /**
     * Adds an ingredient to the plate.
     *
     * @param ing the Ingredient object to be added to the plate
     */
    public void dropItem(Ingredients.Ingredient ing) {
        plate.add(ing);
        checkRecipeCreated();
    }

    /**
     * Check if the ingredients on the plate match any of the two recipes (burger or salad) then clear the plate
     * if a recipe is found and set the recipeDone
     */
    public void checkRecipeCreated(){
        if (plate.size() == burgerRecipe.getIngredients().size()) {
            boolean burgerSame = true;
            boolean burgerIngFound;
            for (Ingredients.Ingredient ing : plate) {
                burgerIngFound = false;
                for (int j = 0; j < burgerRecipe.getIngredients().size(); j++) {
                    if (ing.getClass().toString().equals(burgerRecipe.getIngredients().get(j).getClass().toString())) {
                        if (ing.isCooked()) {
                            burgerIngFound = true;
                        }
                    }
                }
                if (!burgerIngFound) {
                    burgerSame = false;
                }
            }
            if (burgerSame) {
                plate.clear();
                recipeDone = burgerRecipe;
            }
        }
        if (plate.size() == saladRecipe.getIngredients().size()) {
            boolean saladSame = true;
            boolean saladIngFound;
            for (Ingredients.Ingredient ing : plate) {
                saladIngFound = false;
                for (int j = 0; j < saladRecipe.getIngredients().size(); j++) {
                    if (ing.getClass().toString().equals(saladRecipe.getIngredients().get(j).getClass().toString())) {
                        if (ing.isPrepared()) {
                            saladIngFound = true;
                        }
                    }
                }
                if (!saladIngFound) {
                    saladSame = false;
                }
            }
            if (saladSame) {
                plate.clear();
                recipeDone = saladRecipe;
            }
        }
        if (plate.size() == jacketPotatoRecipe.getIngredients().size()) {
            boolean jacketPotatoSame = true;
            boolean jacketPotatoIngFound;
            for (Ingredients.Ingredient ing : plate) {
                jacketPotatoIngFound = false;
                for (int j = 0; j < jacketPotatoRecipe.getIngredients().size(); j++) {
                    if (ing.getClass().toString().equals(jacketPotatoRecipe.getIngredients().get(j).getClass().toString())) {
                        if (ing.isPrepared()) {
                            jacketPotatoIngFound = true;
                        }
                    }
                }
                if (!jacketPotatoIngFound) {
                    jacketPotatoSame = false;
                }
            }
            if (jacketPotatoSame) {
                plate.clear();
                recipeDone = jacketPotatoRecipe;
                jacketPotatoRecipe = new JacketPotatoRecipe();
            }
        }
        if (plate.size() == pizzaRecipe.getIngredients().size()) {
            boolean pizzaSame = true;
            boolean pizzaIngFound;
            for (Ingredient ing : plate) {
                pizzaIngFound = false;
                for (int j = 0; j < pizzaRecipe.getIngredients().size(); j++) {
                    if (ing.getClass().toString().equals(pizzaRecipe.getIngredients().get(j).getClass().toString())) {
                        if (ing.isPrepared()) {
                            pizzaIngFound = true;
                        }
                    }
                }
                if (!pizzaIngFound) {
                    pizzaSame = false;
                }
            }
            if (pizzaSame) {
                plate.clear();
                recipeDone = pizzaRecipe;
                pizzaRecipe = new PizzaRecipe();
            }
        }
    }

    /**
     * Gets the ingredients on the plate.
     *
     * @return An ArrayList of ingredients on the plate.
     */
    public ArrayList getPlate() {
        return (ArrayList) this.plate;
    }

    /**
     * Gets the completed recipe, if any, on the plate.
     *
     * @return The completed recipe on the plate, or null if no recipe is completed.
     */
    public Recipe getCompletedRecipe() {
        return recipeDone;
    }

    /**
     * Gets the x-coordinate of the plate station.
     *
     * @return The x-coordinate of the plate station.
     */
    public float getX() {
        return super.bdefNew.position.x;
    }

    /**
     * Gets the y-coordinate of the plate station.
     *
     * @return The y-coordinate of the plate station.
     */
    public float getY() {
        return super.bdefNew.position.y;
    }

    /**
     * Picks up an item from the plate. If a recipe is completed on the plate,
     * the completed recipe is returned. If no recipe is completed, the last
     * ingredient on the plate is removed and returned.
     *
     * @return A Recipe object if a recipe is completed, or an Ingredient
     * object if no recipe is completed.
     */
    public Object pickUpItem() {
        if (recipeDone != null) {
            Recipe temp = recipeDone;
            recipeDone = null;
            return temp;
        } else {
            Ingredient item = plate.get(plate.size()-1);
            plate.remove(plate.size()-1);
            return item;
        }
    }
}