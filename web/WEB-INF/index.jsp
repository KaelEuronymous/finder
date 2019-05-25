<%@ page import="com.dashboard.model.Heroes" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dashboard.dao.HeroesData" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: cross
  Date: 12/05/19
  Time: 09:22 AM
  To change this template use File | Settings | File Templates.
--%>

<html>
  <head>
    <title>Hero Management</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/personal.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/vegas.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/styles.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">

    <%
      HeroesData data = new HeroesData();
      List<Heroes> listpublish = data.comboPublisher();
      List<Heroes> listalignment = data.comboAlignment();
      List<Heroes> listrace = data.comboRace();
      List<Heroes> herolist = (List<Heroes>) request.getAttribute("hero");

    %>

  </head>
  <body>

  <jsp:include page="../layouts/header.jsp"></jsp:include>


  <div class="page-content">

    <div class="row">
        <div class="row">
          <div class="col-md-12">
            <div class="content-box-large">

              <form action="heroes" method="post">
                  <table>
                    <thead>

                    <tr>
                      <th>
                        <div>
                          <label class="input-group-text" for="inputGroupSelect01">Publisher</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01" name="pub">
                          <%  for (Heroes pub : listpublish) {%>
                          <option value="<%= pub.getPublisherid()%>"><%= pub.getPublishername()%></option>
                          <%}%>
                        </select>
                      </th>
                      <th>
                        <div>
                          <label for="inputGroupSelect02">Alignment</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect02" name="alignmentid">
                          <%  for (Heroes ali : listalignment) {%>
                          <option value="<%= ali.getAlignmentid()%>"><%= ali.getAlignmentname()%></option>
                          <%}%>
                        </select>
                      </th>
                      <th>
                        <div>
                          <label for="inputGroupSelect03">Race</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect03" name="race">
                          <%  for (Heroes race : listrace) {%>
                          <option value="<%= race.getRace()%>"><%= race.getRace()%></option>
                          <%}%>
                        </select>
                      </th>
                      <th>
                        <div>
                          <label>-----------</label>
                        </div>
                        <form action="heroes" method="get">
                          <input type="hidden" name="action" value="search">
                          <input type="submit" value="Search" class="btn btn-primary">
                        </form>
                      </th>
                    </tr>
                    </thead>
                  </table>
              </form>

              <div class="panel-heading">
                <div class="panel-title"><h2>Heroes</h2></div>
              </div>
              <div class="panel-body">
                <table class="table">
                  <thead>
                  <tr>
                    <th>Hero Name</th>
                    <th>Hero Race</th>
                    <th>Hero Alignment</th>
                    <th>Hero Publisher House</th>
                  </tr>
                  <%for (Heroes list : herolist){%>
                  <tr>
                    <td><%= list.getHeroname()%></td>
                    <td><%= list.getRace()%></td>
                    <td><%= list.getAlignmentname()%></td>
                    <td><%= list.getPublishername()%></td>
                    <td>
                      <a href="heroes?action=update&heroid=<%= list.getHeroid()%>"  class="btn btn-primary" >Update</a>
                    </td>
                    <td>
                      <form action="heroes" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="heroid" value="<%= list.getHeroid()%>">
                        <input type="submit" value="Delete" class="btn btn-danger">
                      </form>
                    </td>
                    <%}%>
                    </tr>
                  </thead>
                  <tbody>
                  <tr>


                  </tr>

                  </tbody>
                </table>
                <a href="heroes?action=create" class="btn btn-primary btn">Add Hero</a>
              </div>
          </div>

        </div>
      </div>
    </div>
  </div>


  </body>
  <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/custom.js"></script>
  <script src="http://code.jquery.com/jquery.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/vegas.js"></script>
  <script type="text/javascript">
    $("#example, body").vegas({
      slides: [
        {src: "<%=request.getContextPath()%>/resources/img/1.jpg"},
        {src: "<%=request.getContextPath()%>/resources/img/2.jpg"},
        {src: "<%=request.getContextPath()%>/resources/img/3.jpg"},
        {src: "<%=request.getContextPath()%>/resources/img/4.jpg"}
      ],
      animation: 'random',
      overlay: 'resources/overlays/03.png'
    });
  </script>
</html>