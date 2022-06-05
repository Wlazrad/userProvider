package com.example.userprovider.request.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "REQUEST_DATA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class RequestData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Long id;

    @Column(name = "LOGIN")
    String login;

    @Column(name = "REQUEST_COUNT")
    Long requestCount;
}
