package ar.com.tbf.api.essential.utils;

import org.springframework.data.domain.Page;

import ar.com.tbf.web.generic.filter.RequestResponseAccessibility;

public class PageHeader {

	private static final String QUERY_REQUEST_PAGE = "page=";
	private static final String QUERY_REQUEST_SIZE = "size=";
	private static final String QUERY_PART_SEPARATOR = "&";
	
	private String baseUri;
	private String more = "";
	Page<?> page = null;
	
	public Page<?> build( Page<?> page ) {
		
		this.page    = page;
		this.more    = cleanQuery( RequestResponseAccessibility.getQuery() );
		this.baseUri = RequestResponseAccessibility.getBaseUrl() + RequestResponseAccessibility.getPath();
		
		RequestResponseAccessibility.getResponse().addHeader(    "link"         , first() + prev() + next() + last() );
		RequestResponseAccessibility.getResponse().addIntHeader( "X-Total-Count", this.page.getNumberOfElements() );
		
		return page;
	}
	
	private String cleanQuery(String query) {

		String cleanQuery = query;
		
		int pageIndex = query.indexOf(QUERY_REQUEST_PAGE);
		
		if( pageIndex != -1 ) {
			
			cleanQuery = query.substring(0, pageIndex ) + query.substring( query.indexOf( QUERY_PART_SEPARATOR, pageIndex ) + 1 );
		}
		
		int sizeIndex = cleanQuery.indexOf(QUERY_REQUEST_SIZE);
		
		if( sizeIndex != -1 ) {
			
			cleanQuery = cleanQuery.substring(0, sizeIndex ) + cleanQuery.substring( cleanQuery.indexOf( QUERY_PART_SEPARATOR, sizeIndex ) + 1 );
		}
		
		return cleanQuery;
	}

	private String first(){

		String link = "";
		
		if( this.page.getNumberOfElements() != 0 ){
			
			link = "<"+ this.baseUri + "?page=0&size="+ this.page.getSize() +"&"+ more +">; rel=\"first\",";
		}
		
		return link;
	}

	private String prev(){

		String link = "";
		
		if( ! this.page.isFirst() ){
			link = "<"+ this.baseUri + "?page=" + ( this.page.getNumber() - 1 ) +"&size="+ this.page.getSize() +"&"+ more +">; rel=\"prev\",";
		}
		
		return link;
	}

	private String next(){

		String link = "";
		
		if( ! this.page.isLast() ){
			link = "<"+ this.baseUri + "?page=" + ( this.page.getNumber() + 1 ) +"&size="+ this.page.getSize() +"&"+ more +">; rel=\"next\",";
		}
		
		return link;
	}

	private String last(){

		String link = "";
		
		if( ! this.page.isLast() ){
			link = "<"+ this.baseUri + "?page=" + this.page.getNumber() +"&size="+ this.page.getSize() +"&"+ more +">; rel=\"last\"";
		}
		
		return link;
	}
}
