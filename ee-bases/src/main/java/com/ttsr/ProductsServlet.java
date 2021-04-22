package com.ttsr;

import com.ttsr.persist.ProductRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "productsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {

    private static ProductRepo productRepo;

    @Override
    public void init() throws ServletException {
        productRepo = (ProductRepo) getServletContext().getAttribute("productRepo");
        if(productRepo == null){
            throw new ServletException("ProductRepo not initialized");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productRepo.findAll());
        resp.getWriter().println("Some text");
        getServletContext().getRequestDispatcher("/WEB-INF/product.jsp").forward(req,resp);
    }
}
