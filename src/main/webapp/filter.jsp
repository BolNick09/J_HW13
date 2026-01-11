<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Фильтр</title>
</head>
<body>

<h2>Фильтр автомобилей</h2>

<form action="filter" method="get">
    Производитель: <input name="manufacturer"><br>
    Цвет: <input name="color"><br>
    Тип:
    <select name="type">
        <option value="">---</option>
        <option value="sedan">Sedan</option>
        <option value="hatchback">Hatchback</option>
        <option value="wagon">Wagon</option>
    </select><br>

    Год от: <input name="from" type="number">
    до: <input name="to" type="number"><br><br>

    <button type="submit">Фильтровать</button>
</form>

</body>
</html>
