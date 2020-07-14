package sms;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StockManager
 */
@WebServlet("/StockManager")
public class StockManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sms.javaに飛んだ");
		HttpSession session = request.getSession();

		//ログイン認証の実装
		System.out.println("37");
		UserDataBeans loginData = new UserDataBeans();
		System.out.println("39");
		loginData.setId(Integer.parseInt(request.getParameter("user")));
		loginData.setPass(request.getParameter("pass"));
		System.out.println("42");
		session.setAttribute("loginData", loginData);

		try {
			if(StockManagerDAO.getInstance().login(loginData)) {
			}else{
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}catch(Exception e) {

		}


		//indexからの推移の場合は、こちらの分岐
		if ("from-index".equals(request.getParameter("from"))) {
			System.out.println("indexからの分岐");
		}
		//stockmanagerからの推移の場合は、こちらの分岐
		if ("from-stockmanager".equals(request.getParameter("from"))) {
			//フォームからの入力を取得して、JavaBeansに格納
            ItemDataBeans idb = new ItemDataBeans();
            idb.setName(request.getParameter("name"));
            idb.setStock(Integer.parseInt(request.getParameter("stock")));
            //コンソールチェック用
            System.out.println("【stockmanager.java】stockmanager.jspで入力された登録商品名⇒"+request.getParameter("name"));
            session.setAttribute("idb", idb);
            System.out.println("Session updated!!");
            try {
            	//DBへデータの挿入
				StockManagerDAO.getInstance().insert(idb);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		//全件検索の指示をDAOに出す
		System.out.println("全件検索へ");
		try {
			List<ItemDataBeans> resultData = StockManagerDAO.getInstance().searchAll();
			session.setAttribute("resultData", resultData);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		System.out.println("jspに投げる直前");
		request.getRequestDispatcher("/stockmanager.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
