package br.cefetrj.eic.psw.connection;

public class ConnectionFactory {
	
	public static Conexao criarConexao() {
		return (Conexao) new ConexaoImpl();
		
	}

	
	
}
