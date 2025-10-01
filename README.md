# Shine Job Automation

This project automates the process of logging in, searching, and applying for jobs on [Shine.com](https://www.shine.com) using **Selenium WebDriver** with Java.

---

## Features
- Automatic login to Shine account  
- Job search by title, location, and experience  
- Applies to the first job result automatically  
- Provides status messages for each step  

---

## Tech Stack
- **Java**  
- **Selenium WebDriver**  
- **ChromeDriver**  

---

## Setup & Usage
1. Install [Java](https://www.oracle.com/java/technologies/javase-downloads.html).  
2. Download [ChromeDriver](https://chromedriver.chromium.org/downloads) and set its path in the code:  
   ```java
   System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
3. Update the code with your Shine credentials
emailInput.sendKeys("your_email_here");
passwordInput.sendKeys("your_password_here");
4. Run the program:
javac ShineJobAutomation.java
java ShineJobAutomation
