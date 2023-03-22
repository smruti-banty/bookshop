package com.bookshop.repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.config.DbConfig;
import com.bookshop.model.Book;
import com.bookshop.model.BookUser;

public class CartRepository {
	private static final String CART_TABLE = "cart";
	private static final String BOOK_TABLE = "book";

	private final Connection connection;

	public CartRepository() {
		connection = new DbConfig().getConnection();
	}

	public void addCart(BookUser bookUser) {
		final String QUERY = """
				INSERT INTO %s (user_id, book_id) values (?, ?)
				""".formatted(CART_TABLE);
		try {
			var prepareStatement = connection.prepareStatement(QUERY);
			prepareStatement.setInt(1, bookUser.userId());
			prepareStatement.setInt(2, bookUser.bookId());

			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Book> getBookCart(int userId) {
		List<Book> books = new ArrayList<>();
		final String QUERY = """
				SELECT b.id, b.book_name,
					b.author_name, b.image_url,
					b.description, b.price
				FROM `%s` b
				INNER JOIN `%s` c
				ON b.id = c.book_id
				WHERE c.user_id = ?;
				""".formatted(BOOK_TABLE, CART_TABLE);
		try {
			var prepareStatement = connection.prepareStatement(QUERY);
			prepareStatement.setInt(1, userId);

			var resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				int bookId = resultSet.getInt("id");
				String bookName = resultSet.getString("book_name");
				String authorName = resultSet.getString("author_name");
				String imgUrl = resultSet.getString("image_url");
				String description = resultSet.getString("description");
				double price = resultSet.getDouble("price");

				Book book = new Book(bookId, bookName, authorName, description, price, imgUrl);
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	public void removeBook(int userId, int bookId) {
		final String QUERY = """
				DELETE FROM %s WHERE user_id = ? AND book_id = ?
				""".formatted(CART_TABLE);
		try {
			var prepareStatement = connection.prepareStatement(QUERY);
			prepareStatement.setInt(1, userId);
			prepareStatement.setInt(2, bookId);

			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BookUser> cartBookUserDetails(int userId) {
		List<BookUser> bookUsers = new ArrayList<>();
		final String QUERY = """
				SELECT id, book_id FROM %s WHERE user_id = ?
				""".formatted(CART_TABLE);
		try {
			var prepareStatement = connection.prepareStatement(QUERY);
			prepareStatement.setInt(1, userId);
			var resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int bookId = resultSet.getInt("book_id");

				var bookUser = new BookUser(id, userId, bookId);
				bookUsers.add(bookUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookUsers;
	}

	public void removeBooks(List<BookUser> bookUsers) {
		final String QUERY = """
				DELETE FROM %s WHERE user_id = %d AND book_id = %d
				""";

		try {
			var statement = connection.createStatement();
			for (BookUser bookUser : bookUsers) {
				int userId = bookUser.userId();
				int bookId = bookUser.bookId();

				statement.addBatch(QUERY.formatted(CART_TABLE, userId, bookId));
			}

			statement.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean cartExists(int userId, int bookId) {
		boolean isExists = false;
		final String QUERY = """
				SELECT id FROM `%s` WHERE user_id = ? AND book_id = ?
				""".formatted(CART_TABLE);
		try {
			var prepareStatement = connection.prepareStatement(QUERY);
			prepareStatement.setInt(1, userId);
			prepareStatement.setInt(2, bookId);

			var resultSet = prepareStatement.executeQuery();
			isExists = resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isExists;
	}

}
