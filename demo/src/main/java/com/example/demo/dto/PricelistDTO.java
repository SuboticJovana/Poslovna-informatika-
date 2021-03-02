package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Date;

import com.example.demo.model.Pricelist;


	public class PricelistDTO implements Serializable {
		
		private static final long serialVersionUID = 4174362857862253015L;
		
		private int pricelist_id;
		private Date date_from;
		private Date date_to;
		private int percentage;
		private int total_price;
		
		public PricelistDTO(int pricelist_id, Date date_from, Date date_to, int percentage, int total_price) {
			super();
			this.pricelist_id = pricelist_id;
			this.date_from = date_from;
			this.date_to = date_to;
			this.percentage = percentage;
			this.total_price = total_price;
		}

		public PricelistDTO(Pricelist p) {
			// TODO Auto-generated constructor stub
		}

		public int getPricelist_id() {
			return pricelist_id;
		}

		public void setPricelist_id(int pricelist_id) {
			this.pricelist_id = pricelist_id;
		}

		public Date getDate_from() {
			return date_from;
		}

		public void setDate_from(Date date_from) {
			this.date_from = date_from;
		}

		public Date getDate_to() {
			return date_to;
		}

		public void setDate_to(Date date_to) {
			this.date_to = date_to;
		}

		public int getPercentage() {
			return percentage;
		}

		public void setPercentage(int percentage) {
			this.percentage = percentage;
		}

		public int getTotal_price() {
			return total_price;
		}

		public void setTotal_price(int total_price) {
			this.total_price = total_price;
		}
		
}
