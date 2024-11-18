package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType type;
    private String name;
    private float price;

    @Before
    public void init(){
        ingredient = new Ingredient(type, name, price );
    }

    @Parameterized.Parameters
    public static Object [][] getDate(){
        return new Object[][]{
                {IngredientType.FILLING, "Помидор", 12},
                {IngredientType.SAUCE, "Сырный", 10}
        };
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getName() {
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getType() {
        Assert.assertEquals(type, ingredient.getType());
    }
}