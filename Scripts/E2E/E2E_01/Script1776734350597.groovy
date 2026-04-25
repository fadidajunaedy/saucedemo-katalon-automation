import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Common/TC_Auth_Login'), [('var_username') : 'standard_user', ('var_password') : 'secret_sauce'
        , ('var_expected_status') : 'success', ('var_expected_message') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/TC_Cart_AddDirect'), [('target') : 'Sauce Labs Backpack'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Component_Navbar/button_cart'))

WebUI.click(findTestObject('Component_Navbar/button_cart'))

String cartURL = WebUI.getUrl()

WebUI.verifyMatch(cartURL, 'https://www.saucedemo.com/cart.html', false)

WebUI.callTestCase(findTestCase('Common/TC_Checkout'), [:], FailureHandling.STOP_ON_FAILURE)

