package solty.task.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import solty.task.model.News;

import java.util.Date;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>{


    @Query(value = "SELECT * FROM newsmanager.news WHERE news.tags = ?1", nativeQuery = true)
    List<News> findByTagName(String newsTags);

   @Query(value = "SELECT * FROM newsmanager.news WHERE news.date BETWEEN ?1 AND ?2", nativeQuery = true)
   List<News> findBetweenDate(Date date1, Date date2);

   @Query(value = "SELECT * FROM newsmanager.news WHERE news.tags=?1 AND news.date BETWEEN ?2 AND ?3", nativeQuery = true)
    List<News> findByTagBetweenDate(String newsTags, Date date1, Date date2);
}
