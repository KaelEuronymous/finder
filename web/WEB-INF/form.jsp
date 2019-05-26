<%--
    Document   : index
    Created on : 25/08/2018, 04:10:22 PM
    Author     : cross
--%>
<%@page import="java.util.List"%>
<%@ page import="com.dashboard.model.Heroes" %>
<%@ page import="com.dashboard.dao.HeroesData" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Actualización de Usuarios</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/personal.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/vegas.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/styles.css">

</head>

<%
    String typeForm = (String) request.getAttribute("typeForm");
    Heroes hero = null;

    if (typeForm.equals("update")) {
        hero = (Heroes) request.getAttribute("hero");

    }
    HeroesData data = new HeroesData();
    List<Heroes> listpublish = data.comboPublisher();
    List<Heroes> listalignment = data.comboAlignment();
    List<Heroes> listrace = data.comboRace();

%>
<body>
<jsp:include page="../layouts/header.jsp"></jsp:include>

<div class="page-content">
    <div class="row">
        <div>
            <div class="row">
                <div>
                    <div class="content-box-large">

                        <div class="panel-heading">

                            <div class="panel-title">
                                <% if (typeForm.equals("update")) {
                                    out.print("Update Hero");
                                } else {
                                    out.print("Add Hero");
                                }%>
                            </div>

                        </div>
                        <div class="panel-body">



                            <form class="form-group" role="form" action="heroes" method="post">

                                <div class="form-group">
                                    <input type="hidden" name="action" value="<%= typeForm%>">
                                    <div class="col-lg-1">
                                        <div class="input-group-prepend">
                                            <span>ID Usuario</span>
                                        </div>
                                        <input required type="number" class="form-control" name="id" value="<% if (typeForm.equals("update")) {
                                                        out.print(hero.getHeroid());
                                                    } %>"<% if (typeForm.equals("update")) {
                                                            out.print("readonly");
                                                        } %>>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-3">
                                        <span>Hero Name</span>
                                        <input required type="text" class="form-control" name="name"  placeholder="Hero Name" value="<% if (typeForm.equals("update")) {
                                                           out.print(hero.getHeroname());} %>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-2">
                                        <span>Eyes Color</span>
                                        <input required type="text" class="form-control" name="eyes"  placeholder="Color Eyes" value="<% if (typeForm.equals("update")) {
                                                           out.print(hero.getEyecolor());
                                                       }%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-2">
                                        <span>Hair Color</span>
                                        <input required type="text" class="form-control" name="hair"  placeholder="Color Hair" value="<% if (typeForm.equals("update")) {
                                                           out.print(hero.getHaircolor());
                                                       }%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-2">
                                        <span>Skin Color</span>
                                        <input required type="text" class="form-control" name="skin"  placeholder="Color Skin" value="<% if (typeForm.equals("update")) {
                                                           out.print(hero.getSkincolor());
                                                       }%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-1">
                                        <span>Height</span>
                                        <input required type="number" class="form-control" name="height"  placeholder="cm" value="<% if (typeForm.equals("update")) {
                                                           out.print(hero.getHeight());
                                                       }%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-1">
                                        <span>Weight</span>
                                        <input required type="number" class="form-control" name="weight"  placeholder="" value="<% if (typeForm.equals("update")) {
                                                           out.print(hero.getWeight());
                                                       }%>">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-2">
                                        <span>Race</span>
                                        <select class="custom-select" id="inputGroupSelect00" name="race">
                                            <%  for (Heroes race : listrace) {%>
                                            <option value="<%= race.getRace()%>"><%= race.getRace()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-2">
                                        <span>Publisher House</span>
                                        <select class="custom-select" id="inputGroupSelect01" name="pub">
                                            <%  for (Heroes pub : listpublish) {%>
                                            <option value="<%= pub.getPublisherid()%>"><%= pub.getPublishername()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-lg-1">
                                        <span>Gender</span>
                                        <select class="custom-select" id="inputGroupSelect02" name="genderid">
                                            <option value="1">Female</option>
                                            <option value="2">Male</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-1">
                                        <span>Alignment</span>
                                        <select class="custom-select" id="inputGroupSelect03" name="alignmentid">
                                            <%  for (Heroes ali : listalignment) {%>
                                            <option value="<%= ali.getAlignmentid()%>"><%= ali.getAlignmentname()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>

                                <div>
                                    <div>
                                        <span></span>
                                        <button type="submit" class="col-md-2 col-md-offset-5 btn-primary btn"><%= typeForm%></button>
                                        <a class="col-md-2 col-md-offset-5 btn-primary btn" href="heroes">Back</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
</div>

<jsp:include page="../layouts/footer.jsp"></jsp:include>
</body>
</html>