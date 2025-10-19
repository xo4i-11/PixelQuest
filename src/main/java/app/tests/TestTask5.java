package app.tests;

import app.gameengine.model.gameobjects.CollectibleGameObject;
import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Vector2D;
import app.games.topdownobjects.AxePickup;
import app.games.topdownobjects.MagicPickup;
import app.games.topdownobjects.PotionPickup;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TestTask5 {

    @Test
    public void addInventoryItem_test() {
        Player player= new Player (new Vector2D(6,6), 10);
        CollectibleGameObject magic= new MagicPickup(new Vector2D(2,2));
        CollectibleGameObject axe= new AxePickup(new Vector2D(1,2));
        CollectibleGameObject potion=new PotionPickup(new Vector2D(0,2),10);


        //no item
        assertEquals("No item equipped",player.getActiveItemID());

        // 1 item
        player.addInventoryItem(magic);
        assertEquals("Magic",player.getActiveItemID());

        //some items
        player.addInventoryItem(axe);
        assertEquals("Magic",player.getActiveItemID());

        player.addInventoryItem(potion);
        assertEquals("Magic",player.getActiveItemID());
    }

    @Test
    public void cycleInventoryItem_test() {
        Player player= new Player (new Vector2D(6,6), 10);
        CollectibleGameObject magic= new MagicPickup(new Vector2D(2,2));
        CollectibleGameObject axe= new AxePickup(new Vector2D(1,2));
        CollectibleGameObject potion=new PotionPickup(new Vector2D(0,2),10);

        //no item
        player.cycleInventory();
        assertEquals("No item equipped",player.getActiveItemID());

        //1 item
        player.addInventoryItem(magic);
        player.cycleInventory();
        assertEquals("Magic",player.getActiveItemID());

        //some items
        player.addInventoryItem(axe);
        player.cycleInventory();
        assertEquals("Axe",player.getActiveItemID());

        player.addInventoryItem(potion);
        player.cycleInventory();
        assertEquals("Health Potion",player.getActiveItemID());

        //last item
        player.cycleInventory();
        assertEquals("Magic",player.getActiveItemID());
    }

    @Test
    public void removeActiveItem_test() {
        Player player= new Player (new Vector2D(6,6), 10);
        CollectibleGameObject magic= new MagicPickup(new Vector2D(2,2));
        CollectibleGameObject axe= new AxePickup(new Vector2D(1,2));
        CollectibleGameObject potion=new PotionPickup(new Vector2D(0,2),10);
        CollectibleGameObject magic2= new MagicPickup(new Vector2D(3,2));
        CollectibleGameObject axe2= new AxePickup(new Vector2D(4,2));
        CollectibleGameObject potion2=new PotionPickup(new Vector2D(5,2),10);
        CollectibleGameObject axe3= new AxePickup(new Vector2D(6,2));


        //no item
        player.removeActiveItem();
        assertEquals("No item equipped",player.getActiveItemID());

        // 1 item
        player.addInventoryItem(magic);
        player.removeActiveItem();
        assertEquals("No item equipped",player.getActiveItemID());

        //some items
        player.addInventoryItem(magic);
        player.addInventoryItem(axe);
        player.addInventoryItem(potion);
        player.addInventoryItem(magic2);
        player.addInventoryItem(axe2);
        player.addInventoryItem(potion2);

        player.removeActiveItem();
        assertEquals("Axe",player.getActiveItemID());

        player.cycleInventory();
        player.removeActiveItem();
        assertEquals("Magic",player.getActiveItemID());

        player.addInventoryItem(axe3);
        player.removeActiveItem();
        player.cycleInventory();
        assertEquals("Health Potion",player.getActiveItemID());


        //last item
        player.cycleInventory();
        player.removeActiveItem();
        assertEquals("Axe",player.getActiveItemID());
    }


}
