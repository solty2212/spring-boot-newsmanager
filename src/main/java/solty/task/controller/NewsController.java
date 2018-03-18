package solty.task.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import solty.task.model.News;
import solty.task.repository.NewsRepository;

import javax.validation.Valid;
import java.util.Date;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NewsController {

    @Autowired
    NewsRepository newsRepository;

    @GetMapping("/news")
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @PostMapping("/news")
    public News createNews(@Valid @RequestBody News news) {
        return newsRepository.save(news);
    }

    @GetMapping("/news/{id}")
    public Optional<News> getNewsById(@PathVariable(value = "id") Long newsId) {
        return newsRepository.findById(newsId);
    }

    @GetMapping("/get-by-tag")
    public List<News> getNewsByTagName(@Param(value = "tags") String newsTags) {
        return newsRepository.findByTagName(newsTags);
    }

    @GetMapping("/get-between-date")
    public List<News> getNewsBetweenDate(@Param(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                                         @Param(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date2) {
        return newsRepository.findBetweenDate(date1, date2);
    }

    @GetMapping("/get-by-tag-between-date")
    public List<News> getByTagBetweenDate(@Param(value = "tags") String newsTags,
                                          @Param(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date1,
                                          @Param(value = "date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date date2) {
        return newsRepository.findByTagBetweenDate(newsTags, date1, date2);
    }

}
