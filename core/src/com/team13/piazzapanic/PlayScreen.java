package com.team13.piazzapanic;

import Ingredients.*;
import Recipe.Recipe;
import Sprites.*;
import Recipe.Order;
import Tools.B2WorldCreator;
import Tools.WorldContactListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The PlayScreen class is responsible for displaying the game to the user and handling the user's interactions.
 * The PlayScreen class implements the Screen interface which is part of the LibGDX framework.
 *
 * The PlayScreen class contains several important fields, including the game instance, stage instance, viewport instance,
 * and several other helper classes and variables. The game instance is used to access the global game configuration and
 * to switch between screens. The stage instance is used to display the graphics and handle user interactions, while the
 * viewport instance is used to manage the scaling and resizing of the game window.
 *
 * The PlayScreen class also contains several methods for initializing and updating the game state, including the
 * constructor, show(), render(), update(), and dispose() methods. The constructor sets up the stage, viewport, and
 * other helper classes and variables. The show() method is called when the PlayScreen becomes the active screen. The
 * render() method is called repeatedly to render the game graphics and update the game state. The update() method is
 * called to update the game state and handle user inputs. The dispose() method is called when the PlayScreen is no longer
 * needed and is used to clean up resources and prevent memory leaks.
 */


public class PlayScreen implements Screen {

    private final MainGame game;
    private final OrthographicCamera gamecam;
    private final Viewport gameport;
    public static HUD hud;

    private final TiledMap map;
    private final OrthogonalTiledMapRenderer renderer;

    private final World world;
    private final Chef chef1;
    private final Chef chef2;

    private final Chef chef3;

    private Chef controlledChef;

    private Integer money;

    public ArrayList<Order> ordersArray;
    public Map<Integer, Unlockable> unlockablesArray;
    private Map<Integer, Point> unlockablePositions;
    private int totalUnlocks;
    private int totalOrdersDelivered;

    public PlateStation plateStation;


    public Boolean scenarioComplete;
    public Boolean createdOrder;
    public Boolean unlocksGenerated;
    private Boolean unlockNewRecipes;

    public static float trayX;
    public static float trayY;

    public static float timeSeconds = 0f;

    private float timeSecondsCount = 0f;

    private float lastEndlessTime = -1;

    private float orderDelay = 22;

    /**
     * PlayScreen constructor initializes the game instance, sets initial conditions for scenarioComplete and createdOrder,
     * creates and initializes game camera and viewport,
     * creates and initializes HUD and orders hud, loads and initializes the map,
     * creates and initializes world, creates and initializes chefs and sets them, sets contact listener for world, and initializes ordersArray.
     *
     * @param game The MainGame instance that the PlayScreen will be a part of.
     */

    public PlayScreen(MainGame game) {
        this.game = game;
        money = 0;
        scenarioComplete = Boolean.FALSE;
        createdOrder = Boolean.FALSE;
        unlocksGenerated = Boolean.FALSE;
        unlockNewRecipes = Boolean.FALSE;
        totalOrdersDelivered = 0;
        gamecam = new OrthographicCamera();
        // FitViewport to maintain aspect ratio whilst scaling to screen size
        gameport = new FitViewport(MainGame.V_WIDTH / MainGame.PPM, MainGame.V_HEIGHT / MainGame.PPM, gamecam);
        // create HUD for score & time
        hud = new HUD(game.batch);
        Point position;
        // create orders hud
        Orders orders = new Orders(game.batch);
        // create map
        TmxMapLoader mapLoader = new TmxMapLoader(new InternalFileHandleResolver());
        map = mapLoader.load("Kitchen.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1 / MainGame.PPM);
        gamecam.position.set(gameport.getWorldWidth() / 2, gameport.getWorldHeight() / 2, 0);

        unlockablesArray = new HashMap<Integer, Unlockable>();

        world = new World(new Vector2(0, 0), true);
        B2WorldCreator B2World = new B2WorldCreator(world, map, this);
        unlockablePositions = B2World.getUnlockablePositions();

        chef1 = new Chef(this.world, 31.5F, 65);
        chef2 = new Chef(this.world, 128, 65);
        chef3 = new Chef(this.world, 128, 100);
        controlledChef = chef1;
        world.setContactListener(new WorldContactListener());
        controlledChef.notificationSetBounds("Down");

        ordersArray = new ArrayList<>();
        unlockablesArray = new HashMap<Integer, Unlockable>();

    }

    @Override
    public void show() {

    }


    /**
     * The handleInput method is responsible for handling the input events of the game such as movement and interaction with objects.
     *
     * It checks if the 'R' key is just pressed and both chefs have the user control, if so,
     * it switches the control between the two chefs.
     *
     * If the controlled chef does not have the user control,
     * the method checks if chef1 or chef2 have the user control and sets the control to that chef.
     *
     * If the controlled chef has the user control,
     * it checks if the 'W', 'A', 'S', or 'D' keys are pressed and sets the velocity of the chef accordingly.
     *
     * If the 'E' key is just pressed and the chef is touching a tile,
     * it checks the type of tile and sets the chef's in-hands ingredient accordingly.
     *
     * The method also sets the direction of the chef based on its linear velocity.
     *
     * @param dt is the time delta between the current and previous frame.
     */

    public void handleInput(float dt) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.R) &&
                chef1.getUserControlChef() &&
                chef2.getUserControlChef() &&
                chef3.getUserControlChef()) {
            if (controlledChef.equals(chef1)) {
                controlledChef.b2body.setLinearVelocity(0, 0);
                controlledChef = chef2;
            } else if (controlledChef.equals(chef2)) {
                controlledChef.b2body.setLinearVelocity(0, 0);
                controlledChef = chef3;
            } else if (controlledChef.equals(chef3)) {
                controlledChef.b2body.setLinearVelocity(0, 0);
                controlledChef = chef1;
            }
        }
        if (!controlledChef.getUserControlChef()) {
            if (chef1.getUserControlChef()) {
                controlledChef.b2body.setLinearVelocity(0, 0);
                controlledChef = chef1;
            } else if (chef2.getUserControlChef()) {
                controlledChef.b2body.setLinearVelocity(0, 0);
                controlledChef = chef2;
            } else if (chef3.getUserControlChef()) {
                controlledChef.b2body.setLinearVelocity(0, 0);
                controlledChef = chef3;
            }
        }
        if (controlledChef.getUserControlChef()) {
            float xVelocity = 0;
            float yVelocity = 0;

            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                yVelocity += 0.5f;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                xVelocity -= 0.5f;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                yVelocity -= 0.5f;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                xVelocity += 0.5f;
            }
            controlledChef.b2body.setLinearVelocity(xVelocity, yVelocity);
        } else {
            controlledChef.b2body.setLinearVelocity(0, 0);
        }
        if (controlledChef.b2body.getLinearVelocity().x > 0) {
            controlledChef.notificationSetBounds("Right");
        }
        if (controlledChef.b2body.getLinearVelocity().x < 0) {
            controlledChef.notificationSetBounds("Left");
        }
        if (controlledChef.b2body.getLinearVelocity().y > 0) {
            controlledChef.notificationSetBounds("Up");
        }
        if (controlledChef.b2body.getLinearVelocity().y < 0) {
            controlledChef.notificationSetBounds("Down");
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            if (controlledChef.getTouchingTile() != null) {
                InteractiveTileObject tile = (InteractiveTileObject) controlledChef.getTouchingTile().getUserData();
                String tileName = tile.getClass().getName();
                if (controlledChef.getInHandsIng() == null && controlledChef.getInHandsRecipe() == null) {
                    switch (tileName) {
                        case "Sprites.TomatoStation":
                            TomatoStation tomatoTile = (TomatoStation) tile;
                            controlledChef.setInHandsIng(tomatoTile.getIngredient());
                            controlledChef.setChefSkin(controlledChef.getInHandsIng());
                            break;
                        case "Sprites.BunsStation":
                            BunsStation bunTile = (BunsStation) tile;
                            controlledChef.setInHandsIng(bunTile.getIngredient());
                            controlledChef.setChefSkin(controlledChef.getInHandsIng());
                            break;
                        case "Sprites.OnionStation":
                            OnionStation onionTile = (OnionStation) tile;
                            controlledChef.setInHandsIng(onionTile.getIngredient());
                            controlledChef.setChefSkin(controlledChef.getInHandsIng());
                            break;
                        case "Sprites.SteakStation":
                            SteakStation steakTile = (SteakStation) tile;
                            controlledChef.setInHandsIng(steakTile.getIngredient());
                            controlledChef.setChefSkin(controlledChef.getInHandsIng());
                            break;
                        case "Sprites.LettuceStation":
                            LettuceStation lettuceTile = (LettuceStation) tile;
                            controlledChef.setInHandsIng(lettuceTile.getIngredient());
                            controlledChef.setChefSkin(controlledChef.getInHandsIng());
                            break;
                        case "Sprites.PotatoStation":
                            PotatoStation potatoTile = (PotatoStation) tile;
                            controlledChef.setInHandsIng(potatoTile.getIngredient());
                            controlledChef.setChefSkin(controlledChef.getInHandsIng());
                            break;
                        case "Sprites.DoughStation":
                            DoughStation doughTile = (DoughStation) tile;
                            controlledChef.setInHandsIng(doughTile.getIngredient());
                            controlledChef.setChefSkin(controlledChef.getInHandsIng());
                            break;
                        case "Sprites.CheeseStation":
                            CheeseStation cheeseTile = (CheeseStation) tile;
                            controlledChef.setInHandsIng(cheeseTile.getIngredient());
                            controlledChef.setChefSkin(controlledChef.getInHandsIng());
                            break;
                        case "Sprites.PlateStation":
                            if (plateStation.getPlate().size() > 0 || plateStation.getCompletedRecipe() != null) {
                                controlledChef.pickUpItemFrom(tile);
                            }
                            break;
                        case "Sprites.Oven":
                            Oven oventile = (Oven) tile;
                            if (!oventile.getIsPurchased()) {
                                if(hud.purchaseUnlock()) {
                                    unlockablePositions.remove(oventile.getOvenId());
                                    unlockablesArray.remove(oventile.getOvenId());
                                    oventile.setPurchased();
                                    unlockNewRecipes = !unlockNewRecipes;
                                }
                            }
                    }
                } else {
                    switch (tileName) {
                        case "Sprites.Bin":
                            controlledChef.setInHandsRecipe(null);
                            controlledChef.setInHandsIng(null);
                            controlledChef.setChefSkin(null);
                            break;

                        case "Sprites.ChoppingBoard":
                            if (controlledChef.getInHandsIng() != null) {
                                if (controlledChef.getInHandsIng().prepareTime > 0) {
                                    controlledChef.setUserControlChef(false);
                                }
                            }
                            break;
                        case "Sprites.PlateStation":
                            if (controlledChef.getInHandsRecipe() == null) {
                                controlledChef.dropItemOn(tile, controlledChef.getInHandsIng());
                                controlledChef.setChefSkin(null);
                            }
                            break;
                        case "Sprites.Pan":
                            if (controlledChef.getInHandsIng() != null) {
                                if (controlledChef.getInHandsIng().cookTime > 0) {
                                    controlledChef.setUserControlChef(false);
                                }
                            }
                            break;
                        case "Sprites.Oven":
                            Oven oventile = (Oven) tile;
                            if (oventile.getIsPurchased()) {
                                if (controlledChef.getInHandsRecipe() != null) {
                                    if (controlledChef.getInHandsRecipe().isCooked() == false) {
                                        controlledChef.setUserControlChef(false);
                                    }
                                }
                            }

                            break;
                        case "Sprites.CompletedDishStation":
                            if (controlledChef.getInHandsRecipe() != null) {
                                if ((controlledChef.getInHandsRecipe().isCooked() == true) && (controlledChef.getInHandsRecipe().getClass().equals(ordersArray.get(0).recipe.getClass()))) {
                                    controlledChef.dropItemOn(tile);
                                    ordersArray.get(0).orderComplete = true;
                                    controlledChef.setChefSkin(null);
                                    totalOrdersDelivered++;
                                    if (totalOrdersDelivered >= 5 && MainGame.GameMode == MainGame.Mode.SITUATION) {
                                        scenarioComplete = Boolean.TRUE;
                                    }
                                }
                            }
                            break;
                    }
                }

            }
        }
    }


    /**
     * The update method updates the game elements, such as camera and characters,
     * based on a specified time interval "dt".
     *
     * @param dt time interval for the update
     */
    public void update(float dt) {
        handleInput(dt);

        gamecam.update();
        renderer.setView(gamecam);
        chef1.update(dt);
        chef2.update(dt);
        chef3.update(dt);
        world.step(1 / 60f, 6, 2);

    }

    /**
     * Creates the orders randomly and adds to an array, updates the HUD.
     */
    public void createOrder() { //add new boolean that determines if its the endless or 5 order scenario
        int randomNumberBound = 2;
        if(unlockNewRecipes) randomNumberBound = 4;
        int randomNum = ThreadLocalRandom.current().nextInt(1, randomNumberBound + 1);
        Texture burger_recipe = new Texture("Food/burger_recipe.png");
        Texture salad_recipe = new Texture("Food/salad_recipe.png");
        Texture jacket_potato_recipe = new Texture("Food/jacket_potato_recipe.png");
        Texture pizza_recipe = new Texture("Food/pizza_recipe.png");
        Order order;

        if(randomNum==1) {
            order = new Order(PlateStation.burgerRecipe, burger_recipe);
        }
        else if(randomNum==2) {
            order = new Order(PlateStation.saladRecipe, salad_recipe);
        }
        else if(randomNum==3) {
            order = new Order(PlateStation.jacketPotatoRecipe, jacket_potato_recipe);
        }
        else {
            order = new Order(PlateStation.pizzaRecipe, pizza_recipe);
        }
        order = new Order(PlateStation.saladRecipe, salad_recipe);
        ordersArray.add(order);
        hud.updateOrder(Boolean.FALSE, 1);
        timeSecondsCount = 0;
    }

    public void endlessOrders() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        Texture burger_recipe = new Texture("Food/burger_recipe.png");
        Texture salad_recipe = new Texture("Food/salad_recipe.png");
        Order order;

        //lastEndlessTime = Math.round((timeSecondsCount));
        if (randomNum == 1 || randomNum == 3) {
            order = new Order(PlateStation.saladRecipe, salad_recipe);
        } else {
            order = new Order(PlateStation.burgerRecipe, burger_recipe);
        }
        ordersArray.add(order);
        randomNum = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        hud.updateOrder(Boolean.FALSE,1);
        timeSecondsCount =0;
    }

    /**
     * Updates the orders as they are completed, or if the game scenario has been completed.
     */
    public void updateOrder() {
        if (scenarioComplete == Boolean.TRUE) {
            hud.updateScore(Boolean.TRUE, (totalOrdersDelivered) * 35);
            hud.updateOrder(Boolean.TRUE, 0);
            return;
        }
        if (ordersArray.size() != 0) { //ordersArray != null
            if (ordersArray.get(0).orderComplete) {
                hud.updateScore(Boolean.FALSE, (6 - ordersArray.size()) * 35);
                ordersArray.remove(0);
                hud.updateOrder(Boolean.FALSE, totalOrdersDelivered);
                if(MainGame.GameMode == MainGame.Mode.SITUATION) {
                    createdOrder = Boolean.FALSE; //this is obsolete
                }
                return;
            }

            if (MainGame.GameMode == MainGame.Mode.SITUATION) {
                for (int i = 0; i < ordersArray.size(); i++) {
                    ordersArray.get(i).create(trayX, trayY, game.batch);
                }
            }
            else{
                for (int i = 0; i < ordersArray.size(); i++) {
                    ordersArray.get(i).create(trayX, trayY, game.batch, i);
                }
            }
        }
    }

    public void createLockedItem() { //THIS IS WORKING!! NOW JUST MAKE IT PROGRAMMATIC!!!
        Texture money = new Texture("Money.png");
        Unlockable unlockable;
        for (int i = 0; i < unlockablePositions.size(); i++) {
            unlockable = new Unlockable(money, i, unlockablePositions.get(i).x, unlockablePositions.get(i).y);
            unlockablesArray.put(i, unlockable);
        }
    }

    public void updatePurchases() {
        totalUnlocks = 3;
        for (int i = 0; i < totalUnlocks; i++) {
            if (unlockablesArray.containsKey(i)) {
                unlockablesArray.get(i).create(unlockablesArray.get(i).x * 16, unlockablesArray.get(i).y * 16, game.batch);
            }
        }
        //unlockablesArray.get(0).create(80, 112, game.batch);
        //unlockablesArray.get(1).create(96, 112, game.batch);
        //unlockablesArray.get(2).create(112, 112, game.batch);

        //if (unlockablesArray.size() != 0) {
        //    for (Unlockable unlock : unlockablesArray) {
        //        unlock.create(trayX, trayY, game.batch, unlockablesArray.indexOf(unlock));
        //    }
        //    //ordersArray.get(i).create(trayX, trayY, game.batch);
        //    //ordersArray.get(i).create(trayX, trayY, game.batch, i);
        //}
    }

    /**

     The render method updates the screen by calling the update method with the given delta time, and rendering the graphics of the game.

     It updates the HUD time, clears the screen, and renders the renderer and the hud.

     Additionally, it checks the state of the game and draws the ingredients, completed recipes, and notifications on the screen.

     @param delta The time in seconds since the last frame.
     */
    @Override
    public void render(float delta){
        update(delta);

        //Execute handleEvent each 1 second
        timeSeconds += Gdx.graphics.getRawDeltaTime();
        timeSecondsCount += Gdx.graphics.getDeltaTime();
        if (MainGame.GameMode == MainGame.Mode.SITUATION ) {
            if (Math.round(timeSecondsCount) % 5 == 0 && totalOrdersDelivered < 5 && !createdOrder) {
                createdOrder = Boolean.TRUE;
                createOrder();
            }
        }
        else if (MainGame.GameMode == MainGame.Mode.ENDLESS && orderDelay < Math.round(timeSecondsCount) || createdOrder == Boolean.FALSE) {
            lastEndlessTime = Math.round(timeSeconds) + orderDelay;
            endlessOrders();
            if (orderDelay > 10)orderDelay = orderDelay - 1;
            if (!createdOrder) createdOrder = Boolean.TRUE;
        }

        if(!unlocksGenerated) {
            createLockedItem();
            unlocksGenerated = !unlocksGenerated;
        }

        float period = 1f;
        if (timeSeconds > period) {
            timeSeconds -= period;
            hud.updateTime(scenarioComplete);
        }
        Gdx.gl.glClear(1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();

        updateOrder();
        updatePurchases();

        chef1.draw(game.batch);
        chef2.draw(game.batch);
        chef3.draw(game.batch);
        controlledChef.drawNotification(game.batch);
        if (plateStation.getPlate().size() > 0){
            for(Object ing : plateStation.getPlate()){
                Ingredient ingNew = (Ingredient) ing;
                ingNew.create(plateStation.getX(), plateStation.getY(),game.batch);
            }
        } else if (plateStation.getCompletedRecipe() != null){
            Recipe recipeNew = plateStation.getCompletedRecipe();
            recipeNew.create(plateStation.getX(), plateStation.getY(), game.batch);
        }
        if (!chef1.getUserControlChef()) {
            if (chef1.getTouchingTile() != null && chef1.getInHandsIng() != null){
                if (chef1.getTouchingTile().getUserData() instanceof InteractiveTileObject){
                    chef1.displayIngStatic(game.batch);
                }
            }
        }
        if (!chef2.getUserControlChef()) {
            if (chef2.getTouchingTile() != null && chef2.getInHandsIng() != null) {
                if (chef2.getTouchingTile().getUserData() instanceof InteractiveTileObject) {
                    chef2.displayIngStatic(game.batch);
                }
            }
        }
        if (!chef3.getUserControlChef()) {
            if (chef3.getTouchingTile() != null && chef3.getInHandsIng() != null) {
                if (chef3.getTouchingTile().getUserData() instanceof InteractiveTileObject) {
                    chef3.displayIngStatic(game.batch);
                }
            }
        }
        if (chef1.previousInHandRecipe != null){
            chef1.displayIngDynamic(game.batch);
        }
        if (chef2.previousInHandRecipe != null){
            chef2.displayIngDynamic(game.batch);
        }
        if (chef3.previousInHandRecipe != null){
            chef3.displayIngDynamic(game.batch);
        }


        game.batch.end();

        //game.batch.begin();

        //Texture successTexture = new Texture("Food/pizza.png");

        //game.batch.draw(successTexture, (float) 1.039375, (float) 0.72125, 1, 1);

        //game.batch.end();

    }

    @Override
    public void resize(int width, int height){
        gameport.update(width, height);
    }

    @Override
    public void pause(){

    }

    @Override
    public void resume(){
        
    }

    @Override
    public void hide(){

    }

    @Override
    public void dispose(){
        map.dispose();
        renderer.dispose();
        world.dispose();
        hud.dispose();
    }
}
