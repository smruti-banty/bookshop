package com.bookshop.model;

/**
 * Database related information 
 * class   table
 * ----    -----
 * User    user 
 * 
 * The following are the database column respected to filed
 * 
 * java field      database column
 * ----------      --------------
 * userId      		user_id (int AUTOINCREMENT PRIMARYKEY)
 * name    			name (varchar(45))
 * email            email (varchar(45))
 * password			password (varchar(45))
 * number           number (varchar(20))
 * address			address (mediumtext)
 * role             role (tinyint(2)) (1 for admin, 2 for customer) (default 2)
 */

public record User (int userId, String name, 
		String email, String password, String number, String address, int role){

}
