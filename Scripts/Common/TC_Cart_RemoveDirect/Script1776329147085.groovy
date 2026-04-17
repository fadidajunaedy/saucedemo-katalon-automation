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

WebUI.callTestCase(findTestCase('Common/TC_Cart_AddDirect'), [('target') : 'Sauce Labs Backpack'], FailureHandling.STOP_ON_FAILURE)

def textCartBadge = findTestObject('Component_Navbar/text_cart_badge')
def buttonRemoveFromCart = findTestObject('Page_Inventory/button_remove_from_cart', [('productName') : 'Sauce Labs Backpack'])
def buttonAddToCart = findTestObject('Page_Inventory/button_add_to_cart', [('productName') : 'Sauce Labs Backpack'])

int countQuantityBefore = 0
if (WebUI.verifyElementPresent(textCartBadge, 3, FailureHandling.OPTIONAL)) {
    countQuantityBefore = Integer.parseInt(WebUI.getText(textCartBadge))
}

WebUI.waitForElementClickable(buttonRemoveFromCart, 5)
WebUI.click(buttonRemoveFromCart)

if (WebUI.verifyElementPresent(textCartBadge, 3, FailureHandling.OPTIONAL)) {
    int countQuantityAfter = Integer.parseInt(WebUI.getText(textCartBadge))
    WebUI.verifyEqual(countQuantityAfter, countQuantityBefore - 1)
} else {
    WebUI.verifyEqual(countQuantityBefore, 1)
    WebUI.verifyElementPresent(buttonAddToCart, 3)
}

WebUI.verifyElementText(buttonAddToCart, 'Add to cart')



