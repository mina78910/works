package sms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateConfirm
 */
@WebServlet("/UpdateConfirm")
public class UpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("updateconfirm.javaに飛んだ");
		HttpSession session = request.getSession();

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更

		try {
			System.out.println("34");
			//updateフォームからの入力を取得して、Beansに格納
			ItemDataBeans updatedData = new ItemDataBeans();
			System.out.println("Updateフォームからの値"+request.getParameter("item_id")+request.getParameter("name")+request.getParameter("stock"));
			System.out.println("37");
			updatedData.setItem_id(Integer.parseInt(request.getParameter("item_id")));
			updatedData.setName(request.getParameter("name"));
			updatedData.setStock(Integer.parseInt(request.getParameter("stock")));
			System.out.println("41");


			//次の確認画面で値を表示させるため、セッションに格納
			session.setAttribute("updatedData", updatedData);

		}catch(Exception e) {
			System.out.println(e);
		}


		request.getRequestDispatcher("/updateconfirm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
