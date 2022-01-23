/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;

/**
 *
 * @author user
 */
@WebServlet(name = "LoginCotroller", urlPatterns = {"/login"})
public class LoginCotroller extends HttpServlet{
    UserService userService;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  boolean status = userService.doLogin(req);
        if(status ==  true){
           List<User> users = userService.getAll();
           req.setAttribute("users", users);
           req.getRequestDispatcher("view/welcome.jsp").forward(req, resp);
        }else{
            System.out.println("else part");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.getRequestDispatcher("view/login.jsp").forward(req, resp);

    }
    
    
}
