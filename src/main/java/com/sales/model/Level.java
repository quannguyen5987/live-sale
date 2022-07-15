package com.sales.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "level")
@Data
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "value")
    private int value;
}
