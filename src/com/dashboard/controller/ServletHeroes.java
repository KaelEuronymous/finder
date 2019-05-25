package com.dashboard.controller;

import com.dashboard.dao.HeroesData;
import com.dashboard.model.Heroes;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletHeroes", urlPatterns = {"/heroes"})
public class ServletHeroes extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");

            switch (action) {
                case "create":
                    formNew(request, response);
                    break;

                case "update":
                    formEdit(request, response);
                    break;
            }

        } else {
            HeroesData data = new HeroesData();
            List<Heroes> listHero = data.ListHeroes();
            request.setAttribute("hero", listHero);
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");

            switch (action) {
                case "create":
                    insertHero(request, response);
                    break;

                case "search":
                    searchHero(request, response);
                    break;

                case "delete":
                    deleteHero(request, response);
                    break;

                case "update":
                    updateHero(request, response);
                    break;
            }

        }
    }

    private void formNew(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("typeForm", "create");
        request.getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
    }

    private void formEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer heroid = Integer.parseInt(request.getParameter("heroid"));

        HeroesData daohero = new HeroesData();
        Heroes heroe = daohero.findByID(heroid);

        if (heroe != null) {
            request.setAttribute("typeForm", "update");
            request.setAttribute("hero", heroe);
            request.getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);

        }

    }

    private void searchHero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Integer pubid = Integer.parseInt(request.getParameter("pub"));
        Integer alid = Integer.parseInt(request.getParameter("alignmetnid"));
        String race = request.getParameter("race");

        HeroesData herodao = new HeroesData();
        List<Heroes> message = herodao.findByData(new Heroes(pubid, alid, race));
        request.setAttribute("hero", message);
        request.getRequestDispatcher("heroes");
        response.sendRedirect("heroes");
    }

    private void insertHero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer heroid = Integer.parseInt(request.getParameter("id"));
        String namehero = request.getParameter("name");
        String eyecolor = request.getParameter("eyes");
        String haircolor = request.getParameter("hair");
        String skincolor = request.getParameter("skin");
        Integer height = Integer.parseInt(request.getParameter("height"));
        Integer weight = Integer.parseInt(request.getParameter("weight"));
        String race = request.getParameter("race");
        Integer publisher = Integer.parseInt(request.getParameter("pub"));
        Integer genderid = Integer.parseInt(request.getParameter("genderid"));
        Integer alignmentid = Integer.parseInt(request.getParameter("alignmetnid"));

        System.out.println(heroid+namehero);

        HeroesData herodao = new HeroesData();
        String message = herodao.insert(new Heroes(heroid, namehero, eyecolor, haircolor, skincolor, height, weight, race, publisher, genderid, alignmentid));
        System.out.println(heroid+namehero+eyecolor);
        request.getSession().setAttribute("op_hero", message);
        response.sendRedirect("heroes");
    }


    private void updateHero(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer heroid = Integer.parseInt(request.getParameter("id"));
        String namehero = request.getParameter("name");
        String eyecolor = request.getParameter("eyes");
        String haircolor = request.getParameter("hair");
        String skincolor = request.getParameter("skin");
        Integer height = Integer.parseInt(request.getParameter("height"));
        Integer weight = Integer.parseInt(request.getParameter("weight"));
        String race = request.getParameter("race");
        Integer publisher = Integer.parseInt(request.getParameter("pub"));
        Integer genderid = Integer.parseInt(request.getParameter("genderid"));
        Integer alignmentid = Integer.parseInt(request.getParameter("alignmentid"));

        HeroesData daohero = new HeroesData();
        String message = daohero.update(new Heroes(heroid,namehero,eyecolor,haircolor,skincolor, height, weight, race, publisher, genderid, alignmentid));
        request.getSession().setAttribute("hero", message);
        response.sendRedirect("heroes");

    }

    private void deleteHero(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        Integer heroid = Integer.parseInt(request.getParameter("heroid"));
        HeroesData daohero = new HeroesData();
        String mensaje = daohero.delete(new Heroes(heroid));
        request.getSession().setAttribute("hero", mensaje);
        response.sendRedirect("heroes");

    }


}