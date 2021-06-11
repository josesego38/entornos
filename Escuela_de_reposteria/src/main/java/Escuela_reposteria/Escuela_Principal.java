package Escuela_reposteria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Escuela_Principal {

	private static Connection conexion;

	private static String nivel() {
		Scanner t = new Scanner(System.in);
		boolean solu = true;

		System.out.println("Para saber cual es tu nivel en reposteria deberas responder al siguiente formulario:");
		System.out.println(
				"Recuerda responder a todas las preguntas con: true si tu respuesta es afirmativa y false si es negativa");

		System.out.println("¿Has realizado algun postre o receta relacionada con la reposteria?");
		solu = t.nextBoolean();

		if (solu == true) {
			System.out.println("¿Has realizado con exito las recetas que en el pasado has intentado elaborar?");
			solu = t.nextBoolean();

			if (solu == true) {
				System.out.println("¿Tienes alguna formación academica en el ambito de la reposteria?");
				solu = t.nextBoolean();

				if (solu == true) {
					System.out.println(
							"¿Tienes experiencia laborar en la reposteria(Si has realizado prácticas en alguna empresa de repostria,"
									+ " puedes incluirlas como experiencia laboral.)?");
					solu = t.nextBoolean();

					if (solu == true) {
						System.out.println("En base a tus respuesta, tu nivel en la respoteria es: Experto");
						return "Experto";
					} else {
						System.out.println("Dado a que tienes formación pero no tienes experiencia laboral,"
								+ "tu nivel en resposteria es: Avanzado");
						return "Avanzado";
					}
				} else {
					System.out.println("¿Sabes leer e interpretar una receta con exito? ");
					solu = t.nextBoolean();
					if (solu == true) {
						System.out.println(
								"En funcion de tus respuestas creemos que tu nivel de reposteria es: Intermedio");
						return "Intermedio";
					} else {
						System.out.println("Cuando haces elaboraciones ¿Sientes que no sabes como elaborar la receta?");
						solu = t.nextBoolean();
						if (solu == true) {
							System.out.println("En funcion de tus respuestas creemos que tu nivel es: Principiante");
							return "Principiante";
						} else {
							System.out.println(
									"En funcion de tus respuestas creemos que tu nivel de reposteria es: Intermedio");
							return "Intermedio";
						}
					}
				}
			} else {
				System.out.println(
						"Ya que nunca has realizado una receta de reposteria. ¿Te consideras un novato en esto de la respotería?");
				solu = t.nextBoolean();
				if (solu == true) {
					System.out.println(
							"En función de las respuestas que nos has proporcionado tu nivel en reposteria es: Principiante");
					return "Principiante";
				} else {
					System.out.println("¿Has realizado con exito las recetas que en el pasado has intentado elaborar?");
					solu = t.nextBoolean();
					if (solu == true) {
						System.out.println("¿Tienes conocimientos basico de reposteria?");
						solu = t.nextBoolean();
						if (solu == true) {
							System.out.println("¿Crees que serías capaz de llevar a cabo elaboraciones más complejas?");
							solu = t.nextBoolean();
							if (solu == true) {
								System.out.println(
										"En funcion de tus respuestas creemos que tu nivel de reposteria es: Intermedio");
								return "Intermedio";
							} else {
								System.out.println(
										"En funcion de tus respuestas creemos que tu nivel de reposteria es: Principiante");
								return "Principiante";
							}
						}
					} else {
						System.out.println("En funcion de tus respuestas creemos que tu nivel es: Principiante");
						return "Principiante";
					}

				}

			}
		}
		else {
			System.out.println("Ya que nunca has hecho nada relacionado con la reposteria, creemos que tu nivel es principiante");
		}
		return "Principiante";

	}

	private static String registrarse() throws SQLException {
		Scanner t = new Scanner(System.in);
		Statement st = conexion.createStatement();
		Usuarios nuevo = new Usuarios();
		System.out.println("Introduce tus datos de usuario");
		System.out.println("Nombre");
		nuevo.setNombre(t.next());
		System.out.println("Apellido");
		nuevo.setApellido(t.next());
		System.out.println("Fecha de nacimiento");
		nuevo.setFNacimiento(new Fecha(t.next()));
		System.out.println("DNI");
		nuevo.setDNI(t.next());
		System.out.println("Teléfono");
		nuevo.setTelefono(t.next());
		System.out.println("Contrasena");
		nuevo.setContrasena(t.next());
		System.out.println(
				"Para poder ofrecerte una mejor experiencia, nos gustaria saber cual es tu nivel a traves de un pequeno test");
		nuevo.setNivel(nivel());

		String query1;
		query1 = "insert into usuarios values(" + "default,'" + nuevo.getNombre() + "','" + nuevo.getApellido() + "','"
				+ nuevo.getFNacimiento().mysql() + "','" + nuevo.getDNI() + "','" + nuevo.getTelefono() + "','"
				+ nuevo.getContrasena() + "','" + nuevo.getNivel() + "');";
		System.out.println(query1);
		st.executeUpdate(query1);
		System.out.println("Ya has sido registrado en nuesta base de datos. Tus datos son los siguientes: " + query1);
		return query1;

	}

	private static String receta() throws SQLException {
		Connection conn = Conexion.AbrirConexion();
		Scanner t = new Scanner(System.in);
		Statement st = conn.createStatement();
		Recetas nuevo = new Recetas();
		nuevo.DatosRecetas();
		
		String query1 = "insert into `programacion`.`recetas` values(" + "default,'"+nuevo.getIdUsuario() + "','" + nuevo.getNivel() + "','" + nuevo.getTítulo() + "','"
				+ nuevo.getSabor() + "','" + nuevo.getTiempo() + "','" + nuevo.getTipo_postre()+ "','"
				 +nuevo.getNum_porciones() + "','" +nuevo.getValoracion()+"');";
		st.executeUpdate(query1);
		for(int i=0;i<nuevo.getIngredientes().length;i++) {
			
			String query11="INSERT INTO `programacion`.`ingredientes`(IdIngredientes, IdReceta,Ingredientes) VALUES ("+"DEFAULT," +"(select MAX(idRecetas) from recetas),'"+nuevo.getIngredientes()[i]+"');";
			st.executeUpdate(query11);
		}
		
		for (int i=0; i<nuevo.getProcedimiento().length; i++) {
			String query11="INSERT INTO `programacion`.`procedimiento`(idProcedimiento, IdReceta,Paso,procedimiento) VALUES ("+"DEFAULT," +"(select MAX(idRecetas) from recetas),"+"'"+(i+1)+"','"+nuevo.getProcedimiento()[i]+"');";
			st.executeUpdate(query11);
		}

	
		
		System.out.println("Ya has sido registrado en nuesta base de datos. Tus datos son los siguientes: " + query1);
		
		return query1;
	}

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		Connection conexion = Conexion.AbrirConexion();

		try {

			Statement st = conexion.createStatement();
			// La query1 será para introducir los datos en la tabla de los usuarios
			String query1 = "CREATE TABLE IF NOT EXISTS `programacion`.`usuarios` (\r\n"
					+ "  `idUsuarios` INT NOT NULL AUTO_INCREMENT,\r\n" + "  `Nombre` VARCHAR(45) NOT NULL,\r\n"
					+ "  `Apellido` VARCHAR(45) NULL,\r\n" + "  `FNacimiento` VARCHAR(45) NULL,\r\n"
					+ "  `DNI` VARCHAR(45) NOT NULL,\r\n" + "  `Telefono` VARCHAR(45) NULL,\r\n"
					+ "  `Contrasena` VARCHAR(45) NOT NULL,\r\n" + "  `Nivel` VARCHAR(45) NULL,\r\n"
					+ "  PRIMARY KEY (`idUsuarios`),\r\n"
					+ "  UNIQUE INDEX `idUsuarios_UNIQUE` (`idUsuarios` ASC) VISIBLE,\r\n"
					+ "  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC) VISIBLE);";
			st.executeUpdate(query1);

			// La query2 será para introducir los datos de la tabla de recetas
			String query2 = "CREATE TABLE IF NOT EXISTS `programacion`.`recetas` (\r\n"
					+ "  `idRecetas` int NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `IdUsuario` int NOT NULL,\r\n"
					+ "  `Nivel` varchar(45) NOT NULL,\r\n"
					+ "  `Titulo` varchar(45) NOT NULL,\r\n"
					+ "  `Sabor` varchar(45) NOT NULL,\r\n"
					+ "  `Tiempo` varchar(45) DEFAULT NULL,\r\n"
					+ "  `Tipo_postre` varchar(45) NOT NULL,\r\n"
					+ "  `Num_Porciones` int DEFAULT NULL,\r\n"
					+ "  `Valoracion` int NOT NULL,\r\n"
					+ "  PRIMARY KEY (`idRecetas`),\r\n"
					+ "  UNIQUE KEY `idRecetas_UNIQUE` (`idRecetas`),\r\n"
					+ "  UNIQUE KEY `Titulo_UNIQUE` (`Titulo`),\r\n"
					+ "  KEY `Usuario_idx` (`IdUsuario`),\r\n"
					+ "  KEY `Tit` (`Titulo`),\r\n"
					+ "  CONSTRAINT `IDUSU` FOREIGN KEY (`IdUsuario`) REFERENCES `usuarios` (`idUsuarios`)\r\n"
					+ ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
			st.executeUpdate(query2);

			// La query 3 será para introducir los datos de la tabla de articulos.
			String query3 = "CREATE TABLE IF NOT EXISTS `programacion`.`articulos` (\r\n"
					+ "  `idArticulos` INT NOT NULL AUTO_INCREMENT,\r\n" + "  `Marca` VARCHAR(45) NULL,\r\n"
					+ "  `Modelo` VARCHAR(45) NULL,\r\n" + "  `Precio` FLOAT NULL,\r\n" + "  `Stock` INT NULL,\r\n"
					+ "  PRIMARY KEY (`idArticulos`),\r\n"
					+ "  UNIQUE INDEX `idArticulos_UNIQUE` (`idArticulos` ASC) VISIBLE);";
			st.executeUpdate(query3);

			// La query 4 será para introducir los datos de la tabla de los pedidos.
			String query4 = "CREATE TABLE IF NOT EXISTS `programacion`.`pedidos` (\r\n"
					+ "  `idPedidos` INT NOT NULL AUTO_INCREMENT,\r\n" + "  `idUsuarios` INT NULL,\r\n"
					+ "  `idArticulos` INT NULL,\r\n" + "  `Importe` FLOAT NULL,\r\n" + "  `FPedido` DATE NULL,\r\n"
					+ "  `IdFactura` INT NULL,\r\n" + "  PRIMARY KEY (`idPedidos`),\r\n"
					+ "  INDEX `Usuario_idx` (`idUsuarios` ASC) VISIBLE,\r\n"
					+ "  INDEX `Ariculos_idx` (`idArticulos` ASC) VISIBLE,\r\n"
					+ "  INDEX `Factura_idx` (`IdFactura` ASC) VISIBLE,\r\n" + "  CONSTRAINT `Usuario`\r\n"
					+ "    FOREIGN KEY (`idUsuarios`)\r\n"
					+ "    REFERENCES `programacion`.`usuarios` (`idUsuarios`)\r\n" + "    ON DELETE NO ACTION\r\n"
					+ "    ON UPDATE NO ACTION,\r\n" + "  CONSTRAINT `Ariculos`\r\n"
					+ "    FOREIGN KEY (`idArticulos`)\r\n"
					+ "    REFERENCES `programacion`.`articulos` (`idArticulos`)\r\n" + "    ON DELETE NO ACTION\r\n"
					+ "    ON UPDATE NO ACTION,\r\n" + "  CONSTRAINT `Factura`\r\n"
					+ "    FOREIGN KEY (`IdFactura`)\r\n"
					+ "    REFERENCES `programacion`.`facturas` (`idFacturas`)\r\n" + "    ON DELETE NO ACTION\r\n"
					+ "    ON UPDATE NO ACTION);";
			st.executeUpdate(query4);

			// la query 5 será para la tabla que almacenará los ingredientes de las
			// distintas recetas:
			String query5 = "CREATE TABLE IF NOT EXISTS `programacion`.`ingredientes` (\r\n"
					+ "  `IdIngredientes` int NOT NULL AUTO_INCREMENT,\r\n" + "  `IdReceta` int NOT NULL,\r\n"
					+ "  `Ingredientes` varchar(100) DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`IdIngredientes`,`IdReceta`),\r\n" + "  KEY `Receta_idx` (`IdReceta`),\r\n"
					+ "  CONSTRAINT `IDreceta` FOREIGN KEY (`IdReceta`) REFERENCES `recetas` (`idRecetas`)\r\n"
					+ ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
			st.executeUpdate(query5);

			// la query 6 será para crear la tabla donde se almacenarán los procedimientos
			// de las recetas.

			String query6 = "CREATE TABLE IF NOT EXISTS `programacion`.`procedimiento` (\r\n"
					+ "  `idProcedimiento` int NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `idReceta` int NOT NULL,\r\n"
					+ "  `Paso` int DEFAULT NULL,\r\n"
					+ "  `Procedimiento` varchar(1000) DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`idProcedimiento`,`idReceta`),\r\n"
					+ "  KEY `receta_idx` (`idReceta`),\r\n"
					+ "  CONSTRAINT `receta` FOREIGN KEY (`idReceta`) REFERENCES `recetas` (`idRecetas`)\r\n"
					+ ") ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
			st.executeUpdate(query6);

			// la query 7 será para crear la tabla donde se almacenarán los datos de las
			// valoraciones.

			String query7 = "CREATE TABLE IF NOT EXISTS `programacion`.`valoraciones` (\r\n"
					+ "  `idvaloraciones` int NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre Receta` varchar(45) DEFAULT NULL,\r\n"
					+ "  `IdUsuario` int DEFAULT NULL,\r\n"
					+ "  `IdReceta` int DEFAULT NULL,\r\n"
					+ "  `Valoracion` int DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`idvaloraciones`),\r\n"
					+ "  KEY `TituloReceta_idx` (`Nombre Receta`),\r\n"
					+ "  KEY `Usuario_idx` (`IdUsuario`),\r\n"
					+ "  KEY `IdRece_idx` (`IdReceta`),\r\n"
					+ "  CONSTRAINT `IdRece` FOREIGN KEY (`IdReceta`) REFERENCES `recetas` (`idRecetas`),\r\n"
					+ "  CONSTRAINT `IDUsua` FOREIGN KEY (`IdUsuario`) REFERENCES `usuarios` (`idUsuarios`),\r\n"
					+ "  CONSTRAINT `TituloReceta` FOREIGN KEY (`Nombre Receta`) REFERENCES `recetas` (`Titulo`)\r\n"
					+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
			st.executeUpdate(query7);

			int opcion;
			int opc;
			String ValiUsu;
			do {
				System.out.println("¿Que quieres hacer?");
				System.out.println("1-Registrarte / modificar tus datos de usuario");
				System.out.println("2-Anadir una nueva receta");
				System.out.println(
						"3-Buscar una receta (En funcion de su sabor, el tipo de postre o el nivel de dificultad)");
				System.out.println(
						"4-Leer una receta (Podras ver las valoraciones de otros usuarios e incluso dar la tuya si ya las realizado)");
				System.out.println("5-Permitir a los usuarios realizar un nuevo pedido");
				System.out.println("0-Salir");
				opcion = t.nextInt();

				switch (opcion) {

				case 1:
					System.out.println("¿Que quieres hacer?");
					System.out.println("1-Registrarme como un nuevo usuario");
					System.out.println("2-Modificar mis datos de usuario");
					opc = t.nextInt();
					switch (opc) {

					case 1:
						Usuarios nuevo = new Usuarios();
						System.out.println("Introduce tus datos de usuario");
						System.out.println("Nombre");
						nuevo.setNombre(t.next());
						System.out.println("Apellido");
						nuevo.setApellido(t.next());
						System.out.println("Fecha de nacimiento");
						nuevo.setFNacimiento(new Fecha(t.next()));
						System.out.println("DNI");
						nuevo.setDNI(t.next());
						System.out.println("Teléfono");
						nuevo.setTelefono(t.next());
						System.out.println("Contrasena");
						nuevo.setContrasena(t.next());
						System.out.println(
								"Para poder ofrecerte una mejor experiencia, nos gustaria saber cual es tu nivel a traves de un pequeno test");
						nuevo.setNivel(nivel());

						query1 = "insert into Usuarios values(" + "default,'" + nuevo.getNombre() + "','"
								+ nuevo.getApellido() + "','" + nuevo.getFNacimiento().mysql() + "','" + nuevo.getDNI()
								+ "','" + nuevo.getTelefono() + "','" + nuevo.getContrasena() + "','" + nuevo.getNivel()
								+ "');";
						System.out.println(query1);
						st.executeUpdate(query1);
						System.out.println(
								"Ya has sido registrado en nuesta base de datos. Tus datos son los siguientes: "
										+ query1);
						break;
					case 2:
						System.out.println("Cual es tu DNI");
						ValiUsu = t.next();
						query1 = "Select * from `programacion`.`usuarios` where DNI ='" + ValiUsu + "';";
						ResultSet modi = st.executeQuery(query1);
						System.out.println("Esta es la información que el programa tiene :");
						while (modi.next()) {
							Usuarios rs = new Usuarios();
							rs.setID(modi.getInt("IdUsuarios"));
							rs.setNombre(modi.getString("Nombre"));
							rs.setApellido(modi.getString("Apellido"));
							rs.setFNacimiento(new Fecha(modi.getString("FNacimiento")));
							rs.setDNI(modi.getString("DNI"));
							rs.setTelefono(modi.getString("Telefono"));
							rs.setContrasena(modi.getString("Contrasena"));
							rs.setNivel(modi.getString("Nivel"));
							rs.infoUsuario();
						}
						System.out.println("Ahora que ya sabes la información que el sistema tiene almacenada sobre ti,"
								+ "¿Que dato quieres modificar? Recuerda que podrás modificar todos tus datos menos el id");
						String modi1 = t.next();
						System.out.println("Introduce tu nuevo/nueva " + modi1 + "?");
						String datonuevo = t.next();

						if (modi1.equals("DNI") || modi1.equals("dni") || modi1.equals("Dni")) {
							query1 = "UPDATE `programacion`.`usuarios` SET `DNI` = '" + datonuevo + "' WHERE (`DNI` = '"
									+ ValiUsu + "');";
							System.out.println("Tus datos han sido modificados correctamente");
							st.executeUpdate(query1);
						}

						else if (modi1.equals("Nombre") || modi1.equals("nombre") || modi1.equals("NOMBRE")) {
							query1 = "UPDATE `programacion`.`usuarios` SET `Nombre` = '" + datonuevo
									+ "' WHERE (`DNI` = '" + ValiUsu + "');";
							System.out.println("Tus datos han sido modificados correctamente");
							st.executeUpdate(query1);
						}

						else if (modi1.equals("Apellido") || modi1.equals("apellido") || modi1.equals("APELLIDO")) {
							query1 = "UPDATE `programacion`.`usuarios` SET `Apellido` = '" + datonuevo
									+ "' WHERE (`DNI` = '" + ValiUsu + "');";
							System.out.println("Tus datos han sido modificados correctamente");
							st.executeUpdate(query1);
						}

						else if (modi1.equals("FECHA DE NACIMIENTO") || modi1.equals("fecha de nacimiento")
								|| modi1.equals("Fecha de nacimiento") || modi1.equals("Nacimiento")) {
							query1 = "UPDATE `programacion`.`usuarios` SET `FNacimiento` = '" + datonuevo
									+ "' WHERE (`DNI` = '" + ValiUsu + "');";
							System.out.println("Tus datos han sido modificados correctamente");
							st.executeUpdate(query1);
						}

						else if (modi1.equals("Teléfono") || modi1.equals("TELÉFONO") || modi1.equals("teléfono")
								|| modi1.equals("Telefono") || modi1.equals("TELEFONO")) {
							query1 = "UPDATE `programacion`.`usuarios` SET `Telefono` = '" + datonuevo
									+ "' WHERE (`DNI` = '" + ValiUsu + "');";
							System.out.println(query1);
							System.out.println("Tus datos han sido modificados correctamente");
							st.executeUpdate(query1);
						}

						else if (modi1.equals("Contrasena") || modi1.equals("contrasena")
								|| modi1.equals("CONTRASEnA")) {
							query1 = "UPDATE `programacion`.`usuarios` SET `Contrasena` = '" + datonuevo
									+ "' WHERE (`DNI` = '" + ValiUsu + "');";
							System.out.println("Tus datos han sido modificados correctamente");
							st.executeUpdate(query1);
						}

						else if (modi1.equals("Nivel") || modi1.equals("nivel") || modi1.equals("NIVEL")) {
							query1 = "UPDATE `programacion`.`usuarios` SET `Nivel` = '" + datonuevo
									+ "' WHERE (`DNI` = '" + ValiUsu + "');";
							System.out.println("Tus datos han sido modificados correctamente");
							st.executeUpdate(query1);
						}

						else {
							System.out.println(
									"Este dato no existe o no se puede modificar. Prueba introduciendo el dato que quieres modificar en mayúsculas ");
						}

					}
					break;

				case 2:
					System.out.println("Para poder introducir una nueva receta, primero debes estar registrado");
					System.out.println("¿Estas registrado?");
					String resp = t.next();
					if (resp.equals("Si") || resp.equals("SI") || resp.equals("si")) {
						System.out.println("Cual es tu DNI");
						ValiUsu = t.next();
						query1 = "Select * from `programacion`.`usuarios` where DNI ='" + ValiUsu + "';";
						ResultSet modi = st.executeQuery(query1);
						receta();

					} else {
						registrarse();
						System.out.println("Ahora ya estas registrado");
					}
					break;

				case 3:
					
					break;

				case 4:
					break;

				case 5:
					break;

				case 0:
					System.out.println("Gracias por confiar es nuestra escuela. Vuelve pronto, adios.");
					break;

				default:
					System.out.println("Esta opción no es valida");
				}
			} while (opcion != 0);
		} catch (SQLException e) {
			System.out.println("Ha habido un fallo al conectar con la base de datos ESC_PRIN");
		}
	}

}
