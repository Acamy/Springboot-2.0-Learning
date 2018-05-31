import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTestServlet extends HttpServlet {
    private DataSource ds;
    public void init(ServletConfig servletConfig) throws ServletException {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context)initContext.lookup("java:comp/env");

            ds = (DataSource)envContext.lookup("jdbc/TestDB");


        } catch (NamingException e) {
            e.printStackTrace();
        }

    }


    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        Writer writer = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try {
            Connection conn = ds.getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SHOW DATABASES");
            while (rs.next()){
                String dbName = rs.getString(1);
                writer.write(dbName + "<br />");
                writer.flush();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
