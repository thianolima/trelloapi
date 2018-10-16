package br.com.teltelecom.dtos;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ActionDto {

	private String id;
	private Date date;
	private String type;
	private Data data;
	
	
	public class Data {
        @Getter @Setter
		private String text;
        
        @Getter @Setter
        private BoardDto board;
        
        @Getter @Setter
        private CardDto card;
        
        @Getter @Setter
        private ListAfterDto listAfter;
        
        @Getter @Setter
        private ListBeforeDto listBefore;          
    }
		
}
