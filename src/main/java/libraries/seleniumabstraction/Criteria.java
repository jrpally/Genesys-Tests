package libraries.seleniumabstraction;

import org.openqa.selenium.By;

public class Criteria {
    private By xpath;

    public Criteria(By xpath) {

        this.xpath = xpath;
    }

    public static Criteria byXpath(String xpath) {
        if (xpath == null) {
            throw new IllegalArgumentException("xpath cannot be null");
        }
        return new Criteria(By.xpath(xpath));
    }

    public static Criteria byId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("xpath cannot be null");
        }
        return new Criteria(By.id(id));
    }

    public String toString() {
        return getBy().toString();
    }

    public By getBy() {
        return this.xpath;
    }
}
