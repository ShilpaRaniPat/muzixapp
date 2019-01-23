package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Muzix;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuzixRepository extends MongoRepository<Muzix,Integer> {


////   @Query("select m from Muzix m where m.trackName=?1")
//    List<Muzix> getMuzixByName(String Name);

}
