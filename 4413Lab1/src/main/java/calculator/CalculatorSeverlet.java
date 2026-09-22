package calculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet implementation class CalculatorSeverlet
 */
@WebServlet("/CalculatorSeverlet")
public class CalculatorSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorSeverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String noItemsParam = request.getParameter("noItems");
		String priceParam = request.getParameter("price");
		String taxParam = request.getParameter("tax");
		
		int noItems = Integer.parseInt(noItemsParam);
		double price = Double.parseDouble(priceParam);
		double tax = Double.parseDouble(taxParam);

		double total = noItems * price * (1 + tax/100.0);
		total = Math.round(total * 100)/ 100.0;
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Shopping cart Price Calculator</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Shopping cart Price Calculator</h1>");
		out.println("<p>You entered:</p>");
		out.println("<ul>");
		out.println("<li>Number of items: " + noItems + "</li>");
		out.println("<li>Price of each item: $" + price + "</li>");
		out.println("<li>Tax rate: " + tax + "%</li>");
		out.println("</ul>");
		out.println("<p>The total price is calculated as:</p>");
		out.println("<p>total = noItems * price * (1 + tax / 100)</p>");
		out.println("<p>The total price is: $" + total + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
