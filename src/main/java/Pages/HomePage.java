package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class HomePage extends BasePage {
    String searchtxt="ceket";
    String URL="https://www.network.com.tr/search?searchKey=ceket&page=2";
    By CoociesAccept= new By.ByXPath("//button[@id='onetrust-accept-btn-handler']");
    By NetworkPageUrl=new By.ByXPath("//a[@class='header__logo']//*[name()='svg']");
    By Search=new By.ByXPath("//input[@id='search']");
    By SearchIcon=new By.ByXPath("//button[normalize-space()='Tümünü Gör']");
    By ScrollPageDown=new By.ByXPath("//button[normalize-space()='Daha fazla göster']");
    By PageDown=new By.ByXPath("//button[normalize-space()='Daha fazla göster']");
    By SelectByJacket=new By.ByXPath("//div[@class='product js-product-133233 gtm-added']//label[@for='size_L'][normalize-space()='L']");
    By GoToBasketButton=new By.ByXPath("//a[normalize-space()='Sepete Git']");
    //By SelectJacketName=new By.ByXPath("div[class='product js-product-133233 gtm-added'] h3[class='product__title']");
    By BasketProductName=new By.ByCssSelector(".cartItem__title");
    By ScrollPage=new By.ByXPath("//div[@class='product js-product-140001 gtm-added']//button[@type='button']//*[name()='svg']");
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void NetworkPageFunction() {
        waitForSecond(2);
        click(CoociesAccept);
        waitForSecond(1);
        Boolean NetworkPageUrlControll = isDisplay(NetworkPageUrl);
        Assert.assertTrue(NetworkPageUrlControll);
        if (NetworkPageUrlControll == true) {
            System.out.println("Network Page Open");
        }
        waitForSecond(1);
        click(Search);
        send(Search, searchtxt);
        waitForSecond(2);
        click(SearchIcon);

        scrollPageElement(drivers().findElement(ScrollPageDown));
        waitForSecond(3);
        click(PageDown);
        waitForSecond(2);

        if (drivers().getCurrentUrl()==URL) {
            System.out.println("Moved to page 2");
        }

        waitForSecond(1);
        scrollPageElement(drivers().findElement(ScrollPage));
        waitForSecond(1);
        click(SelectByJacket);
        waitForSecond(2);
        String JacketControll = find(By.xpath("div[class='product js-product-133233 gtm-added'] h3[class='product__title']")).getText();
        waitForSecond(2);
        click(GoToBasketButton);
        waitForSecond(2);

        String JacketBasketControll = find(By.cssSelector(".cartItem__title"))
                .getText();
        Assert.assertEquals(JacketBasketControll,JacketControll);
        waitForSecond(2);



    }

}
