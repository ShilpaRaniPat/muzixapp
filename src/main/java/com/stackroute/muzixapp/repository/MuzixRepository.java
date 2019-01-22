package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuzixRepository extends JpaRepository<Muzix,Integer> {


    @Query("select m from Muzix m where m.trackName=?1")
    List<Muzix> getMuzixByName(String Name);
}
