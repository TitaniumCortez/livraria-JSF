package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.util.RedirectView;


@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();
	private Integer autorId;
	
	
	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public Autor getAutor() {
		return autor;
	}
	public void carregarAutorPelaId() {
		System.out.println("ID: " +autorId);
		this.autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
	}
	
	public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		new DAO<Autor>(Autor.class).adiciona(this.autor);
		this.autor = new Autor();
		return new RedirectView("livro").toString();
	}	
	
}
