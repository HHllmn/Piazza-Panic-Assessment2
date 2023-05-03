package io.tests;

import static org.junit.Assert.fail;
import java.util.Set;
import com.badlogic.gdx.Gdx;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.Sets;

@RunWith(GdxTestRunner.class)
public class AssetTests {

    private final static Set<String> ALLASSETS = Sets.newSet(
            //Chef PNG
            "Chef/Chef_holding_baked_potato.png",
            "Chef/Chef_holding_buns.png",
            "Chef/Chef_holding_buns_toasted.png",
            "Chef/Chef_holding_burger.png",
            "Chef/Chef_holding_cheese.png",
            "Chef/Chef_holding_chopped_lettuce.png",
            "Chef/Chef_holding_chopped_onion.png",
            "Chef/Chef_holding_chopped_tomato.png",
            "Chef/Chef_holding_cut_potato.png",
            "Chef/Chef_holding_dough.png",
            "Chef/Chef_holding_front.png",
            "Chef/Chef_holding_grated_cheese.png",
            "Chef/Chef_holding_jacket_potato.png",
            "Chef/Chef_holding_lettuce.png",
            "Chef/Chef_holding_meat.png",
            "Chef/Chef_holding_onion.png",
            "Chef/Chef_holding_patty.png",
            "Chef/Chef_holding_pizza.png",
            "Chef/Chef_holding_potato.png",
            "Chef/Chef_holding_rolled_dough.png",
            "Chef/Chef_holding_salad.png",
            "Chef/Chef_holding_tomato.png",
            "Chef/Chef_holding_uncooked_jacket_potato.png",
            "Chef/Chef_holding_uncooked_pizza.png",
            "Chef/Chef_normal.png",
            "Chef/chefIdentifier.png",

            //Food PNG
            "Food/Baked_potato.png",
            "Food/Burger.png",
            "Food/Burger_buns.png",
            "Food/burger_recipe.png",
            "Food/Cheese.png",
            "Food/Chopped_lettuce.png",
            "Food/Chopped_onion.png",
            "Food/Chopped_tomato.png",
            "Food/Cooked_patty.png",
            "Food/Dough.png",
            "Food/Dough_Rolled.png",
            "Food/Grated_cheese.png",
            "Food/Jacket_Potato.png",
            "Food/Jacket_Potato_recipe.png",
            "Food/Lettuce.png",
            "Food/Meat.png",
            "Food/Onion.png",
            "Food/Patty.png",
            "Food/Pizza.png",
            "Food/Pizza_recipe.png",
            "Food/Potato.png",
            "Food/Cut_potato.png",
            "Food/Salad.png",
            "Food/salad_recipe.png",
            "Food/Toasted_burger_buns.png",
            "Food/Tomato.png",
            "Food/Uncooked_Jacket_Potato.png",
            "Food/Uncooked_Pizza.png",

            //Other PNG (Tiles for kitchen etc)
            "blowtorchPower.png",
            "borderTex.png",
            "borderTexG.png",
            "borderTexO.png",
            "borderTexR.png",
            "endlessImage.png",
            "endlessImage1.png",
            "endlessImage2.png",
            "endlessImage3.png",
            "Money.png",
            "moneyPower.png",
            "pauseImage.png",
            "powerup_cook.png",
            "powerup_money.png",
            "powerup_patience.png",
            "powerup_reputation.png",
            "reputationPower.png",
            "situationImage.png",
            "speedPower.png",
            "TileSet.png",
            "Tile_set.png",
            "timePower.png"
    );
    @Test
    public void testAssetExists() {
        for(String asset: ALLASSETS){
            if(Gdx.files.internal(asset).exists()){
                continue;
            }
            else{
                fail("There is an asset missing: " + asset);
            }
        }
        Assert.assertTrue("All assets are present", true);
    }
}