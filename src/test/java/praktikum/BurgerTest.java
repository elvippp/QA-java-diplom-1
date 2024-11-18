package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Ingredient mockIngredient;
    @Mock
    private Bun mockBun;

    private float bunPrice;
    private float expectedBurgerPrice;
    private float ingredientPrice;
    private String bunName;
    private String ingredientName;
    private IngredientType ingredientType;
    private String expectedReceipt;



    public BurgerTest(float bunPrice, float ingredientPrice, float expectedBurgerPrice,
                      String bunName, String ingredientName, IngredientType ingredientType,
                      String expectedReceipt) {
        this.bunPrice = bunPrice;
        this.expectedBurgerPrice = expectedBurgerPrice;
        this.ingredientPrice = ingredientPrice;
        this.bunName = bunName;
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
        this.expectedReceipt = expectedReceipt;
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);
        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockIngredient.getPrice()).thenReturn(ingredientPrice);
        when(mockBun.getName()).thenReturn(bunName);
        when(mockIngredient.getName()).thenReturn(ingredientName);
        when(mockIngredient.getType()).thenReturn(ingredientType);

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 2.0f, 3.0f, 7.0f, "Brioche", "Tomato", IngredientType.FILLING,
                        "(==== Brioche ====)" + System.lineSeparator() +
                                "= filling Tomato =" + System.lineSeparator() +
                                "(==== Brioche ====)" + System.lineSeparator() + System.lineSeparator() +
                                "Price: 7,000000" + System.lineSeparator() },
                { 1.5f, 2.5f, 5.5f, "RiceBun", "Cucumber", IngredientType.FILLING,
                        "(==== RiceBun ====)" + System.lineSeparator() +
                                "= filling Cucumber =" + System.lineSeparator() +
                                "(==== RiceBun ====)" + System.lineSeparator() + System.lineSeparator() +
                                "Price: 5,500000" + System.lineSeparator() },
                { 3.0f, 1.0f, 7.0f, "WholeGrain", "Bacon", IngredientType.FILLING,
                        "(==== WholeGrain ====)" + System.lineSeparator() +
                                "= filling Bacon =" + System.lineSeparator() +
                                "(==== WholeGrain ====)" + System.lineSeparator() + System.lineSeparator() +
                                "Price: 7,000000" + System.lineSeparator() }
        });
    }


    @Test
    public void addIngredient() {
        Ingredient newIngredient = mock(Ingredient.class);
        burger.addIngredient(newIngredient);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.removeIngredient(0);
        assertEquals(0,burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        Ingredient anotherIngredient = mock(Ingredient.class);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(1, 0);
        assertEquals(anotherIngredient, burger.ingredients.get(0));
        assertEquals(mockIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getPrice() {
        assertEquals(expectedBurgerPrice, burger.getPrice(), 0.01f);
    }

    @Test
    public void getReceipt() {
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}