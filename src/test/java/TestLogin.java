import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.comita.sedsf.entity.Contractor;
import ru.comita.sedsf.tests.page.ContractorPage;
import ru.comita.sedsf.tests.page.LoginPage;
import ru.comita.sedsf.utils.SettingsClass;
import ru.comita.sedsf.utils.DataJsonParser;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class TestLogin {
    private String jsonFile = "src\\main\\resources\\data.json";
    private String ukkShop = "http://ukk-eshop.comita.lan:8080/ccwe";
    private Contractor contractor = new Contractor();
    private LoginPage lp = new LoginPage();
    private ContractorPage cp = new ContractorPage();


    @BeforeTest
    public void setUp() throws FileNotFoundException {
        SettingsClass bc = SettingsClass.getConfig();
        contractor = DataJsonParser.parseJsonToEntity(jsonFile, contractor);
        open(ukkShop);
    }

    @Test
    public void testSome() {


        lp.fillAllPage(contractor.getContractorLogin(), contractor.getContractorPassword());
        cp.checkCompanySuccessLogin();

    }
    @AfterTest
    public void finishTest() {
        close();
    }
}
