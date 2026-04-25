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

WebUI.callTestCase(findTestCase('Common/TC_Cart_AddDirect'), [('target') : targetProduct1], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/TC_Cart_AddDirect'), [('target') : targetProduct2], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/TC_Cart_RemoveDirect'), [('target') : targetProduct1], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Page_Inventory/button_add_to_cart', [('productName') : targetProduct1]), 5)

WebUI.callTestCase(findTestCase('Common/TC_Util_ResetAppState'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Component_Navbar/text_cart_badge'), 5)

WebUI.verifyElementPresent(findTestObject('Page_Inventory/button_add_to_cart', [('productName') : targetProduct2]), 5)

