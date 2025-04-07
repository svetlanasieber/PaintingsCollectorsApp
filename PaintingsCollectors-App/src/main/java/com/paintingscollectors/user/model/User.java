package com.paintingscollectors.user.model;

import com.paintingscollectors.painting.model.FavouritePainting;
import com.paintingscollectors.painting.model.Painting;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Painting> paintings;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<FavouritePainting> favouritePaintings;


}
