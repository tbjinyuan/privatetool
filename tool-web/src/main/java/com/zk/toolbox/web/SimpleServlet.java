package com.zk.toolbox.web;


/**
 * Created by zhengke on 16/9/3.
 */

import com.zk.toolbox.biz.SimpleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet {

   @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      PrintWriter out = response.getWriter();

      String serviceDesc = SimpleService.getServiceDescription();
      out.println(serviceDesc);
      out.flush();
      out.close();

   }
}
