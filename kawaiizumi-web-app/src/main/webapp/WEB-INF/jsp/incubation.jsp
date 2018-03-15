<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >

<head>
  <meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Responsive Table</title>
  
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
      <link rel="stylesheet" href="css/style.css">
  
</head>

<body>

  <div class="wrap">
    <p class="intro">&lt; Responsive comparison table, decrease/increase browser width to see it in action &gt;</p>
    <h3 class="table-title">Comparison Table:</h3>
    <table class="comparison-table">
        <thead>
            <tr>
                <td></td>
                <td></td>
                <td class="marker">Package 1</td>
                <td class="marker">Package 2</td>
                <td class="marker">Package 3</td>
            </tr>
        </thead>
        <tr>
            <td>Item 1</td>
            <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Provident laudantium.</td>
            <td class="marker">✔</td>
            <td class="marker">✔</td>
            <td class="marker">✔</td>
        </tr>
        <tr>
            <td>Item 2</td>
            <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quasi quaerat.</td>
            <td class="marker">✔</td>
            <td class="marker">✔</td>
            <td class="marker">✔</td>
        </tr>
        <tr>
            <td>Item 3</td>
            <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Neque maxime.</td>
            <td class="marker">✔</td>
            <td class="marker">✔</td>
            <td class="marker">✔</td>
        </tr>
        <tr>
            <td>Item 4</td>
            <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nemo hic.</td>
            <td class="marker">✔</td>
            <td class="marker">✔</td>
            <td class="marker">✔</td>
        </tr>
        <tr>
            <td>Item 5</td>
            <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam laborum!</td>
            <td class="marker">✔</td>
            <td class="marker">✔</td>
            <td class="marker">✔</td>
        </tr>
        <tr>
            <td>Item 6</td>
            <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ea quidem.</td>
            <td class="marker">✖</td>
            <td class="marker">✔</td>
            <td class="marker">✔</td>
        </tr>
        <tr>
            <td>Item 7</td>
            <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nam minus.</td>
            <td class="marker">✖</td>
            <td class="marker">✖</td>
            <td class="marker">✔</td>
        </tr>
        <tr>
            <td>Item 8</td>
            <td>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloribus nostrum?</td>
            <td class="marker">✖</td>
            <td class="marker">✖</td>
            <td class="marker">✔</td>
        </tr>
    </table>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script  src="js/index.js"></script>
</body>

</html>
