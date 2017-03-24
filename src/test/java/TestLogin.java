import com.codeborne.selenide.Screenshots;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.comita.esshop.entity.ContractorEntity;
import ru.comita.esshop.tests.page.ContractorPage;
import ru.comita.esshop.tests.page.LoginPage;
import ru.comita.esshop.utils.SettingsClass;
import ru.comita.esshop.utils.TestUtils;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;

@Title("TestSuite")
public class TestLogin {
    private LoginPage loginPage;
    private ContractorPage contractorPage;
    private SettingsClass settingsClass;
    private ContractorEntity contractorEntity;

    @BeforeTest
    public void clearScreenshotList(){
        Screenshots.screenshots.getScreenshots().clear();
    }

    @BeforeTest
    public void setUp() throws FileNotFoundException {
        System.setProperty("selenide.browser", "chrome");
        System.setProperty("webdriver.chrome.driver", SettingsClass.class.getClassLoader().getResource("chromedriver.exe").getPath());
        settingsClass = SettingsClass.getConfig();
        loginPage = open(LoginPage.PAGE_URL, LoginPage.class);
    }

    @Title("Login test")
    @Test
    @Step("Проверка страницы, авторизации и выхода")
    public void testSome() throws Exception {
        contractorEntity = new ContractorEntity();
        contractorEntity = TestUtils.parseJsonToEntity("data.json", contractorEntity);
        loginPage.fillAllPage(contractorEntity.getContractorLogin(), contractorEntity.getContractorPassword());

        contractorPage.checkCompanySuccessLogin()
                .logout();
    }


}
