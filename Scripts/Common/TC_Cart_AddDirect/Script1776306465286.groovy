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

def textCartBadge = findTestObject('Component_Navbar/text_cart_badge')
def buttonAddToCart = findTestObject('Page_Inventory/button_add_to_cart', [('productName') : target])

int countQuantityBefore = 0
if (WebUI.verifyElementPresent(textCartBadge, 5, FailureHandling.OPTIONAL)) {
    String textBefore = WebUI.getText(textCartBadge)
    countQuantityBefore = Integer.parseInt(textBefore)
}

WebUI.waitForElementClickable(buttonAddToCart, 5)
WebUI.click(buttonAddToCart)

WebUI.verifyElementPresent(textCartBadge, 5)

String rawCountQuantityAfter = WebUI.getText(textCartBadge)
int countQuantityAfter = Integer.parseInt(rawCountQuantityAfter)
WebUI.verifyEqual(countQuantityAfter, countQuantityBefore + 1)
WebUI.verifyElementText(findTestObject('Page_Inventory/button_remove_from_cart', [('productName') : target]), 
    'Remove')

