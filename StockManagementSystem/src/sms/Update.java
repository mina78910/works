package sms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update.javaに飛んだ");
		HttpSession session = request.getSession();

        try {
        	//新規生成したbeansに、クエリストリングで取得したIDだけをセットする
        	ItemDataBeans willSearchByIdData = new ItemDataBeans();
        	willSearchByIdData.setItem_id(Integer.parseInt(request.getParameter("id")));

        	//上で生成したID付きの空beansをDAOに流して、SQLの加工～ID検索までやってもらう　そしてヒットしたレコードの中身がすべてもどってくるので、セッションに格納
        	ItemDataBeans SearchedbyIdData = StockManagerDAO.getInstance().searchByID(willSearchByIdData);
        	session.setAttribute("SearchedbyIdData", SearchedbyIdData);

        }catch(Exception e) {

        }







		request.getRequestDispatcher("/update.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
