package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

public class DAO {

//	Modolo de conexão
//	Parametro para conexão
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda";
	private String urlprof = "jdbc:mysql://127.0.0.1:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "backend@24";
	
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			return con;
		}catch (SQLException |  ClassNotFoundException e) {
			System.out.println("Coneção Não Funcional "+ e);
			return null;
		}
	}
	
/**
 * Inserir contato.
 *
 * @param Modelo the modelo
 */
//	CRUD  -> Create
	public void InserirContato(JavaBeans Modelo) {
			String create = "insert into contatos (nome, fone, email) VALUES (? , ? , ?)";
			try {
			
				Connection con = conectar();
				PreparedStatement stament = con.prepareStatement(create);
				
				stament.setString(1, Modelo.getNome());
				stament.setString(2, Modelo.getFone());
				stament.setString(3, Modelo.getEmail());
					
				stament.executeUpdate();
				con.close();
				
		}catch (SQLException e) {
			System.out.println("Error Na Inserção de Dados");
		}	
	}
	
/**
 * Read contato.
 *
 * @return the result set
 */
//	CRUD -> Read8
	public ResultSet  ReadContato() {
		String sql = "SELECT * FROM contatos";
		try {
			Connection con = conectar();
			
			java.sql.Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			
			int count=0;
            while (result.next()) {
                count+=1;
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String fone = result.getString("fone");
                String email = result.getString("email");
                System.out.println("Linha #:"+ count + " Id#: "+ id + " Nome#: "+ nome + " Telefone: "+ fone + " Email: "+ email);
           
            
                }
            con.close();
            return result;
	
		}catch (Exception e) {
			return null;
		}
		
	}
	
	/**
	 * Lista contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listaContatos(){
//		Criando uma Lista Dynamic
		ArrayList<JavaBeans> Lista = new ArrayList<>();
//		Escrevendo a Query
		String sql = "SELECT * FROM contatos order by id";
		try {
			Connection con = conectar();
			
//			Preparando o Banco de Dados para a Query
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
            while (result.next()) {
//            	Variaveis de Vão armazenar as informação do bando de Dados
            	int id = result.getInt("id");
                String nome = result.getString("nome");
                String fone = result.getString("fone");
                String email = result.getString("email");
                
                JavaBeans Contato = new JavaBeans(id, nome, fone , email);
                Lista.add(Contato);
            
                }
            
            con.close();
            return Lista;
	
		}catch (Exception e) {
			return null;
		}	
		
	}
	
	/**
	 * Excluir.
	 *
	 * @param id the id
	 */
	public void Excluir(int id) {
//		Query
		String deleteSql = "DELETE FROM contatos WHERE id= "+ id;
	
		try {
//			Pega A conexão
			Connection con = conectar();
			java.sql.Statement stmt = con.createStatement();
			stmt.executeUpdate(deleteSql);
			
//			Fechar a coneção
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Buscar id.
	 *
	 * @param id the id
	 * @return the java beans
	 */
	public JavaBeans BuscarId(int id) {
//		Query
		String buscar = String.format("SELECT * FROM contatos WHERE id= %d ", id);
		
		try {
//			Criar a Conexão
			Connection con = conectar();
//			prepara para fazer a query
			java.sql.Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(buscar);
			
//			Criar um String para criar um objeto
			String nome = null, fone = null, email = null;
			int idTeste = 0;
			
//			Pegando as Informção do Result
			while (result.next()) {
	//           Variaveis de Vão armazenar as informação do bando de Dados
	            idTeste = result.getInt("id");
	            nome = result.getString("nome");
	            fone = result.getString("fone");
	            email = result.getString("email");
	             
			}
//			Criar o Objeto
            JavaBeans Contato = new JavaBeans(idTeste, nome, fone , email);
                  	
//            Fecha Conexão e returna o contato
            con.close();
			return Contato;
			
		} catch (SQLException e) {
//			Caso der erro print o erro e retorna null
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Update.
	 *
	 * @param UpdateContato the update contato
	 */
	public void Update(JavaBeans UpdateContato) {
		String Update = "UPDATE contatos SET nome = ?, fone = ? , email = ? WHERE id = ?";
		try {
			Connection con = conectar();
			PreparedStatement stmt = con.prepareStatement(Update);
			stmt.setString(1, UpdateContato.getNome());
			stmt.setString(2, UpdateContato.getFone());
			stmt.setString(3, UpdateContato.getEmail());
			stmt.setInt(4, UpdateContato.getId());
			stmt.executeUpdate();

			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
//	Testar Connection
//	public void TesteCon() {
//		try {	
//			Connection con = conectar();
//			System.out.println(con);
//			System.out.println("Conectado");
//		}catch (Exception e) {
//			System.out.println("Error " + e);
//		}
//	}
	
}
