<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Index</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>	
	<div class="container">
  <h2>CRUD</h2>         
  <table class="table table-hover">
    <thead>
      <tr>
      	<th>No</th>
        <th>Category Name</th>
        <th>Description</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <tr>
      	<td>1</td>
        <td>Category Name</td>
        <td>Description Category</td>
        <td>
        	<button type="button" class="btn btn-warning">Update</button>
			<button type="button" class="btn btn-danger">Delete</button>
        </td>
      </tr>
      <tr>
      	<td>2</td>
        <td>Category Name</td>
        <td>Description Category</td>
        <td>
        	<button type="button" class="btn btn-warning">Update</button>
			<button type="button" class="btn btn-danger">Delete</button>
        </td>
      </tr>
      <tr>
      	<td>3</td>
        <td>Category Name</td>
        <td>Description Category</td>
        <td>
        	<button type="button" class="btn btn-warning">Update</button>
			<button type="button" class="btn btn-danger">Delete</button>
        </td>
      </tr>
    </tbody>
  </table>
  <ul class="pagination">
	  <li class="active"><a href="#">1</a></li>
	  <li><a href="#">2</a></li>
	  <li><a href="#">3</a></li>
	  <li><a href="#">4</a></li>
	  <li><a href="#">5</a></li>
	</ul>

</div>
</body>
</html>