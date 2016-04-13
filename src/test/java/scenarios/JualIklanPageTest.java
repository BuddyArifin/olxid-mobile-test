package scenarios;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.JualIklanPage;
import pages.KategoriPage;
import pages.LocationPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

@Features("Jual Iklan Features")
public class JualIklanPageTest extends AndroidSetup{
    private JualIklanPage jualIklan;
    private String titleIklan="BMW 325i Silver 2013 Tiptronic";
    private String descIklan="BMW 325i warna silver tahun 2013. Tiptronic. Kondisi Mulus. Tanpa PR. Bensin selalu Shell";
    private String namaPengiklan="Frengky Sheeran";
    private String categoryL1="Mobil";
    private String categoryL2="Mobil Bekas";
    private String categoryL3="BMW";
    private String locationL1="Jawa Barat";
    private String locationL2="Bandung Kota";
	private String emailIklan="frengky.sheeran@gmail.com";
    private String telpIklan="081122334455";
    private String hargaProduct="325000000";
    private String transmisi="Triptonic";
    private String emailIklanNotRegistered="frengky.orlend@gmail.com";
    
	@BeforeClass
	public void setUp() throws Exception{
		prepareAndroidForAppium();
        System.out.println("Jual Iklan Page Running on ...");
	}
	
	@AfterClass
	 public void tearDown() throws Exception {
	    	System.out.println("Jual Iklan Page Page Quit");
	        driver.quit();
	 }
	
	@AfterMethod
    public void onTestFailure(ITestResult testResult) throws IOException {
      if(testResult.getStatus() == ITestResult.FAILURE){
          System.out.println(testResult.getStatus());
          BasePage bp =  new BasePage(driver);
          try {
             bp.getAttachment("Failed on "+testResult+" .jpg");
          }catch(Exception e){
        	 System.out.println("-->Failed to Execute ScreenShot"); 
          }
      }
	}
	
	@Test(priority=1)
	 @Stories("As A User I Wont Be Able to Sell Product")
	 @TestCaseId("TC_ADR_006_001")
	 @Title("Verify User Not Able to Post An Ads If All Field Blank")
	 public void verifyUserNotAbleToPostAnAdsIfAllFieldBlank() throws Exception{
		HomePage homepage = new HomePage(driver);
		jualIklan = homepage.clickJualIklan();
		jualIklan.checkKembaliKePasangIklan();
        jualIklan.setElementJualIklan();
        driver.scrollTo("Nama");
        jualIklan.clickPasangIklanButton();
        jualIklan.verifyAllErrorNotification();
	 }
	 
	 @Test(priority=2)
	 @Stories("As A User I Wont Be Able to Sell Product")
	 @TestCaseId("TC_ADR_006_002")
	 @Title("Verify User Not Able to Post An Ads If Title Length Less Than 15, Description Less than 20, Email wrong Format, Phone Wrong Format")
	 public void verifyUserNotAbleToPostAnAdsIfElementsNotMeetCriteria() throws Exception{
	    jualIklan.setElementJualIklan();
       // jualIklan.clickImageButonIklan();// for capture image from camera, sometimes cant connect 
       // jualIklan.chooseGaleryImage();
       // jualIklan.captureImageFromCamera();
        jualIklan.setElementJualIklan();
        KategoriPage kategori = jualIklan.clickCategoryMobil();
        kategori.clickCategory(categoryL1);
        kategori.clickCategory(categoryL2);
        kategori.clickCategory(categoryL3);
        jualIklan.setTitleJualIklan(titleIklan.substring(0,14));//Iklan Title Less Than 15
        jualIklan.setDescription(descIklan.substring(0,19));//Iklan deskripsi Less Than 20
        jualIklan.setElementJualIklanKedua();
        jualIklan.clickHargaChooserButton();
        jualIklan.fillHargaProduct(hargaProduct);
        jualIklan.selesaiSetHargaProduct();
        jualIklan.clickTipeKendaraanButton();
        jualIklan.setTipeKendaraan();
        //Page automatically scroll on Tipe Kendaraan Position
        jualIklan.setElementJualIklanKetiga();
        jualIklan.clickTransmisi();
        jualIklan.chooseTransmisi(transmisi);
        jualIklan.clickTahunPembuatan();
        jualIklan.setTahunPembuatan();//latest tahun pembuatan
        LocationPage location = jualIklan.clickLocation();
        location.clickLocation(locationL1);
        location.clickLocation(locationL2);
        driver.scrollTo("Telepon");
        jualIklan.setNama(namaPengiklan);
        jualIklan.setElementTelpPengiklan();
        jualIklan.setEmail(emailIklan.replace("@gmail.com", ""));//wrong email format
        jualIklan.setTelp(telpIklan);
        driver.scrollTo("Pasang iklan");
        jualIklan.clickPasangIklanButton();
        driver.scrollTo("Ambil foto");
        jualIklan.verifyErrorOnTitle();
        jualIklan.verifyErrorOnDesc();
	 }
	 	
	 @Test(priority=3)
	 @Stories("As A User I Want to Be Able to Sell Product")
	 @TestCaseId("TC_ADR_006_003")
	 @Title("As A User I Want to Be Able to Sell Product - Email not Registered Before")
	 public void verifyUserAbleToPostAnAds() throws Exception{
	    jualIklan.setElementJualIklan();
	    KategoriPage kategori = jualIklan.clickCategoryMobil();
	    kategori.clickCategory(categoryL1);
	    kategori.clickCategory(categoryL2);
	    kategori.clickCategory(categoryL3);
	    jualIklan.setTitleJualIklan(titleIklan);
	    jualIklan.setDescription(descIklan);
	    jualIklan.setElementJualIklanKedua();
	    jualIklan.clickHargaChooserButton();
	    jualIklan.fillHargaProduct(hargaProduct);
	    jualIklan.selesaiSetHargaProduct();
	    jualIklan.clickTipeKendaraanButton();
	    jualIklan.setTipeKendaraan();
	        //Page automatically scroll on Tipe Kendaraan Position
	    jualIklan.setElementJualIklanKetiga();
	    jualIklan.clickTransmisi();
	    jualIklan.chooseTransmisi(transmisi);
	    jualIklan.clickTahunPembuatan();
	    jualIklan.setTahunPembuatan();//latest tahun pembuatan
	    LocationPage location = jualIklan.clickLocation();
	    location.clickLocation(locationL1);
	    location.clickLocation(locationL2);
	    driver.scrollTo("Telepon");
	    jualIklan.setNama(namaPengiklan);
	    jualIklan.setElementTelpPengiklan();
	    jualIklan.setEmail(emailIklanNotRegistered);//wrong email format
	    jualIklan.setTelp(telpIklan);
	    driver.scrollTo("Pasang iklan");
	    jualIklan.clickPasangIklanButton();
	 }
}
