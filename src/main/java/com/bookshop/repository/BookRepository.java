package com.bookshop.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.config.DbConfig;
import com.bookshop.model.Book;

public class BookRepository {

	private final Connection connection;
	private static final String BOOK_TABLE = "book";

	public BookRepository() {
		connection = new DbConfig().getConnection();
	}

	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		try {
			var prepareStatement = connection.prepareStatement("SELECT * FROM " + BOOK_TABLE);
			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				books.add(book(resultSet));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return books;
	}

	public Book getBook(int id) {
		Book book = null;
		try {
			final String QUERY = "SELECT * FROM %s WHERE id = ?".formatted(BOOK_TABLE);

			var prepareStatement = connection.prepareStatement(QUERY);
			prepareStatement.setInt(1, id);

			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				book = book(resultSet);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
	}

	public void addBook(Book book) {
		try {
			final String QUERY = """
					INSERT INTO %s (book_name, author_name, image_url, description, price) VALUES
					(?, ?, ?, ?, ?)
					""".formatted(BOOK_TABLE);

			var prepareStatement = connection.prepareStatement(QUERY);
			prepareStatement.setString(1, book.name());
			prepareStatement.setString(2, book.author());
			prepareStatement.setString(3, book.imgUrl());
			prepareStatement.setString(4, book.descrption());
			prepareStatement.setDouble(5, book.price());

			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateBook(Book book) {
		try {
			final String QUERY = """
					UPDATE %s SET book_name = ?, author_name = ?, image_url = ?, description = ?, price = ? WHERE id = ?
					""".formatted(BOOK_TABLE);

			var prepareStatement = connection.prepareStatement(QUERY);
			prepareStatement.setString(1, book.name());
			prepareStatement.setString(2, book.author());
			prepareStatement.setString(3, book.imgUrl());
			prepareStatement.setString(4, book.descrption());
			prepareStatement.setDouble(5, book.price());
			prepareStatement.setInt(6, book.id());

			prepareStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(int id) {
		try {
			final String QUERY = """
					DELETE FROM %S WHERE id = ?
					""".formatted(BOOK_TABLE);

			var prepareStatement = connection.prepareStatement(QUERY);
			prepareStatement.setInt(1, id);

			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Book book(ResultSet resultSet) throws Exception {
		int id = resultSet.getInt("id");
		String bookName = resultSet.getString("book_name");
		String authorName = resultSet.getString("author_name");
		String imageUrl = resultSet.getString("image_url");
		String descirption = resultSet.getString("description");
		double price = resultSet.getDouble("price");

		return new Book(id, bookName, authorName, descirption, price, imageUrl);
	}
}
