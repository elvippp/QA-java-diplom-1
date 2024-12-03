package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private String typeName;
    private IngredientType expectedType;

    public  IngredientTypeTest(IngredientType expectedType, String typeName){
        this.expectedType = expectedType;
        this.typeName = typeName;
    }

    @Parameterized.Parameters
    public static Object [][] getDate(){
        return new Object[][]{
                {IngredientType.FILLING, "FILLING"},
                {IngredientType.SAUCE, "SAUCE"}
        };
    }

    @Test
    public void testIngredientTypeValueOf() {
        Assert.assertEquals(expectedType, IngredientType.valueOf(typeName));
    }
}
