package org.itstep;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SongFinder {

    public ArrayList<Song> getSongsList() {

        ArrayList<Song> songList = new ArrayList();

        System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get("https://muzofond.com");

        WebElement songsUlList = driver.findElement(By.className("unstyled songs"));

        List<WebElement> songsLiElements = songsUlList.findElements(By.tagName("li"));

        int sizeList = (int) (15 + (Math.random() * (20 - 15)));

        if (songsLiElements.size() < sizeList) {

            sizeList = songsLiElements.size();
        }

        for (int i = 0; i < sizeList; i++) {

            Song song = new Song();

            WebElement description = songsLiElements.get(i).findElement(By.className("desc"));

            song.name = description.getText();

            song.filePath = "D:\\music\\" + song.name + ".mp3";
            
            songList.add(song);
            
        }
        

        return songList;

    }

}