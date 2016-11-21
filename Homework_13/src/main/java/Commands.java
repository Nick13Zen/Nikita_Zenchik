
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Class with commands to execute
 *
 */
public class Commands {
    private int failedTests = 0;
    private  int passedTests =0;
    private double allCommandsTime = 0;
    public WebDriver driver = new ChromeDriver();


    /**
     * Method opens url address
     *
     * @param url  String url address
     * @param time Long time to load page
     * @return String line to put in log file
     */
    public String openUrl(String url, String time) {
        String result = " ";
        long startTime = System.currentTimeMillis();
        driver.get(url);
        long endTime = System.currentTimeMillis();
        double executeTime = SECONDS.toSeconds(endTime - startTime)* Math.pow(10,(-3));
        if (!driver.getTitle().equals("") && (executeTime < Long.parseLong(time))) {
            result = "+";
            passedTests++;
        } else {
            result = "!";
            failedTests++;
        }
        String duration = Double.toString(executeTime);
        allCommandsTime += executeTime;
        System.out.println(result + " [open \"" + url + "\" \"" + time + "\"] " + duration);
        return result + " [open \"" + url + "\" \"" + time + "\"] " + duration;
    }

    /**
     * Method to check link present by href
     *
     * @return String line to put in log file
     */
    public String checkLinkPresentByHref(String href) {
        String result = "+";
        long startTime = System.currentTimeMillis();
        try {
            driver.findElement(By.xpath("//a[@href=\"" + href + "\"]"));
        } catch (NoSuchElementException e) {
            long endTime = System.currentTimeMillis();
            double executeTime = SECONDS.toSeconds(endTime - startTime)*Math.pow(10,(-3));
            String duration = Double.toString(executeTime);
            allCommandsTime += executeTime;
            result = "!";
            failedTests++;
            System.out.println( result + " [checkLinkPresentByHref \"" + href + "\"] " + duration);
            return result + " [checkLinkPresentByHref \"" + href + "\"] " + duration;
        }
        passedTests++;
        long endTime = System.currentTimeMillis();
        double executeTime = SECONDS.toSeconds(endTime - startTime)*Math.pow(10,(-3));
        String duration = Double.toString(executeTime);
        allCommandsTime += executeTime;
        System.out.println( result + " [checkLinkPresentByHref \"" + href + "\"] " + duration);
        return result + " [checkLinkPresentByHref \"" + href + "\"] " + duration;
    }

    /**
     * Method to check if page title is similar to given
     *
     * @param title String line with expected page title
     * @return String line to put in log file
     */
    public String checkPageTitle(String title) {
        String result = "";
        long startTime = System.currentTimeMillis();
        String currentTitle = driver.getTitle();
        long endTime = System.currentTimeMillis();
        double executeTime = SECONDS.toSeconds(endTime - startTime)* Math.pow(10,(-3));
        if (currentTitle.equals(title)) {
            result = "+";
            passedTests++;
        } else {
            result = "!";
            failedTests++;
        }
        String duration = Double.toString(executeTime);
        allCommandsTime += executeTime;
        String outputLine = result + " [checkPageTitle \"" + title + "\"] " + duration;
        System.out.println(outputLine);
        return outputLine;
    }

    /**
     * Method to check link by name
     *
     * @param name String name of link
     * @return String line to put in log file
     */
    public String checkLinkPresentByName(String name) {
        String result = "+";
        long startTime = System.currentTimeMillis();
        try {
            driver.findElement(By.xpath("//a[text()=\"" + name + "\"]"));
        } catch (NoSuchElementException e) {
            long endTime = System.currentTimeMillis();
            double executeTime = SECONDS.toSeconds(endTime - startTime)*Math.pow(10,(-3));
            String duration = Double.toString(executeTime);
            allCommandsTime += executeTime;
            result = "!";
            failedTests++;
            System.out.println(result + " [checkLinkPresentByName \"" + name + "\"] " + duration);
            return result + " [checkLinkPresentByName \"" + name + "\"] " + duration;
        }
        passedTests++;
        long endTime = System.currentTimeMillis();
        double executeTime = SECONDS.toSeconds(endTime - startTime)*Math.pow(10,(-3));
        String duration = Double.toString(executeTime);
        allCommandsTime += executeTime;
        System.out.println(result + " [checkLinkPresentByName \"" + name + "\"] " + duration);
        return result + " [checkLinkPresentByName \"" + name + "\"] " + duration;
    }

    /**
     * Mehod to check if page contains text
     * @param text String text to check
     * @return String line to put in log file
     */
    public String checkPageContains(String text) {
        String result = "";
        long startTime = System.currentTimeMillis();
        String currentText = driver.getPageSource();
        long endTime = System.currentTimeMillis();
        double executeTime = SECONDS.toSeconds(endTime - startTime)*Math.pow(10,(-3));
        if (currentText.contains(text)) {
            result = "+";
            passedTests++;
        } else {
            result = "!";
            failedTests++;
        }
        String duration = Double.toString(executeTime);
        allCommandsTime += executeTime;
        String outputLine = result + " [checkPageContains \"" + text + "\"] " + duration;
        System.out.println(outputLine);
        return outputLine;
    }


    /**
     * Getter for field failedTests
     * @return failedTests int count of failedTests
     */
    public int getFailedTests(){
        return failedTests;
    }
    /**
     * Getter for field time
     * @return time double value of total time
     */
    public double getTime(){
        return allCommandsTime;
    }
    public int getPassedTests(){
        return passedTests;
    }
}
