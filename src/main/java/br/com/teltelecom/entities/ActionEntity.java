package br.com.teltelecom.entities;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ActionEntity {

	private String id;
	private Date date;
	private String type;
	private Data data;
	
	
	public class Data {
        @Getter @Setter
		private String text;
        
        @Getter @Setter
        private BoardEntity board;
        
        @Getter @Setter
        private CardEntity card;
        
        @Getter @Setter
        private ListAfterEntity listAfter;
        
        @Getter @Setter
        private ListBeforeEntity listBefore;          
    }
		
}
