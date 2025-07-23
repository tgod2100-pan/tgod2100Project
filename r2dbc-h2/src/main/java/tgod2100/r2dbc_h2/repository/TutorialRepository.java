package tgod2100.r2dbc_h2.repository;

import tgod2100.r2dbc_h2.model.Tutorial;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import tgod2100.r2dbc_h2.model.Tutorial;

public interface TutorialRepository extends R2dbcRepository<Tutorial, Long> {
    Flux<Tutorial> findByPublished(boolean published);
    // SELECT * FROM tutorials WHERE published=?
    Flux<Tutorial> findByTitleContaining(String title);
    /*
     Spring Data JPA 命名方法
        findBy: 查詢的動作 --> SELECT * FROM ...WHERE...
        Containing: 表示模糊查詢的動作 --> SQL LIKE
        IgnoreCase: 表示忽略大小寫

        1. 查詢單個: findBy[Field]
            List<Tutorial> findByTitle(String title)
            --> SELECT * FROM tutorials WHERE title = ?
        2. 查詢多個: findBy[Field1]And[Field2]
            List<Tutoril> findByTitleAndPublished(String title, boolean published)
            --> SELECT * FROM tutorials WHERE title = ? AND published = ?
        3. 模糊搜尋: findBy[Field]Containing:
            List<Tutorial> findByTitleContaining(String title);
            --> SELECT * FROM tutorials WHERE title LIKE ?

            List<Tutorial> findByContainingIgnoreCase(String title);
            --> SELECT * FROM tutorials WHERE LOWER(title) LIKE LOWER(?)

        4. 排列查詢: findBy[Field]OrderBy[Field2]Asc 或 findBy[Field]OrderBy[Field2]Desc
            List<Tutorial> findByPublishedOrderByTitleAsc(boolean published);
            --> SELECT * FROM tutorials WHERE published = ? ORDER BY title ASC

        5. 查詢是否存在: existsBy[Fidle]
            boolean existedByTitle(String title);
            --> SELECT COUNT(*) > 0 FROM tutorials WHERE title = ?

        6. 範圍查詢: findBy[Field]GreaterThan
            List<Tutorial> findByIdGreaterThan(long id);
            --> SELECT * FROM tutorials WHERE id > ?

            List<Tutorial> findByIdLessThan(long id)
            --> SELECT * FROM tutorials WHERE id < ?

            List<Tutorial> findByIdBetween(long id1,long id2);
            --> SELECT * FROM tutorials WHERE id BETWEEN ? AND ?

    */

}
