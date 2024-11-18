package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


public class BunTest {
    private Bun bun;
    private String bunName;
    private float bunPrice;

    @Before
    public void init() {
        bun = new Bun(bunName, bunPrice);
    }

    @Parameterized.Parameters
    public static Object[][] getDate() {
        return new Object[][]{
                {"Бриошь", 25},
                {"Багет", 5}
        };
    }

    @Test
    public void getName() {
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(bunPrice, bun.getPrice(), 0);
    }
}