package lockersapplication;

import java.io.File;
import java.io.IOException;
import java.util.*;

//WELCOME SCREEN
public class LockedMeProject {
		public void homePageLayout()
		{
		for(int j=0;j<2;j++) {
			for(int i=0;i<150;i++) {
			System.out.print(".");
			}
			System.out.println();
			System.out.println();
			}
		}
		
	private void space() {
		for(int i=0;i<32;i++) {
		System.out.print(" ");
		}
	}
	private void homePageScreen() {
		LockedMeProject obj = new LockedMeProject();
		System.out.println();
		obj.space();
		System.out.print("LOCKEDME.COM APPLICATION");
		obj.space();
		System.out.println();
		System.out.println();
		obj.space();
		System.out.print("DEVELOPED BY RAJSHREE SATHAWNE");
		obj.space();
		System.out.println();
		System.out.println();
	}

	private void Order() {
		File file = new File("E://");
		System.out.println("Displaying all the files in the path "+file.getAbsolutePath());
		System.out.println();
		String arr[]=file.list();
		Set<String>treeset = new TreeSet<String>();
		int m=0;
		for(String j:arr)
		{
			m++;
			treeset.add(j);
			System.out.println("    "+m+"."+j);
		}
        System.out.println();
        System.out.println();
        System.out.println("All the files are displayed..");
	}
	private void fileFunctionalities() {
		homePageLayout();
		System.out.println();
		System.out.println("Please select the option from below");
		System.out.println();
		System.out.println("1.Add File");
		System.out.println("2.Delete File");
		System.out.println("3.Search File");
		System.out.println("4.Navigate to Main");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		LockedMeProject obj = new LockedMeProject();
		int input = scan.nextInt();
		switch(input) {
		case 1:{
			try {
				obj.AddFile();
				break;
			} catch (Exception e) {
				
				e.printStackTrace();
			}	
		}
		case 2:{
			try {
				obj.DeleteFile();
				break;
			} catch (Exception e) {
				
				e.printStackTrace();
			}	
		}
		case 3:{
			try {
				obj.SearchFile();
				break;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		case 4:{
			try {
				obj.NavigateFile();
				break;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		}

	}
	// USER INPUT
	public void MenuPage() {
		try{
		//System.out.println();
		//System.out.println();
		//System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("You are welcome to LockedMe.com");
		System.out.println();
		System.out.println("Here's what we can help you with");
		System.out.println("	1. Listout the Files name in Ascending order");
		System.out.println("	2. File Operations");
		System.out.println("	3. Close the Application");
		System.out.println("Please enter the option you are interested in: [in integer format] ");
		LockedMeProject obj = new LockedMeProject();
		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();
		switch(option) {
		case 1:{
			//List the files
			obj.Order();
			obj.MenuPage();
			break;
		}
		case 2:{
			//File operations
			obj.fileFunctionalities();
			break;
		}
		case 3:{
			//exit
            System.exit(0);
			break;
		}
		}
			}
		catch(Exception e)
		{
			System.out.println("Exception catched.."+e);
		}
	}
	//File functionalities : Add,delete,search,navigate
	public void AddFile() throws IOException {
		System.out.println("Let's create a file for you. Please enter the file name here with the required format..");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		String filename=scan.nextLine();
		if(filename.equals("E")||filename.equals("C")||filename.equals(""))
		{
			System.out.println("Please enter valid Filename");
			System.out.println();
			AddFile();
		}
		else {
			File file=new File("E:\\"+filename);
			if(file.exists())
		
			{
				System.out.println("Oops! The filename you have entered already exists..");
				System.out.println();
				char input = scan.next().charAt(0);
				if(input=='E') {
					fileFunctionalities();
				}
				else if(input=='C') {
					AddFile();
				}
				else {
					System.out.println("invalid input!");
					MenuPage();
				}
			}else {
				file.createNewFile();
				System.out.println("Congrats! Your file has been successfully created..");
				System.out.println();
				System.out.println();
				System.out.println("Enter 'E' to Exit to the main Menu OR 'C' for Continue");
				char input=scan.next().charAt(0);
				if(input=='E') {
					fileFunctionalities();
				}
				else if(input=='C'){
					AddFile();
				}
				else {
					System.out.println("invalid input!");
					MenuPage();
				}
			}
			
		}
		
		
		

	}
	public void DeleteFile() {
		System.out.println("Not required? Okay, please enter the filename with the file format you wish to delete..");
		System.out.println();
		System.out.println();
		System.out.println("Please enter file name");
		Scanner scan = new Scanner(System.in);
		String filename = scan.nextLine();
		if(filename.equals("E")||filename.equals("C")||filename.equals(""))
		{
			System.out.println("Please enter valid filename");
			System.out.println();
			DeleteFile();
		}
		else {
		File file=new File("E:\\"+filename);
		File path=new File("E:\\");
		String filecheck=file.getName();
		String arr[]=path.list();
		int count=0;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i].equals(filecheck))
			{
				file.delete();
				System.out.println("File deleted successfully..");
				count=1;
				System.out.println();
				System.out.println("Enter 'E' to Exit to the main Menu OR 'C' for Continue");
				char input = scan.next().charAt(0);
				if(input=='E') {
					fileFunctionalities();
				}
				else if(input=='C'){
					DeleteFile();
				}
				else {
					System.out.println("invalid input!");
					MenuPage();
				}
			}else {
				continue;
			}
		}
		if(count==0) {
			System.out.println("File not found!(Note:Case sensitive)");
			System.out.println();
			System.out.println("Enter 'E' to Exit to the main Menu OR 'C' for Continue");
			char input = scan.next().charAt(0);
			if(input=='E') {
				fileFunctionalities();
			}
			else if(input=='C'){
				DeleteFile();
			}
			else {
				System.out.println("invalid input!");
				
				MenuPage();
			}
		}
	}
	}
	public void NavigateFile() {
		LockedMeProject obj = new LockedMeProject();
		obj.MenuPage();
	}
	public void SearchFile() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter File name..");
		String input= scan.nextLine();
		File file=new File("E:\\"+input);
		if(file.exists())
		{
			System.out.println("File searched!");
			System.out.println();
			System.out.println("Enter 'E' to Exit to the main Menu OR 'C' for Continue");
			char check = scan.next().charAt(0);
			if(check=='E') {
				fileFunctionalities();
			}
			else if(check=='C'){
				SearchFile();
			}
			else {
				System.out.println("invalid input!");
				MenuPage();
			}
		}
		else
		{
			System.out.println("File Not Found!");
			System.out.println();
			System.out.println("Enter 'E' to Exit to the main Menu OR 'C' for Continue");
			char check = scan.next().charAt(0);
			if(check=='E') {
				fileFunctionalities();
			}
			else if(check=='C'){
				SearchFile();
			}
			else {
				System.out.println("invalid input!");
				MenuPage();
			}
		}
	}
	//-----------------------------------------------------------------------------------------------
	public static void main(String[] args) 
	{
		try{
		LockedMeProject obj = new LockedMeProject();
		obj.homePageLayout();
		obj.homePageScreen();
		obj.homePageLayout();
		
	Scanner scan = new Scanner(System.in);
	System.out.print("Please press 'B' and tap'Enter' to begin the application..");
	char start=scan.next().charAt(0);
	if(start=='B')
	{
		obj.MenuPage();
	}
	else 
	{
		System.out.print("invalid input");
		obj.MenuPage();
	}
		}
		catch(Exception e)
		{
			System.out.println("Exception.."+e);
		}
	}
	}

