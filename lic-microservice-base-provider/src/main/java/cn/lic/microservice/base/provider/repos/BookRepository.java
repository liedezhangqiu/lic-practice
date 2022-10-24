package cn.lic.microservice.base.provider.repos;

import cn.lic.microservice.base.provider.model.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

}
