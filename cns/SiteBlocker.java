 
import java.io.*; 
import java.util.Scanner; 
 
public class SiteBlocker { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        String site; 
 
        System.out.println("Enter the name of the site to block:"); 
        site = scanner.nextLine(); 
 
        // Path to the hosts file 
        String hostsFilePath = "C:/Windows/System32/drivers/etc/hosts"; 
 
        try (BufferedWriter out = new BufferedWriter(new FileWriter(hostsFilePath, true))) { 
            // Write the entry to block the site 
            out.write("127.0.0.1\t" + site); 
            out.newLine(); 
            System.out.println(site + " is blocked."); 
        } catch (IOException e) { 
            System.out.println("Error: Either the file was not found, or you don't have permission to modify it. Please run the program as Administrator."); 
        } 
 
        scanner.close(); 
    } 
}
