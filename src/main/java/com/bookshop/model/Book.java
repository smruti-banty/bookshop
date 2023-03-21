package com.bookshop.model;
/**
 * Database related information 
 * class   table
 * ----    -----
 * Book    book 
 * 
 * The following are the database column respected to filed
 * 
 * java field      database column
 * ----------      --------------
 * id      			id (int AUTOINCREMENT PRIMARYKEY)
 * name    			book_name (varchar(45))
 * author           author_name (varchar(45))
 * imgUrl			image_url (mediumtext)
 * description      description (mediumtext)
 * price			price (double)
 *
 */
public record Book(int id, String name,
		String author, String descrption, double price, String imgUrl) {

}
