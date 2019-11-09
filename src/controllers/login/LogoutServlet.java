package controllers.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    // ログアウト処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // セッションスコープのlogin_employee破棄
        request.getSession().removeAttribute("login_employee");

        // ログアウト完了メッセージ
        request.getSession().setAttribute("flush", "ログアウトしました。");

        // ログインページにリダイレクト
        response.sendRedirect(request.getContextPath() + "/login");
    }

}
