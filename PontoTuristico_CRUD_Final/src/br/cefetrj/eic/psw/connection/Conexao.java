package br.cefetrj.eic.psw.connection;

public interface Conexao {

	public void fecharConexao();

	public void iniciarTransacao();
	public void commit();
	public void rollback();
	public boolean transacaoAtiva();
}
