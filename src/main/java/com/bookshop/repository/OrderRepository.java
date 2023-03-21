package com.bookshop.repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.config.DbConfig;
import com.bookshop.model.Book;
import com.bookshop.model.BookUser;

public class OrderRepository {
	private static final String ORDER_TABLE = "order";
	private static final String BOOK_TABLE = "book";

	private final Connection connection;

	public OrderRepository() {
		connection = new DbConfig().getConnection();
	}

	public void order(List<BookUser> bookUsers) {
		final String QUERY = """
				INSERT INTO `%s` (user_id, book_id) values (%d, %d)
				""";

		try {
			var statement = connection.createStatement();
			for (BookUser bookUser : bookUsers) {
				int userId = bookUser.userId();
				int bookId = bookUser.bookId();

				statement.addBatch(QUERY.formatted(ORDER_TABLE, userId, bookId));
			}

			statement.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Book> getOrders(int userId) {
		List<Book> books = new ArrayList<>();
		final String QUERY = """
				SELECT b.id, b.book_name,
					b.author_name, b.image_url,
					b.description, b.price
				FROM `%s` b
				INNER JOIN `%s` o
				ON b.id = o.book_id
				WHERE o.user_id = ?;
				""".formatted(BOOK_TABLE, ORDER_TABLE);
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

}
