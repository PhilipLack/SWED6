package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter website URL to monitor: ");
        String url = scanner.nextLine();

        System.out.println("Choose strategy: 1. Identical content size 2. Identical HTML content 3. Identical text content");
        int strategyChoice = scanner.nextInt();
        scanner.nextLine(); 

        Strategy strategy = null;
        switch (strategyChoice) {
            case 1:
                strategy = new IdenticalContentSize();
                break;
            case 2:
                strategy = new IdenticalHtmlContent();
                break;
            case 3:
                strategy = new IdenticalTextContent();
                break;
            
        }

        User user = new User(userID, username);
        Website website = new Website(url, strategy);
        SubscriptionManager manager = new SubscriptionManager();
        user.registerForUpdates(website, "Immediate");

        List<Website> websites = new ArrayList<>();
        websites.add(website);

        CommunicationChannel channel = new CommunicationChannel("Email");
        WebsiteMonitorSystem monitorSystem = new WebsiteMonitorSystem();

        System.out.println("Starting website monitor system...");
        new Thread(() -> monitorSystem.monitorWebsites(websites, channel)).start();

        while (true) {
            System.out.print("Type 'exit' to stop: ");
            String command = scanner.nextLine();
            if (command.equals("exit")) {
                System.out.println("Stopping website monitor system");
                break;
                
            }
        }
        
    }
}
