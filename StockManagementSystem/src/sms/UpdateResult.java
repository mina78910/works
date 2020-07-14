package sms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateResult
 */
@WebServlet("/UpdateResult")
public class UpdateResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("updateresult.javaに飛んだ");

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更

		HttpSession se = request.getSession();
		ItemDataBeans willUpdateToDB = (ItemDataBeans)se.getAttribute("updatedData");


		try {
			//DBへデータの挿入
			StockManagerDAO.getInstance().update(willUpdateToDB);

		}catch(Exception e){

		}

		request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
