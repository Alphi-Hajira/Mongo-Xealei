package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;

	
//	BaseClass - Creation Methods:
//		=============================
//		#1) get()
//		#2) getCurrentUrl()
//		#3) findElement(By, by) and click()
//		#4) isEnabled()
//		#5) findElement(By, by) with sendKeys()
//		#6) findElement(By, by) with getText()
//		#7) Submit()
//		#8) findElements(By, by)
//		#9) findElements(By, by) with size()
//		#10) pageLoadTimeout(time,unit)
//		#11) implicitlyWait()
//		#12) untill() and visibilityOfElementLocated()
//		#13) untill() and alertIsPresent()
//		#14) getTitle()
//		#15) Select
//		#16) navigate()
//		#17) getScreenshotAs()
//		#18) moveToElement()
//		#19) dragAndDrop()
//		#20) switchTo() and accept(), dismiss() and sendKeys()
//		#21) getWindowHandle() and getWindowHandles()
//		#22) getConnection()
//		#23) POI
//		#24) assertEquals(),assertNotEquals(), assertTrue() and assertFalse()
//		#25) close() and quit()
//

		//1.get()
		public void loadUrl(String url){
		driver.get(url);
		}

		//2. getCurrentUrl()
		public String getCurrentUrl(){
		String currentUrl=driver.getCurrentUrl();
		return currentUrl;
		}

		//3. findElementById()
		public WebElement findElementById(String attributeValue){
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
		}
		
		//4. findElementByClassName()
		public WebElement findElementByClassName(String attributeValue){
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
		}

		//5. findElementByXpath()
		public WebElement findElementByXpath(String Xpath){
		WebElement element = driver.findElement(By.xpath( Xpath));
		return element;
		}

		//6. isEnabled()
		public boolean isEnabled(WebElement element){
		boolean isEnable = element.isEnabled();
		return  isEnable;
		}

		//7.getText()
		public String getText(WebElement element){
		String text=element.getText();
		return text;
		}

		//8.sendKeys()
		public void sendKeys(WebElement element,String data){
		element.sendKeys(data);
		}

		//9.Submit()
		public void submit(WebElement element){
		element.submit();
		}

		//10.clearText()
		public void clearText(WebElement element){
		element.clear();
		}

		//11.getAttribute()
		public String getAttributeValue(WebElement element,String attributeValue){
		String value=element.getAttribute(attributeValue);
		return value;
		}

		//12.maximize()
		public void maximize(){
		driver.manage().window().maximize();
		}

		//13.quite()
		public void quit(){
		driver.quit();
		}

		//14.close()
		public void close(){
		driver.close();
		}

		//15.implicitlyWaitBySeconds()
		public void implicitlyWaitBySeconds(long seconds){
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(seconds));
		}

		//16.implicitlyWaitByMilliSeconds()
		public void implicitlyWaitByMilliSeconds(long millis){
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(millis));
		}

		//17.browserType()
		public void browserType(String BrowserType){
		if(BrowserType.equalsIgnoreCase("Chrome")){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}else if (BrowserType.equalsIgnoreCase("Edge")){
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		}
		}

		//18.getTitle()
		public void getTitle(){
		driver.getTitle();
		}

		//19.navigateToForward()
		public void navigateToForward(){
		driver.navigate().forward();
		}

		//20.navigateToBackward()
		public void navigateToBackward(){
		driver.navigate().back();
		}

		//21.pageRefresh()
		public void refresh(){
		driver.navigate().refresh();
		}

		//22.navigateToUrl()
		public void navigateToUrl(String Url){
		driver.navigate().to(Url);
		}

		//23.explicitWaitForAlertIsPresent()
		public void alertIsPresent(long Seconds){
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Seconds));
		wait.until(ExpectedConditions.alertIsPresent());
		}

		//24.explicitWaitForElementToBeClickable()
		public void elementToBeClickable(WebElement element,long Seconds){
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}

		//25.elementToBeSelected()
		public void elementToBeSelected(WebElement element,long Seconds){
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Seconds));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		}

		//26.SwitchToAlert()
		public void switchToAlert(){
		driver.switchTo().alert();
		}

		//27.Accept alert()
		public void acceptAlert(){
		driver.switchTo().alert().accept();
		}

		//28.Dismiss alert()
		public void dismissAlert(){
		driver.switchTo().alert().dismiss();
		}

		//29.sendKeysForAlert()
		public void sendKeysForAlert(String data){
		driver.switchTo().alert().sendKeys(data);
		}

		//30.doubleClick()
		public void doubleClick(WebElement element){
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
		}

		//31.mouseOverAction()
		public void moveToElement(WebElement element){
		Actions action =new Actions(driver);
		action.moveToElement(element).perform();
		}

		//32.dragAndDrop()
		public void dragAndDrop(WebElement source,WebElement destination){
		Actions action = new Actions(driver);
		action.dragAndDrop(source,destination).perform();
		}

		//33.getWindowHandle()
		public String getWindowHandle(){
		String windowHandle =driver.getWindowHandle();
		return windowHandle;
		}

		//34.getWindowHandles()
		public Set<String> getWindowHandles(){
		Set<String> windowHandles =driver.getWindowHandles();
		return windowHandles;
		}

		//35.switchToWindowByStringName()
		public void switchToWindowByString(String name){
		driver.switchTo().window(name);
		}

		//36.switchToWindowById()
		public void switchToWindowById(String index){
		driver.switchTo().window(index);
		}

		//37.switchToFrameByIndex
		public void switchToFrameByIndex(int index){
		driver.switchTo().frame(index);
		}

		//38.switchToFrameByWebElement
		public void switchToFrameByIndex(WebElement element){
		driver.switchTo().frame(element);
		}

		//39.switchToFrameById
		public void switchToFrameByIndex(String id){
		driver.switchTo().frame(id);
		}

		//40.switchToParentFrame
		public void switchToParentFrame(){
		driver.switchTo().parentFrame();
		}

		//41.exitFrame
		public void exitFrame(){
		driver.switchTo().defaultContent();
		}

		//42.click()
		public void click(WebElement element){
		element.click();
		}

		//43.isDisplayed
		public boolean isDisplayed(WebElement element){
		boolean isDisplay=element.isDisplayed();
		return isDisplay;
		}

		//44.selectByIndex()
		public void selectByIndex(WebElement element,int index){
		Select select =new Select(element);
		select.selectByIndex(index);
		}

		//45.selectByValue()
		public void selectByValue(WebElement element,String value){
		Select select=new Select(element);
		select.selectByValue(value);
		}

		//46.selectByVisibleText()
		public void selectByVisibleText(WebElement element,String text){
		Select select=new Select(element);
		select.selectByVisibleText(text);
		}

		//47.getFirstSelectedOption()
		public WebElement getFirstSelectedOption(WebElement element){
		Select select=new Select(element);
		WebElement element1=select.getFirstSelectedOption();
		return element1;
		}

		//48.getAllOptions()
		public List<WebElement> getAllOptions(WebElement element){
		Select select =new Select(element);
		List<WebElement>allOptions=select.getOptions();
		return allOptions;
		}

		//49.getAllSelectedOptions()
		public List<WebElement> getAllSelectedOptions(WebElement element){
		Select select =new Select(element);
		List<WebElement>allSelectedOptions=select.getAllSelectedOptions();
		return allSelectedOptions;
		}

		//50.deSelectByIndex()
		public void deSelectByIndex(WebElement element,int index){
		Select select =new Select(element);
		select.deselectByIndex(index);
		}

		//51.deSelectByValue()
		public void deSelectByValue(WebElement element,String value){
		Select select=new Select(element);
		select.deselectByValue(value);
		}

		//52.deSelectByVisibleText()
		public void deSelectByVisibleText(WebElement element,String text){
		Select select=new Select(element);
		select.deselectByVisibleText(text);
		}

		//53.deSelectAll()
		public void deSelectAll(WebElement element){
		Select select=new Select(element);
		select.deselectAll();
		}

		//54.isMultiple()
		public boolean isMultiple(WebElement element){
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
		}

		//55.Thread.Sleep()
		public void thread(int millis) throws Exception{
		Thread.sleep(millis);
		}

		//56.Robot KeyPress()
		public void robotKeyPress(int keyCode) throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(keyCode);
		}


		//57.Robot KeyRelease
		public void robotKeyRelease(int keyCode) throws AWTException {
		Robot robot=new Robot();
		robot.keyRelease(keyCode);
		}

}
