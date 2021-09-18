/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoFactory {
    
    
        /*Informa-se tres parametros para a conexão de banco de dados*/
    private static final String URL="jdbc:mysql://localhost/projetoetb"; 
    private static final String USUARIO="root";
    private static final String PASS=null;
    private static final String DRIVER="com.mysql.jdbc.Driver";
    
    
    public static Connection conectar() throws SQLException {
       
        try{
      
            Class.forName(DRIVER);
            Connection conexao = DriverManager.getConnection(URL, USUARIO, PASS);
            System.out.println("Conexão efetuada com sucesso!");
            return conexao;
        } catch (ClassNotFoundException ex) {
            System.out.println("Classe inexistente no conexao factory");
            return null;
        } catch(SQLException sql){
            System.out.println("Erro na conexão de banco de dados");
            return null;
        }
        
 
        
    }
    
    public static void desconectar(Connection conexao) throws SQLException{
        
        conexao.close();
       
    }
    
}