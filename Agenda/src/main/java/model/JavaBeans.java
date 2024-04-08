package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
/** The id. */
//	Atributos do Servidor de Banco de Dados do dbagente
	private int id;
	
	/** The nome. */
	private String nome;
	
	/** The fone. */
	private String fone;
	
	/** The email. */
	private String email;
	
	
/**
 * Instantiates a new java beans.
 */
//	Contrudor SuperClass
	public JavaBeans() {
			super();
		}
	
	
/**
 * Instantiates a new java beans.
 *
 * @param id the id
 * @param nome the nome
 * @param fone the fone
 * @param email the email
 */
//	Contrudor com Campos
	public JavaBeans(int id, String nome, String fone, String email) {
	super();
	this.id = id;
	this.nome = nome;
	this.fone = fone;
	this.email = email;
}



	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	//	Metodos Getter e Setter
	public int getId() {
		return this.id;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Gets the fone.
	 *
	 * @return the fone
	 */
	public String getFone() {
		return fone;
	}
	
	/**
	 * Sets the fone.
	 *
	 * @param fone the new fone
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
