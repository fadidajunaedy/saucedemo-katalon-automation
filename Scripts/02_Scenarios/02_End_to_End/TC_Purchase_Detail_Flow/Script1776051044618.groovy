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

WebUI.callTestCase(findTestCase('Common/TC_Login'), [('var_action_username') : 'standard_user', ('var_action_password') : 'secret_sauce'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Component_Navbar/text_cart_badge'), 0)

WebUI.callTestCase(findTestCase('Common/TC_Add_To_Cart_Via_Detail'), [('target') : 'Sauce Labs Backpack'], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Component_Navbar/text_cart_badge'), 0)

WebUI.verifyElementText(findTestObject('Component_Navbar/text_cart_badge'), '1')

WebUI.click(findTestObject('Component_Navbar/button_cart'))

def cartPageUrl = WebUI.getUrl()

WebUI.verifyMatch(cartPageUrl, 'https://www.saucedemo.com/cart.html', false)

WebUI.verifyElementClickable(findTestObject('Page_Cart/button_checkout'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Cart/button_checkout'))

def checkoutStepOnePage = WebUI.getUrl()

WebUI.verifyMatch(checkoutStepOnePage, 'https://www.saucedemo.com/checkout-step-one.html', false)

WebUI.callTestCase(findTestCase('Common/TC_Fill_Checkout_Form'), [('firstname') : 'Fadida', ('lastname') : 'Junaedy', ('postal_code') : '24032002'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/TC_Price_Total_Validation'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Checkout_Step_Two/button_finish'))

String checkoutCompleteUrl = WebUI.getUrl()

WebUI.verifyMatch(checkoutCompleteUrl, 'https://www.saucedemo.com/checkout-complete.html', false)

WebUI.verifyElementPresent(findTestObject('Page_Checkout_Complete/text_complete_header'), 0)

WebUI.verifyElementText(findTestObject('Page_Checkout_Complete/text_complete_header'), 'Thank you for your order!')

