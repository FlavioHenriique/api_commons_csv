package com.mycompany.teste;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@WebServlet(name = "front", urlPatterns = {"/front"})
public class front extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet front</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet front at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Reader reader = Files.newBufferedReader(Paths.get("/home/flavio/planilha.csv"),
                Charset.forName("ISO-8859-1"));
        CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withQuote('"'));

        Iterator<CSVRecord> iterator = parser.iterator();

        List<String[]> linhas = new ArrayList<>();
        
        String[] linha1 = iterator.next().get(0).split("\t");
        linhas.add(linha1);
        
        for (int k = 0; k < 1000; k++) {
            String[] linha = iterator.next().get(0).split("\t");
            
            if(linha.length == linha1.length){   
                linhas.add(linha);
            }
        }
        System.out.println(System.getProperty("user.dir"));
        request.setAttribute("dados", linhas);
        
        RequestDispatcher d = request.getRequestDispatcher("index.jsp");
        d.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
