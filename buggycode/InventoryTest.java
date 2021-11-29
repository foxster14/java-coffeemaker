import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import jdk.jfr.Timestamp;

public class InventoryTest {

    //Instantiate the inventory object
    private Inventory inventoryItem;
    private CoffeeMaker coffeeMaker;
    private RecipeBook recipeBook;

    //Sample recipe to use in testing
    private Recipe recipeTest;

    @Before
	public void setUp() throws RecipeException {
		inventoryItem = new Inventory();

        //likely don't need for this test case, but including just in case
        coffeeMaker = new CoffeeMaker();
		recipeBook = new RecipeBook();
        recipeTest = new Recipe(); 
    }

    ////------- Test to see if sugar is added to the inventory-------////
    @Test //Test if program will let me subtract sugar when I should be adding
	public void testAddNegativeSugarToInventory() {
        try {
            //int sugarAmount = 1;
            //inventoryItem.setSugar(sugarAmount);
            inventoryItem.setSugar(15);
            int sugarAmount = inventoryItem.getSugar();
            int randomNum = -1;
            inventoryItem.addSugar(randomNum + "");
            assertEquals(sugarAmount + randomNum, inventoryItem.getSugar());
		    //assertEquals(1, inventoryItem.getSugar());
        } catch (InventoryException e) {
            fail("Failed with positive integer as input");
        }
	}
    
    @Test //This test will fail
	public void testAddPositiveSugarToInventory() {
        try {
            inventoryItem.setSugar(5);
            int sugarAmount = inventoryItem.getSugar();
            int randomNum = 2;
            inventoryItem.addSugar(randomNum + "");
            assertEquals(sugarAmount + randomNum, inventoryItem.getSugar());
		    //assertEquals(1, inventoryItem.getSugar());
        } catch (InventoryException e) {
            fail("Failed with positive integer as input");
        }
	}


}
