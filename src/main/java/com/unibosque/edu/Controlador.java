package com.unibosque.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controlador() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");
		

		switch (menu) {
		case "Principal":
			request.getRequestDispatcher("/Principal.jsp").forward(request, response);
			break;
			
		case "Usuarios":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Usuarios> lista = TestJSON.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Usuarios usuario = new Usuarios();
				usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
				usuario.setNombre_usuario(request.getParameter("txtnombre"));
				usuario.setEmail_usuario(request.getParameter("txtemail"));
				usuario.setUsuario(request.getParameter("txtusuario"));
				usuario.setPassword(request.getParameter("txtpassword"));

				int respuesta = 0;
				try {
					respuesta = TestJSON.postJSON(usuario);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Usuarios usuario = new Usuarios();
				usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
				usuario.setNombre_usuario(request.getParameter("txtnombre"));
				usuario.setEmail_usuario(request.getParameter("txtemail"));
				usuario.setUsuario(request.getParameter("txtusuario"));
				usuario.setPassword(request.getParameter("txtpassword"));

				int respuesta = 0;
				try {
					respuesta = TestJSON.putJSON(usuario, usuario.getCedula_usuario());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Usuarios> lista1 = TestJSON.getJSON();
					System.out.println("Parametro: " + id);
					for (Usuarios usuarios:lista1) {
						if (usuarios.getCedula_usuario() == id) {
							request.setAttribute("usuarioSeleccionado", usuarios);
							request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = TestJSON.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
			break;
			
		case "Clientes":
			
			if (accion.equals("Listar")) {
				try {
					ArrayList<Clientes> lista = clientesJSON.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Clientes cliente = new Clientes();
				cliente.setCedula_cliente(Long.parseLong(request.getParameter("txtcedula_cliente")));
				cliente.setNombre_cliente(request.getParameter("txtnombre_cliente"));
				cliente.setEmail_cliente(request.getParameter("txtemail_cliente"));
				cliente.setDireccion_cliente(request.getParameter("txtdireccion_cliente"));
				cliente.setTelefono_cliente(request.getParameter("txttelefono_cliente"));

				int respuesta = 0;
				try {
					respuesta = clientesJSON.postJSON(cliente);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Clientes cliente = new Clientes();
				cliente.setCedula_cliente(Long.parseLong(request.getParameter("txtcedula_cliente")));
				cliente.setNombre_cliente(request.getParameter("txtnombre_cliente"));
				cliente.setEmail_cliente(request.getParameter("txtemail_cliente"));
				cliente.setDireccion_cliente(request.getParameter("txtdireccion_cliente"));
				cliente.setTelefono_cliente(request.getParameter("txttelefono_cliente"));

				int respuesta = 0;
				try {
					respuesta = clientesJSON.putJSON(cliente, cliente.getCedula_cliente());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Clientes> lista1 = clientesJSON.getJSON();
					System.out.println("Parametro: " + id);
					for (Clientes clientes : lista1) {
						if (clientes.getCedula_cliente() == id) {
							request.setAttribute("clienteSeleccionado", clientes);
							request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = clientesJSON.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
			break;
			
			
		case "Proveedores":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Proveedores> lista = proveedoresJSON.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNitproveedor(Long.parseLong(request.getParameter("txtnitproveedor")));
				proveedor.setCiudad_proveedor(request.getParameter("txtciudad_proveedor"));
				proveedor.setDireccion_proveedor(request.getParameter("txtdireccion_proveedor"));
				proveedor.setNombre_proveedor(request.getParameter("txtnombre_proveedor"));
				proveedor.setTelefono_proveedor(request.getParameter("txttelefono_proveedor"));

				int respuesta = 0;
				try {
					respuesta = proveedoresJSON.postJSON(proveedor);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Proveedores proveedor = new Proveedores();
				proveedor.setNitproveedor(Long.parseLong(request.getParameter("txtnitproveedor")));
				proveedor.setCiudad_proveedor(request.getParameter("txtciudad_proveedor"));
				proveedor.setDireccion_proveedor(request.getParameter("txtdireccion_proveedor"));
				proveedor.setNombre_proveedor(request.getParameter("txtnombre_proveedor"));
				proveedor.setTelefono_proveedor(request.getParameter("txttelefono_proveedor"));

				int respuesta = 0;
				try {
					respuesta = proveedoresJSON.putJSON(proveedor, proveedor.getNitproveedor());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Proveedores> lista1 = proveedoresJSON.getJSON();
					System.out.println("Parametro: " + id);
					for (Proveedores proveedores : lista1) {
						if (proveedores.getNitproveedor() == id) {
							request.setAttribute("proveedorSeleccionado", proveedores);
							request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = proveedoresJSON.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
			break;
						
			
		case "Productos":
			if (accion.equals("Listar")) {
				try {
					ArrayList<Productos> lista = productosJSON.getJSON();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Agregar")) {
				Productos producto = new Productos();
				producto.setCodigo_producto(Long.parseLong(request.getParameter("txtcodigo_producto")));
				producto.setIvacompra(Long.parseLong(request.getParameter("txtivacompra")));
				producto.setNitproveedor(Long.parseLong(request.getParameter("txtnitproveedor")));
				producto.setNombre_producto(request.getParameter("txtnombre_producto"));
				producto.setPrecio_compra(Long.parseLong(request.getParameter("txtprecio_compra")));
				producto.setPrecio_venta(Long.parseLong(request.getParameter("txtprecio_venta")));

				int respuesta = 0;
				try {
					respuesta = productosJSON.postJSON(producto);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Actualizar")) {
				Productos producto = new Productos();
				producto.setCodigo_producto(Long.parseLong(request.getParameter("txtcodigo_producto")));
				producto.setIvacompra(Long.parseLong(request.getParameter("txtivacompra")));
				producto.setNitproveedor(Long.parseLong(request.getParameter("txtnitproveedor")));
				producto.setNombre_producto(request.getParameter("txtnombre_producto"));
				producto.setPrecio_compra(Long.parseLong(request.getParameter("txtprecio_compra")));
				producto.setPrecio_venta(Long.parseLong(request.getParameter("txtprecio_venta")));

				int respuesta = 0;
				try {
					respuesta = productosJSON.putJSON(producto, producto.getCodigo_producto());
					PrintWriter write = response.getWriter();

					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Cargar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				try {
					ArrayList<Productos> lista1 = productosJSON.getJSON();
					System.out.println("Parametro: " + id);
					for (Productos productos : lista1) {
						if (productos.getCodigo_producto() == id) {
							request.setAttribute("productoSeleccionado", productos);
							request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
									response);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (accion.equals("Eliminar")) {
				Long id = Long.parseLong(request.getParameter("id"));
				int respuesta = 0;
				try {
					respuesta = productosJSON.deleteJSON(id);
					PrintWriter write = response.getWriter();
					if (respuesta == 200) {
						request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
								response);
					} else {
						write.println("Error: " + respuesta);
					}
					write.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/Productos.jsp").forward(request, response);
			break;
			
			
		case "Ventas":
			request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
			break;
			
			
		}
	}
}