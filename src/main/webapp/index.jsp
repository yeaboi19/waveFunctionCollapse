<%@ page import="tableClasses.Table" %>
<%@ page import="Manager.TableManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>doodoo</title>
    <link rel="stylesheet" href="styling/index.css"/>
    <%
        int sizeX;
        if(request.getParameter("xSlider")==null)sizeX=25;
        else sizeX = Integer.parseInt(request.getParameter("xSlider"));
        int sizeY;
        if(request.getParameter("ySlider")==null)sizeY=25;
        else sizeY = Integer.parseInt(request.getParameter("ySlider"));
        TableManager tableManager = new TableManager(new Table(sizeX, sizeY));
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                tableManager.setCell(j, i, tableManager.getRandomType(j, i));
            }
        }
        Table table = tableManager.getTable();
    %>
    <script>
        console.log(<%= sizeX %>);
        console.log(<%= sizeY %>);
        console.log(<%= request.getParameter("xSlider")%>);
        console.log(<%= request.getParameter("ySlider")%>);
    </script>
</head>
<body>
<div class="tableBorder">
    <table class="centerTable" style="border-spacing: 0;border-collapse: collapse">
        <% for (int i = 0; i < sizeY; i++) {%>
        <tr <%--class="tableBorder"--%>>
            <% for (int j = 0; j < sizeX; j++) {%>
            <% tableManager.setCell(j, i, tableManager.getRandomType(j, i));%>
            <td style="width: 15px;height: 15px">
                <img alt="functionImage" src="<%= table.getCellURL(j,i) %>" style="width: 15px; height: 15px"
                     title="<%= table.getCell(j,i).getOptions() + " " + j + "- j || "+ i + "- i"%>">
            </td>
            <%}%>
        </tr>
        <%}%>
    </table>
</div>
<div class="centerTable">
    <form name="sliderForm" method="post" action="SliderManager">
        <p>X axis size</p>
        <label for="xSlider"></label><input type="range" min="1" max="250" value="<%= sizeX %>" name="xSlider" id="xSlider">
        <p>Value :<a id="X_value"><%= sizeX %></a></p>
        <p>Y axis size</p>
        <label for="ySlider"></label><input type="range" min="1" max="250" value="<%= sizeY %>" name="ySlider" id="ySlider">
        <p>Value :<a id="Y_value"><%= sizeY %></a></p>
        <script>
            let X_Slider = document.getElementById("xSlider");
            let Y_Slider = document.getElementById("ySlider");
            let X_Value = document.getElementById("X_value");
            let Y_Value = document.getElementById("Y_value");
            X_Slider.oninput = function () {
                X_Value.innerHTML = this.value;
            }
            Y_Slider.oninput = function () {
                Y_Value.innerHTML = this.value;
            }
        </script>
        <button type="submit">submit</button>
    </form>
</div>
</body>
</html>
