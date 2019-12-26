package com.jimprince99;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
// Commented-out this line as we are using the web.xml file
//@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private ArrayList<Book> bookList  = new ArrayList<Book>();
	private BookDAO bookDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        
        bookDAO = new BookDAO();
        bookDAO.connect();
        bookDAO.disconnect();
        
        // add books to our ArrayList
//        bookList .add(new Book("To Kill a Mockingbird", "a", 5.50f));
//        bookList .add(new Book("1984", "b", 5.50f));
//        bookList .add(new Book("Frankenstien", "c", 5.50f));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		String action = request.getPathInfo();
		if (action.equals("/new"))
		{
			addBook(request, response);
		} else {
			listBooks(request,response);
		}
		
		//request.setAttribute("book_title", "1984");
//		request.setAttribute("book_list", bookList );
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/BookList.jsp");
//		dispatcher.forward(request, response);
//		
		
		
//		String title = request.getParameter("title");
//		String author = request.getParameter("author");
//		output.println("book title=" + title);
//		output.println("book author=" + author);
////		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		if (action.equals("/insert"))
		{
			insertBook(request, response);
		}
		
		
		//		PrintWriter output = response.getWriter();
//		String title = request.getParameter("title");
//		String author = request.getParameter("author");
//		output.println("book title=" + title);
//		output.println("book author=" + author);
		
//		// TODO Auto-generated method stub
//		doGet(request, response);
	}
	
	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		
		Book newBook = new Book(title, author, Float.parseFloat(price));
		//bookList.add(newBook);
		bookDAO.insertBook(newBook);
		
		response.sendRedirect("list");
	}
	
	private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BookForm.html");
		dispatcher.forward(request, response);
	}
	
	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Book> books = bookDAO.listAllBooks();
		request.setAttribute("book_list", books);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/BookList.jsp");
		dispatcher.forward(request, response);
	}
	
	

}
