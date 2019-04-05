package suites;

import NPMTest.AddNewCampaign;
import login.LoginWithDataFromExcel;
import login.LoginWithPageObject;
import login.LoginWithParams;
import login.UnvalidLoginWithDataFromExcel;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginWithDataFromExcel.class,
        UnvalidLoginWithDataFromExcel.class,
//        LoginWithPageObject.class,
//        LoginWithParams.class,
        AddNewCampaign.class
})

public class SmokeSuite {

}
