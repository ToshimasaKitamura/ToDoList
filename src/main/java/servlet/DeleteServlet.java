package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DeleteDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete-servlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Getリクエストを受け付けてTodoを削除する
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// リクエストパラメータから削除するTodoのidを取得する
    	int id = Integer.parseInt(request.getParameter(constant.Parameters.TODO_ID));

    	DeleteDAO dao = new DeleteDAO();
    	try {
    		// todoを削除する
    		dao.deleteTodo(id);
    	} catch(SQLException | ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	response.sendRedirect("list-servlet");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
