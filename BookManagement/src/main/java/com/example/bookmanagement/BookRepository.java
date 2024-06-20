package com.example.bookmanagement;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {
//    phân trang tăng hiệu  năng
    Page<Book> findByLibraryId(int libraryId, Pageable pageable);

    @Modifying
    @Transactional  //must read ACID
    @Query("delete from Book b where b.library.id=?1")

    void deleteByLibraryId(Integer libraryId);
}
