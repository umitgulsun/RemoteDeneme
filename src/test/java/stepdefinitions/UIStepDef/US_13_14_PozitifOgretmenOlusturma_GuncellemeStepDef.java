package stepdefinitions.UIStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.SchoolTeacherAddPageRemote;
import utilities.ConfigReader;
import utilities.grid.MyRemoteDriver;

import java.util.ArrayList;
import java.util.List;

public class US_13_14_PozitifOgretmenOlusturma_GuncellemeStepDef {

    SchoolTeacherAddPageRemote schoolTeacherAddPage;
    Actions actions;

    @Given("Setup Driver {string} {string}")
    public void setupDriver(String arg0, String arg1) {
        MyRemoteDriver.getRemoteDriverSetup(arg0, MyRemoteDriver.getOptions(arg1));
        schoolTeacherAddPage = new SchoolTeacherAddPageRemote(MyRemoteDriver.getRemoteDriver());
        actions = new Actions(MyRemoteDriver.getRemoteDriver());
    }

    @Given("Kullanici menu butonuna tiklar")
    public void kullaniciMenuButonunaTiklar() throws InterruptedException {
        schoolTeacherAddPage.menu.click();
        Thread.sleep(3000);
    }

    @Given("Kullanici ogretmen alanina tiklar")
    public void kullanici_ogretmen_alanina_tiklar() throws InterruptedException {
        schoolTeacherAddPage.teacherManagementLink.click();
        Thread.sleep(2000);
    }


    @Given("dersler alanina ders bilgilerini fake girer")
    public void derslerAlaninaDersBilgileriniFakeGirer() throws InterruptedException {
        actions.sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).build().perform();
        Thread.sleep(1000);

        schoolTeacherAddPage.ogretmenDersSecme.click();
        Thread.sleep(3000);
        schoolTeacherAddPage.ogretmenDersSecme.sendKeys("JAVA", Keys.ENTER);
    }


    @Given("username alanina username bilgileri girer")
    public void usernameAlaninaUsernameBilgileriGirer() {
        schoolTeacherAddPage.ogretmenUserName.sendKeys(ConfigReader.getProperty("usernames"));
    }


    @Then("submit tusuna tiklar")
    public void submitTusunaTiklar() throws InterruptedException {
        schoolTeacherAddPage.ogretmenSubmitButton.click();
        Thread.sleep(5000);
    }


    @Given("{string} alanina gecerli bir email girer")
    public void alaninaGecerliBirEmailGirer(String arg0) {
        schoolTeacherAddPage.ogretmenEmail.sendKeys(ConfigReader.getProperty("email"));

    }

    @Given("Kullanici anasayfaya gider")
    public void kullaniciAnasayfayaGider() {
        MyRemoteDriver.getRemoteDriver().get(ConfigReader.getProperty("schoolUrl"));
    }

    @Given("Kullanici Anasayfada logine tiklar")
    public void kullaniciAnasayfadaLogineTiklar() {

        try {
            schoolTeacherAddPage.menu.click();
            schoolTeacherAddPage.logout.click();
            schoolTeacherAddPage.logoutYesButton.click();
        } catch (Exception e) {

        }
        schoolTeacherAddPage.LoginAnasayfaLinki.click();

    }

    @Given("{string} ve {string} girer")
    public void veGirer(String arg0, String arg1) throws InterruptedException {
        schoolTeacherAddPage.username.sendKeys(ConfigReader.getProperty(arg0));
        schoolTeacherAddPage.password.sendKeys(ConfigReader.getProperty(arg1));
    }

    @Given("login tusuna tiklar")
    public void loginTusunaTiklar() {
        schoolTeacherAddPage.LoginButton.click();
    }

    public static List<String> ssnListesi = new ArrayList<>();


    @Given("{string} ve \"<ders>\"alanina ders bilgileri girer")
    public void ve_ders_alanina_ders_bilgileri_girer(String string) throws InterruptedException {
        actions.sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).
                sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.UP).build().perform();
        Thread.sleep(3000);
        schoolTeacherAddPage.ogretmenDersSecme.sendKeys(string, Keys.ENTER);
        Thread.sleep(1000);
    }

    @Given("{string} alanina bilgileri girer")
    public void alaninaBilgileriGirer(String arg0) throws InterruptedException {

        schoolTeacherAddPage.ogretmenName.sendKeys(arg0);
    }

    @Given("{string} alanina surname bilgileri girer")
    public void alaninaSurnameBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenSurName.sendKeys(arg0);
    }

    @Given("{string} alanina birthplace bilgileri girer")
    public void alaninaBirthplaceBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenBirthPlace.sendKeys(arg0);
    }

    @Given("{string} alanina email bilgileri girer")
    public void alanina_email_bilgileri_girer(String string) {
        schoolTeacherAddPage.ogretmenEmail.sendKeys(string);
    }

    @Given("{string} alanina gender bilgileri girer")
    public void alaninaGenderBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenGender.click();
    }

    @Given("{string} alanina birthday bilgileri girer")
    public void alaninaBirthdayBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenBirthDay.sendKeys(arg0);
    }

    @Given("{string} alanina uc-uc-dort rakam seklinde bilgileri girer")
    public void alaninaUcUcDortRakamSeklindeBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenPhoneNumber.sendKeys(arg0);
    }

    @Given("{string} alanina uc-iki-dort rakam seklinde bilgileri girer")
    public void alaninaUcIkiDortRakamSeklindeBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenSsn.sendKeys(arg0);
        ssnListesi.add(arg0);
    }

    @Given("{string} alanina danisman bilgileri girer")
    public void alanina_danisman_bilgileri_girer(String string) {
        schoolTeacherAddPage.ogretmenDanisman.click();
    }

    @Given("{string} alanina username bilgileri girer")
    public void alaninaUsernameBilgileriGirer(String arg0) {
        schoolTeacherAddPage.ogretmenUserName.sendKeys(arg0);
    }

    @Given("{string} alanina password bilgileri girer")
    public void alaninaPasswordBilgileriGirer(String arg0) throws InterruptedException {
        schoolTeacherAddPage.ogretmenPassword.sendKeys(arg0);
        Thread.sleep(2000);
    }

    public List<String> olumsuzListe = new ArrayList<>();


    @Given("close remoteDriver")
    public void closeRemoteDriver() {
        MyRemoteDriver.getRemoteDriver().quit();
    }

}
