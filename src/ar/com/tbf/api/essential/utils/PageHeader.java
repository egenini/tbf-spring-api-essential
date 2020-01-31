package ar.com.tbf.api.essential.utils;

import org.springframework.data.domain.Page;

import ar.com.tbf.web.generic.filter.RequestResponseAccessibility;

public class PageHeader {

	private String baseUri;
	private String more = "";
	Page<?> page = null;
	
	public Page<?> build( Page<?> page ) {
		
		this.page    = page;
		this.more    = RequestResponseAccessibility.getQuery();
		this.baseUri = RequestResponseAccessibility.getUrl();
		
		RequestResponseAccessibility.getResponse().addHeader(    "link"         , first() + prev() + next() + last() );
		RequestResponseAccessibility.getResponse().addIntHeader( "X-Total-Count", this.page.getNumberOfElements() );
		
		return page;
	}
	
	private String first(){

		String link = "";
		
		if( this.page.getNumberOfElements() != 0 ){
			
			link = "<"+ this.baseUri + "?page=1&size="+ this.page.getSize() + more +">; rel=\"first\",";
		}
		
		return link;
	}

	private String prev(){

		String link = "";
		
		if( ! this.page.isFirst() ){
			link = "<"+ this.baseUri + "?page=" + ( this.page.getNumber() - 1 ) +"&size="+ this.page.getSize() + more +">; rel=\"prev\",";
		}
		
		return link;
	}

	private String next(){

		String link = "";
		
		if( ! this.page.isLast() ){
			link = "<"+ this.baseUri + "?page=" + ( this.page.getNumber() + 1 ) +"&size="+ this.page.getSize() + more +">; rel=\"next\",";
		}
		
		return link;
	}

	private String last(){

		String link = "";
		
		if( ! this.page.isLast() ){
			link = "<"+ this.baseUri + "?page=" + this.page.getNumber() +"&size="+ this.page.getSize() + more +">; rel=\"last\"";
		}
		
		return link;
	}
}
