package com.sales.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "stupid")
@Data
public class Stupid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AVATAR", length = 1000)
    private String avatar;

    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @CreationTimestamp
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name="LEVEL_ID", nullable=false)
    private Level level;
}
