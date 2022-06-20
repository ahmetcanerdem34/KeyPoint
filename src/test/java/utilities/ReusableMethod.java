package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ReusableMethod {



    public static void sleep(int sayi){
        try {
            Thread.sleep(sayi);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
