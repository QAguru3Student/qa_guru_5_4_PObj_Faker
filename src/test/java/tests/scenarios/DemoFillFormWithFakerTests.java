package tests.scenarios;

import org.junit.jupiter.api.Test;
import tests.pages.DemoFillFormWithFakerPage;

public class DemoFillFormWithFakerTests {

    DemoFillFormWithFakerPage demoFillFormWithFakerPage = new DemoFillFormWithFakerPage();
    @Test
    void successfulFillFormTest(){
        demoFillFormWithFakerPage.openPage();
        demoFillFormWithFakerPage.fillForm();
        demoFillFormWithFakerPage.checkForm();

    }
}