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

def linkProduct = findTestObject('Page_Inventory/link_product_via_title', [('productName') : target])

def textCartBadge = findTestObject('Component_Navbar/text_cart_badge')

def buttonAddToCart = findTestObject('Page_Inventory_Item/button_add_to_cart')

def buttonRemoveFromCart = findTestObject('Page_Inventory_Item/button_remove_from_cart')

def buttonBackToProducts = findTestObject('Page_Inventory_Item/button_back_to_products')

int countQuantityBefore = 0

if (WebUI.verifyElementPresent(textCartBadge, 3, FailureHandling.OPTIONAL)) {
    countQuantityBefore = Integer.parseInt(WebUI.getText(textCartBadge))
}

WebUI.waitForElementClickable(linkProduct, 5)

WebUI.click(linkProduct)

WebUI.waitForElementPresent(buttonBackToProducts, 5)

String currentUrl = WebUI.getUrl()

WebUI.verifyMatch(currentUrl, '.*/inventory-item\\.html\\?id=.*', true, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(buttonAddToCart, 5)

WebUI.click(buttonAddToCart)

WebUI.verifyElementPresent(textCartBadge, 5)

int countQuantityAfter = Integer.parseInt(WebUI.getText(textCartBadge))

WebUI.verifyEqual(countQuantityAfter, countQuantityBefore + 1)

WebUI.verifyElementPresent(buttonRemoveFromCart, 3)

WebUI.verifyElementText(buttonRemoveFromCart, 'Remove')

println("Success: Berhasil menambahkan $target dari halaman detail.")

