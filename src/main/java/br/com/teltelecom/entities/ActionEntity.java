package br.com.teltelecom.entities;

import java.util.Date;

public class ActionEntity {

	private String id;
	private Date date;
	private String type;
	private Data data;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}



	public class Data {

        private String text;
        private BoardEntity board;
        private CardEntity card;
    	private ListAfterEntity listAfter;
    	private ListBeforeEntity listBefore;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public BoardEntity getBoard() {
            return board;
        }

        public void setBoard(BoardEntity board) {
            this.board = board;
        }

        public CardEntity getCard() {
            return card;
        }

        public void setCard(CardEntity card) {
            this.card = card;
        }

		public ListAfterEntity getListAfter() {
			return listAfter;
		}

		public void setListAfter(ListAfterEntity listAfter) {
			this.listAfter = listAfter;
		}

		public ListBeforeEntity getListBefore() {
			return listBefore;
		}

		public void setListBefore(ListBeforeEntity listBefore) {
			this.listBefore = listBefore;
		}                
    }
		
}
