package br.com.caelum.livraria.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.caelum.livraria.modelo.Usuario;

public class Autorizador implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {

		FacesContext context = event.getFacesContext();
		String nomepagina = context.getViewRoot().getViewId();
		Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		System.out.println("ID PG = " + nomepagina);

		if ("/login.xhtml".equals(nomepagina))
			return;
		
		if (usuario != null)
			return;
		
		NavigationHandler handler = context.getApplication().getNavigationHandler();
		handler.handleNavigation(context, null, new RedirectView("login").toString());
		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {

	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.RESTORE_VIEW;
	}

}
