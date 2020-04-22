package br.com.esig.edu.crm.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import br.com.esig.audit.annotations.CriadoEm;
import br.com.esig.audit.annotations.CriadoPor;
import br.com.esig.edu.crm.comum.dominio.Usuario;


/**
 * @author Dinarte
 */

@Entity
@Table(name = "crm", schema = "endereco_email")
public class EnderecoEmail {

	@Id
	@GeneratedValue(generator = "endereco_email_generator")
	@GenericGenerator(name = "endereco_email_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "crm.endereco_email_seq") })
	@Column(name = "id_endereco_email", unique = true, nullable = false, insertable = true, updatable = true)
	private int id;
	
	private String email;
		
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_contato", unique = false, nullable = true)
	private Contato contato;
	
	@CriadoPor
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario_cadastro", unique = false, nullable = true)
	private Usuario usuarioCadastro;
	
	@CriadoEm
	@Column(name="data_cadastro")
	private Date dataCadastro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}



}
