<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="entity.Car" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Cars</title>
</head>
<body>

<h2>Список автомобилей</h2>

<table border="1">
    <tr>
        <th>Производитель</th>
        <th>Модель</th>
        <th>Двигатель</th>
        <th>Год</th>
        <th>Цвет</th>
        <th>Тип</th>
    </tr>

<%
    List<Car> cars = (List<Car>) request.getAttribute("cars");
    for (Car c : cars) {
%>
    <tr>
        <td><%= c.getManufacturer() %></td>
        <td><%= c.getModel() %></td>
        <td><%= c.getEngineVolume() %></td>
        <td><%= c.getYear() %></td>
        <td><%= c.getColor() %></td>
        <td><%= c.getType() %></td>
    </tr>
<%
    }
%>

</table>

<br>
<a href="index.jsp">Назад</a>

</body>
</html>
