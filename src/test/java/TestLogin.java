import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.comita.esshop.entity.ContractorEntity;
import ru.comita.esshop.tests.page.LoginPage;
import ru.comita.esshop.utils.SettingsClass;
import ru.comita.esshop.utils.TestUtils;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;

public class TestLogin {
    private LoginPage lp;
    private SettingsClass sc;
    private ContractorEntity contractorEntity;


    @BeforeTest
    public void setUp() throws FileNotFoundException {
        System.setProperty("selenide.browser", "chrome");
        System.setProperty("webdriver.chrome.driver", SettingsClass.class.getClassLoader().getResource("chromedriver.exe").getPath());
        sc = SettingsClass.getConfig();
        lp = open(LoginPage.PAGE_URL, LoginPage.class);
    }

    @Test
    public void testSome() throws Exception {
        contractorEntity = new ContractorEntity();
        contractorEntity = TestUtils.parseJsonToEntity("data.json", contractorEntity);
        lp.fillAllPage(contractorEntity.getContractorLogin(), contractorEntity.getContractorPassword())
                .checkCompanySuccessLogin()
                .logout();
    }
}
