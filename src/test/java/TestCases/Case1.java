package TestCases;
import Drivers.driver;
import Pages.HomePage;
import org.testng.annotations.Test;

public class Case1 extends driver {

    @Test
    public void Test() {
        HomePage test=new HomePage(driver);

        test.NetworkPageFunction();


    }

}
