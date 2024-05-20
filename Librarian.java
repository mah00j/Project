package Project;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import static Project.Book.books;
import static Project.User.users;

public class Librarian extends Person implements Librarian_Procedures {
	private int employeeID;
    public static LinkedList<Librarian> librarian = new LinkedList<>();

    
  
    
	public Librarian(String n, int a, String g, int empID) {
		super(n, a, g);
		this.employeeID=empID;
	}
	public Librarian(Librarian newLib) {
		 super(newLib.getName(), newLib.getAge(), newLib.getGender());
	        this.employeeID = newLib.employeeID;
	}

	public String AddLibrarian(String name,int age,String gender, int eid) {
		
		if (age < 18 || age>100) {
	        throw new IllegalArgumentException("Age must be between 18 and 100");
	    }

		else {
			boolean ID=false;
		 for (Librarian librarians: librarian) {
	  if (eid==librarians.getEmployeeID()) {
		  ID=true;
		  break;
	  }
	  
	  }
		
			 
		Librarian lib_jdid = new Librarian(name, age, gender, eid);
		boolean flag = false;
        for (Librarian u : librarian) {
        	
            if (lib_jdid.getName().equalsIgnoreCase(u.getName())) {
             flag = true;  
             return "already esmak mawjud 3enna";
            }
            }
             if (!flag) {
 	            librarian.add(lib_jdid);
 	            return "librarian added successfully!";
             }
             }
 	      return "Library card exists already";
 	}
	
	
	@Override
	public String toString() {
		return super.toString()+ " ,employeeID: " + employeeID ;
	}
	//HAVE A flag here if book does not exist
	@Override
	public String SearchBookByTitle(String title) {
		boolean flag=false;
    for(Book book: books) {
    	if(book.getTitle().equalsIgnoreCase(title)) {
    		flag=true;
    		return "book with this title: "+book.getTitle().toString()+" is found";
    	}
    }
    
   return "No book found by this title: "+title;
    
		
	}
	//HAVE A flag here if books do not exist

	@Override
	public String SearchBookByAuthor(String authorName) {
	    StringBuilder result = new StringBuilder();
	    boolean flag = false;
	    for (Book book : books) {
	        if (book.getAuthor().equalsIgnoreCase(authorName)) {
	            flag = true;
	         result.append("Book: ").append(book.getTitle()).append("\n");
	        result.append("Author: ").append(book.getAuthor()).append("\n"); //appends metel adds 3al ekhir of it
	      result.append("______________________\n");
	        }
	    }
	    if (flag) {
	        return "Books by author " + authorName + ":\n" + result.toString();
	    } else {
	        return "No books found by author " + authorName;
	    }
	}
	//HAVE A flag here if books do not exist (done)

	@Override
	public String SearchBookByGenre(String genre) {
		boolean flag =false;
		for(Book book: books) {
	   if(book.getGenre().equalsIgnoreCase(genre)) {
		   flag=true;
		 return "book in "+book.getGenre().toString()+"genre is found" ;

			   }
		   	}
 return "book in this genre: "+genre+" not found";
			   
		
	}

	@Override
	public String AddUser(String name, int age, String gender, int lcnum) {
	    if (age < 18 || age > 100) {
	       return "age needs to be between 18 and 100";
	    }

	    boolean IDuserE=false;
	    for (User u : users) {
	        if (lcnum == u.getLibraryCardNum()) {
	            IDuserE=true;
	            break;
	        }
	    }

	    System.out.println("IDuserE: " + IDuserE); // Add this log statement

	    if (IDuserE) {
	        return "Library card number already exists.";
	    }

	    for (User u : users) {
	        if (name.equalsIgnoreCase(u.getName())) {
	            return "User with the same name already exists.";
	        }
	    }

	    User newUser = new User(name, age, gender, lcnum);
	    users.add(newUser);
	    return "Librarian added successfully!";
	}
	@Override
	public void AddBooks(int ISBN, String title, String author, String genre, boolean availability, boolean reserved) {
		 Book newBook = new Book(ISBN, title, author, genre, availability, reserved);
		 books.add(newBook);
		 System.out.println("book added successfully!");
		
	}

	@Override
    public String Check_Information() {
        return toString();
    }

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	
		     }

