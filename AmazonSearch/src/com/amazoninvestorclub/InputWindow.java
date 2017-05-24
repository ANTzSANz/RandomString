package com.amazoninvestorclub;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.stqa.selenium.factory.WebDriverFactory;


public class InputWindow extends JFrame {
	private JTextField itemAsin;
	private JTextField checkedItemLink;
	private JTextField keyWord;
	private JTextField groupField;
	private JTextField priceField;
	private JTextField fItemField;
	private JTextField searchPageField;
	private JTextField pageField;
	private JTextField positionField;
	private JCheckBox groupChBox;
	private JCheckBox priceChBox;
	WaitTimer timer = new WaitTimer();

	public InputWindow(String title) {
		super.setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(700, 500);
		getContentPane().setLayout(null);

		itemAsin = new JTextField();
		itemAsin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		itemAsin.setBounds(140, 11, 322, 30);
		getContentPane().add(itemAsin);
		itemAsin.setColumns(10);

		JButton checkAsinBtn = new JButton("Check item ASIN");
		checkAsinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkedItemLink.setText("Wait...");
				getContentPane().repaint();
				checkItemAsin();
			}

		});
		checkAsinBtn.setForeground(Color.RED);
		checkAsinBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkAsinBtn.setBounds(469, 11, 215, 30);
		getContentPane().add(checkAsinBtn);

		checkedItemLink = new JTextField();
		checkedItemLink.setEditable(false);
		checkedItemLink.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkedItemLink.setBounds(140, 52, 544, 30);
		getContentPane().add(checkedItemLink);
		checkedItemLink.setColumns(10);

		JLabel asinLbl = new JLabel("ASIN:");
		asinLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		asinLbl.setBounds(10, 11, 120, 30);
		getContentPane().add(asinLbl);

		JLabel itemLinkLbl = new JLabel("Item link:");
		itemLinkLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		itemLinkLbl.setBounds(10, 52, 120, 30);
		getContentPane().add(itemLinkLbl);

		keyWord = new JTextField();
		keyWord.setBounds(140, 119, 322, 30);
		getContentPane().add(keyWord);
		keyWord.setColumns(10);

		JLabel keyWordLbl = new JLabel("Key word:");
		keyWordLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		keyWordLbl.setBounds(10, 117, 120, 30);
		getContentPane().add(keyWordLbl);

		JLabel groupLbl = new JLabel("Group:");
		groupLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		groupLbl.setBounds(10, 160, 120, 30);
		getContentPane().add(groupLbl);

		JLabel priceLbl = new JLabel("Price:");
		priceLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		priceLbl.setBounds(10, 201, 120, 30);
		getContentPane().add(priceLbl);

		groupField = new JTextField();
		groupField.setColumns(10);
		groupField.setBounds(140, 160, 322, 30);
		getContentPane().add(groupField);

		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(140, 201, 322, 30);
		getContentPane().add(priceField);

		groupChBox = new JCheckBox("   search in group");
		groupChBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		groupChBox.setBounds(484, 166, 200, 23);
		getContentPane().add(groupChBox);

		priceChBox = new JCheckBox("   search by price");
		priceChBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(priceChBox.isSelected()){
					groupChBox.setSelected(true);
				} else{
					groupChBox.setSelected(false);
				}
			}
		});
		priceChBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		priceChBox.setBounds(484, 207, 200, 23);
		getContentPane().add(priceChBox);

		JLabel fItemLbl = new JLabel("Found item link:");
		fItemLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fItemLbl.setBounds(10, 309, 120, 30);
		getContentPane().add(fItemLbl);

		fItemField = new JTextField();
		fItemField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fItemField.setEditable(false);
		fItemField.setColumns(10);
		fItemField.setBounds(140, 309, 544, 30);
		getContentPane().add(fItemField);

		JLabel searcPageLbl = new JLabel("Search page link:");
		searcPageLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searcPageLbl.setBounds(10, 350, 120, 30);
		getContentPane().add(searcPageLbl);

		searchPageField = new JTextField();
		searchPageField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		searchPageField.setEditable(false);
		searchPageField.setColumns(10);
		searchPageField.setBounds(140, 350, 544, 30);
		getContentPane().add(searchPageField);

		JLabel pageLbl = new JLabel("Item page:");
		pageLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pageLbl.setBounds(10, 391, 120, 30);
		getContentPane().add(pageLbl);

		pageField = new JTextField();
		pageField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pageField.setEditable(false);
		pageField.setColumns(10);
		pageField.setBounds(140, 391, 544, 30);
		getContentPane().add(pageField);

		JLabel positionLbl = new JLabel("Item position:");
		positionLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		positionLbl.setBounds(10, 432, 120, 30);
		getContentPane().add(positionLbl);

		positionField = new JTextField();
		positionField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		positionField.setEditable(false);
		positionField.setColumns(10);
		positionField.setBounds(140, 432, 544, 30);
		getContentPane().add(positionField);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 101, 674, 8);
		getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 290, 674, 8);
		getContentPane().add(separator_1);

		JButton searchItem = new JButton("Search item");
		searchItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findItemByKey();
			}
		});
		searchItem.setForeground(Color.RED);
		searchItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchItem.setBounds(140, 242, 322, 30);
		getContentPane().add(searchItem);

		getContentPane().repaint();
	}

	private void findItemByKey() {
	
		if (keyWord.getText().isEmpty() || keyWord.getText().contains("Input key!")) {
			keyWord.setText("Input key!");
		} else {
			if (itemAsin.getText().isEmpty() || itemAsin.getText().contains("Input ASIN!")) {
				itemAsin.setText("Input ASIN!");
			} else {
				fItemField.setText("Wait...");
				getContentPane().repaint();

				boolean serchInGroup = groupChBox.isSelected();
				boolean serchByPrice = priceChBox.isSelected();

				if (groupField.getText() == null || groupField.getText().isEmpty()) {
					serchInGroup = false;
				}
				if (priceField.getText() == null || priceField.getText().isEmpty()) {
					serchByPrice = false;
				}

				timer.waitSeconds(1);
				ItemInfo itemInfo = findItemByFilters(serchInGroup, serchByPrice);

				if (!itemInfo.itemLink.isEmpty()) {
					fItemField.setText(itemInfo.itemLink);
					searchPageField.setText(itemInfo.searchLink);
					pageField.setText(String.valueOf(itemInfo.page));
					positionField.setText(String.valueOf(itemInfo.position));
				} else {
					fItemField.setText("Item was not found!");
				}
			}
		}

	}

	private ItemInfo findItemByFilters(boolean serchInGroup, boolean serchByPrice) {

		ItemInfo itInfo = new ItemInfo();
		itInfo.itemLink = "";
		if (serchInGroup && serchByPrice) {
			itInfo = getSearchByPrice();
		}
		if (serchInGroup && !serchByPrice) {
			itInfo = getSearchInGroup();
		}
		if (!serchInGroup) {
			itInfo = getGeneralSearch();
		}

		return itInfo;
	}

	private ItemInfo getGeneralSearch() {
		ItemInfo itInfo = new ItemInfo();
		itInfo.itemLink = "";
		String searchLink = "";
		WebDriver userDriver = getFireFoxDriverForSearch();
		timer.waitSeconds(3);
		WebElement searchInput = userDriver.findElement(By.id("twotabsearchtextbox"));
		searchInput.sendKeys(keyWord.getText());
		
		WebElement searchForm = userDriver.findElement(By.name("site-search"));
		timer.waitSeconds(3);
		searchForm.submit();
		timer.waitSeconds(3);
		searchLink = userDriver.getCurrentUrl();
		userDriver.get(searchLink);
		timer.waitSeconds(3);
		
		// try to find group
		boolean refPresent;
		try {
			userDriver.findElement(By.id("refinements"));
			refPresent = true;
		} catch (NoSuchElementException e) {
			refPresent = false;
		}
		
		if (refPresent) {
			WebElement refinementsBlock = userDriver.findElement(By.id("refinements"));
			List<WebElement> liElements = refinementsBlock.findElements(By.tagName("li"));
			boolean searchLinkNotFound = true;
			for(int i=0; i<liElements.size() && i<5; i++){
				WebElement liElement = liElements.get(i);
				// check for present element
				if(searchLinkNotFound){
					boolean present;
					try {
						liElement.findElement(By.tagName("a"));
						present = true;
					} catch (NoSuchElementException e) {
						present = false;
						continue;
					}
					if (present) {
						WebElement aElement = liElement.findElement(By.tagName("a"));

						if (aElement.getText().contains("Any Category")) {
							searchLinkNotFound = false;
							searchLink = aElement.getAttribute("href");
							if (!searchLink.contains("https://www.amazon.com")) {
								searchLink = "https://www.amazon.com" + searchLink;
							}
							userDriver.get(searchLink);
							timer.waitSeconds(3);
						}

					}
				}
				
			}
		}
		searchLink = userDriver.getCurrentUrl();
		boolean itemNotFound = true;
		// find last page
		int lastPage = 0;
		timer.waitSeconds(3);
		if (userDriver.getPageSource().contains("id=\"pagn\"")) {
			if (userDriver.getPageSource().contains("pagnDisabled")) {
				WebElement pagesElements = userDriver.findElement(By.id("pagn"));
				WebElement maxPageElement = pagesElements.findElement(By.className("pagnDisabled"));
				String lastPageStr = maxPageElement.getText();
				lastPage = Integer.valueOf(lastPageStr);
			} else {
				WebElement pagesElements = userDriver.findElement(By.id("pagn"));
				List<WebElement> pagesLinkElements = pagesElements.findElements(By.className("pagnLink"));
				if (!pagesLinkElements.isEmpty()) {
					WebElement lastPageElement = pagesLinkElements.get((pagesLinkElements.size() - 1));
					WebElement lastPageLink = lastPageElement.findElement(By.tagName("a"));
					String lastPageStr = lastPageLink.getText();
					lastPage = Integer.valueOf(lastPageStr);
				} else {
					lastPage = 1;
				}
			}
		}

		if (lastPage == 0) {
			lastPage = 1;
		}
		int page = 0;
		int position = 0;

		while (itemNotFound) {
			if (!userDriver.getPageSource().contains("twotabsearchtextbox")) {
				userDriver.quit();
				timer.waitSeconds(210);

				userDriver = getFireFoxDriverForSearch();
				userDriver.get(searchLink);
			}
			String resultListID = "";
			if (userDriver.getPageSource().contains("s-results-list-atf")) {
				resultListID = "s-results-list-atf";
			} else {
				resultListID = "mainResults";
			}

			WebElement foundItemsList = userDriver.findElement(By.id(resultListID));
			List<WebElement> foundElements = foundItemsList.findElements(By.tagName("li"));
			if (!foundElements.isEmpty()) {
				page++;
				for (WebElement foundElement : foundElements) {
					String elementAsin = foundElement.getAttribute("data-asin");
					if (elementAsin != null) {
						position++;
						if (elementAsin.contains(itemAsin.getText())) {
							itemNotFound = false;
							List<WebElement> aElements = new ArrayList<>();
							aElements = foundElement.findElements(By.tagName("a"));
							String itemLink = aElements.get(0).getAttribute("href");
							if (!itemLink.contains("https://www.amazon.com")) {
								itemLink = "https://www.amazon.com" + itemLink;
							}
							itInfo.itemLink = itemLink;
							itInfo.searchLink = userDriver.getCurrentUrl();
							itInfo.page = page;
							itInfo.position = position;
							
							try {
								userDriver.quit();
							} catch (Exception e) {
								return itInfo;
							}
							return itInfo;
						}
					}
				}
			} else {
				try {
					userDriver.quit();
				} catch (Exception e) {
					return itInfo;
				}
				return itInfo;
			}

			if (itemNotFound) {
				if (page < lastPage) {
					if (page == 1) {
						if (userDriver.getPageSource().contains("pagnNextLink")) {
							WebElement nextPageEl = userDriver.findElement(By.id("pagnNextLink"));
							searchLink = nextPageEl.getAttribute("href");
							if (!searchLink.contains("https://www.amazon.com")) {
								searchLink = "https://www.amazon.com" + searchLink;
							}
							userDriver.get(searchLink);
							timer.waitSeconds(5); // timer
						} else {
							try {
								userDriver.quit();
							} catch (Exception e) {
								return itInfo;
							}
							return itInfo;

						}
					} else {
						searchLink = getNextSearchPage(userDriver.getCurrentUrl(), page + 1);
						if (!searchLink.contains("https://www.amazon.com")) {
							searchLink = "https://www.amazon.com" + searchLink;
						}
						userDriver.get(searchLink);
						timer.waitSeconds(5); // timer
					}
				} else {
					try {
						userDriver.quit();
					} catch (Exception e) {
						return itInfo;
					}
					return itInfo;
				}
			}
		}
		try {
			userDriver.quit();
		} catch (Exception e) {
			return itInfo;
		}
		return itInfo;
	}

	private ItemInfo getSearchInGroup() {
		ItemInfo itInfo = new ItemInfo();
		itInfo.itemLink = "";
		String searchLink = "";
		WebDriver userDriver = getFireFoxDriverForSearch();
		timer.waitSeconds(3);
		WebElement searchInput = userDriver.findElement(By.id("twotabsearchtextbox"));
		searchInput.sendKeys(keyWord.getText());
		
		WebElement searchForm = userDriver.findElement(By.name("site-search"));
		timer.waitSeconds(3);
		searchForm.submit();
		timer.waitSeconds(3);
		searchLink = userDriver.getCurrentUrl();
		userDriver.get(searchLink);
		timer.waitSeconds(3);
		
		// try to find group
		boolean refPresent;
		try {
			userDriver.findElement(By.id("refinements"));
			refPresent = true;
		} catch (NoSuchElementException e) {
			refPresent = false;
		}
		
		if (refPresent) {
			WebElement refinementsBlock = userDriver.findElement(By.id("refinements"));
			List<WebElement> liElements = refinementsBlock.findElements(By.tagName("li"));
			boolean searchLinkNotFound = true;
			for(int i=0; i<liElements.size()&&i<5; i++){
				WebElement liElement = liElements.get(i);
				// check for present element
				if(searchLinkNotFound){
					
					boolean present;
					try {
						liElement.findElement(By.tagName("a"));
						present = true;
					} catch (NoSuchElementException e) {
						present = false;
						continue;
					}
					if (present) {
						WebElement aElement = liElement.findElement(By.tagName("a"));

						if (aElement.getText().contains("Any Category")) {
							searchLinkNotFound = false;
							searchLink = aElement.getAttribute("href");
							if (!searchLink.contains("https://www.amazon.com")) {
								searchLink = "https://www.amazon.com" + searchLink;
							}
							userDriver.get(searchLink);
							timer.waitSeconds(3);
						}

					}
				}
				
			}
		}
		// try to find group
		if (refPresent) {
			WebElement refinementsBlock = userDriver.findElement(By.id("refinements"));
			List<WebElement> liElements = refinementsBlock.findElements(By.tagName("li"));
			boolean searchLinkNotFound = true;
			for(int i=0; i<liElements.size()&&i<5; i++){
				WebElement liElement = liElements.get(i);
				// check for present element
				if(searchLinkNotFound){
					boolean present;
					try {
						liElement.findElement(By.tagName("a"));
						present = true;
					} catch (NoSuchElementException e) {
						present = false;
						continue;
					}
					if (present) {
						WebElement aElement = liElement.findElement(By.tagName("a"));

						if (aElement.getText().contains(groupField.getText())) {
							searchLinkNotFound = false;
							searchLink = aElement.getAttribute("href");
							if (!searchLink.contains("https://www.amazon.com")) {
								searchLink = "https://www.amazon.com" + searchLink;
							}
							userDriver.get(searchLink);
							timer.waitSeconds(3);
						}

					}
				}
				
			}
		}
		
		searchLink = userDriver.getCurrentUrl();
		boolean itemNotFound = true;
		// find last page
		int lastPage = 0;
		timer.waitSeconds(3);
		if (userDriver.getPageSource().contains("id=\"pagn\"")) {
			if (userDriver.getPageSource().contains("pagnDisabled")) {
				WebElement pagesElements = userDriver.findElement(By.id("pagn"));
				WebElement maxPageElement = pagesElements.findElement(By.className("pagnDisabled"));
				String lastPageStr = maxPageElement.getText();
				lastPage = Integer.valueOf(lastPageStr);
			} else {
				WebElement pagesElements = userDriver.findElement(By.id("pagn"));
				List<WebElement> pagesLinkElements = pagesElements.findElements(By.className("pagnLink"));
				if (!pagesLinkElements.isEmpty()) {
					WebElement lastPageElement = pagesLinkElements.get((pagesLinkElements.size() - 1));
					WebElement lastPageLink = lastPageElement.findElement(By.tagName("a"));
					String lastPageStr = lastPageLink.getText();
					lastPage = Integer.valueOf(lastPageStr);
				} else {
					lastPage = 1;
				}
			}
		}

		if (lastPage == 0) {
			lastPage = 1;
		}
		int page = 0;
		int position = 0;

		while (itemNotFound) {
			if (!userDriver.getPageSource().contains("twotabsearchtextbox")) {
				userDriver.quit();
				timer.waitSeconds(210);

				userDriver = getFireFoxDriverForSearch();
				userDriver.get(searchLink);
			}
			String resultListID = "";
			if (userDriver.getPageSource().contains("s-results-list-atf")) {
				resultListID = "s-results-list-atf";
			} else {
				resultListID = "mainResults";
			}

			WebElement foundItemsList = userDriver.findElement(By.id(resultListID));
			List<WebElement> foundElements = foundItemsList.findElements(By.tagName("li"));
			if (!foundElements.isEmpty()) {
				page++;
				for (WebElement foundElement : foundElements) {
					String elementAsin = foundElement.getAttribute("data-asin");
					if (elementAsin != null) {
						position++;
						if (elementAsin.contains(itemAsin.getText())) {
							itemNotFound = false;
							List<WebElement> aElements = new ArrayList<>();
							aElements = foundElement.findElements(By.tagName("a"));
							String itemLink = aElements.get(0).getAttribute("href");
							if (!itemLink.contains("https://www.amazon.com")) {
								itemLink = "https://www.amazon.com" + itemLink;
							}
							itInfo.itemLink = itemLink;
							itInfo.searchLink = userDriver.getCurrentUrl();
							itInfo.page = page;
							itInfo.position = position;
							
							try {
								userDriver.quit();
							} catch (Exception e) {
								return itInfo;
							}
							return itInfo;
						}
					}
				}
			} else {
				try {
					userDriver.quit();
				} catch (Exception e) {
					return itInfo;
				}
				return itInfo;
			}

			if (itemNotFound) {
				if (page < lastPage) {
					if (page == 1) {
						if (userDriver.getPageSource().contains("pagnNextLink")) {
							WebElement nextPageEl = userDriver.findElement(By.id("pagnNextLink"));
							searchLink = nextPageEl.getAttribute("href");
							if (!searchLink.contains("https://www.amazon.com")) {
								searchLink = "https://www.amazon.com" + searchLink;
							}
							userDriver.get(searchLink);
							timer.waitSeconds(5); // timer
						} else {
							try {
								userDriver.quit();
							} catch (Exception e) {
								return itInfo;
							}
							return itInfo;

						}
					} else {
						searchLink = getNextSearchPage(userDriver.getCurrentUrl(), page + 1);
						if (!searchLink.contains("https://www.amazon.com")) {
							searchLink = "https://www.amazon.com" + searchLink;
						}
						userDriver.get(searchLink);
						timer.waitSeconds(5); // timer
					}
				} else {
					try {
						userDriver.quit();
					} catch (Exception e) {
						return itInfo;
					}
					return itInfo;
				}
			}
		}
		try {
			userDriver.quit();
		} catch (Exception e) {
			return itInfo;
		}
		return itInfo;
	}

	private ItemInfo getSearchByPrice() {
		ItemInfo itInfo = new ItemInfo();
		itInfo.itemLink = "";
		String searchLink = "";
		WebDriver userDriver = getFireFoxDriverForSearch();
		timer.waitSeconds(3);
		WebElement searchInput = userDriver.findElement(By.id("twotabsearchtextbox"));
		searchInput.sendKeys(keyWord.getText());
		
		WebElement searchForm = userDriver.findElement(By.name("site-search"));
		timer.waitSeconds(3);
		searchForm.submit();
		timer.waitSeconds(3);
		searchLink = userDriver.getCurrentUrl();
		userDriver.get(searchLink);
		timer.waitSeconds(3);
		
		// try to find group
		boolean refPresent;
		try {
			userDriver.findElement(By.id("refinements"));
			refPresent = true;
		} catch (NoSuchElementException e) {
			refPresent = false;
		}
		
		if (refPresent) {
			WebElement refinementsBlock = userDriver.findElement(By.id("refinements"));
			List<WebElement> liElements = refinementsBlock.findElements(By.tagName("li"));
			boolean searchLinkNotFound = true;
			for(int i=0; i<liElements.size()&&i<5; i++){
				WebElement liElement = liElements.get(i);
				// check for present element
				if(searchLinkNotFound){
					
					boolean present;
					try {
						liElement.findElement(By.tagName("a"));
						present = true;
					} catch (NoSuchElementException e) {
						present = false;
						continue;
					}
					if (present) {
						WebElement aElement = liElement.findElement(By.tagName("a"));

						if (aElement.getText().contains("Any Category")) {
							searchLinkNotFound = false;
							searchLink = aElement.getAttribute("href");
							if (!searchLink.contains("https://www.amazon.com")) {
								searchLink = "https://www.amazon.com" + searchLink;
							}
							userDriver.get(searchLink);
							timer.waitSeconds(3);
						}

					}
				}
				
			}
		}
		// try to find group
		if (refPresent) {
			WebElement refinementsBlock = userDriver.findElement(By.id("refinements"));
			List<WebElement> liElements = refinementsBlock.findElements(By.tagName("li"));
			boolean searchLinkNotFound = true;
			for(int i=0; i<liElements.size()&&i<5; i++){
				WebElement liElement = liElements.get(i);
				// check for present element
				if(searchLinkNotFound){
					boolean present;
					try {
						liElement.findElement(By.tagName("a"));
						present = true;
					} catch (NoSuchElementException e) {
						present = false;
						continue;
					}
					if (present) {
						WebElement aElement = liElement.findElement(By.tagName("a"));

						if (aElement.getText().contains(groupField.getText())) {
							searchLinkNotFound = false;
							searchLink = aElement.getAttribute("href");
							if (!searchLink.contains("https://www.amazon.com")) {
								searchLink = "https://www.amazon.com" + searchLink;
							}
							userDriver.get(searchLink);
							timer.waitSeconds(3);
						}

					}
				}
				
			}
		}
		
		// try to set price
		int itemPrice = PriceParser.getIntPrice(priceField.getText());
		int lowPriceInt = (itemPrice / 100) - 1;
		if (lowPriceInt < 0) {
			lowPriceInt = 0;
		}
		int highPriceInt = (itemPrice / 100) + 1;
		WebElement lowPriceIn = userDriver.findElement(By.id("low-price"));
		lowPriceIn.sendKeys(String.valueOf(lowPriceInt));
		WebElement highPriceIn = userDriver.findElement(By.id("high-price"));
		highPriceIn.sendKeys(String.valueOf(highPriceInt));
		timer.waitSeconds(3);
		WebElement goBtn = userDriver.findElement(By.className("leftNavGoBtn"));
		goBtn.click();
		timer.waitSeconds(3);
		searchLink = userDriver.getCurrentUrl();
		userDriver.get(searchLink);
		
		boolean itemNotFound = true;
		// find last page
		int lastPage = 0;
		timer.waitSeconds(3);
		if (userDriver.getPageSource().contains("id=\"pagn\"")) {
			if (userDriver.getPageSource().contains("pagnDisabled")) {
				WebElement pagesElements = userDriver.findElement(By.id("pagn"));
				WebElement maxPageElement = pagesElements.findElement(By.className("pagnDisabled"));
				String lastPageStr = maxPageElement.getText();
				lastPage = Integer.valueOf(lastPageStr);
			} else {
				WebElement pagesElements = userDriver.findElement(By.id("pagn"));
				List<WebElement> pagesLinkElements = pagesElements.findElements(By.className("pagnLink"));
				if (!pagesLinkElements.isEmpty()) {
					WebElement lastPageElement = pagesLinkElements.get((pagesLinkElements.size() - 1));
					WebElement lastPageLink = lastPageElement.findElement(By.tagName("a"));
					String lastPageStr = lastPageLink.getText();
					lastPage = Integer.valueOf(lastPageStr);
				} else {
					lastPage = 1;
				}
			}
		}

		if (lastPage == 0) {
			lastPage = 1;
		}
		int page = 0;
		int position = 0;

		while (itemNotFound) {
			if (!userDriver.getPageSource().contains("twotabsearchtextbox")) {
				userDriver.quit();
				timer.waitSeconds(210);

				userDriver = getFireFoxDriverForSearch();
				userDriver.get(searchLink);
			}
			String resultListID = "";
			if (userDriver.getPageSource().contains("s-results-list-atf")) {
				resultListID = "s-results-list-atf";
			} else {
				resultListID = "mainResults";
			}

			WebElement foundItemsList = userDriver.findElement(By.id(resultListID));
			List<WebElement> foundElements = foundItemsList.findElements(By.tagName("li"));
			if (!foundElements.isEmpty()) {
				page++;
				for (WebElement foundElement : foundElements) {
					String elementAsin = foundElement.getAttribute("data-asin");
					if (elementAsin != null) {
						position++;
						if (elementAsin.contains(itemAsin.getText())) {
							itemNotFound = false;
							List<WebElement> aElements = new ArrayList<>();
							aElements = foundElement.findElements(By.tagName("a"));
							String itemLink = aElements.get(0).getAttribute("href");
							if (!itemLink.contains("https://www.amazon.com")) {
								itemLink = "https://www.amazon.com" + itemLink;
							}
							itInfo.itemLink = itemLink;
							itInfo.searchLink = userDriver.getCurrentUrl();
							itInfo.page = page;
							itInfo.position = position;
							
							try {
								userDriver.quit();
							} catch (Exception e) {
								return itInfo;
							}
							return itInfo;
						}
					}
				}
			} else {
				try {
					userDriver.quit();
				} catch (Exception e) {
					return itInfo;
				}
				return itInfo;
			}

			if (itemNotFound) {
				if (page < lastPage) {
					if (page == 1) {
						if (userDriver.getPageSource().contains("pagnNextLink")) {
							WebElement nextPageEl = userDriver.findElement(By.id("pagnNextLink"));
							searchLink = nextPageEl.getAttribute("href");
							if (!searchLink.contains("https://www.amazon.com")) {
								searchLink = "https://www.amazon.com" + searchLink;
							}
							userDriver.get(searchLink);
							timer.waitSeconds(5); // timer
						} else {
							try {
								userDriver.quit();
							} catch (Exception e) {
								return itInfo;
							}
							return itInfo;

						}
					} else {
						searchLink = getNextSearchPage(userDriver.getCurrentUrl(), page + 1);
						if (!searchLink.contains("https://www.amazon.com")) {
							searchLink = "https://www.amazon.com" + searchLink;
						}
						userDriver.get(searchLink);
						timer.waitSeconds(5); // timer
					}
				} else {
					try {
						userDriver.quit();
					} catch (Exception e) {
						return itInfo;
					}
					return itInfo;
				}
			}
		}
		try {
			userDriver.quit();
		} catch (Exception e) {
			return itInfo;
		}
		return itInfo;
	}

	private String getNextSearchPage(String navUrl, int pageToBeIn) {
		String nextPage = "";
		if (!navUrl.contains("page=")) {
			return nextPage;
		}

		char[] strElements = navUrl.toCharArray();
		ArrayList<Character> charElements = new ArrayList<>();
		for (char chElement : strElements) {
			charElements.add(chElement);
		}
		char[] intElements = String.valueOf(pageToBeIn).toCharArray();
		int repIndex = -1;
		for (int i = 0; i < charElements.size(); i++) {
			if (charElements.get(i) == '=' && charElements.get(i - 1) == 'e' && charElements.get(i - 2) == 'g'
					&& charElements.get(i - 3) == 'a' && charElements.get(i - 4) == 'p') {
				repIndex = i + 1;
			}
			if (repIndex == i) {
				if (Character.isDigit(charElements.get(i))) {
					charElements.remove(i);
					i--;
				}
			}
		}
		for (int i = 0; i < intElements.length; i++) {
			charElements.add(repIndex, intElements[i]);
			repIndex++;
		}
		for (char chToStr : charElements) {
			if (Character.isDigit(chToStr)) {
				nextPage += Character.getNumericValue(chToStr);
			} else {
				nextPage += String.valueOf(chToStr);
			}
		}
		return nextPage;
	}

	// private String getGeneralSearch() {
	// ItemInfo itInfo = new ItemInfo();
	// itInfo.itemLink = "";
	// String searchLink = "";
	// WebDriver userDriver = getFireFoxDriverForSearch();
	// timer.waitSeconds(3);
	//
	// if (userDriver.getPageSource().contains("searchDropdownBox")) {
	// WebElement searchInput =
	// userDriver.findElement(By.id("twotabsearchtextbox"));
	// searchInput.sendKeys(keyWord.getText());
	// WebElement searchForm = userDriver.findElement(By.name("site-search"));
	//
	// //check searchDrop
	// WebElement searchDrop =
	// userDriver.findElement(By.id("searchDropdownBox"));
	// String styleSD = searchDrop.getAttribute("style");
	// //if searchDrop is displayed
	// if (!styleSD.contains("none")) {
	// Select groupSel = new
	// Select(userDriver.findElement(By.id("searchDropdownBox")));
	// groupSel.selectByVisibleText("All Departments");
	// timer.waitSeconds(1);
	// searchForm.submit();
	// timer.waitSeconds(2);
	// searchLink = userDriver.getCurrentUrl();
	// if (!searchLink.contains("https://www.amazon.com")) {
	// searchLink = "https://www.amazon.com" + searchLink;
	// }
	// //if searchDrop is not displayed
	// } else{
	// timer.waitSeconds(3);
	// searchForm.submit();
	// timer.waitSeconds(3);
	// userDriver.get(userDriver.getCurrentUrl());
	//
	//
	// WebElement refinementsBlock =
	// userDriver.findElement(By.id("refinements"));
	// List<WebElement> liElements =
	// refinementsBlock.findElements(By.tagName("li"));
	// for (WebElement liElement : liElements) {
	// // check for present element
	// boolean present;
	// try {
	// liElement.findElement(By.tagName("a"));
	// present = true;
	// } catch (NoSuchElementException e) {
	// present = false;
	// }
	// if (present) {
	// WebElement aElement = liElement.findElement(By.tagName("a"));
	//
	// if (aElement.getText().contains("Any Category") ||
	// aElement.getText().contains("All Departments")) {
	// searchLink = aElement.getAttribute("href");
	// if (!searchLink.contains("https://www.amazon.com")) {
	// searchLink = "https://www.amazon.com" + searchLink;
	// }
	// }
	//
	// }
	// }
	// }
	// } else{
	// WebElement searchInput =
	// userDriver.findElement(By.id("twotabsearchtextbox"));
	// searchInput.sendKeys(keyWord.getText());
	// WebElement searchForm = userDriver.findElement(By.name("site-search"));
	// timer.waitSeconds(3);
	// searchForm.submit();
	// timer.waitSeconds(3);
	// userDriver.get(userDriver.getCurrentUrl());
	// WebElement refinementsBlock =
	// userDriver.findElement(By.id("refinements"));
	// List<WebElement> liElements =
	// refinementsBlock.findElements(By.tagName("li"));
	// for (WebElement liElement : liElements) {
	// // check for present element
	// boolean present;
	// try {
	// liElement.findElement(By.tagName("a"));
	// present = true;
	// } catch (NoSuchElementException e) {
	// present = false;
	// }
	// if (present) {
	// WebElement aElement = liElement.findElement(By.tagName("a"));
	//
	// if (aElement.getText().contains("Any Category") ||
	// aElement.getText().contains("All Departments")) {
	// searchLink = aElement.getAttribute("href");
	// if (!searchLink.contains("https://www.amazon.com")) {
	// searchLink = "https://www.amazon.com" + searchLink;
	// }
	// }
	//
	// }
	// }
	// }
	// // lfktt bpvtybnm
	//
	// WebElement searchDrop =
	// userDriver.findElement(By.id("searchDropdownBox"));
	// String styleSD = searchDrop.getAttribute("style");
	// if (!styleSD.contains("none")) {
	// WebElement searchInput =
	// userDriver.findElement(By.id("twotabsearchtextbox"));
	// searchInput.sendKeys(keyWord.getText());
	// WebElement searchForm = userDriver.findElement(By.name("site-search"));
	// // Select groupSel = new
	// // Select(userDriver.findElement(By.id("searchDropdownBox")));
	// // groupSel.selectByVisibleText("All Departments");
	// timer.waitSeconds(3);
	// searchForm.submit();
	// searchLink = userDriver.getCurrentUrl();
	// } else {
	// WebElement searchInput =
	// userDriver.findElement(By.id("twotabsearchtextbox"));
	// searchInput.sendKeys(keyWord.getText());
	// WebElement searchForm = userDriver.findElement(By.name("site-search"));
	// timer.waitSeconds(3);
	// searchForm.submit();
	// timer.waitSeconds(3);
	// userDriver.get(userDriver.getCurrentUrl());
	// WebElement refinementsBlock =
	// userDriver.findElement(By.id("refinements"));
	// List<WebElement> liElements =
	// refinementsBlock.findElements(By.tagName("li"));
	// for (WebElement liElement : liElements) {
	// // check for present element
	// boolean present;
	// try {
	// liElement.findElement(By.tagName("a"));
	// present = true;
	// } catch (NoSuchElementException e) {
	// present = false;
	// }
	// if (present) {
	// WebElement aElement = liElement.findElement(By.tagName("a"));
	//
	// if (aElement.getText().contains("Any Category") ||
	// aElement.getText().contains("All Departments")) {
	// searchLink = aElement.getAttribute("href");
	// if (!searchLink.contains("https://www.amazon.com")) {
	// searchLink = "https://www.amazon.com" + searchLink;
	// }
	// }
	//
	// }
	// }
	// }
	// }else
	//
	// {
	// WebElement searchInput =
	// userDriver.findElement(By.id("twotabsearchtextbox"));
	// searchInput.sendKeys(keyWord.getText());
	// WebElement searchForm = userDriver.findElement(By.name("site-search"));
	// timer.waitSeconds(3);
	// searchForm.submit();
	// timer.waitSeconds(3);
	// userDriver.get(userDriver.getCurrentUrl());
	// WebElement refinementsBlock =
	// userDriver.findElement(By.id("refinements"));
	// List<WebElement> liElements =
	// refinementsBlock.findElements(By.tagName("li"));
	// for (WebElement liElement : liElements) {
	// // check for present element
	// boolean present;
	// try {
	// liElement.findElement(By.tagName("a"));
	// present = true;
	// } catch (NoSuchElementException e) {
	// present = false;
	// }
	// if (present) {
	// WebElement aElement = liElement.findElement(By.tagName("a"));
	// if (aElement.getText().contains("Any Category") ||
	// aElement.getText().contains("All Departments")) {
	// searchLink = aElement.getAttribute("href");
	// if (!searchLink.contains("https://www.amazon.com")) {
	// searchLink = "https://www.amazon.com" + searchLink;
	// }
	// }
	//
	// }
	// }
	// }

	// userDriver.quit();
	// return searchLink;
	// }

	// private String getSearchLinkInGroup() {
	// System.out.println("2");
	// String searchLink = "";
	// WebDriver userDriver = getFireFoxDriverForSearch();
	// timer.waitSeconds(5);
	// if (userDriver.getPageSource().contains("searchDropdownBox")) {
	// WebElement searchDrop =
	// userDriver.findElement(By.id("searchDropdownBox"));
	// if (searchDrop.isDisplayed()) {
	//
	// // }
	// // String styleSD = searchDrop.getAttribute("style");
	// // if (!styleSD.contains("none")) {
	// WebElement searchInput =
	// userDriver.findElement(By.id("twotabsearchtextbox"));
	// searchInput.sendKeys(keyWord.getText());
	// WebElement searchForm = userDriver.findElement(By.name("site-search"));
	// Select groupSel = new
	// Select(userDriver.findElement(By.id("searchDropdownBox")));
	// groupSel.selectByVisibleText(groupField.getText());
	// timer.waitSeconds(3);
	// searchForm.submit();
	// timer.waitSeconds(3);
	// searchLink = userDriver.getCurrentUrl();
	// timer.waitSeconds(3);
	// } else {
	// WebElement searchInput =
	// userDriver.findElement(By.id("twotabsearchtextbox"));
	// searchInput.sendKeys(keyWord.getText());
	// WebElement searchForm = userDriver.findElement(By.name("site-search"));
	// timer.waitSeconds(3);
	// searchForm.submit();
	// timer.waitSeconds(3);
	// userDriver.get(userDriver.getCurrentUrl());
	// timer.waitSeconds(3);
	// WebElement refinementsBlock =
	// userDriver.findElement(By.id("refinements"));
	// List<WebElement> liElements =
	// refinementsBlock.findElements(By.tagName("li"));
	// for (WebElement liElement : liElements) {
	// // check for present element
	// boolean present;
	// try {
	// liElement.findElement(By.tagName("a"));
	// present = true;
	// } catch (NoSuchElementException e) {
	// present = false;
	// }
	// if (present) {
	// WebElement aElement = liElement.findElement(By.tagName("a"));
	//
	// if (aElement.getText().contains(groupField.getText())) {
	// searchLink = aElement.getAttribute("href");
	// if (!searchLink.contains("https://www.amazon.com")) {
	// searchLink = "https://www.amazon.com" + searchLink;
	// }
	// }
	//
	// }
	// }
	// }
	// } else {
	// WebElement searchInput =
	// userDriver.findElement(By.id("twotabsearchtextbox"));
	// searchInput.sendKeys(keyWord.getText());
	// WebElement searchForm = userDriver.findElement(By.name("site-search"));
	// timer.waitSeconds(3);
	// searchForm.submit();
	// timer.waitSeconds(3);
	// userDriver.get(userDriver.getCurrentUrl());
	// WebElement refinementsBlock =
	// userDriver.findElement(By.id("refinements"));
	// List<WebElement> liElements =
	// refinementsBlock.findElements(By.tagName("li"));
	// for (WebElement liElement : liElements) {
	// // check for present element
	// boolean present;
	// try {
	// liElement.findElement(By.tagName("a"));
	// present = true;
	// } catch (NoSuchElementException e) {
	// present = false;
	// }
	// if (present) {
	// WebElement aElement = liElement.findElement(By.tagName("a"));
	//
	// if (aElement.getText().contains(groupField.getText())) {
	// searchLink = aElement.getAttribute("href");
	// if (!searchLink.contains("https://www.amazon.com")) {
	// searchLink = "https://www.amazon.com" + searchLink;
	// }
	// }
	//
	// }
	// }
	// }
	//
	// userDriver.quit();
	// return searchLink;
	// }
	//
	// private String getSearchLinkByPrice() {
	// System.out.println("3");
	// String searchLink = "";
	// WebDriver userDriver = getFireFoxDriverForSearch();
	// timer.waitSeconds(5);
	// if (userDriver.getPageSource().contains("searchDropdownBox")) {
	// WebElement searchDrop =
	// userDriver.findElement(By.id("searchDropdownBox"));
	// if (searchDrop.isDisplayed()) {
	//
	// // }
	// // String styleSD = searchDrop.getAttribute("style");
	// // if (!styleSD.contains("none")) {
	// WebElement searchInput =
	// userDriver.findElement(By.id("twotabsearchtextbox"));
	// searchInput.sendKeys(keyWord.getText());
	// WebElement searchForm = userDriver.findElement(By.name("site-search"));
	// Select groupSel = new
	// Select(userDriver.findElement(By.id("searchDropdownBox")));
	// groupSel.selectByVisibleText(groupField.getText());
	// timer.waitSeconds(3);
	// searchForm.submit();
	// timer.waitSeconds(3);
	// searchLink = userDriver.getCurrentUrl();
	// timer.waitSeconds(3);
	// } else {
	// WebElement searchInput =
	// userDriver.findElement(By.id("twotabsearchtextbox"));
	// searchInput.sendKeys(keyWord.getText());
	// WebElement searchForm = userDriver.findElement(By.name("site-search"));
	// timer.waitSeconds(3);
	// searchForm.submit();
	// timer.waitSeconds(3);
	// userDriver.get(userDriver.getCurrentUrl());
	// timer.waitSeconds(3);
	// WebElement refinementsBlock =
	// userDriver.findElement(By.id("refinements"));
	// List<WebElement> liElements =
	// refinementsBlock.findElements(By.tagName("li"));
	// for (WebElement liElement : liElements) {
	// // check for present element
	// boolean present;
	// try {
	// liElement.findElement(By.tagName("a"));
	// present = true;
	// } catch (NoSuchElementException e) {
	// present = false;
	// }
	// if (present) {
	// WebElement aElement = liElement.findElement(By.tagName("a"));
	//
	// if (aElement.getText().contains(groupField.getText())) {
	// searchLink = aElement.getAttribute("href");
	// if (!searchLink.contains("https://www.amazon.com")) {
	// searchLink = "https://www.amazon.com" + searchLink;
	// }
	// }
	//
	// }
	// }
	// }
	// } else {
	// WebElement searchInput =
	// userDriver.findElement(By.id("twotabsearchtextbox"));
	// searchInput.sendKeys(keyWord.getText());
	// WebElement searchForm = userDriver.findElement(By.name("site-search"));
	// timer.waitSeconds(3);
	// searchForm.submit();
	// timer.waitSeconds(3);
	// userDriver.get(userDriver.getCurrentUrl());
	// timer.waitSeconds(3);
	// WebElement refinementsBlock =
	// userDriver.findElement(By.id("refinements"));
	// List<WebElement> liElements =
	// refinementsBlock.findElements(By.tagName("li"));
	// for (WebElement liElement : liElements) {
	// // check for present element
	// boolean present;
	// try {
	// liElement.findElement(By.tagName("a"));
	// present = true;
	// } catch (NoSuchElementException e) {
	// present = false;
	// }
	// if (present) {
	// WebElement aElement = liElement.findElement(By.tagName("a"));
	//
	// if (aElement.getText().contains(groupField.getText())) {
	// searchLink = aElement.getAttribute("href");
	// if (!searchLink.contains("https://www.amazon.com")) {
	// searchLink = "https://www.amazon.com" + searchLink;
	// }
	// }
	//
	// }
	// }
	// }
	// userDriver.get(searchLink);
	// timer.waitSeconds(5);
	// int lowPriceInt = (PriceParser.getIntPrice(priceField.getText()) / 100) -
	// 2;
	// if (lowPriceInt < 0) {
	// lowPriceInt = 0;
	// }
	// int highPriceInt = (PriceParser.getIntPrice(priceField.getText()) / 100)
	// + 2;
	// WebElement lowPriceIn = userDriver.findElement(By.id("low-price"));
	// lowPriceIn.sendKeys(String.valueOf(lowPriceInt));
	// WebElement highPriceIn = userDriver.findElement(By.id("high-price"));
	// highPriceIn.sendKeys(String.valueOf(highPriceInt));
	// timer.waitSeconds(5);
	// WebElement goBtn = userDriver.findElement(By.className("leftNavGoBtn"));
	// goBtn.click();
	// timer.waitSeconds(5);
	// searchLink = userDriver.getCurrentUrl();
	// if (!searchLink.contains("https://www.amazon.com")) {
	// searchLink = "https://www.amazon.com" + searchLink;
	// }
	// userDriver.quit();
	// return searchLink;
	// }

	private void checkItemAsin() {
		String itemAsinStr = itemAsin.getText();
		if (!itemAsinStr.isEmpty()) {

			if (itemAsin.getText().contains("You should input ASIN before!")) {
				itemAsin.setText("You should input ASIN before!");
				checkedItemLink.setText("");
			} else {
				timer.waitSeconds(1);
				Item item = checkItemByASIN(itemAsinStr);
				if (item.itemLink.isEmpty()) {
					checkedItemLink.setText("Item was not found!");
				} else {
					checkedItemLink.setText(item.itemLink);
					groupField.setText(item.group);
					priceField.setText(PriceParser.getStrPrice(item.price));
				}
			}
		} else {
			itemAsin.setText("You should input ASIN before!");
			checkedItemLink.setText("");
		}
	}

	private Item checkItemByASIN(String itemAsinStr) {
		Item item = new Item();
		item.itemLink = "";
		String itPriceAsStr = "";
		WebDriver userDriver = getFireFoxDriverForSearch();
		if (userDriver == null) {
			return item;
		} else {
			if (userDriver.getPageSource().contains("twotabsearchtextbox")) {
				WebElement searchInput = userDriver.findElement(By.id("twotabsearchtextbox"));
				searchInput.sendKeys(itemAsinStr);
				WebElement searchForm = userDriver.findElement(By.name("site-search"));
				timer.waitSeconds(1);
				searchForm.submit();
				timer.waitSeconds(2);
				userDriver.get(userDriver.getCurrentUrl());
				timer.waitSeconds(1);

				String resultListID = "";
				if (userDriver.getPageSource().contains("s-results-list-atf")) {
					resultListID = "s-results-list-atf";
				} else {
					resultListID = "mainResults";
				}

				WebElement foundItemsList = userDriver.findElement(By.id(resultListID));
				List<WebElement> foundElements = foundItemsList.findElements(By.tagName("li"));
				if (!foundElements.isEmpty()) {
					for (WebElement foundElement : foundElements) {
						String elementAsin = foundElement.getAttribute("data-asin");
						if (elementAsin != null) {
							if (elementAsin.contains(itemAsinStr)) {

								List<WebElement> aElements = new ArrayList<>();
								aElements = foundElement.findElements(By.tagName("a"));
								item.itemLink = aElements.get(0).getAttribute("href");
								if (!item.itemLink.contains("https://www.amazon.com")) {
									item.itemLink = "https://www.amazon.com" + item.itemLink;
								}
								timer.waitSeconds(5);
								userDriver.get(item.itemLink);
								timer.waitSeconds(5);

								if (userDriver.getPageSource().contains("priceblock_ourprice")) {
									itPriceAsStr = userDriver.findElement(By.id("priceblock_ourprice")).getText();
								}
								if (userDriver.getPageSource().contains("priceblock_dealprice")) {
									itPriceAsStr = userDriver.findElement(By.id("priceblock_dealprice")).getText();
								}
								if (!itPriceAsStr.isEmpty()) {
									item.price = PriceParser.getIntPrice(itPriceAsStr);
								}

								String itemGroup = "";
								if (userDriver.getPageSource().contains("wayfinding-breadcrumbs_feature_div")) {
									WebElement element = userDriver
											.findElement(By.id("wayfinding-breadcrumbs_feature_div"));
									List<WebElement> groupLinks = element.findElements(By.tagName("li"));
									if (!groupLinks.isEmpty()) {
										WebElement mainGroupEl = groupLinks.get(0);
										itemGroup = mainGroupEl.findElement(By.tagName("a")).getText();
									}
								} else {
									if (userDriver.getPageSource().contains("Back to results")) {
										WebElement element = userDriver.findElement(By.id("brand"));
										String groupLink = element.getText();
										itemGroup = groupLink;
									}
								}
								if (!itemGroup.isEmpty()) {
									item.group = itemGroup;
								}

								userDriver.quit();
								return item;
							}
						}
					}

				} else {
					userDriver.quit();
					return item;
				}
			}

		}
		return item;
	}

	
	private WebDriver getFireFoxDriverForSearch() {
//		String userPath = System.getProperty("user.dir");
//		String fileSep = System.getProperty("file.separator");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\student.STEP\\workspace\\AmazonSearch\\geckodriver.exe");

		DesiredCapabilities firefox = DesiredCapabilities.firefox();

//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("permissions.default.image", 2);
//		firefox.setCapability(FirefoxDriver.PROFILE, profile);

		WebDriver driver = WebDriverFactory.getDriver(firefox);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		timer.waitSeconds(5);
		driver.get("https://www.amazon.com");
		timer.waitSeconds(5);
		// check driver
		String currentPage = driver.getPageSource();
		if (currentPage.contains("twotabsearchtextbox")) {
			return driver;
		} else {
			driver.quit();
			return null;
		}
	}
}
