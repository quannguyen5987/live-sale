package com.sales.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AVATAR")
    private String avatar;

    @ManyToOne
    @JoinColumn(name="LEVEL_ID", nullable=false)
    private Level level;
}
