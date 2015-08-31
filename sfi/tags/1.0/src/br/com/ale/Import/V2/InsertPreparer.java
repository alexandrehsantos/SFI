package br.com.ale.Import.V2;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe reponsavel por receber os dados obtidos da classe FileReader e
 * deixa-los no formato para o insert
 * 
 * @author ale
 *
 */

public class InsertPreparer {

	private String[] colunNames; // Armazena os nomes das colunas extraídos de
									// uma linha com delimitada.
	private StringBuilder listOfColunNames; // Aramzena a Strng inteira com a
												// lista de nomes de colunas
												// para o
												// insert (col1,col2)
	protected static ArrayList<StringBuilder> insertStatmente; // Armazena o
																// comando
																// insert
	// construído
	private ArrayList<String> fileInList; // Armazena o conteúdo capturado pela
											// classe ReadFile a partir de um
											// arquivo delimitado
	
	private ArrayList<String> colunContent;// Armazena o conteúdo da lista
												// listOfColunName separando
												// cada
												// elemento dividindo pelo
												// delimitador

	private ArrayList<String> listOfColunContent; // Armazena a lista
													// do
	// conteúdo
	// das colunas para a contrução
	// do insert

	private int numberColuns;
	private String table;

	/**
	 * O construtor recebe como parametro a classe FileReader para utilizar o
	 * conteudo criado armazenado na lista durante a execuçao da classe
	 * 
	 * @param r
	 */
	public InsertPreparer(FileReader r) {

		// this.table = table;

		this.fileInList = r.fileInList;

		// Chama o metodo responsavel por executar toda a funcao da classe
		this.buildStatement();

		// this.numberColuns = r.numberColuns;
	}

	public void buildStatement() {
		this.splitColunName();
		this.buildListOfColuns();
		this.extractColunContent();
		this.buildListContent();
	}

	/**
	 * Metodo responsável por pegar o cabeçalho do csv e extrair o nome das
	 * colunas
	 */

	public void splitColunName() {
		this.colunNames = this.fileInList.get(0).split(",");

	}

	/**
	 * Metodo responsavel criar o parametro com nomes das colunas utilizado em
	 * um insert
	 */
	public void buildListOfColuns() {
		listOfColunNames = new StringBuilder();

		for (int j = 0; j < getColunNames().length; j++) {

			getListOfColunNames().append(getColunNames()[j]);

			if (j < (getColunNames().length - 1))
				getListOfColunNames().append(",");

		}

		getListOfColunNames().insert(0, "(");
		getListOfColunNames().insert(getListOfColunNames().length(), ")");

		System.out.println(getListOfColunNames());
	}

  /**
   * Metodo responsavel por extrair o conteudo de todas as colunas e armazenar em uma unica lista a fim de retirar
   * o separador padrão do csv.
   */
	
	public void extractColunContent() {

		colunContent = new ArrayList<String>();

		for (int i = 1; i < fileInList.size(); i++) {

			for (String s : fileInList.get(i).split(",")) {

				getColunContent().add(s);

			}

		}

	}

	
	
	
	/**
	 * Metodo responsavel por montar o parametro values() de um insert 
	 */

	public void buildListContent() {
		listOfColunContent = new ArrayList<String>();

		int i = 0;

		StringBuilder linha = new StringBuilder();

		for (i = 0; i < getColunContent().size();) {
			// Utiliza o tamanho do ArrayList colunName que possui a quantidade
			// de colunas para determinar a quantidade de colunas que o arquivo
			// sera quebrado novamente

			linha.delete(0, linha.length());

			for (int j = 0; j < getColunNames().length; j++, i++) {

				if (i >= getColunContent().size()) {
					break;
				}

				// Adiciona as áspas, não conhecia o PreparedStatement

				linha.append("\"" + getColunContent().get(i) + "\"");
				System.out.println(linha);
				if (j < (getColunNames().length - 1)) {
					linha.append(",");

				}

			}

			// Adiciona o parenteses do ínicio
			linha.insert(0, "(");
			// Adiciona o parenteses do fim
			linha.insert(linha.length(), ")");

			// Adiciona a linha reconstruída a lista
			getListOfColunContent().add(linha.toString());
			System.out.println(linha);

		}

	}

	public StringBuilder getListOfColunNames() {
		return listOfColunNames;
	}

	public String[] getColunNames() {
		return colunNames;
	}

	public ArrayList<String> getColunContent() {
		return colunContent;
	}
	

	public ArrayList<String> getListOfColunContent() {
		return listOfColunContent;
	}



}
