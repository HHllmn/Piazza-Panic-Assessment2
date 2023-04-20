package io.tests;

import static org.junit.Assert.fail;
import java.util.Set;
import com.badlogic.gdx.Gdx;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.collections.Sets;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class AssetTests {

    private final static Set<String> ALLASSETS = Sets.newSet(
            //Chef PNG
            "Chef/Chef_holding_buns.png",
            "Chef/Chef_holding_buns_toasted.png",
            "Chef/Chef_holding_burger.png",
            "Chef/Chef_holding_chopped_lettuce.png",
            "Chef/Chef_holding_chopped_onion.png",
            "Chef/Chef_holding_front.png",
            "Chef/Chef_holding_lettuce.png",
            "Chef/Chef_holding_meat.png",
            "Chef/Chef_holding_onion.png",
            "Chef/Chef_holding_patty.png",
            "Chef/Chef_holding_salad.png",
            "Chef/Chef_holding_tomato.png",
            "Chef/Chef_normal.png",
            "Chef/chefIdentifier.png",

            //Food PNG
            "Food/Burger.png",
            "Food/Burger_buns.png",
            "Food/burger_recipe.png",
            "Food/Chopped_lettuce.png",
            "Food/Chopped_onion.png",
            "Food/Chopped_tomato.png",
            "Food/Cooked_patty.png",
            "Food/Lettuce.png",
            "Food/Meat.png",
            "Food/Onion.png",
            "Food/Patty.png",
            "Food/Salad.png",
            "Food/salad_recipe.png",
            "Food/Toasted_burger_buns.png",
            "Food/Tomato.png",

            //Other PNG (Tiles for kitchen etc)
            "TileSet.png",
            "Tile_set.png",
            "startImage.png"
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