<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.unibosque.edu.Productos"%>
<%@page import="java.util.ArrayList"%>    
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Creacion de productos</title>
</head>
<body>

<div class="row">
   <div class="card col-md-4">
       <div class="card-body">
           <h5 class="card-title">Productos</h5>
           <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los productos de la tienda</h6>
           <div>
     		 <form class="form-sign" method="get" action="Controlador">
      		      
		        <div class="form-group">
		         <input type="hidden" name="menu" value="Productos">
		         <label>Codigo producto:</label>
		         <input type="text" name="txtcodigo_producto" class="form-control" value="${productoSeleccionado.getCodigo_producto()}">
		        </div>
		        <div class="form-group">
		         <label>Iva Compra:</label>
				<input type="text" name="txtivacompra" class="form-control" value="${productoSeleccionado.getIvacompra()}">
		        </div>
		        <div class="form-group">
		         <label>Nit proveedor:</label>
		         <input type="text" name="txtnitproveedor" class="form-control" value="${productoSeleccionado.getNitproveedor()}">
		        </div>
		        <div class="form-group">
		         <label>Nombre producto:</label>
		         <input type="text" name="txtnombre_producto" class="form-control" value="${productoSeleccionado.getNombre_producto()}">
                   </div>
		        <div class="form-group">
		        <label>Precio compra:</label>
		         <input type="text" name="txtprecio_compra" class="form-control" value="${productoSeleccionado.getPrecio_compra()}">
		        </div>
		        <div class="form-group">
		        <label>Precio venta:</label>
		         <input type="text" name="txtprecio_venta" class="form-control" value="${productoSeleccionado.getPrecio_venta()}">
		        </div>
		        <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
		        <input type="submit" class="btn btn-success" name="accion" value="Actualizar">
       	 </form>
    </div>
  </div>
  </div>
 <div class="col-md-8">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Codigo producto</th>
                <th scope="col">Iva Compra</th>
                <th scope="col">Nit proveedor</th>
                <th scope="col">Nombre producto</th>
                <th scope="col">Precio compra</th>
                <th scope="col">Precio venta</th>
           </tr>
        </thead>
        <tbody>
            <% ArrayList<Productos> lista= (ArrayList<Productos>) request.getAttribute("lista");
			for (Productos producto : lista){
			%>
			<tr>
				<td><%=producto.getCodigo_producto()%></td>
				<td><%=producto.getIvacompra()%></td>
				<td><%=producto.getNitproveedor()%></td>
				<td><%=producto.getNombre_producto()%></td>
				<td><%=producto.getPrecio_compra()%></td>
				<td><%=producto.getPrecio_venta()%></td>
				<td> 
	               <a class="btn btn-warning" href="Controlador?menu=Productos&accion=Cargar&id=<%=producto.getCodigo_producto()%>">Editar</a>
	               <a class="btn btn-danger" href="Controlador?menu=Productos&accion=Eliminar&id=<%=producto.getCodigo_producto()%>">Eliminar</a>
            	</td>
            </tr>
            <%}%>
        </tbody>
    </table>
</div>
<!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script> </body> </html>