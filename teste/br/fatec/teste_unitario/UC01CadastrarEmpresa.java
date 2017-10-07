package br.fatec.teste_unitario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.fatec.model.Empresa;
import br.fatec.model.EmpresaDAO;

public class UC01CadastrarEmpresa {
	private static Empresa empresa;
	private static EmpresaDAO empresaDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		empresa = new Empresa();
		empresaDAO = new EmpresaDAO();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	
	}

	/**
	 * CT01 - cadastra empresa
	 * Objetivo - verificar comportamento ao cadastrar empresa
	 */
	@Test
	public void CT01UC01FBCadastrarEMpresa_com_sucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	/**
	 * CT02 - cadastra cnpj invalido
	 * Objetivo - verificar comportamento ao inputar cnpj invalido
	 */
	
	@Test
	public void CT01UC02A1cadastra_cnpj_invalido() {
		assertEquals("CNPJ invalido.", empresa.setCnpj("12221"));
	}
/**
 * CT03 - cnpj ja cadastrado
 * Objetivo - Verificar comportamento quando o cnpj ja esta cadastrado
 */
	@Test
	public void CT03UC01A1ja_cadastrado() {
		assertEquals(0, empresaDAO.adiciona(empresa));
	}
	
	
	@After
	public  void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}


	


	
	

}