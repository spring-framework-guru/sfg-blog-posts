package org.springframework.guru.domain;

import javax.persistence.*;

@Entity
//@NamedStoredProcedureQuery(name = "Blog.getTotalBlogsByTitlelEntity", procedureName = "GET_TOTAL_BLOGS_BY_TITLE", parameters = {
//        @StoredProcedureParameter(mode = ParameterMode.IN, name = "title_in", type = String.class),
//        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "count_out", type = Integer.class) })
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long blogId;

    @Column
    private String title;

    @Column
    private Integer yearOfPost;

    public long getBlogId() {
        return blogId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYearOfPost() {
        return yearOfPost;
    }
}
